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
        </form>
    </div>
</template>

<script>
import ApptService from '../services/ApptService';
export default {
    data() {
        return {
            newApptRequest: {
                date: '',
                startTime: '09:00:00'
            },
            apptTimes: []
        }
    },
    methods: {
        getTimes() {
            ApptService.getApptStartTimeByDate(this.newApptRequest.date)
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
    max-width: 15vw;
}
.appointment-form{
    display: flex;
    justify-content: center;
}
</style>