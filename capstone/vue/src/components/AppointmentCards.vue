<template>
  <div class="cards">
        <router-link class="appt-card" v-for="appointment in $store.state.myAppointments" v-bind:key="appointment.id" v-bind:to="{name: 'appointment-details', params: {apptId:appointment.id}}">
        <!-- <div class="card" v-for="appointment in $store.state.myAppointments" v-bind:key="appointment.id"> Change To Router Link When AppointmentDetails View Is Implemented -->
            <img class="appt-pic" src="@/images/Appointment.png" alt="Appointment-Image">
            <h2 class="link-text">{{ appointment.appointmentDate }}</h2>
            <h3 class="link-text">Time: {{ appointment.apptStartTime }}</h3>
            <h4 class="link-text">Appointment Id: {{ appointment.id }} </h4>
            <h4
                class="link-text"
                v-bind:class="{ confirmed: appointment.status === 'Confirmed' } ||
                              { rescheduled: appointment.status === 'Rescheduled' } ||
                              { cancelled: appointment.status === 'Cancelled'}"
            >
                Status: {{ appointment.status }}</h4>
        <!-- </div> -->
        </router-link>
    </div>
</template>

<script>
export default {
  name: 'appointment-cards'
}
</script>

<style>
.confirmed {
    background-color: rgb(174, 255, 174);
}

.rescheduled {
    background-color: yellow;
}

.cancelled {
    background-color: red;
}

.appt-card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 400px;
    margin: 20px;
    padding-top: 20px;
    text-align: center;
    box-shadow: 0 4px 5px 0 rgba(0,0,0,0.5), 0 1px 10px 0 rgba(0,0,0,0.7), 0 2px 4px -1px rgba(0,0,0,0.9);
    
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

a:link {
    color: black;
    text-decoration: none;
}

a:visited {
    color: black;
}

@media screen and (max-width: 1000px) {
    .appt-card {
        max-width: 500px;
    }
}

</style>