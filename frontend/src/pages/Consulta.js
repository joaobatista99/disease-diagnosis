import React from 'react';
import '../assets/css/Consulta.css';
import doctor from '../assets/images/doctor.png';
import Button from '../components/Button';
import { withRouter } from 'react-router-dom';

class Consulta extends React.Component {
  render() {
    return (
      <div className='Consulta-container'>
        <p className='Consulta-title'>Consulta</p>
        <div class='Consulta-content'>
          <img className='Consulta-doctor-image' src={doctor} />
          <div className="Consulta-input-div">
            <textarea className='Consulta-input' type='textarea' />
            <Button label="CONCLUIR" />
          </div>
        </div>
      </div>
    );
  }
}

export default withRouter(Consulta);
