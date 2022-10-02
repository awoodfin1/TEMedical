import axios from 'axios';

export default {

  //going to have to update this method
  getApptStartTimeByDate(date) {
    return axios.get(`/appointment/${date}`)
  },

  createAppointment(apptRequest) {
    return axios.post(`/appointment`, apptRequest)
  },

  getAppointments() {
    return axios.get('/my-appointments')
  },

  getAppointmentsByDate(date) {
    return axios.get(`/my-appointments/${date}`)
  },

  getAppointmentById(apptId) {
    return axios.get(`/my-appointments/${apptId}`)
  },

  updateAppointment(apptId, updatedAppt) {
    return axios.put(`/my-appointments/${apptId}`, updatedAppt)
  }



}