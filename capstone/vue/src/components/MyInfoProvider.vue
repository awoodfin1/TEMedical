<template>
    <div class="provider-container">
        <div class = "provider-info">
            <h1>My Profile</h1>
            <h4 class="top-line">{{provider.title}} {{provider.firstName}} {{provider.lastName}} {{provider.postNominals}}</h4>
            <img class="provider-pic" v-bind:src="provider.photoUrl" alt="">
            <h4>Specialty: {{provider.specialty}}</h4>
            <h4 v-if="provider.rating">Provider Rating: {{roundedRating(provider.rating)}}</h4>
            <h4 v-if="provider.phoneNumber">Phone Number: {{provider.phoneNumber}}</h4>
            <h4>This provider speaks {{provider.language}}.</h4>
            <h3 id="bio-header">Biography</h3>
            <h4>"{{provider.bio}}"</h4>
        </div>
    </div>
</template>

<script>
    import ProviderService from "../services/ProviderService";
    export default{
        name: 'my-info-provider',
        data(){
            return {
                provider: {},
            }
        },
        created() {
            ProviderService.getProviderByUsername().then( (response) =>{
                this.provider = response.data;
            });
            
        },
        methods: {
            roundedRating(rating) {
                rating = Number.parseFloat(rating).toFixed(2);
                return rating;
            }
        }
    }
</script>

<style>
    #bio-header {
        color:rgb(0, 180, 242);
    }
</style>