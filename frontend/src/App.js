import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Home from './pages/Home';
import Consulta from './pages/Consulta';

class App extends React.Component {
  render() {
    return(
      <BrowserRouter>
        <Switch>
          <Route path='/home' component={Home} />
          <Route path='/consulta' component={Consulta} />
        </Switch>
      </BrowserRouter>
    );
  }
}

export default App;
