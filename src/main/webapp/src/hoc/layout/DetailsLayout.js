import React from 'react'
import { useParams } from "react-router-dom";
import { useHistory } from "react-router-dom";
import Details from '../../containers/Details/Details'
import { Container } from 'react-bootstrap'

const DetailsLayout = (props) => {
  const { flightOfferId } = useParams()
  let history = useHistory();
  return (
    <>
      <Container>
        <Details flightOfferId={flightOfferId} history={history}/>
      </Container>
    </>
  )
}

export default DetailsLayout
