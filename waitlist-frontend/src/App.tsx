import * as React from 'react';
import './App.css';
import { Switch, Route, withRouter, RouteComponentProps, Link } from 'react-router-dom';
import Home from './components/Home';
import Create from './components/customer/Create';
import EditCustomer from './components/customer/Edit';
import SignUp from "./components/restaurant/Signup";
import CustomerManagement from "./components/restaurant/CustomerManagement";
import Login from "./components/restaurant/Login";
import {
    createInstance,
    OptimizelyFeature,
    OptimizelyProvider,
    withOptimizely
} from '@optimizely/react-sdk';

const optimizely = createInstance({
    sdkKey: 'AW4TSFUnTcjcgygvuDVEF'
});

class App extends React.Component<RouteComponentProps<any>> {
  public render() {
    return (
        <OptimizelyProvider
            optimizely={optimizely}
            user={{
                id: 'user123',
            }}
        >
      <div>
        <nav>
          <ul>
          <li>
              <Link to={'/'}> Join Waitlist </Link>
            </li>
           
            <li>
              <Link to={'/queue'}> View Queue </Link>
            </li>
              <OptimizelyFeature feature="sign_up_restaurant">
                  {(enabled) => (
                      enabled
                          ?  <Link to =" "></Link>
                          :  <li> <Link to={'/signup'}> Signup Restaurant </Link> </li>
                  )}
              </OptimizelyFeature>
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
            <Route path={'/login'} exact component={Login} />
            <Route path={'/customers'} exact component={CustomerManagement}/>
          <Route path={'/edit/:id'} component={EditCustomer} />
            <OptimizelyFeature feature="sign_up_restaurant">
                {(enabled) => (
                    enabled
                        ?  <Route path={'/'} exact component={Create}></Route>
                        :  <Route path={'/signup'} exact component={SignUp} />
                )}
            </OptimizelyFeature>
        </Switch>
      </div>
        </OptimizelyProvider>
    );
  }
}

export default withRouter(App);