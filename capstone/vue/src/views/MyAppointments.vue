<template>
  <div>
    <!-- Attempt to implement notification banner -->
    <!-- <div class="alert" v-if="$store.state.displayApptUpdate">
      <span class="closebtn" v-on:click="toggleOffDisplayApptUpdate()">&times;</span>
      A patient booked a new appointment with you!
    </div> -->
    <h1 v-if="!$store.state.user.provider">My Appointments</h1>
    <AppointmentCards/>
  </div>
</template>

<script>
import ApptService from '../services/ApptService';
import AppointmentCards from '../components/AppointmentCards.vue';
// import AuthService from '../services/AuthService';

export default {
  name: "my-appointments",
  created() {
    ApptService.getAppointments().then( (response) => {
      this.$store.commit("SET_APPOINTMENTS", response.data);
      scroll(0,0);
    });
  },
  components: {
    AppointmentCards
  // },
  // methods: {
  //   toggleOffDisplayApptUpdate() {
  //     AuthService.flipDisplayApptUpdate().then( (response) => {
  //       if (response.status === 200) {
  //         this.$store.commit("SET_DISPLAY_APPT_UPDATE", false);
  //       }
  //     });
  //   }
  }
}
</script>

<style>
h1 {
  text-align: center;
}
/* Styling for the notification banner
/* The alert message box */
/* .alert {
  padding: 20px;
  background-color: rgb(174, 255, 174);
  color: rgb(0, 180, 242);
  margin-bottom: 15px;
} */

/* The close button */
/* .closebtn {
  margin-left: 15px;
  color: black;
  font-weight: bold;
  float: right;
  font-size: 22px;
  line-height: 20px;
  cursor: pointer;
  transition: 0.3s;
} */

/* When moving the mouse over the close button */
/* .closebtn:hover {
  color: red;
} */

</style>