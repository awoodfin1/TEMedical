<template>
    <div class="update-patient">
        <h2>Please Update Your Profile</h2>
        <form>
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
        </form>
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
            }
        },
        created(){
            PatientService.getPatientByUsername().then((response) =>{
                this.newPatient = response.data;
            });
        },
    }
</script>