<template>
  <div class="home">
    <h1>Welcome To Our Home Page</h1>
    <p>About Us: We do medical scheduling!</p>
    <br>
    <providers v-if="!$store.state.user.provider"/>
    <my-appointments v-if="$store.state.user.Provider"/>
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
