import {
    applyMiddleware,
    combineReducers,
    createStore,
} from 'redux';

import thunk from 'redux-thunk';


// reducers.js
export const geod = (state = {}, action) => {
    switch (action.type) {
        case 'ACTIVATE_TEST':
            return action.geod;
        case 'CLOSE_TEST':
            return {};
        default:
            return state;
    }
};

export const user_list = (state = {}, action) => {
    switch (action.type) {
        case "FETCH_REQUEST":
            return state;
        case 'FETCH_SUCCESS':
            return { user_list: action.payload };
        default:
            return {};
    }
};

export const reducers = combineReducers({
    geod, user_list,
});

// store.js
export function configureStore(initialState = {}) {
    const store = createStore(
        reducers,
        initialState,
        applyMiddleware(thunk)
    )
    return store;
};

export const store = configureStore();