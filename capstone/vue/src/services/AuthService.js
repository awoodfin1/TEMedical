import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },

  getOfficeInfo(){
    return axios.get('/office')
  },

  getDisplayApptUpdate() {
    return axios.get('/user')
  },

  flipDisplayApptUpdate() {
    return axios.put('/user', false)
  }

}
