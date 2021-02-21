import React, {Component} from 'react';
import {connect} from "react-redux";
import PropTypes from "prop-types";

import {getSupplierById} from "../../actions/supplier-actions";

class SupplierViewComponent extends Component {

    componentDidMount() {
        this.props.getSupplierById(this.props.match.params.id);
    };

    render() {
        const {firstName, lastName, city, address, telephone} = this.props.supplier;

        return (
            <div>
                <br/>
                <div className="card col-md-6 offset-md-3">
                    <h3 className="text-center">View Supplier Details</h3>
                    <div className="card-body">
                        <div className="row">
                            <div className="mr-2">First Name:</div>
                            <div>{firstName}</div>
                        </div>
                        <div className="row">
                            <div className="mr-2">Last Name:</div>
                            <div>{lastName}</div>
                        </div>
                        <div className="row">
                            <div className="mr-2">City:</div>
                            <div>{city}</div>
                        </div>
                        <div className="row">
                            <div className="mr-2">Address:</div>
                            <div>{address}</div>
                        </div>
                        <div className="row">
                            <div className="mr-2">Telephone:</div>
                            <div>{telephone}</div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

SupplierViewComponent.propTypes = {
    getSupplierById: PropTypes.func.isRequired,
    errors: PropTypes.object.isRequired,
    supplier: PropTypes.object.isRequired
};

const mapStateToProps = (state) => ({
    errors: state.errors,
    supplier: state.suppliers.supplier
});

export default connect(mapStateToProps, {getSupplierById})(SupplierViewComponent);