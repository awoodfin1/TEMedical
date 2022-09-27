<template>
  <div class="appointments-info">
    <h1>Appointments</h1>
    <h2>Your next scheduled appointment is ... </h2>
    <h2>Click HERE to Schedule An Appointment</h2>
  </div>
</template>

<script>
import ApptService from "../services/ApptService";

export default {
  name: 'appts-info',
  data(){
    return {
      appointment: []
    }
  },
  created() {
    ApptService.viewMyProviderAvailability().then( (response) => {
      this.appointment = response.data
    });
  }

}
</script>

<style>

</style>