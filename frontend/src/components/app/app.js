import React from 'react';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import {Provider} from "react-redux";
import store from "../../store";

import SuppliersListComponent from "../suppliers-components/suppliers-list-component";
import SupplierAddComponent from "../suppliers-components/supplier-add-component";
import SupplierUpdateComponent from "../suppliers-components/supplier-update-component";
import SupplierViewComponent from "../suppliers-components/supplier-view-component";
import Header from "../parts/header";
import Footer from "../parts/footer";

import "./app.css"

const App = () => {
    return (
        <Provider store={store}>
            <Router>
                <Header/>
                <div className="container">
                    <Switch>
                        <Route exact path="/" component={SuppliersListComponent}/>
                        <Route exact path="/suppliers/add" component={SupplierAddComponent}/>
                        <Route exact path="/suppliers/:id" component={SupplierUpdateComponent}/>
                        <Route exact path="/suppliers/view/:id" component={SupplierViewComponent}/>
                    </Switch>
                </div>
                <Footer/>
            </Router>
        </Provider>
    );
};

export default App;