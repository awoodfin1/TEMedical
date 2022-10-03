<template>
    <div class="my-profile-provider">
        <update-provider/>
    </div>
</template>

<script>
    import UpdateProvider from '../components/UpdateProvider.vue';
    export default{
        name: 'my-profile-provider',
        components: {UpdateProvider}
    }
</script>