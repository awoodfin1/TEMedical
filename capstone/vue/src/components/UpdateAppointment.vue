<template>
  <div class="update-appointment">
    <form class="update-appointment-form" v-on:submit="updateAppointment" v-if="this.showForm">

    </form>
  </div>
</template>

<script>
// import ApptService from '../services/ApptService';

export default {
  name: "update-appointment",
  data() {
    return {
      showForm: false,
      appointment: {}
    }
  },
  created() {
    // ApptService.getAppointmentById() {

    // }
  },
  methods: {
    updateAppointment() {

    }
  }

}
</script>

<style>

</style>