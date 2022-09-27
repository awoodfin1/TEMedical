<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <office-info />
  </div>
</template>

<script>
import OfficeInfo from '../components/OfficeInfo.vue';

export default {
  name: "home",
  components: {
    OfficeInfo
  }
};
</script>
