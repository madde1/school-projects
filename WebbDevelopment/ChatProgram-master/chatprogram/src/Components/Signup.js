import React from 'react';
import PropTypes from 'prop-types';
import axios from 'axios'

//Material-ui imports
import TextField from '@material-ui/core/TextField';
import Grid from '@material-ui/core/Grid';
import Button from '@material-ui/core/Button';
import { withStyles } from '@material-ui/styles';
import Typography from '@material-ui/core/Typography';

//Import of other classes and functions
import { setToken } from './AuthHelper';

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
        width:'350px'
    },
    button:{
        width:'200px'
    },
  };

class Signup extends React.Component {

  state = {
      user: '',
      pass: ''
  }

  handleFormSubmit(event) {
    event.preventDefault();
    axios({
        method: 'post',
        url: 'http://localhost:3010/signup',
        data: {
          username: this.state.user,
          password: this.state.pass
        }
    }).then((result) => {
        if (result && result.data && result.data.signedJWT) {
            setToken(result.data.signedJWT)
            this.props.history.replace('/');
        }
    })
}

  render() {
    //To be able to change style on html elements. 
    const { classes } = this.props;
    return (
      <div className={classes.form}>
        <div>
        <Typography align="center" variant="h3" gutterBottom>Come on and join our chatrooms!</Typography>
          <form onSubmit={event => this.handleFormSubmit(event)}>
            <Grid
            container
            direction="column"
            justify="center"
            alignItems="center"
            >
              <TextField
              className={classes.textField}
              id="outlined-email-input"
              label="Email"
              name="email"
              autoComplete="email"
              margin="normal"
              variant="outlined"
              type="text" 
              value={this.state.user}
              placeholder="email"
              onChange={e => this.setState({user: e.target.value})}
              />
              <br></br>
              <TextField 
              id="outlined-password-input"
              label="Password"
              className={classes.textField}
              name="password"
              autoComplete="password"
              margin="normal"
              variant="outlined"
              type="password" 
              value={this.state.pass}
              placeholder="password"
              onChange={e => this.setState({pass: e.target.value})}
              />
              <br></br>
              <Button className={classes.button}variant="contained" color="secondary" type="submit" value="Submit" >Sign up!</Button>
            </Grid>
          </form>
        </div>
      </div>
      )
  }
}

Signup.propTypes = {
    classes: PropTypes.object.isRequired,
  };

 export default withStyles(styles)(Signup);