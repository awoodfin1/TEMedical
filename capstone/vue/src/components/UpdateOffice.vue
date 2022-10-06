<template>
    <div class="update-office">
        <h2 class="update-office-title">Please Update Our Office Info</h2>
        <form class="update-office-form" v-on:submit.prevent="updateOffice()" v-if="this.showForm">
            <label for="update-message" class="display-message">Update Office Message?</label>
            <select name="update-message" id="update-message" v-model="showMessageField" required>
                <option value=""></option>
                <option value=true>Yes</option>
                <option value=false>No</option>
            </select>
            <!-- <input type="checkbox" id="update-message" v-model="office.displayMessage" required> -->
            <label for="message" v-if="office.display_message">Type Message To Be Displayed Here.</label>
            <input type="textarea"  v-model="office.message" id="message" v-if="showMessageField" required>
            <button id="officeSubmitBtn" type="submit">Submit</button>
        </form>
        <h4 v-if="!this.showForm">Form Submitted! Thank You!</h4>
    </div>
</template>

<script>
    import AuthService from '../services/AuthService';
    import ProviderService from '../services/ProviderService';
    export default{
        name: 'update-office',
        data(){
            return{
                office: {},
                showForm: true,
                showMessageField: false
            }
        },
        created() {
            AuthService.getOfficeInfo().then( (response) =>{
                this.office = response.data;
            });
        },
        methods: {
            updateOffice(){
                ProviderService.updateOffice(this.office).then((response)=>{
                    if(response.status === 200 || response.status === 204){
                        this.showForm = false;
                    }
                });
            }
        }
    }
</script>


<style>
    .update-office{
        display: flex;
        flex-direction: column;
        align-items: center;
        box-shadow: 0 4px 5px 0 rgba(0,0,0,0.14), 0 1px 10px 0 rgba(0,0,0,0.12), 0 2px 4px -1px rgba(0,0,0,0.2);
        padding: 0 15px 25px 15px;
        margin: 3% 20% 3% 20%;
    }

    .update-office-form{
        display: flex;
        flex-direction: column;
        align-self: center;
    }

    .display-message{
        text-align: center;
    }

    .update-office-title {
        color:rgb(0, 180, 242);
    }

    #officeSubmitBtn {
        background-color: rgb(174, 255, 174);
        margin-top: 10px;
    }
</style>
