import axios from 'axios';

export default {

  viewMyProviderAvailability(){
    return axios.get('/appointment')
  },

  getApptStartTimeByDate(date) {
    return axios.get(`/appointment`, date)
  },

  createAppointment(date, startTime) {
    return axios.post(`/appointment`, date, startTime)
  }

}