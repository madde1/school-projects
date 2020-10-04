import React from 'react';
import PropTypes from 'prop-types';

//Material-ui imports
import { Paper } from '@material-ui/core';
import { withStyles } from '@material-ui/styles';



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
      marginLeft: '120px',
      marginRight: '120px',
        width:'400px'
    },
    button:{
        width:'200px'
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

class ChatContainer extends React.Component{

render(){
    //To be able to change style on html elements. 
    const { classes } = this.props;
    return(
        <div>
            <Paper className={classes.paper}>
             {/**Render out the messages in the chat window. 
                Checks if username is the "your username" and if it is prints out
                message on the left side */}   
            <ul align="left">
                {this.props.messages.map((msgObj, index)=>{
                if(msgObj.username === this.props.username){
                return <li style={{listStyleType:"none"}} key={index}>
                {msgObj.username+ " - " + msgObj.msg}
                </li>
                }
                return null
                })}
            </ul>
                {/**Same as the code above but checks if its not "your username" then 
                    render out the message on the right side och the chat window. */}
            <ul align="right">
                {this.props.messages.map((msgObj, index)=>{
                if(msgObj.username !== this.props.username){
                return <li style={{listStyleType:"none"}} key={index}>
                {msgObj.username+ " - " + msgObj.msg}
                </li>
                }
                return null
                })}
            </ul>
            </Paper> 
        </div>
        )
    }
}

ChatContainer.propTypes = {
    classes: PropTypes.object.isRequired,
  };

export default withStyles(styles)(ChatContainer);