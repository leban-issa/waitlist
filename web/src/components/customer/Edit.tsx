import * as React from 'react';
import { RouteComponentProps, withRouter } from 'react-router-dom';
import axios from 'axios';

export interface IValues {
    [key: string]: any;
}

export interface IFormState {
    id: string,
    customer: any;
    values: IValues[];
    submitSuccess: boolean;
    loading: boolean;
}

class EditCustomer extends React.Component<RouteComponentProps<any>, IFormState> {
    constructor(props: RouteComponentProps) {
        super(props);
        this.state = {
            id: this.props.match.params.id,
            customer: {},
            values: [],
            loading: false,
            submitSuccess: false,
        }
    }

    public componentDidMount(): void {
        axios.get(` http://localhost:8080/Customer/findAllCustomers/${this.state.id}`).then(data => {
            this.setState({ customer: data.data });
        })
    }

    private processFormSubmission = async (e: React.FormEvent<HTMLFormElement>): Promise<void> => {
        e.preventDefault();
        this.setState({ loading: true });
        axios.put(` http://localhost:8080/Customer/findAllCustomers/${this.state.id}`, this.state.values).then(data => {
            this.setState({ submitSuccess: true, loading: false })
            setTimeout(() => {
                this.props.history.push('/customers');
            }, 1500)
        })
    }


    private setValues = (values: IValues) => {
        this.setState({ values: { ...this.state.values, ...values } });
    }

    private handleInputChanges = (e: React.FormEvent<HTMLInputElement>) => {
        e.preventDefault();
        this.setValues({ [e.currentTarget.id]: e.currentTarget.value })
    }

    public render() {
        const { submitSuccess, loading } = this.state;
        return (
            <div className="App">
                {this.state.customer &&
                    <div>
                        < h1 > </h1>
                        


                        <div>
                            <div className={"col-md-12 form-wrapper"}>
                                <h2> Edit Customer </h2>

                                {submitSuccess && (
                                    <div className="alert alert-info" role="alert">
                                        Customer's details has been edited successfully </div>
                                )}

                                <form id={"create-post-form"} onSubmit={this.processFormSubmission} noValidate={true}>
                                    <div className="form-group col-md-12">
                                        <label htmlFor="name">  Name </label>
                                        <input type="text" id="name" defaultValue={this.state.customer.name} onChange={(e) => this.handleInputChanges(e)} name="name" className="form-control" placeholder="Enter customer's name" />
                                    </div>

                                    <div className="form-group col-md-12">
                                        <label htmlFor="email"> Email </label>
                                        <input type="email" id="email" defaultValue={this.state.customer.email} onChange={(e) => this.handleInputChanges(e)} name="email" className="form-control" placeholder="Enter customer's email address" />
                                    </div>

                                    <div className="form-group col-md-12">
                                        <label htmlFor="phone"> Phone </label>
                                        <input type="text" id="phone" defaultValue={this.state.customer.phone} onChange={(e) => this.handleInputChanges(e)} name="phone" className="form-control" placeholder="Enter customer's phone number" />
                                    </div>

                                    <div className="form-group col-md-12">
                                        <label htmlFor="partySize"> Party Size </label>
                                        <input type="text" id="partySize" defaultValue={this.state.customer.partySize} onChange={(e) => this.handleInputChanges(e)} name="partySize" className="form-control" placeholder="Enter party size" />
                                    </div>

                                    <div className="form-group col-md-4 pull-right">
                                        <button className="btn btn-success" type="submit">
                                            Edit Customer </button>
                                        {loading &&
                                            <span className="fa fa-circle-o-notch fa-spin" />
                                        }
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                }
            </div>
        )
    }
}

export default withRouter(EditCustomer)