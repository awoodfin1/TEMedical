<template>
    <div class="cards">
        <router-link class="card" v-for="provider in $store.state.providers" v-bind:key="provider.id" v-bind:to="{name: 'Provider', params: {providerId:provider.id}}">
            <img class="profile-pic" v-bind:src="provider.photoUrl" alt="">
            <h2>{{ appointment.appointmentDate }}</h2>
            <h3>{{ appointment.apptStartTime }} - {{ appointment.apptEndTime }}</h3>
            <h4>{{provider.bio}}</h4>
            <h4 v-if="provider.rating">Provider Rating: {{provider.rating}}</h4>
            <h4 v-if="provider.phoneNumber">Contact Info:</h4>
            <h4 v-if="provider.phoneNumber">{{provider.phoneNumber}}</h4>
        </router-link> 
    </div>
</template>

<script>
    export default{
        name: 'provider-card',
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
.profile-pic{
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