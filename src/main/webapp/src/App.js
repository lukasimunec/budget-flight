import 'react-app-polyfill/ie9'

import React from 'react';
import './App.css';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Layout from './hoc/layout/Layout'
import HomeLayout from './hoc/layout/HomeLayout';
import DetailsLayout from './hoc/layout/DetailsLayout';

function App() {

  return (
    <BrowserRouter>
      <Layout>
        <Switch>
          <Route path="/details/:flightOfferId" component={DetailsLayout} />
          <Route component={HomeLayout} />
        </Switch>
      </Layout>
    </BrowserRouter>
  );
}

export default App;
