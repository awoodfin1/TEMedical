<template>
    <div class="my-profile-patient">
        <update-patient/>
    </div>
</template>

<script>
    import UpdatePatient from '../components/UpdatePatient.vue';
    export default{
        name: 'my-profile-patient',
        components: {UpdatePatient}
    }
</script>