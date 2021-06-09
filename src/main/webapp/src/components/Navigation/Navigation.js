import React from 'react';
import { Nav, Navbar } from 'react-bootstrap'
import logo from "../../assets/images/budget-flight-logo.png";
import "./Navigation.css"

const Navigation = (props) => {

    return (
        <Navbar className="navbar" collapseOnSelect expand="lg" variant="light" aria-label="Navigation bar">
            <Navbar.Brand href="/">
                <img className="logo" src={logo} alt="FINA početna stranica"/>
            </Navbar.Brand>
            
            <Navbar.Brand href="/" className="d-none d-sm-block">
                <strong className="ospd">Budget Flight</strong>
            </Navbar.Brand>

            <Navbar.Toggle aria-controls="responsive-navbar-nav" />
            <Navbar.Collapse className="collapse-navbar justify-content-end" id="responsive-navbar-nav">
                <Nav>
                    <Nav.Link className="nav-text toggle-button:focus" href="https://king-ict.com/">About Us</Nav.Link>
                </Nav>
            </Navbar.Collapse>
        </Navbar>
    );
}

export default Navigation;