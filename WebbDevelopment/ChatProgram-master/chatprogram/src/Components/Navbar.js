import React from 'react';
import { Link } from "react-router-dom";

//Material-ui imports
import Paper from '@material-ui/core/Paper';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import { makeStyles } from '@material-ui/core/styles';


//Css settings
const useStyles = makeStyles(theme => ({
    paper: {
      marginBottom:'50px'
    },
  }));

//Destructuring - Use object insted of props to easier be able to use key values. 
export const Nav = ({selectedCat, onSelect}) => {
    const classes = useStyles();
    return (
        <Paper className={classes.paper} >
        <Tabs
            value={selectedCat}
            onChange={(event, index) => {onSelect(index)}}
            indicatorColor="primary"
            textColor="primary"
            centered
        >
            <Tab label="Home" component={Link} to="/"/>
            <Tab label="SingUp" component={Link} to="/signup"/>
            <Tab label="Login" component={Link} to="/login"/>
        </Tabs>
        </Paper>
    )
}
