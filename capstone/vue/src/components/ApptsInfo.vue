<template>
  <div class="appointments-info">
    <h1>Schedule An Appointment </h1>
    <h4>Please Complete the following form:</h4>
  </div>
</template>

<script>
import ApptService from "../services/ApptService";

export default {
  name: 'appts-info',
  data(){
    return {
      date: '2022-10-31',
      appointment: []
    }
  },
  created() {
    ApptService.getApptStartTimeByDate(this.date).then( (response) => {
      this.appointment = response.data
    });
  }

}
</script>

<style>

.appointments-info{
  text-align: center;
}

</style>