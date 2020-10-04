import React from 'react';
import PropTypes from 'prop-types';

//Material-ui imports
import { withStyles } from '@material-ui/styles';
import Grid from '@material-ui/core/Grid';

//Import all chat components
import ChatContainer from './ChatContainer';
import ChatInput from './ChatInput';
import ChatStore from './ChatStore';

//Socket io
const io = require('socket.io-client');


//Material-ui styling
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
        width:'400px'
    },
    button:{
        width:'200px'
    },
    paper:{
        width:'200px',
        height:'600px',
        marginTop:'50px',
        marginRight:'50px'
    },
    header:{
        marginTop:'30px'
    },
    conChat:{
        width:'800px',
        height:'760px'
    }
}




class ChatApp extends React.Component{
 
  //Constructor to use state and be able to save and change value of variables. 
    constructor(props){
        super(props)
        this.state ={
         url: "",
            messages: [],
            username: '',
    
        }
    }

    //Lifecycle with methods to store and send messages and username
    componentDidMount() {
      //Used to call the server method
        this.initSocket();
    
        //Set the username
        ChatStore.on("initialized", username => {
          this.setState({ username: username });
        });
    
        //New message - setting message, who sent it and emiting it to server. 
        ChatStore.on("newMessage", msg => {
          //Store the Message
          let newMsg = { msg: msg, username: this.state.username };
          this.setState(prevState => ({
            messages: [...prevState.messages, newMsg]
          }));
          this.io.emit("chat-message", newMsg);
          console.log("New Message ", msg);
        });
    
        // Message Coming from other Users
        this.io.on("chat-message", newMsg => {
            if(newMsg.username !== ''){
          this.setState(prevState => ({
            messages: [...prevState.messages, newMsg]
          }));
          console.log("Message from Another User: "+ newMsg.username, newMsg.msg);
        }})
      }

    //Connect to the Server using Socket IO
      initSocket() {
        this.io = io("http://localhost:3010");
        console.log("IO: ", this.io);
      }

    render(){
   
        return(
            <Grid
            container
            direction="column"
            justify="center"
            alignItems="center"
            >            
            <ChatContainer messages={this.state.messages} username={this.state.username}/>             
            <ChatInput />
            </Grid>
        )
    }
}

ChatApp.propTypes = {
    classes: PropTypes.object.isRequired,
  };

  export default withStyles(styles)(ChatApp);