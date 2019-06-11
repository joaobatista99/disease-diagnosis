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
      console.log(res);
      this.setState({ question: res.data.question });
    });
  }

  getNextQuestion(){
    let paramsAnswer = { answer: this.state.answer };
    this.setState({ answer: "" });
    axios.get("http://localhost:8080/answerquestion", {params: paramsAnswer}).then(res => {
      console.log(res);
      if(res.data.diagnosis != undefined)
        this.props.history.push({ pathname: "/resultado", state: { diagnosis: res.data.diagnosis }});
      else
        this.setState({ question: res.data.question });
    });
  }

  render() {
    return (
      <div className='Consulta-container'>
        <p className='Consulta-title'>Consulta</p>
        <div className='Consulta-content'>
          <img className='Consulta-doctor-image' src={doctor} />
          <div className="Consulta-input-div">
            <p className="Consulta-pergunta">{this.state.question}</p>
            <textarea value={this.state.answer} onChange={(e) => this.setState({ answer: e.target.value })} className='Consulta-input' type='textarea' />
            <Button onClick={this.getNextQuestion} label="PRÓXIMO" />
          </div>
        </div>
      </div>
    );
  }
}

export default withRouter(Consulta);
