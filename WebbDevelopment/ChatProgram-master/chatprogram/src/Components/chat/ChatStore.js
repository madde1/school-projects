const EventEmitter = require("events").EventEmitter;
//Event class. 
class ChatStore extends EventEmitter{
    constructor(props){
        super(props)
        this.state ={
            messages: [],
            username: ''
        }
    }
    //Method to set username
    init(username){
        this.emit("initialized", username);
        this.state.username = username;
        console.log("username: " + username)
    }
    //Method to get username
    getUsername(){
        return this.state.username;
    }

    //Method to send messages.
    addMessage(msg){
        this.state.messages.push(msg);
        this.emit("newMessage", msg);
        console.log("messages" , this.state.messages)
    }
}

module.exports = new ChatStore();