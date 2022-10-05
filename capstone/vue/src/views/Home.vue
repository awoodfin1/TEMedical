<template>
  <div class="home">
    <h1>Welcome To Your Home Page!</h1>
    <p v-if="!$store.state.user.provider">Schedule an appointment with one of our prized providers!</p>
    <p v-if="$store.state.user.provider">Below are your upcoming appointments!</p>
    <br>
    <providers v-if="!$store.state.user.provider"/>
    <my-appointments v-if="$store.state.user.provider"/>
  </div>
</template>

<script>
import Providers from './Providers.vue';
import MyAppointments from './MyAppointments.vue';

export default {
  name: "home",
  components: {
    Providers,
    MyAppointments
  }
};
</script>

<style>
  .home{
    text-align: center;
  }
</style>
