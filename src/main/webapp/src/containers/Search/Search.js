import React from "react";
import { Row, Col } from "react-bootstrap"
import ResultTable from "../../components/ResultTable/ResultTable";
import SearchCard from '../../components/SearchCard/SearchCard'
import GetFlightOffers from "../../api/GetFlightOffers"
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import "./Search.css"

export default class Search extends React.Component {

    constructor() {
        super();
        this.state = {
            tableParameters: {
                show: false,
                data: [],
                pages: null,
                loading: false
            },
            tableForm: {
                pageSize: 10,
                page: 0
            },
            searchForm: {
                departureAirport: "",
                destinationAirport: "",
                departureDate: new Date().setDate(new Date().getDate() + 1),
                returnDate: null,
                numberOfPassengers: 1,
                currency: 0
            },
            passengers: 1
        };
        this.fetchData = this.fetchData.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
        this.handleDateChange = this.handleDateChange.bind(this);
        this.onDetailsClick = this.onDetailsClick.bind(this);
    }

    componentDidMount() {

        //Save search form history
        if(this.props.history.location.state != null && this.props.history.location.state !== "undefined"){
            this.setState({
                ...this.props.history.location.state.state,
                tableParameters: {
                    show: true,
                    loading: false
                }
            })
        }
        this.props.history.push("/", null)

        //Fix datepicker input fields
        const datePickers = document.getElementsByClassName("react-datepicker__input-container");
        Array.from(datePickers).forEach((el => el.childNodes[0].setAttribute("readOnly", true)))
    };

    //Handle form input field change
    handleChange(e) {
        let target = e.target;
        e.preventDefault();
        this.setState(prev => ({
            searchForm: {
                ...prev.searchForm,
                [target.name]: target.value.toUpperCase()
            }
        }))
    }

    //Handle form date field change
    handleDateChange(date, name) {
        this.setState(prev => ({
            searchForm: {
                ...prev.searchForm,
                [name]: date
            }
        }))

        if (name === "departureDate" && this.state.searchForm.returnDate != null && (date > this.state.searchForm.returnDate || date === this.state.searchForm.returnDate)) {
            var newReturnDate = new Date(date.getTime())
            newReturnDate.setDate(newReturnDate.getDate() + 1)
            this.setState(prev => ({
                searchForm: {
                    ...prev.searchForm,
                    returnDate: newReturnDate
                }
            }))
        } else if (name === "returnDate" && date != null && (date < this.state.searchForm.returnDate || date === this.state.searchForm.returnDate)) {
            var newDepartureDate = new Date(date.getTime())
            newDepartureDate.setDate(newDepartureDate.getDate() - 1)
            this.setState(prev => ({
                searchForm: {
                    ...prev.searchForm,
                    departureDate: newDepartureDate
                }
            }))
        }
    }

    //Form submit
    onSubmit(e) {
        e.preventDefault();
        this.fetchData(this.state.tableForm)
    }

    //Details click
    onDetailsClick(id){
        var stateCopy = this.state;
        stateCopy.tableParameters = null;
        stateCopy.tableForm  = {
            page: this.state.tableForm.page,
            pageSize: this.state.tableForm.pageSize
        }
        this.props.history.push("/", {state: stateCopy})
        this.props.history.push("/details/" + id);
    }

    //Fetch flight offers
    fetchData(tableForm) {
        if (this.state.tableParameters.loading === false) {
            this.setState({
                tableParameters: {
                    show: true,
                    loading: true,
                },
                tableForm: tableForm
            }, () => {
                GetFlightOffers(this.state.searchForm, this.state.tableForm).then(
                    res => {
                        this.setState({
                            tableParameters: {
                                show: true,
                                loading: false,
                                data: res.rows,
                                pages: res.pages
                            },
                            passengers: this.state.searchForm.numberOfPassengers
                        });
                    }
                ).catch(error => {
                	console.log(error)
                    this.setState({
                        tableParameters: {
                            show: false,
                            loading: false,
                        }
                    });
                    if(error.response != null){
                        toast.warn(error.response.data.message)
                    }else{
                        toast.warn(error)
                    }
                });
            });
        }
    }

    render() {
        return (
            <React.Fragment>
                <Row className="search-view justify-content-center">
                    <Col lg="6">
                        <SearchCard naslov="Search Cheap Flights" 
                        handleChange={this.handleChange} 
                        handleDateChange={this.handleDateChange} 
                        onSubmit={this.onSubmit}
                        {...this.state.searchForm} />
                    </Col>
                </Row>

                {this.state.tableParameters.show ?
                    <Row className="result-view justify-content-center">
                        <Col lg="10">
                            <ResultTable history={this.props.history}
                            fetchData={this.fetchData} 
                            onDetailsClick={this.onDetailsClick}
                            passengers={this.state.passengers} 
                            {...this.state.tableParameters} />
                        </Col>
                    </Row> : null
                }
                <ToastContainer />
            </React.Fragment>
        );
    }
}
