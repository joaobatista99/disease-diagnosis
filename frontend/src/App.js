import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Home from './pages/Home';
import Consulta from './pages/Consulta';
import Resultado from './pages/Resultado';

class App extends React.Component {
  render() {
    return(
      <BrowserRouter>
        <Switch>
          <Route exact path='/' component={Home} />
          <Route exact path='/home' component={Home} />
          <Route exact path='/consulta' component={Consulta} />
          <Route exact path='/resultado' component={Resultado} />
        </Switch>
      </BrowserRouter>
    );
  }
}

export default App;
