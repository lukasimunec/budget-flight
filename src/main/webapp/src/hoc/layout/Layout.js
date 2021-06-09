import React from 'react'
import Navigation from '../../components/Navigation/Navigation'
import Footer from '../../components/Footer/Footer'

const layout = (props) => {

  return (
    <React.Fragment>
      <div id="content-wrap">
        <Navigation />
        {props.children}
      </div>
      <Footer />
    </React.Fragment>
  )
}

export default layout
