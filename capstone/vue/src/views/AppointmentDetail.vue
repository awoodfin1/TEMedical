<template>
  <div>
    <AppointmentDetails v-bind:appt-id="parseInt($route.params.apptId)"/>
    <!-- <UpdateAppointmentForm v-bind:appt-id="parseInt($route.params.apptId)"/> -->
  </div>
</template>

<script>
import AppointmentDetails from '../components/AppointmentDetails.vue';
// import UpdateAppointmentForm from '../components/UpdateAppointmentForm.vue';

export default {
  name: "appointment-detail",
  components: {
    AppointmentDetails,
    // UpdateAppointmentForm
  }
}
</script>

<style>

</style>