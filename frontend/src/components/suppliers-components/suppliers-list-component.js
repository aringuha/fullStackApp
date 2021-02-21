import React, {Component} from 'react';
import {Link} from "react-router-dom";
import {connect} from "react-redux";
import PropTypes from "prop-types";

import {getSuppliers, deleteSupplier} from "../../actions/supplier-actions";

import "./supplier.css";

class SuppliersListComponent extends Component {

    componentDidMount() {
        this.props.getSuppliers();
    };

    deleteSupplier = (id) => {
        this.props.deleteSupplier(id);
    };

    render() {
        const {suppliers} = this.props.suppliers;

        return (
            <div>
                <h2 className="text-center mt-4">Suppliers List</h2>
                <div className="row">
                    <Link to={"/suppliers/add"}>
                        <button style={{marginBottom: "10px"}}
                                className="btn btn-success">Add Supplier
                        </button>
                    </Link>
                </div>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead className="bg-dark" style={{color: "white"}}>
                        <tr className="notbold">
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>City</th>
                            <th>Address</th>
                            <th>Telephone</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {suppliers.map((supplier) =>
                            <tr key={supplier.id}>
                                <td> {supplier.firstName} </td>
                                <td> {supplier.lastName}</td>
                                <td> {supplier.city}</td>
                                <td> {supplier.address}</td>
                                <td> {supplier.telephone}</td>
                                <td>
                                    <Link to={`/suppliers/${supplier.id}`}>
                                        <button className="btn btn-dark">Edit</button>
                                    </Link>
                                    <Link to={`/suppliers/view/${supplier.id}`}>
                                        <button className="btn btn-dark">View</button>
                                    </Link>
                                    <button onClick={() => this.deleteSupplier(supplier.id)}
                                            className="btn btn-danger">Delete
                                    </button>
                                </td>
                            </tr>
                        )}
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

SuppliersListComponent.propTypes = {
    getSuppliers: PropTypes.func.isRequired,
    deleteSupplier: PropTypes.func.isRequired,
    Suppliers: PropTypes.object.isRequired
};

const mapStateToProps = (state) => ({
    suppliers: state.suppliers
});

export default connect(mapStateToProps, {getSuppliers, deleteSupplier})(SuppliersListComponent);