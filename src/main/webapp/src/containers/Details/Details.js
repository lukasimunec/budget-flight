import React from "react";
import { Row, Col } from "react-bootstrap"
import DetailsCard from "../../components/DetailsCard/DetailsCard";
import GetFlightOfferDetails from "../../api/GetFlightOfferDetails"

export default class Details extends React.Component {

    constructor() {
        super();
        this.state = {
            details: null,
            show: false
        }
        this.fetchData = this.fetchData.bind(this);
    }

    //Fetch data on mount
    componentDidMount() {
        this.fetchData(this.props.flightOfferId);
    };

    //Fetch flight offer details
    fetchData(id) {
        GetFlightOfferDetails(id).then(
            res => {
                this.setState({
                    details: res,
                    show: true
                });
            }
        ).catch(error => {
            window.location.href = "/"
        });
    }

    render() {
        return (
            <div>
                {this.state.show && this.state.details != null ?
                    <DetailsCard details={this.state.details} />
                    :
                    <Row className="justify-content-center">
                        <Col lg="1">
                            LOADING...
                        </Col>
                    </Row>
                }
            </div>
        );
    }
}
