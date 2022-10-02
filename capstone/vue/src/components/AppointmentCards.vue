<template>
  <div class="cards">
        <div class="card" v-for="appointment in $store.state.myAppointments" v-bind:key="appointment.id"> <!--Change To Router Link When AppointmentDetails View Is Implemented-->
            <img class="appt-pic" src="@/images/Appointment.png" alt="Appointment-Image">
            <h2>{{ appointment.appointmentDate }}</h2>
            <h3>{{ appointment.apptStartTime }} - {{ appointment.apptEndTime }}</h3>
            <h4>Status: {{ appointment.status }}</h4>
            <h4 v-if="appointment.appointmentReason">Reason For Appointment</h4>
            <p v-if="appointment.appointmentReason">{{ appointment.appointmentReason }}</p>
            <h4 v-if="appointment.appointmentDetails">Appointment Details:</h4>
            <p v-if="appointment.appointmentDetails">{{ appointment.appointmentDetails }}</p>
        </div>
    </div>
</template>

<script>
export default {
  name: 'appointment-cards'
}
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 400px;
    margin: 20px;
    padding-top: 20px;
}
.appt-pic{
    max-width: 250px;
    max-height: 100px;
    border-radius: 50%;
    
}
.cards{
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>