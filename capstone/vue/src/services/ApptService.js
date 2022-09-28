import axios from 'axios';

export default {

  // viewMyProviderAvailability(){
  //   return axios.get('/appointment')
  // },

  getApptStartTimeByDate(date) {
    return axios.get(`/appointment/${date}`)
  },

  createAppointment(apptRequest) {
    return axios.post(`/appointment`, apptRequest)
  }

}