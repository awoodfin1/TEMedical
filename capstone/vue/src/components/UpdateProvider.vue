<template>
    <div class="update-provider">
        <h2>Please Update Your Profile</h2>
        <form class="update-provider-form" v-on:submit.prevent="updateProvider()" v-if="this.showForm">
            <label for="update-title">Title: </label>
            <input type="text" v-model="newProvider.title" id="update-title">
            <label for="update-first-name">First Name: </label>
            <input type="text" v-model="newProvider.firstName" id="update-first-name" required>
            <label for="update-last-name">Last Name: </label>
            <input type="text" v-model="newProvider.lastName" id="update-last-name" required>
            <label for="update-post-nominals">Post Nominals: </label>
            <input type="text" v-model="newProvider.postNominals" id="update-post-nominals">
            <label for="update-specialty">Specialty: </label>
            <input type="text" v-model="newProvider.specialty" id="update-specialty" required>
            <label for="update-gender">Gender: </label>
            <input type="text" v-model="newProvider.gender" id="update-gender">
            <label for="update-language">Language: </label>
            <input type="text" v-model="newProvider.language" id="update-language">
            <label for="update-phone-number">Phone Number: </label>
            <input type="text" v-model="newProvider.phoneNumber" id="update-phone-number" required>
            <label for="update-bio">Update Bio: </label>
            <input type="text" v-model="newProvider.bio" id="update-bio">
            <button type="submit">Submit</button>
        </form>
        <h4 v-if="!this.showForm">Form Submitted! Thank You!</h4>
    </div>
</template>

<script>
    import ProviderService from '../services/ProviderService';
    export default {
        name: 'update-provider',
        data() {
            return{
                newProvider: {

                },
                showForm: true
            }
        },
        created(){
            ProviderService.getProviderByUsername().then((response) =>{
                this.newProvider = response.data;
            });
        },
        methods: {
            updateProvider(){
                ProviderService.updateProvider(this.newProvider).then((response)=>{
                    if(response.status === 200 || response.status === 204){
                        this.showForm = false;
                    }
                });
            },
        }
    }
</script>

<style>
    .update-provider{
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .update-provider-form{
        display: flex;
        flex-direction: column;
        align-self: center;
    }
    .update-health-issues input{
        width: auto;
    }
</style>