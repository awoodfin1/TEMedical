<template>
    <div class="appointment-form">
        <form v-on:submit.prevent="addAppointment()" class="apptSelect">
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
            <select id="apptReason" name="apptReason">
                <option value="">--Please choose an option--</option>
                <option value="prescriptionRefill">Prescription Refill</option>
                <option value="skin">Skin Disorder</option>
                <option value="jointsOsteoarthritis">Joint Pain And Osteoarthritis</option>
                <option value="backPain">Back Problems</option>
                <option value="cholesterol">Cholesterol Problem</option>
                <option value="upperRespiratory">Upper Respiratory Problems</option>
                <option value="anxietyBipolarDepression">Anxiety, Bipolar Disorder and/or Depression</option>
                <option value="neurologyDisorder">Chronic Neurology Disorder</option>
                <option value="highBloodPressure">High Blood Pressure</option>
                <option value="headacheMigraine">Headaches And Migraines</option>
                <option value="diabetes">Diabetes</option>
                <option value="other">Other</option>
            </select>
            <label for="apptDescription">Brief Description:</label>
            <textarea name="apptDescription" id="apptDescription" cols="30" rows="10"></textarea>
            <button id="apptFormBtn" type="submit">Submit</button>
            <br />
        </form>
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
                newPatient: false
            },
            apptTimes: [],
            
        }
    },
    created() {
        this.newApptRequest.providerId = this.providerId;
    },
    methods: {
        getTimes() {
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
                    this.resetForm();
                }
            })
        },
        resetForm() {
            this.newApptRequest = {
                date: '',
                startTime: ''
            }
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
.appointment-form{
    display: flex;
    justify-content: center;
    
}

#apptFormBtn {
    margin: 10px 150px 0 0;
    background-color: rgb(174, 255, 174);

}

@media screen and (max-width: 1000px) {
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