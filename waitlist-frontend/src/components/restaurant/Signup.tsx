import * as React from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import axios from 'axios';

export interface IValues {
    name: string,
    address: string,
    phoneNumber: string
    password: string
}

export interface IFormState {
    [key: string]: any;
    values: IValues[];
    submitSuccess: boolean;
    loading: boolean;
}

export default class SignUp extends React.Component<RouteComponentProps, IFormState> {
    constructor(props: RouteComponentProps) {
        super(props);
        this.state = {
            name: '',
            address: '',
            phoneNumber: '',
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
            address: this.state.address,
            phoneNumber: this.state.phoneNumber,
            password: this.state.password
        }

        this.setState({ submitSuccess: true, values: [...this.state.values, formData], loading: false });

        axios.post(`http://localhost:8080/Restaurant/addRestaurant`, formData).then(data => [
            setTimeout(() => {
                this.props.history.push('/');
            }, 1500)
        ]);
    }

    private handleInputChanges = (e: React.FormEvent<HTMLInputElement>) => {
        e.preventDefault();
        this.setState({
            [e.currentTarget.name]: e.currentTarget.value,
        })
    }

    public render() {
        const { submitSuccess, loading } = this.state;
        const txtFieldState = {
            value: "",
            valid: true,
            typeMismatch: false,
            errMsg: "" //this is where our error message gets across
        };
        return (
            <div>
                <div className={"col-md-12 form-wrapper"}>
                    <h2>  </h2>
                    {!submitSuccess && (
                        <div className="alert alert-info" role="alert">
                            Fill the form below to sign up your restaurant
                        </div>
                    )}

                    {submitSuccess && (
                        <div className="alert alert-info" role="alert">
                            Successfully signed up
                        </div>
                    )}

                    <form id={"sign-up"} onSubmit={this.processFormSubmission} noValidate={false}>
                        <div className="form-group col-md-12">
                            <label htmlFor="name"> Restaurant Name </label>
                            <input type="text" id="name" onChange={(e) => this.handleInputChanges(e)} name="name" className="form-control" placeholder="Enter Restaurant Name" required />
                            {/*<div className={"invalid"}>*/}
                            {/*    Please Enter a Name*/}
                            {/*</div>*/}
                        </div>

                        <div className="form-group col-md-12">
                            <label htmlFor="address"> Address </label>
                            <input type="address" id="address" onChange={(e) => this.handleInputChanges(e)} name="address" className="form-control" placeholder="Enter Address" required />
                        </div>

                        <div className="form-group col-md-12">
                            <label htmlFor="phoneNumber"> Phone Number </label>
                            <input type="tel" id="phoneNumber" onChange={(e) => this.handleInputChanges(e)} name="phoneNumber" className="form-control" pattern={"^\\d{3}-\\d{3}-\\d{4}$"} placeholder="123-456-7777" required />
                        </div>

                        <div className="form-group col-md-12">
                            <label htmlFor="password"> Password </label>
                            <input type="password" id="password" onChange={(e) => this.handleInputChanges(e)} name="password" className="form-control" placeholder="Enter Password" required />
                        </div>

                        <div className="form-group col-md-4 pull-right">
                            <button className="btn btn-success" type="submit" id="submitButton" >
                                Sign Up
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
