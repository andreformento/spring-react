import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './app/App';
import registerServiceWorker from './registerServiceWorker';
import { BrowserRouter as Router } from 'react-router-dom';
import { SnackbarProvider } from 'notistack';

ReactDOM.render(
    <Router>
        <SnackbarProvider maxSnack={3} anchorOrigin={{ vertical: 'top', horizontal: 'center', }}>
            <App />
        </SnackbarProvider>
    </Router>,
    document.getElementById('root')
);

registerServiceWorker();
