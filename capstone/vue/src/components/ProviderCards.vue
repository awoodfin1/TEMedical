<template>
    <div class="cards">
        <div class="card" v-for="provider in $store.state.providers" v-bind:key="provider.id"> <!--Change To Router Link When ProviderInfo View Is Implemented-->
            <img class="profile-pic" v-bind:src="provider.photoUrl" alt="">
            <h3>{{provider.title}} {{provider.firstName}} {{provider.lastName}} {{provider.postNominals}}</h3>
            <h3>{{provider.specialty}}</h3>
            <h4>{{provider.bio}}</h4>
            <h4 v-if="provider.rating">Provider Rating: {{provider.rating}}</h4>
            <h4 v-if="provider.phoneNumber">Contact Info:</h4>
            <h4 v-if="provider.phoneNumber">{{provider.phoneNumber}}</h4>
        </div>
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