import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Home from './pages/Home';

class App extends React.Component {
  render() {
    return(
      <BrowserRouter>
        <Switch>
          <Route path='/home' component={Home} />
        </Switch>
      </BrowserRouter>
    );
  }
}

export default App;
