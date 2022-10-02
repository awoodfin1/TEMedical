<template>
  <div>
    <AppointmentDetails v-bind:appt-id="parseInt($route.params.apptId)"/>
  </div>
</template>

<script>
import AppointmentDetails from '../components/AppointmentDetails.vue';

export default {
  name: "appointment-detail",
  components: {
    AppointmentDetails
  }
}
</script>

<style>

</style>