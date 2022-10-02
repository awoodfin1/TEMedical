import axios from 'axios';

export default {

  getPatientByApptId(apptId) {
    return axios.get(`/patient/appointment/${apptId}`)
  },

  getPatientByUsername() {
    return axios.get('/patient/my-profile')
  },

  updatePatient(updatedPatient) {
    return axios.put('/patient/my-profile', updatedPatient)
  }
}