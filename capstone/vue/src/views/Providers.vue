<template>
  <div>
    <ProviderCards/>
  </div>
</template>

<script>
import ProviderService from '../services/ProviderService';
import ProviderCards from '../components/ProviderCards.vue';

export default {
    name: "providers",
    created() {
        ProviderService.getAllProviders().then((response) => {
            this.$store.commit("SET_PROVIDERS", response.data);
            scroll(0,0);
        });
    },
    components: { ProviderCards }
};
</script>

<style>

</style>