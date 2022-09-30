<template>
  <div class="home">
    <h1>Welcome To Our Home Page</h1>
    <p>About Us: We do medical scheduling!</p>
    <br>
    <provider />
  </div>
</template>

<script>
import Provider from './Provider.vue';

export default {
  name: "home",
  components: {
    Provider
  }
};
</script>

<style>
  .home{
    text-align: center;
  }
</style>
