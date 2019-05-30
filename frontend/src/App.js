import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Home from './pages/Home';
import Consulta from './pages/Consulta';

class App extends React.Component {
  render() {
    return(
      <BrowserRouter>
        <Switch>
          <Route exact path='/' component={Home} />
          <Route exact path='/home' component={Home} />
          <Route exact path='/consulta' component={Consulta} />
        </Switch>
      </BrowserRouter>
    );
  }
}

export default App;
