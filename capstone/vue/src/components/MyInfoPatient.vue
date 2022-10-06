<template>
    <div class="patient-container">
        <div class = "patient-info">
            <h1>My Profile</h1>
            <h4 class="top-line">{{patient.firstName}} {{patient.lastName}}</h4>
            <h3 class="sub-title" v-if="patient.phoneNumber || patient.emailAddress">Contact Info</h3>
            <h4 v-if="patient.phoneNumber">Phone Number: {{patient.phoneNumber}}</h4>
            <h4 v-if="patient.emailAddress">Email Address: {{patient.emailAddress}}</h4>
            <h3 class="sub-title">Health History</h3>
            <h4>{{patient.healthIssuesDescription}}</h4>
        </div>
    </div>
</template>

<script>
    import PatientService from "../services/PatientService";
    export default{
        name: 'my-info-patient',
        data(){
            return {
                patient: {},
            }
        },
        created() {
            PatientService.getPatientByUsername().then( (response) =>{
                this.patient = response.data;
            });
            
        },
    }
</script>

<style>
    .patient-container{
        text-align: center;
    }
    .sub-title {
        color:rgb(0, 180, 242);
    }
</style>