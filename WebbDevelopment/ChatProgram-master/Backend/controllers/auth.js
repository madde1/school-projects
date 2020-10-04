//imports User from user.model
const User = require('../models/user.model')
//JsonWebtoken import
const jwt = require('jsonwebtoken')

//Create new user function
function createJWT(user) {
    return jwt.sign({ id: user.id }, process.env.JWT_DEV_ENV_SECRET, {
        expiresIn: process.env.JWT_DEV_ENV_EXP
    })
}
//Verifyes token.
const verifyJWT = token =>
  new Promise((resolve, reject) => {
    jwt.verify(token, process.env.JWT_DEV_ENV_SECRET, (err, payload) => {
      if (err) return reject(err)
      resolve(payload)
    })
})

//Signup function to create new user with the data coming in
const signup = (req, res) => {
    const user = new User()
    user.email = req.body.username
    user.password = req.body.password
    user.save(function (err, user) {
        if (err) {
            console.log(err)
            return res.status(500).end()
        } else {
            const signedJWT = createJWT(user)
            return res.status(201).send({ signedJWT })
        }
    })
}

//Login function checks username and passwords in db for match
const login = async (req, res) => {
    const user = await User.findOne({ email: req.body.username }).exec()
    if (!user) {
        return res.status(400).send({ message: 'invalid combination' })
    }
    const matchingPasswords = await user.checkPassword(req.body.password)
    if (!matchingPasswords) {
        return res.status(400).send({ message: 'invalid combination' })
    }
    const signedJWT = createJWT(user)
    return res.status(201).send({ signedJWT })
}

//Checks if autorized. 
const isAuthorized = async (req, res, next) => {

    const bearer = req.headers.authorization
    
    const token = bearer.split('Bearer ')[1].trim()
    let payload

    try {
        payload = await verifyJWT(token)
    } catch (e) {
        return res.status(500).end()
    }

    const user = await User.findById(payload.id).exec()

    if (!user) {
        return res.status(500).end()
    }

    req.user = user
    next()
}

module.exports = {
    signup: signup,
    login: login,
    isAuthorized: isAuthorized
}