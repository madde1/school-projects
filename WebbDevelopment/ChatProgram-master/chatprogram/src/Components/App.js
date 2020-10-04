import React from 'react';
import axios from 'axios'
import PropTypes from 'prop-types';

//Material-ui imports
import { Typography } from '@material-ui/core';
import Grid from '@material-ui/core/Grid';
import { withStyles } from '@material-ui/styles';

//Import of other classes and functions
import { isLoggedIn, getToken } from './AuthHelper';
import ChatApp from './chat/ChatApp';

//Css settings
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

class App extends React.Component {

    //Lifecycle to get if logged in and if tokens match show protected part (Chatprogram)
    componentDidMount() {
        if (!isLoggedIn()) {
            this.props.history.replace('/login')
        } else {
            axios({
                method: 'get',
                url: 'http://localhost:3010/',
                headers: {
                    authorization: 'Bearer ' + getToken()
                }
            }).then((result) => {
                    console.log("app protected resource")
                    console.log(result)
            })
        }
    }

    render() {
          //To be able to change style on html elements. 
        const { classes } = this.props;

        return (
            <Grid
            container
            direction="column"
            justify="center"
            alignItems="center"
            >
            <Typography className={classes.header} align="center" variant="h3" >Chatroom </Typography>
              <ChatApp />
           </Grid>
        )
    }
}

App.propTypes = {
    classes: PropTypes.object.isRequired,
  };

export default withStyles(styles)(App);
