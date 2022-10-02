<template>
  <div class="appointment-container">
        <div class = "appointment-details">
            <h3 class="top-line">Appointment Id: {{ appointment.id }} | Status: {{ appointment.status }}</h3>
            <img class="appt-pic" src="@/images/Appointment.png" alt="Appointment-Image">
            <h1>{{ appointment.appointmentDate }}</h1>
            <h2>{{ appointment.apptStartTime }} - {{ appointment.apptEndTime }}</h2>
            <h3>Reason For Appointment (if provided):</h3>
            <p>{{ appointment.appointmentReason }}</p>
            <h3>Appointment Details (if provided):</h3>
            <p>{{ appointment.appointmentDetails }}</p>  
            <input v-if="!updateAppointment" v-on:click.prevent="flipBoolean" type="button" name="updateAppointment" id="updateAppointment" value="Update Appointment">
            <!-- Implement Update Appointment Form HERE -->
        </div>
    </div>
</template>

<script>
import ApptService from "../services/ApptService";

export default {
  name: 'appointment-details',
  props: {
    'apptId': Number
  },
  data() {
    return {
      appointment: [],
      updateAppointment: false
    }
  },
  created() {
    ApptService.getAppointmentById(this.apptId).then( (response) => {
      this.appointment = response.data
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