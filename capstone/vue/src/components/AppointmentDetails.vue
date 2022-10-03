<template>
  <div class="appointment-container">
        <div class="appointment-details">
            <h3 class="top-line">Appointment Id: {{ appointment.id }} | Status: {{ appointment.status }}</h3>
            <img class="appt-pic" src="@/images/Appointment.png" alt="Appointment-Image">
            <div class = "appointment-info">
              <h1>Appointment Information</h1>
              <h3>Date: {{ appointment.appointmentDate }}</h3>
              <h3>Time: {{ appointment.apptStartTime }} - {{ appointment.apptEndTime }}</h3>
              <h3 v-if="appointment.appointmentReason">Reason For Appointment (if provided):</h3>
              <p v-if="appointment.appointmentReason">{{ appointment.appointmentReason }}</p>
              <h3 v-if="appointment.appointmentDetails">Appointment Details (if provided):</h3>
              <p v-if="appointment.appointmentDetails">{{ appointment.appointmentDetails }}</p>
            </div>
            <div class="patient-info" v-if="$store.state.user.provider">
              <h1>Patient Information</h1>
              <h3>Name: {{ $store.state.apptPatient.firstName }} {{ $store.state.apptPatient.lastName }}</h3>
              <h4>DOB: {{ $store.state.apptPatient.birthdate }}</h4>
              <h4>Health Issues Description:</h4>
              <p>{{ $store.state.apptPatient.healthIssuesDescription }}</p>
            </div>
            <input v-if="$store.state.user.provider && !updateAppointment" v-on:click.prevent="flipBoolean" type="button" name="updateAppointment" id="updateAppointment" value="Update Appointment">
            <!-- Implement Update Appointment Form HERE -->
        </div>
    </div>
</template>

<script>
import ApptService from "../services/ApptService";
import PatientService from '../services/PatientService'

export default {
  name: 'appointment-details',
  props: {
    'apptId': Number
  },
  data() {
    return {
      appointment: [],
      // apptPatient: []
      updateAppointment: false,
    }
  },
  created() {
    ApptService.getAppointmentById(this.apptId).then( (response) => {
      this.appointment = response.data
    });
    PatientService.getPatientByApptId(this.apptId).then( (response) => {
      // this.apptPatient = response.data;
      this.$store.commit('SET_APPT_PATIENT', response.data);
    });
  },
  methods: {
    flipBoolean() {
      this.updateAppointment = !this.updateAppointment;
    }
  }

}
</script>

<style scoped>
div .appointment-details {
    /* display: flex;
    align-items: center;
    justify-content: space-evenly; */
    text-align: center;
}

.appointment-container p {
    text-align: center;
}

.appt-pic{
    max-width: 300px;
    max-height: 250px;
}
</style>