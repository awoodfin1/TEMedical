<template>
    <div class="update-provider">
        <h2  class="update-provider-title">Please Update Your Profile</h2>
        <form class="update-provider-form" v-on:submit.prevent="updateProvider()" v-if="this.showForm">
            <label for="update-title">Title: </label>
            <input class="update-provider-field" type="text" v-model="newProvider.title" id="update-title">
            <label for="update-first-name">First Name: </label>
            <input class="update-provider-field" type="text" v-model="newProvider.firstName" id="update-first-name" required>
            <label for="update-last-name">Last Name: </label>
            <input class="update-provider-field" type="text" v-model="newProvider.lastName" id="update-last-name" required>
            <label for="update-post-nominals">Post Nominals: </label>
            <input class="update-provider-field" type="text" v-model="newProvider.postNominals" id="update-post-nominals">
            <label for="update-specialty">Specialty: </label>
            <input class="update-provider-field" type="text" v-model="newProvider.specialty" id="update-specialty" required>
            <label for="update-gender">Gender: </label>
            <select name="update-provider-gender" id="update-gender" class="update-provider-field" required>
                <option value=""></option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select>
            <label for="update-language">Language: </label>
            <input class="update-provider-field" type="text" v-model="newProvider.language" id="update-language">
            <label for="update-phone-number">Phone Number: </label>
            <input class="update-provider-field" type="text" v-model="newProvider.phoneNumber" id="update-phone-number">
            <label for="update-bio">Update Bio: </label>
            <input class="update-provider-field" type="text" v-model="newProvider.bio" id="update-bio">
            <label for="update-image-url">Update Image URL: </label>
            <input class="update-provider-field" type="text" v-model="newProvider.photoUrl" id="update-image-url">
            <button id="providerSubmitBtn" type="submit">Submit</button>
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
        box-shadow: 0 4px 5px 0 rgba(0,0,0,0.14), 0 1px 10px 0 rgba(0,0,0,0.12), 0 2px 4px -1px rgba(0,0,0,0.2);
        padding: 0 15px 25px 15px;
        margin: 3% 20% 3% 20%;
    }
    .update-provider-form{
        display: flex;
        flex-direction: column;
        align-self: center;
    }
    .update-health-issues input{
        width: auto;
    }

    .update-provider-field{
        margin-bottom: 20px;
    }

    .update-provider-title {
        color:rgb(0, 180, 242);
    }

    #providerSubmitBtn {
        background-color: rgb(174, 255, 174);
        margin-top: 10px;
    }

    @media screen and (max-width: 1000px) {
        .update-provider {
            padding: 0 2px 25px 2px;
            margin: 3% 0 3% 0;
        }       
     }
</style>