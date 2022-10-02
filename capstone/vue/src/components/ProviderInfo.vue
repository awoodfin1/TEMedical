<template>
    <div class="provider-container">
        <div class = "provider-info">
            <h4 class="top-line">{{provider.title}} {{provider.firstName}} {{provider.lastName}} {{provider.postNominals}}</h4>
            <img class="provider-pic" v-bind:src="provider.photoUrl" alt="">
            <h4>{{provider.specialty}}</h4>
            <h4 v-if="provider.rating">Provider Rating: {{provider.rating}}</h4>
            <h4 v-if="provider.phoneNumber">Contact Info:</h4>
            <h4 v-if="provider.phoneNumber">{{provider.phoneNumber}}</h4>
            <h4>This provider speaks {{provider.language}}.</h4>
            <h4>{{provider.bio}}</h4>   
            <input v-if="!bookAppointment" v-on:click.prevent="flipBoolean" type="button" name="bookAppointment" id="bookAppointment" value="Book Appointment">
            <!-- Implement Book Appointment Form HERE -->
            <appointment-form v-if="bookAppointment"/>
        </div>
    </div>
</template>

<script>
    import ProviderService from "../services/ProviderService";
    import AppointmentForm from "./AppointmentForm.vue";
    export default{
        name: 'provider-info',
        components: {AppointmentForm},
        props: {
            'providerId' : Number
        },
        data(){
            return {
                bookAppointment: false,
                provider: []
            }
        },
        created() {
            ProviderService.getProvider(this.providerId).then( (response) =>{
                this.provider = response.data;
            });
        },
        methods:{
            flipBoolean(){
                this.bookAppointment = !this.bookAppointment;
            }
        }
    }
</script>

<style>

    div .provider-info {
        /* display: flex;
        align-items: center;
        justify-content: space-evenly; */
        text-align: center;
    }

    .provider-container p {
        text-align: center;
    }

    .provider-pic{
        max-width: 300px;
        max-height: 250px;
    }
</style>