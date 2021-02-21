import {GET_SUPPLIERS, DELETE_SUPPLIER, GET_SUPPLIER_BY_ID} from "../actions/types";

const initialState = {
    suppliers: [],
    supplier: {}
};

export default function (state = initialState, action) {
    const {type, payload} = action;

    switch (type) {
        case GET_SUPPLIERS:
            return {...state, suppliers: payload};

        case DELETE_SUPPLIER:
            return {...state, suppliers: state.suppliers.filter((supplier) => supplier.id !== payload)};

        case GET_SUPPLIER_BY_ID:
            return {...state, supplier: payload};

        default:
            return state;
    }
}
