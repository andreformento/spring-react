import React, { Component } from 'react';
import { getWorkspaces, createWorkspace } from '../util/APIUtils';
import './Workspaces.css';

class Workspaces extends Component {
    constructor(props) {
        super(props);
        this.state = {
            currentWorkspace: null,
            loading: false
        }
        this.loadWorkspaces = this.loadWorkspaces.bind(this);
    }

    loadWorkspaces() {
        this.setState({
            loading: true
        });

        getWorkspaces()
            .then(response => {
                this.setState({
                    workspaces: response,
                    loading: false
                });

                console.log('workspaces', response)
            }).catch(error => {
                this.setState({
                    loading: false
                });
            });
    }

    componentDidMount() {
        this.loadWorkspaces();
    }

    handleSubmit = (event) => {
        let newWorkspace = {name: event.target.name.value};

        createWorkspace(newWorkspace)
            .then(response => {
                this.setState({
                    workspaces: response,
                    loading: false
                });

                console.log('workspaces', response)
            }).catch(error => {
                this.setState({
                    loading: false
                });
            });

        event.preventDefault();
    }

    render() {
        return (
            <div className="workspaces-container">
                <div className="container">
                    <form onSubmit={this.handleSubmit}>
                        <label> Name:
                            <input type="text" value={this.state.value} name="name" onChange={this.handleChange} />
                        </label>
                        <input type="submit" value="Submit" />
                    </form>
                </div>

                <div className="container">
                    <div className="workspaces-info">
                        <div className="workspaces-avatar">
                            {
                                this.props.currentUser.imageUrl ? (
                                    <img src={this.props.currentUser.imageUrl} alt={this.props.currentUser.name} />
                                ) : (
                                        <div className="text-avatar">
                                            <span>{this.props.currentUser.name && this.props.currentUser.name[0]}</span>
                                        </div>
                                    )
                            }
                        </div>
                        <div className="workspaces-name">
                            <h2>{this.props.currentUser.name}</h2>
                            <p className="workspaces-email">{this.props.currentUser.email}</p>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Workspaces
