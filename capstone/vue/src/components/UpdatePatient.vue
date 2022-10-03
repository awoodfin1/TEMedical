<template>
    <div class="update-patient">
        <h2>Please Update Your Profile</h2>
        <form class="update-patient-form" v-on:submit.prevent="updatePatient()" v-if="this.showForm">
            <label for="update-first-name">First Name: </label>
            <input type="text" v-model="newPatient.firstName" id="update-first-name" required>
            <label for="update-last-name">Last Name: </label>
            <input type="text" v-model="newPatient.lastName" id="update-last-name" required>
            <label for="update-phone-number">Phone Number: </label>
            <input type="text" v-model="newPatient.phoneNumber" id="update-phone-number" required>
            <label for="update-email-address">Email Address: </label>
            <input type="text" v-model="newPatient.emailAddress" id="update-email-address" required>
            <label for="update-birthdate">Birthdate: </label>
            <input type="date" v-model="newPatient.birthdate" id="update-birthdate">
            <label for="update-health-issues">List Any Health Issues: </label>
            <input type="text" v-model="newPatient.healthIssuesDescription" id="update-health-issues">
            <button type="submit">Submit</button>
        </form>
        <h4 v-if="!this.showForm">Form Submitted! Thank You!</h4>
    </div>
</template>

<script>
    import PatientService from '../services/PatientService';
    export default {
        name: 'update-patient',
        data() {
            return{
                newPatient: {

                },
                showForm: true
            }
        },
        created(){
            PatientService.getPatientByUsername().then((response) =>{
                this.newPatient = response.data;
            });
        },
        methods: {
            updatePatient(){
                PatientService.updatePatient(this.newPatient).then((response)=>{
                    if(response.status === 200 || response.status === 204){
                        this.showForm = false;
                    }
                });
            },
        }
    }
</script>

<style>
    .update-patient{
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .update-patient-form{
        display: flex;
        flex-direction: column;
        align-self: center;
    }
    .update-health-issues input{
        width: auto;
    }
</style>