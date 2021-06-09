import React from 'react'
import './SearchCard.css'
import { Form, Button, Row, Col } from 'react-bootstrap'
import DatePick from "../DatePick/DatePick"

const SearchCard = (props) => {

  return (
    <Row className="naslov" >

      <Col lg={12} className="justify-content-center naslov-text">
        <h3>{props.naslov}</h3>
      </Col>

      <Col lg={12} className="justify-content-center naslov-text">
        <Form onSubmit={props.onSubmit}>
          <Form.Row>
            <Form.Group as={Col} controlId="formGridEmail">
              <Form.Label>Departure airport</Form.Label>
              <Form.Control required placeholder="IATA" name="departureAirport" pattern="[A-Za-z]{3}" value={props.departureAirport} onChange={(e) => props.handleChange(e)} />
            </Form.Group>

            <Form.Group as={Col} controlId="formGridPassword">
              <Form.Label>Destination airport</Form.Label>
              <Form.Control required placeholder="IATA" name="destinationAirport" pattern="[A-Za-z]{3}" value={props.destinationAirport} onChange={(e) => props.handleChange(e)} />
            </Form.Group>
          </Form.Row>

          <Form.Row>
            <Form.Group as={Col} >
              <Form.Label>Departure date</Form.Label>
              <DatePick isClearable={false} name="departureDate" minDate={new Date().setDate(new Date().getDate() + 1)} value={props.departureDate} handleDateChange={props.handleDateChange}/>
            </Form.Group>

            <Form.Group as={Col} >
              <Form.Label>Return date</Form.Label>
              <DatePick isClearable={true} name="returnDate" minDate={new Date().setDate(new Date().getDate() + 2)} value={props.returnDate} handleDateChange={props.handleDateChange}/>
            </Form.Group>
          </Form.Row>

          <Form.Row>
            <Form.Group as={Col} controlId="formGridAddress2">
              <Form.Label>Number of passengers</Form.Label>
              <Form.Control required type="number" min="1" max="9" step="1" placeholder="Number of passengers" name="numberOfPassengers" value={props.numberOfPassengers}
                onChange={(e) => props.handleChange(e)} />
            </Form.Group>

            <Form.Group as={Col} controlId="formGridState">
              <Form.Label>Currency</Form.Label>
              <Form.Control as="select" name="currency" value={props.currency} onChange={(e) => props.handleChange(e)} >
                <option value="0">HRK</option>
                <option value="1">EUR</option>
                <option value="2">USD</option>
              </Form.Control>
            </Form.Group>
          </Form.Row>

          <Row className="justify-content-center">
            <Button variant="primary" type="submit">
              Search
              </Button>
          </Row>
        </Form>
      </Col>
    </Row>
  )
}

export default SearchCard
