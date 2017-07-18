import React, { Component, Text} from 'react';
import { connect } from 'react-redux';

import {
    activateTest,
    closeTest,
    getUserList,
} from '../actions/actions';

// App.js
export class App extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>

                <h4> User List </h4>

                {this.props.value.title ?
                    <button onClick={this.props.closeTest}>
                        Exit Test
                    </button> :
                    <button onClick={() => this.props.activateTest({ title: 'I am a geo dude!' })}>
                        Test
                    </button>
                }

                <button onClick={() => (this.props.getUserList())}>
                    Get User List
                </button>

                <br/>

                <ul>
                    {
                        this.props.user_list.user_list ?
                            this.props.user_list.user_list.map((user) => {
                                return(
                                    <li key={user.id}>{user.firstName}, {user.lastName}, {user.description}</li>
                                )
                            }) :
                            console.log("after", this.props.user_list)
                    }
                </ul>

            </div>
        );
    }
}

// AppContainer.js
const mapStateToProps = (state, ownProps) => ({
    value : state.geod,
    user_list : state.user_list,
});

const mapDispatchToProps = {
    activateTest,
    closeTest,
    getUserList,
};

export default connect(
    mapStateToProps, mapDispatchToProps,
)(App);