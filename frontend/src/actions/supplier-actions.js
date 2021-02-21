import axios from "axios";
import {GET_ERRORS, GET_SUPPLIERS, DELETE_SUPPLIER, GET_SUPPLIER_BY_ID} from "./types";

const SUPPLIER_API_BASE_URL = "http://localhost:8080/api/v1/suppliers";
// const SUPPLIER_API_BASE_URL = "...amazonaws.com:8080/api/v1/suppliers";

export const createSupplier = (supplier, history) => async dispatch => {
    try {
        await axios.post(SUPPLIER_API_BASE_URL, supplier);
        history.push("/");
        dispatch({
            type: GET_ERRORS,
            payload: {}
        })
    } catch (error) {
        dispatch({
            type: GET_ERRORS,
            payload: error.response.data
        })
    }
};

export const updateSupplier = (supplierId, supplier, history) => async dispatch => {
    try {
        await axios.put(SUPPLIER_API_BASE_URL + "/" + supplierId, supplier);
        history.push("/");
        dispatch({
            type: GET_ERRORS,
            payload: {}
        })
    } catch (error) {
        dispatch({
            type: GET_ERRORS,
            payload: error.response.data
        })
    }
};

export const getSuppliers = () => async dispatch => {
    const response = await axios.get(SUPPLIER_API_BASE_URL);
    dispatch({
        type: GET_SUPPLIERS,
        payload: response.data
    })
};

export const deleteSupplier = (supplierId) => async dispatch => {
    await axios.delete(SUPPLIER_API_BASE_URL + "/" + supplierId);
    dispatch({
        type: DELETE_SUPPLIER,
        payload: supplierId
    })
};

export const getSupplierById = (supplierId) => async dispatch => {
    const response = await axios.get(SUPPLIER_API_BASE_URL + "/" + supplierId);
    dispatch({
        type: GET_SUPPLIER_BY_ID,
        payload: response.data
    })
};