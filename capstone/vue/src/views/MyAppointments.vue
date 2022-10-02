<template>
  <div>
    <AppointmentCards/>
  </div>
</template>

<script>
import ApptService from '../services/ApptService';
import AppointmentCards from '../components/AppointmentCards.vue';

export default {
  name: "my-appointments",
  created() {
    ApptService.getAppointments().then( (response) => {
      this.$store.commit("SET_APPOINTMENTS", response.data);
    });
  },
  components: {
    AppointmentCards
  }
}
</script>

<style>

</style>