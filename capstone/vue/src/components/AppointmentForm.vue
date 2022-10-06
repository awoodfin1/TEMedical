<template>
    <div class="appointment-form">
        <form v-on:submit.prevent="addAppointment()" class="apptSelect" v-if="this.showForm">
            <label for="dateInput">Please Select a Date</label>
            <input type="date" name="date" min="2022-09-28" max="2022-12-31" v-model="newApptRequest.date" v-on:change="getTimes()" required>
            <label for="timeSelect">Please Select a Time</label>
            <select id="timeSelect" name="timeSelect" v-model="newApptRequest.startTime" required>
                <option v-for="time in apptTimes" v-bind:key="time" >
                    {{ time }}
                </option>
            </select>
            <label for="isNewPatient">Are You a New Patient?</label>
            <input v-model="newApptRequest.newPatient" type="checkbox" name="isNewPatient" id="isNewPatient" value= true>
            <label for="apptReason">Reason for Visit:</label>
            <select id="apptReason" name="apptReason" v-model="newApptRequest.apptReason" required>
                <!-- <option value="">--Please choose an option--</option> -->
                <option >Prescription Refill</option>
                <option >Skin Disorder</option>
                <option >Joint Pain And Osteoarthritis</option>
                <option >Back Problems</option>
                <option >Cholesterol Problem</option>
                <option >Upper Respiratory Problems</option>
                <option >Anxiety, Bipolar Disorder and/or Depression</option>
                <option >Chronic Neurology Disorder</option>
                <option >High Blood Pressure</option>
                <option >Headaches And Migraines</option>
                <option >Diabetes</option>
                <option >Other</option>
            </select>
            <label for="apptDescription">Brief Description:</label>
            <textarea name="apptDescription" id="apptDescription" cols="30" rows="10" v-model="newApptRequest.apptDetails" required></textarea>
            <button id="apptFormBtn" type="submit">Submit</button>
            <br />
        </form>
        <h4 v-if="!this.showForm">Form Submitted! Thank You!</h4>
    </div>
</template>

<script>
import ApptService from '../services/ApptService';
export default {
    props: {
        'providerId' : Number
    },
    data() {
        return {
            newApptRequest: {
                providerId: 0,
                date: '',
                startTime: '09:00:00',
                apptReason: '',
                apptDetails: '',
                newPatient: false
            },
            apptTimes: [],
            showForm: true
            
        }
    },
    created() {
        this.newApptRequest.providerId = this.providerId;
    },
    methods: {
        getTimes() {
            this.appTimes = [];
            ApptService.getApptStartTimeByProviderByDate(this.newApptRequest.providerId, this.newApptRequest.date)
            .then((response) => {
                if (response.status === 200) {
                    this.apptTimes = response.data;
                }
            })
        },
        addAppointment() {
            ApptService.createAppointment(this.newApptRequest)
            .then(response => {
                if(response.status === 201) {
                    this.showForm = false;
                    this.resetForm();
                    
                }
            })
        },
        resetForm() {
            this.newApptRequest = {
                providerId: 0,
                date: '',
                startTime: '09:00:00',
                apptReason: '',
                apptDetails: '',
                newPatient: false
            }
            this.appTimes = [];
        }
    }
}
</script>

<style>
.apptSelect{
    display: flex;
    flex-direction: column;
    max-width: 25vw;
}

.apptSelect input,select {
    margin-bottom: 15px;
}

.appointment-form{
    display: flex;
    justify-content: center;
    
}

#apptFormBtn {
    margin: 10px 150px 0 0;
    background-color: rgb(174, 255, 174);

}

@media screen and (max-width: 1000px) {
    /* .appointment-form {
        max-width: 500px;
    } */

    .apptSelect {
        max-width: 80vw;
    }
}

@media screen and (max-width: 425px) {
    .apptSelect {
            
        max-width: 70vw;
    }

    #apptFormBtn {
        margin-right: 30vw;
    }
}
</style>