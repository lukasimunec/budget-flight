import React from 'react'
import './DetailsCard.css'
import { Card, Row, Col } from 'react-bootstrap'

const DetailsCard = (props) => {

  return (
    <Card className="text-center">
      <Card.Header>Flight Offer #{props.details.flightOffer.id}</Card.Header>
      <Card.Body>
        <Card.Title>{props.details.flightOffer.departureAirport} &rarr; {props.details.flightOffer.destinationAirport}</Card.Title>
        <div>
          <Row className="justify-content-center">
            <Col lg={6}>
                  {props.details.flightOffer.route.map((item, i) =>
                      <span key={i}>{item} {props.details.flightOffer.route[i+1] ? <span style={{"color": "green"}}>&rarr;</span> : null} </span>
                  )}
                  <br/>
                  {props.details.flightOffer.returnRoute.slice(0).reverse().map((item, i) =>
                      <span key={i}>{item} {props.details.flightOffer.returnRoute[i+1] ? <span style={{"color": "red"}}>&larr;</span> : null} </span>
                  )}
            </Col>
          </Row>
          <br/>
          <Row className="justify-content-center">
            <Col lg={3}>
              <span>Departure Date</span>
              <br/>
              <span>{props.details.flightOffer.departureDate}</span>
            </Col>
            <Col lg={3}>
              <span>Sittings</span>
              <br/>
              <span style={{"color": "green"}}>{props.details.flightOffer.sittings} &rarr;</span>
              <br/>
              {props.details.flightOffer.returnSittings !== 0 ? 
                  <div>
                      <span style={{"color": "red"}}>{props.details.flightOffer.returnSittings} &larr;</span>
                  </div> : null
              }
            </Col>
            <Col lg={3}>
              <span>Return Date</span>
              <br/>
              {props.details.flightOffer.returnDate != null ? 
                <span>{props.details.flightOffer.returnDate}</span>
                :
                "/"
              }
            </Col>
          </Row>
          <br/>
          <Row className="justify-content-center">
          <Col lg={3}>
              <span>Bookable Seats</span>
              <br/>
              <span>{props.details.flightOffer.bookableSeats}</span>
            </Col>
            <Col lg={3}>
              <span>Base Price</span>
              <br/>
              <span>{props.details.basePrice} {props.details.flightOffer.currency}</span>
            </Col>
            <Col lg={3}>
              <span>Total Price</span>
              <br/>
              <span>{props.details.flightOffer.price} {props.details.flightOffer.currency}</span>
            </Col>
          </Row>
          <br/>
          <Row className="justify-content-center">
            <Col lg={3}>
              <span>Non Homogeneous</span>
              <br/>
              <span>{props.details.nonHomogeneous}</span>
            </Col>
            <Col lg={3}>
              <span>Instant Ticketing Required</span>
              <br/>
              <span>{props.details.instantTicketingRequired}</span>
            </Col>
            <Col lg={3}>
              <span>One Way</span>
              <br/>
              <span>{props.details.oneWay}</span>
            </Col>
          </Row>
        </div>
      </Card.Body>
      <Card.Footer>
          Last Ticketing Date: {props.details.lastTicketingDate}
        </Card.Footer>
    </Card>
  )
}

export default DetailsCard
