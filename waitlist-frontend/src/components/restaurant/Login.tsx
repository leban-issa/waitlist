import * as React from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import axios from 'axios';


export interface IValues {
    name: string,
    password: string
}

export interface IFormState {
    [key: string]: any;
    values: IValues[];
    submitSuccess: boolean;
    loading: boolean;
}

export default class Login extends React.Component<RouteComponentProps, IFormState> {
    constructor(props: RouteComponentProps) {
        super(props);
        this.state = {
            name: '',
            password: '',
            values: [],
            loading: false,
            submitSuccess: false,
        }
    }

    private processFormSubmission = (e: React.FormEvent<HTMLFormElement>): void => {
        e.preventDefault();
        this.setState({ loading: true });

        const formData = {
            name: this.state.name,
            password: this.state.password
        }

        this.setState({ submitSuccess: true, values: [...this.state.values, formData], loading: false });
        this.props.history.push('/customers');
    }

    private handleInputChanges = (e: React.FormEvent<HTMLInputElement>) => {
        e.preventDefault();
        this.setState({
            [e.currentTarget.name]: e.currentTarget.value,
        })
    }

    public render() {
        const { submitSuccess, loading } = this.state;

        return (
            <div>
                <div className={"col-md-12 form-wrapper"}>
                    <h2>  </h2>
                    {!submitSuccess && (
                        <div className="alert alert-info" role="alert">
                            Fill form below to login
                        </div>
                    )}

                    {submitSuccess && (
                        <div className="alert alert-info" role="alert">
                            Successfully logged in
                        </div>
                    )}

                    <form id={"login"} onSubmit={this.processFormSubmission} noValidate={false}>
                        <div className="form-group col-md-12">
                            <label htmlFor="name"> Restaurant Name </label>
                            <input type="text" id="name" onChange={(e) => this.handleInputChanges(e)} name="name" className="form-control" placeholder="Enter Restaurant Name" required />
                        </div>

                        <div className="form-group col-md-12">
                            <label htmlFor="password"> Password </label>
                            <input type="password" id="password" onChange={(e) => this.handleInputChanges(e)} name="password" className="form-control" placeholder="Enter Password" required />
                        </div>

                        <div className="form-group col-md-4 pull-right">
                            <button className="btn btn-success" type="submit" >
                                Login
                            </button>
                            {loading &&
                            <span className="fa fa-circle-o-notch fa-spin" />
                            }
                        </div>
                    </form>
                </div>
            </div>
        )
    }
}
