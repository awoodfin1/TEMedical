<template>
    <div class="update-patient">
        <h2 class="update-patient-title">Please Update Your Profile</h2>
        <form class="update-patient-form" v-on:submit.prevent="updatePatient()" v-if="this.showForm">
            <label for="update-first-name">First Name: </label>
            <input class="update-patient-field" type="text" v-model="newPatient.firstName" id="update-first-name" required>
            <label for="update-last-name">Last Name: </label>
            <input class="update-patient-field" type="text" v-model="newPatient.lastName" id="update-last-name" required>
            <label for="update-phone-number">Phone Number: </label>
            <input class="update-patient-field" type="text" v-model="newPatient.phoneNumber" id="update-phone-number" required>
            <label for="update-email-address">Email Address: </label>
            <input class="update-patient-field" type="text" v-model="newPatient.emailAddress" id="update-email-address" required>
            <label for="update-birthdate">Birthdate: </label>
            <input class="update-patient-field" type="date" v-model="newPatient.birthdate" id="update-birthdate">
            <label for="update-health-issues">List Any Health Issues: </label>
            <input class="update-patient-field" type="text" v-model="newPatient.healthIssuesDescription" id="update-health-issues">
            <button id="profileSubmitBtn" type="submit">Submit</button>
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
        box-shadow: 0 4px 5px 0 rgba(0,0,0,0.14), 0 1px 10px 0 rgba(0,0,0,0.12), 0 2px 4px -1px rgba(0,0,0,0.2);
        padding: 0 15px 25px 15px;
        margin: 3% 20% 3% 20%;
    }
    .update-patient-form{
        display: flex;
        flex-direction: column;
        align-self: center;
    }
    .update-health-issues input{
        width: auto;
    }

    .update-patient-title {
        color:rgb(0, 180, 242);
    }

    #profileSubmitBtn {
        background-color: rgb(174, 255, 174);
        margin-top: 10px;
    }

     .update-patient-field {
         margin-bottom: 20px;
     } 

     @media screen and (max-width: 1000px) {
        .update-patient {
            padding: 0 2px 25px 2px;
            margin: 3% 0 3% 0;
        }

       
     }
</style>