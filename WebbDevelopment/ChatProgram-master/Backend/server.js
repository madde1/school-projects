//Imports
const cors = require('cors')
const bodyParser = require('body-parser')
const mongoose = require('mongoose')
const envVars = require('dotenv').config()
//Express imports
const express = require('express')
const app = express()
//Setting port to 3010
const port = 3010;
//Socket io imports
const http = require("http").createServer(app);
const io = require("socket.io")(http);
//controlles functions from auth.js 
const signup = require('./controllers/auth').signup
const login = require('./controllers/auth').login
const isAuthorized = require('./controllers/auth').isAuthorized


if (envVars.error) {
  console.log('Erro parsing environment variables')
}

app.use(cors())
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({extended: true}))

//Connecting to mongodb
mongoose.connect('mongodb://localhost/users', {useNewUrlParser: true, useCreateIndex: true})
mongoose.connection.on('error', console.error.bind(console, 'MongoDB connection error:'))

//
app.get('/', function(req, res){
 res.json({someProperty : "Some value"})
})

//Post method route
app.post('/signup', signup)
app.post('/login', login)
//Get method route
app.use('/api', isAuthorized)

//Socket io - on connection methods
io.on("connection", socket =>{

  console.log("New client connected");

  //New message method
  socket.on("chat-message", msg =>{
    console.log("New message: " + msg);
    //Only sends message to other user
    socket.broadcast.emit("chat-message", msg);
  });

  //On disconnect, only console log client disconnected in server terminal
  socket.on("disconnect", () =>{
    console.log("Client disconnected");
  })
})

//Listening on port 3010. 
http.listen(port, ()=>{
  console.log("Server is running on port: " + port)
})
