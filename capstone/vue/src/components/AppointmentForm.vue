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
            <button type="submit">Submit</button>
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
                startTime: '09:00:00'
            },
            apptTimes: []
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

@media screen and (max-width: 1000px) {
    .apptSelect {
        max-width: 80vw;
    }
}
</style>