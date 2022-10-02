import axios from 'axios';

export default {

  getAllProviders() {
    return axios.get('/providers')
  },
  getProvider(providerId){
    return axios.get(`/providers/${providerId}`)
  }
}