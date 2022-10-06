<template>
    <div class="provider-container">
        <div class = "provider-info">
            <h4 class="top-line">{{provider.title}} {{provider.firstName}} {{provider.lastName}} {{provider.postNominals}}</h4>
            <img class="provider-pic" v-bind:src="provider.photoUrl" alt="">
            <h4>{{provider.specialty}}</h4>
            <h4 v-if="provider.rating">Provider Rating: {{roundedRating(provider.rating)}}</h4>
            <h4 v-if="provider.phoneNumber">Contact Info:</h4>
            <h4 v-if="provider.phoneNumber">{{provider.phoneNumber}}</h4>
            <h4>This provider speaks {{provider.language}}.</h4>
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