<template>
  <div class="home">
    <h1>Welcome To Our Home Page</h1>
    <p>About Us: We do medical scheduling!</p>
    <br>
    <providers v-if="!$store.state.isProvider"/>
  </div>
</template>

<script>
import Providers from './Providers.vue';

export default {
  name: "home",
  components: {
    Providers
  }
};
</script>

<style>
  .home{
    text-align: center;
  }
</style>
