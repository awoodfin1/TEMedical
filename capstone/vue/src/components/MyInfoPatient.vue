<template>
    <div class="patient-container">
        <div class = "patient-info">
            <h4 class="top-line">{{patient.firstName}} {{patient.lastName}}</h4>
            <h4>HEALTH HISTORY </h4>
            <h4>{{patient.healthIssuesDescription}}</h4>
            <h4 v-if="patient.phoneNumber || patient.emailAddress">CONTACT INFO</h4>
            <h4 v-if="patient.phoneNumber">Phone Number: {{patient.phoneNumber}}</h4>
            <h4>Email Address: {{patient.emailAddress}}</h4>
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
</style>