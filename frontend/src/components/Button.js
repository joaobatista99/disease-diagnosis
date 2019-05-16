import React from 'react';
import '../assets/css/Button.css';

class Button extends React.Component {
  render() {
    return(
      <div className='Button-container' onClick={this.props.onClick}>
        <p className='Button-title'>COMEÇAR</p>
      </div>
    );
  }
}

export default Button;
