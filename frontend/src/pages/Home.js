import React from 'react';
import '../assets/css/Home.css';
import hospital from '../assets/images/hospital.png';
import zombie from '../assets/images/zombie.png';
import zombies from '../assets/images/zombies.png';
import Button from '../components/Button';
import { withRouter } from 'react-router-dom';

class Home extends React.Component {
  render() {
    return (
      <div className='Home-container'>
        <p className='Home-title'>GANG LIBANÊS</p>
        <div className='Home-hospital-div'>
          <img src={zombie} className='Home-hospital-image'/>
          <img src={hospital} className='Home-hospital-image'/>
          <img src={zombies} className='Home-hospital-image'/>
        </div>
        <Button onClick={() => this.props.history.push('/consulta')} />
      </div>
    );

  }
}

export default withRouter(Home);
