<template>
    <div>
      <ProviderInfo v-bind:provider-id="parseInt($route.params.providerId)"/>
    </div>
</template>


<script>
    import ProviderInfo from '../components/ProviderInfo.vue';
    
    export default {
        name: "Provider",
        components: { ProviderInfo },
        created() {
            scroll(0,0);
        }
    };
    </script>