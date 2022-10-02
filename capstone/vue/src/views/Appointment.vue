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
  box-shadow: 0 4px 5px 0 rgba(0,0,0,0.14), 0 1px 10px 0 rgba(0,0,0,0.12), 0 2px 4px -1px rgba(0,0,0,0.2);
  margin: 3% 14% 8% 14%;
}
</style>