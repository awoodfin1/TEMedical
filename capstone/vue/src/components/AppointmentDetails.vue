<template>
  <div class="appointment-container">
        <div class="appointment-details">
            <h3 class="top-line">Appointment Id: {{ appointment.id }} | Status: {{ appointment.status }}</h3>
            <img class="appt-pic" src="@/images/Appointment.png" alt="Appointment-Image">
            <div class = "appointment-info">
              <h1>Appointment Information</h1>
              <h3>Date: {{ appointment.appointmentDate }}</h3>
              <h3>Time: {{ appointment.apptStartTime }}</h3>
              <h3 v-if="appointment.appointmentReason">Reason For Appointment:</h3>
              <p v-if="appointment.appointmentReason">{{ appointment.appointmentReason }}</p>
              <h3 v-if="appointment.appointmentDetails">Appointment Details:</h3>
              <p v-if="appointment.appointmentDetails">{{ appointment.appointmentDetails }}</p>
            </div>
            <div class="patient-info" v-if="$store.state.user.provider">
              <h1>Patient Information</h1>
              <h3>Name: {{ $store.state.apptPatient.firstName }} {{ $store.state.apptPatient.lastName }}</h3>
              <h4>DOB: {{ $store.state.apptPatient.birthdate }}</h4>
              <h4>Health Issues Description:</h4>
              <p>{{ $store.state.apptPatient.healthIssuesDescription }}</p>
            </div>
            <input v-if="$store.state.user.provider && !updateAppt" v-on:click.prevent="toggleUpdateAppt" type="button" name="updateAppt" id="updateAppt" value="Update Appointment">
            <!-- Implement Update Appointment Form HERE -->
            <div class="update-appointment" v-if="updateAppt">
              <h5>Would you like to CANCEL or RESCHEDULE this appointment?</h5>
                <input type="button" value="CANCEL APPOINTMENT" v-on:click="cancelAppointment(appointment)">
                <input type="button" value="RESCHEDULE APPOINTMENT" v-on:click.prevent="toggleReschAppt">
                <div class="reschedule-appointment" v-if="rescheduleAppointment">
                  <form class="reschedule-appointment-form" v-on:submit.prevent="submitUpdatedAppointment(appointment)">
                    <label for="update-appt-date">Appointment Date:</label>
                    <input type="date" name="date" v-model="appointment.appointmentDate" required>
                    <label for="update-appt-start-time">Appointment Time:</label>
                    <input type="time" name="time" v-model="appointment.apptStartTime" required>
                    <button type="submit">Save & Submit</button>
                  </form>
                </div>
                <!-- This section below could be a way to confirm if the appointment status should be changed -->
                <!-- <div class="confirm-cancel-appointment" v-if="cancelAppt">
                  <h5>Are you SURE you wish to CANCEL this appointment?</h5>
                    <input type="button" value="YES, CANCEL APPT" v-on:click="!cancelAppt">
                    <input type="button" value="NO" v-on:click.prevent="toggleReschAppt">
                </div> -->
            </div>
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
      appointment: {},
      // apptPatient: []
      updateAppt: false,
      // cancelAppt: false,
      rescheduleAppointment: false
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
    toggleUpdateAppt() {
      this.updateAppt = !this.updateAppt;
    },
    cancelAppointment(appointment) {
      appointment.status = 'Cancelled';
      this.toggleUpdateAppt();
      ApptService.updateAppointment(appointment.id, appointment).then( 
          this.$router.push({name: 'appointment-details', params: {apptId:appointment.id}})
      );
    },
    toggleReschAppt() {
      this.rescheduleAppointment = !this.rescheduleAppointment;
    },
    showForm() {
      
    },
    submitUpdatedAppointment(appointment) {
      appointment.status = 'Rescheduled';
      this.toggleUpdateAppt();
      this.toggleReschAppt();
      ApptService.updateAppointment(appointment.id, appointment).then( (response) => {
        if (response.status === 201) {
          this.$router.push({name: 'appointment-details', params: {apptId:appointment.id}});
        }
      });
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