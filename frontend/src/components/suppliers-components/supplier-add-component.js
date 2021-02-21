import React, {Component} from 'react';
import {connect} from "react-redux";
import PropTypes from "prop-types";

import {createSupplier} from "../../actions/supplier-actions";
import InputForm from "../parts/input-form";

class SupplierAddComponent extends Component {
    state = {
        firstName: "",
        lastName: "",
        city: "",
        address: "",
        telephone: "",
        errors: {}
    };

    // static getDerivedStateFromProps(nextProps)
    componentWillReceiveProps(nextProps) {
        if (nextProps.errors) {
            this.setState({errors: nextProps.errors});
        }
    }

    handleInputChange = (event) => {
        const {name, value} = event.target;

        this.setState({
            [name]: value
        });
    };

    createSupplier = (event) => {
        event.preventDefault();

        const {firstName, lastName, city, address, telephone} = this.state;
        const supplier = {firstName, lastName, city, address, telephone};

        this.props.createSupplier(supplier, this.props.history);
    };

    render() {
        return (
            <div>
                <InputForm
                    title={"Add Supplier"}
                    supplier={this.state}
                    errors={this.state.errors}
                    onSubmitForm={this.createSupplier}
                    handleInputChange={this.handleInputChange}/>
            </div>
        );
    }
}

SupplierAddComponent.propTypes = {
    createSupplier: PropTypes.func.isRequired,
    errors: PropTypes.object.isRequired,
};

const mapStateToProps = (state) => ({
    errors: state.errors,
});

export default connect(mapStateToProps, {createSupplier})(SupplierAddComponent);