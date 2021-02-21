import {combineReducers} from "redux";
import errorsReducer from "./error-reducer";
import supplierReducer from "./supplier-reducer";

export default combineReducers({
    errors: errorsReducer,
    suppliers: supplierReducer
});