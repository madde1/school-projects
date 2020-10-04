import React from 'react';
import PropTypes from 'prop-types';

//Material-ui imports
import Button from '@material-ui/core/Button';
import { withStyles } from '@material-ui/styles';

//Import ChatStore component
import ChatStore from './ChatStore';

//Material-ui style
const styles ={
    root:{
        flexGrow:1,
        marginTop:'50px'
    },
    form:{
        marginTop:'50px'
    },
    container: {
      display: 'flex',
      flexWrap: 'wrap',
     
    },
    textField: {
        width:'350px',
        height:'50px',
        fontSize:'30px',
        marginTop:'20px',
        paddingLeft:'15px'
    },
    button:{
        width:'150px',
        height:'55px',
        fontSize:'25px',
        marginBottom:'12px'
    },
    paper:{
        width:'400px',
        height:'600px',
        marginTop:'50px'
    },
    header:{
        marginTop:'30px'
    }
}


class ChatInput extends React.Component{
    constructor(props){
        super(props)

        this.state = {
            message: ''
        }
    }

    //Event to handle when new message is being sent. 
    sendMessage(e){
        e.preventDefault();
        this.setState({message: this.msgTextField.value})
        //AddMessage method from chatstore. 
        ChatStore.addMessage(this.msgTextField.value);
        //Empyt the input field
        this.msgTextField.value="";
       // console.log("New Message: " + this.msgTextField.value);
    }
    render(){
         //To be able to change style on html elements. 
        const { classes } = this.props;
        return(
            <div>
            <input key={0} placeholder="Message" className={classes.textField} ref={input => this.msgTextField = input}/>
            <Button  className={classes.button}variant="contained" color="secondary" type="submit" value="Submit" onClick={this.sendMessage.bind(this)} >Send</Button>
            </div>
         
        )
    }
}

ChatInput.propTypes = {
    classes: PropTypes.object.isRequired,
  };

  export default withStyles(styles)(ChatInput);