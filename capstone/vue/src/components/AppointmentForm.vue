<template>
  <div>
      <form v-on:submit.prevent="addAppointment()" class="apptSelect">
          <label for="dateInput">Please Select a Date</label> 
          <input type="text" name="dateInput" id="dateInput" v-model="newApptRequest.date" v-on:change="getTimes()" />

          <label for="timeSelect">Please Select a Time</label>
          <select id="timeSelect" name="timeSelect" v-model="newApptRequest.startTime">
              <option v-for="time in apptTimes" v-bind:key="time" value="">
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
                startTime: ''
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
            ApptService.createAppointment(this.newApptRequest.date, this.newApptRequest.startTime)
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

</style>