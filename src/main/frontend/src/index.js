import React from 'react';
import ReactDOM from 'react-dom';
import App from './containers/App';
// import './main.css';

// Add these imports - Step 1
import { Provider } from 'react-redux';
import { store } from './reducers/redux';

// Wrap existing app in Provider - Step 2
ReactDOM.render(
    <Provider store={store}>
        <App />
    </Provider>,
    document.getElementById('app')
);