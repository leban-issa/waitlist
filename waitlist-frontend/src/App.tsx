import * as React from 'react';
import './App.css';
import { Switch, Route, withRouter, RouteComponentProps, Link } from 'react-router-dom';
import Home from './components/Home';
import Create from './components/customer/Create';
import EditCustomer from './components/customer/Edit';
import SignUp from "./components/restaurant/Signup";
import CustomerManagement from "./components/restaurant/CustomerManagement";
import Login from "./components/restaurant/Login";



class App extends React.Component<RouteComponentProps<any>> {
  public render() {
    return (
      <div>
        <nav>
          <ul>
          <li>
              <Link to={'/'}> Join Waitlist </Link>
            </li>
           
            <li>
              <Link to={'/queue'}> View Queue </Link>
            </li>

              <li>
                  <Link to={'/signup'}> Signup Restaurant </Link>
              </li>

              <li>
                  <Link to={'/login'}> Login </Link>
              </li>

              <li>
                  <Link to={'/customers'}> Waitlist Management </Link>
              </li>
          </ul>
        </nav>

        <Switch>
          <Route path={'/'} exact component={Create} />
          <Route path={'/queue'} component={Home}></Route>
            <Route path={'/signup'} exact component={SignUp} />
            <Route path={'/login'} exact component={Login} />
            <Route path={'/customers'} exact component={CustomerManagement}/>
          <Route path={'/edit/:id'} component={EditCustomer} />
        </Switch>
      </div>
    );
  }
}

export default withRouter(App);