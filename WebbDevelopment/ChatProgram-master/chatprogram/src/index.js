import React, { Fragment } from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route} from "react-router-dom";

//Import of other classes and functions
import App from './Components/App';
import { Nav } from './Components/Navbar'
import  SingUp  from './Components/Signup';
import  Login  from './Components/Login';

//Material-ui imports
import { Typography } from '@material-ui/core';

class Index extends React.Component{

    state = {
        categorySelected : 0,
        title: 'HomePage'
    }
    
    //Method to change page and title on page when other navigation part i pressed. 
    onCategoryChange = selectedCat => {
        console.log("selected category: " + selectedCat)
        this.setState({
            categorySelected : selectedCat
        })
        if(selectedCat === 0){
          
            this.setState({
                title: "Homepage" 
            })
          
        }else if(selectedCat === 1){
              this.setState({
                title: "Sign up to the chat program"
            })
            
        }else if(selectedCat === 2){
            this.setState({
                title: "Sign in"
            })
        
        }
    }

render(){  
    return(
        
        <Router>
         <Fragment>
                <Nav selectedCat={this.state.categorySelected} onSelect={this.onCategoryChange}/>
                <Typography variant="h1" component="h2" align='center' onSelect={this.onCategoryChange}>{this.state.title}</Typography>
                <Route exact path="/" component={App} />
               <Route exact path="/Signup" component={SingUp}/>
               <Route exact path="/Login" component={Login} />
               </Fragment>
        </Router>
       
    
    )
}
}

ReactDOM.render(<Index />, document.getElementById('root'))