import React from 'react';
import '../assets/css/Consulta.css';
import doctor from '../assets/images/doctor.png';
import Button from '../components/Button';
import { withRouter } from 'react-router-dom';
import axios from 'axios';

class Consulta extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      question: "",
      answer: ""
    };

    this.getNextQuestion = this.getNextQuestion.bind(this);
  }

  componentDidMount(){
    axios.get("http://localhost:8080/newappointment").then(res => {
      this.setState({ question: res.body.question });
      console.log(res);
    });
  }

  getNextQuestion(){
    let params = { answer: this.answer };
    axios.get("http://localhost:8080/answerquestion", params).then(res => {
      this.setState({ question: res.question });
    });
  }

  render() {
    return (
      <div className='Consulta-container'>
        <p className='Consulta-title'>Consulta</p>
        <div class='Consulta-content'>
          <img className='Consulta-doctor-image' src={doctor} />
          <div className="Consulta-input-div">
            <p className="Consulta-pergunta">{this.state.question}</p>
            <textarea className='Consulta-input' type='textarea' />
            <Button onClick={this.getNextQuestion} label="CONCLUIR" />
          </div>
        </div>
      </div>
    );
  }
}

export default withRouter(Consulta);
