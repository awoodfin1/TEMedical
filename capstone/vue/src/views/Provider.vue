<template>
  <div>
    <h1>{{ $store.state.providers }}</h1>
  </div>
</template>

<script>
import ProviderService from '../services/ProviderService';

export default {
  name: 'providers',
  created() {
    ProviderService.getAllProviders().then( (response) => {
      this.$store.commit("GET_PROVIDERS", response.data);
    });
  }
};
</script>

<style>

</style>