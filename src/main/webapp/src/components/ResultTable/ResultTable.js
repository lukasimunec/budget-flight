import React from 'react';
import { Button } from "react-bootstrap";
import ReactTable from "react-table";
import "react-table/react-table.css";

const ResultTable = (props) => {

    return (
        <ReactTable
            columns={[
                {
                    Header: "Departure Airport",
                    accessor: "departureAirport",
                    headerStyle: { textAlign: 'center' },
                    style: { textAlign: 'center' }
                },
                {
                    Header: "Destination Airport",
                    accessor: "destinationAirport",
                    headerStyle: { textAlign: 'center' },
                    style: { textAlign: 'center' }
                },
                {
                    Header: "Departure Date",
                    accessor: "departureDate",
                    headerStyle: { textAlign: 'center' },
                    style: { textAlign: 'center' },                    
                    Cell: row =>
                        <React.Fragment>
                            {row.original.departureDate !== null ? 
                                <div>
                                    <span>{row.original.departureDate.split(" ")[0]}</span>
                                    <br/>
                                    <span>{row.original.departureDate.split(" ")[1]}</span>
                                </div> : 
                                <span>/</span>
                            }
                        </React.Fragment>
                },
                {
                    Header: "Return Date",
                    accessor: "returnDate",
                    headerStyle: { textAlign: 'center' },
                    style: { textAlign: 'center' },
                    Cell: row =>
                        <React.Fragment>
                            {row.original.returnDate !== null ? 
                                <div>
                                    <span>{row.original.returnDate.split(" ")[0]}</span>
                                    <br/>
                                    <span>{row.original.returnDate.split(" ")[1]}</span>
                                </div> : 
                                <span>/</span>
                            }
                        </React.Fragment>
                },
                {
                    Header: "Route",
                    headerStyle: { textAlign: 'center' },
                    style: { textAlign: 'center' },
                    width: 400,
                    Cell: row =>
                        <React.Fragment>
                            {row.original.route.map((item, i) =>
                                <span key={i}>{item} {row.original.route[i+1] ? <span style={{"color": "green"}}>&rarr;</span> : null} </span>
                            )}
                            <br />
                            {row.original.returnRoute.slice(0).reverse().map((item, i) =>
                                <span key={i}>{item} {row.original.returnRoute[i+1] ? <span style={{"color": "red"}}>&larr;</span> : null} </span>
                            )}
                        </React.Fragment>
                },
                {
                    Header: "Sittings",
                    headerStyle: { textAlign: 'center' },
                    style: { textAlign: 'center' },
                    Cell: row =>
                        <React.Fragment>
                            <span style={{"color": "green"}}>{row.original.sittings} &rarr;</span>
                            {row.original.returnSittings !== 0 ? 
                                <div>
                                    <span style={{"color": "red"}}>{row.original.returnSittings} &larr;</span>
                                </div> : null
                            }
                        </React.Fragment>
                },
                {
                    Header: "Passengers",
                    headerStyle: { textAlign: 'center' },
                    style: { textAlign: 'center' },
                    Cell: row =>
                        <React.Fragment>
                            <span>{props.passengers}</span>
                            <br />
                            <span>of {row.original.bookableSeats} seats</span>
                        </React.Fragment>
                },
                {
                    Header: "Price",
                    accessor: "price",
                    headerStyle: { textAlign: 'center' },
                    style: { textAlign: 'center' }
                },
                {
                    Header: "Currency",
                    accessor: "currency",
                    headerStyle: { textAlign: 'center' },
                    style: { textAlign: 'center' }
                },
                {
                    accessor: "name",
                    headerStyle: { textAlign: 'center' },
                    style: { textAlign: 'center' },
                    Cell: row => 
                        <React.Fragment>
                            <Button onClick={() => { props.onDetailsClick(row.original.id)}}>
                                Details
                            </Button>
                        </React.Fragment>
                }
            ]}
            defaultPageSize={10}
            showPageSizeOptions={false}
            sortable={false}
            manual
            data={props.data}
            pages={props.pages}
            loading={props.loading}
            onFetchData={props.fetchData}
        />
    );
}

export default ResultTable;