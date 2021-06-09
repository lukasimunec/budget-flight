import React from 'react'
import { useHistory } from "react-router-dom";
import Search from '../../containers/Search/Search'
import { Container } from 'react-bootstrap'

const HomeLayout = (props) => {
  let history = useHistory();
  return (
    <>
      <Container fluid>
        <Search history={history}/>
      </Container>
    </>
  )
}

export default HomeLayout
