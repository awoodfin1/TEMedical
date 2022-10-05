import axios from 'axios';

export default {

  getAllProviders() {
    return axios.get('/providers')
  },

  getProvider(providerId){
    return axios.get(`/providers/${providerId}`)
  },

  getProviderByUsername(){
    return axios.get('/provider/my-profile')
  },

  updateProvider(updatedProvider){
    return axios.put('/provider/my-profile', updatedProvider)
  },

  getProviderIdByFullName(fullName) {
    return axios.get(`/provider/${fullName}`)
  }
}