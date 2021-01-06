import React, { Component } from 'react';
import './Workspaces.css';

class Workspaces extends Component {
    constructor(props) {
        super(props);
        console.log(props);
    }
    render() {
        return (
            <div className="workspaces-container">
                <div className="container">
                    <div className="workspaces-info">
                        <div className="workspaces-avatar">
                            {
                                this.props.currentUser.imageUrl ? (
                                    <img src={this.props.currentUser.imageUrl} alt={this.props.currentUser.name}/>
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