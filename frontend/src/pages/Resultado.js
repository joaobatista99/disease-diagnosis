import React from 'react';
import '../assets/css/Resultado.css';
import doctor from '../assets/images/doctor2.png';
import Button from '../components/Button';
import { withRouter } from 'react-router-dom';

class Resultado extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      diagnosis: "",
    };

    this.reset = this.reset.bind(this);
  }

  componentDidMount(){
    this.setState({ diagnosis: this.props.location.state.diagnosis});
  }

  reset(){
    this.props.history.push("/home");
  }

  render () {
    return (
      <div className='Resultado-container'>
        <p className='Resultado-title'>Resultado</p>
        <div className='Resultado-content'>
          <img className='Resultado-doctor-image' src={doctor} />
          <p className="Resultado-pergunta">{this.state.diagnosis}</p>
        </div>
        <Button onClick={this.reset} label="CONCLUIR" />
      </div>
    );
  }
}

export default withRouter(Resultado);
