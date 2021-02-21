import React, {Component} from 'react';
import {connect} from "react-redux";
import PropTypes from "prop-types";

import {updateSupplier, getSupplierById} from "../../actions/supplier-actions";
import InputForm from "../parts/input-form";

class SupplierUpdateComponent extends Component {
    state = {
        firstName: "",
        lastName: "",
        city: "",
        address: "",
        telephone: "",
        errors: {}
    };

    componentDidMount() {
        this.props.getSupplierById(this.props.match.params.id);
    }

    // static getDerivedStateFromProps(nextProps)
    componentWillReceiveProps(nextProps) {
        if (nextProps.errors) {
            this.setState({errors: nextProps.errors});
        }

        this.setState({
            ...nextProps.supplier
        });
    }

    handleInputChange = (event) => {
        const {name, value} = event.target;

        this.setState({
            [name]: value
        });
    };

    updateSupplier = (event) => {
        event.preventDefault();

        const {firstName, lastName, city, address, telephone} = this.state;
        const supplier = {firstName, lastName, city, address, telephone};

        this.props.updateSupplier(this.props.match.params.id, supplier, this.props.history);
    };

    render() {

        return (
            <div>
                <InputForm
                    title={"Update Supplier"}
                    supplier={this.state}
                    errors={this.state.errors}
                    onSubmitForm={this.updateSupplier}
                    handleInputChange={this.handleInputChange}/>
            </div>
        );
    }
}

SupplierUpdateComponent.propTypes = {
    updateSupplier: PropTypes.func.isRequired,
    getSupplierById: PropTypes.func.isRequired,
    errors: PropTypes.object.isRequired,
    supplier: PropTypes.object.isRequired
};

const mapStateToProps = (state) => ({
    errors: state.errors,
    supplier: state.suppliers.supplier
});

export default connect(mapStateToProps, {updateSupplier, getSupplierById})(SupplierUpdateComponent);