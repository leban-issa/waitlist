import * as React from 'react';
import { RouteComponentProps, withRouter } from 'react-router-dom';
import axios from 'axios';

export interface IValues {
    name: string,
    email: string,
    phone: string,
    partySize: string
}

export interface IFormState {
    [key: string]: any;
    values: IValues[];
    submitSuccess: boolean;
    loading: boolean;
    errors : {
        name :  string,
        email : string,
        phone : string,
        partySize : string

    }
}

const Regex = RegExp(/^\s?[A-Z0–9]+[A-Z0–9._+-]{0,}@[A-Z0–9._+-]+\.[A-Z0–9]{2,4}\s?$/i);
const phoneRegex= RegExp(/^\d{3}\.\d{3}\.\d{4}$/i);

export default class Create extends React.Component<RouteComponentProps, IFormState> {
    constructor(props: RouteComponentProps) {
        super(props);
        this.state = {
            name: '',
            email: '',
            phone: '',
            partySize: '',
            values: [],
            loading: false,
            submitSuccess: false,
            errors : {
                name :  '',
                email : '',
                phone : '',
                partySize : ''

            }
        }
    }

    private processFormSubmission = (e: React.FormEvent<HTMLFormElement>): void => {
        e.preventDefault();
        this.setState({ loading: true });

        const formData = {
            name: this.state.name,
            email: this.state.email,
            phone: this.state.phone,
            partySize: this.state.partySize,
        }

        this.setState({ submitSuccess: true, values: [...this.state.values, formData], loading: false });

        axios.post(`http://localhost:8080/Customer/addCustomer`, formData).then(data => [
            setTimeout(() => {
                this.props.history.push('/queue');
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
                            Fill the form below to join the waitlist
                        </div>
                    )}

                    {submitSuccess && (
                        <div className="alert alert-info" role="alert">
                            Successfully joined the waitlist
                        </div>
                    )}

                    <form id={"create-post-form"} onSubmit={this.processFormSubmission} noValidate={false}>
                        <div className="form-group col-md-12">
                            <label htmlFor="name"> Full Name </label>
                            <input type="text" id="name" onChange={(e) => this.handleInputChanges(e)} name="name" className="form-control" placeholder="Enter Name" required />
                            {/*<div className={"invalid"}>*/}
                            {/*    Please Enter a Name*/}
                            {/*</div>*/}
                        </div>

                        <div className="form-group col-md-12">
                            <label htmlFor="email"> Email </label>
                            <input type="email" id="email" onChange={(e) => this.handleInputChanges(e)} name="email" className="form-control" placeholder="Enter Email Address" required />
                            <div className={"invalid-feedback"}>
                                Please Enter a Email
                            </div>
                        </div>

                        <div className="form-group col-md-12">
                            <label htmlFor="phone"> Phone </label>
                            <input type="text" id="phone" onChange={(e) => this.handleInputChanges(e)} name="phone" className="form-control" pattern={"^\\d{3}-\\d{3}-\\d{4}$"} placeholder="Enter Phone Number with format xxx-xxx-xxxx" required />
                        </div>

                        <div className="form-group col-md-12">
                            <label htmlFor="partySize"> Party Size </label>
                            <input type="text" id="partySize" onChange={(e) => this.handleInputChanges(e)} name="partySize" className="form-control" placeholder="Enter Party Size" required />
                        </div>

                        <div className="form-group col-md-4 pull-right">
                            <button className="btn btn-success" type="submit" >
                                Join Waitlist
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

//export default withRouter(Create)