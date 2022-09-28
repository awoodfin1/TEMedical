<template>
  <div class="appointment">
    <appts-info />
    <appointment-form/>
  </div>
</template>

<script>
import AppointmentForm from '../components/AppointmentForm.vue';
import ApptsInfo from "../components/ApptsInfo.vue";

export default {
  name: "appointment",
  components: {
    ApptsInfo,
    AppointmentForm
  },
}
</script>

<style>
.appointment{
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>