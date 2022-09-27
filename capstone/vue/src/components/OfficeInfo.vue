<template>
    <div class = "office-info">
        <h1>OFFICE INFORMATION</h1>
        <h1>Office number: {{office.id}}</h1>
        <h2>Located at {{office.streetAddress}}</h2>
        <h2>{{office.city}}, {{office.stateAbbr}} {{office.zipcode}}</h2>
        <p>Our hours are from {{office.openTime}} to {{office.closeTime}}.</p>
        <p>Feel free to reach us at {{office.phoneNumber}}!</p>
        <br>
        <p>Additional information: Our current rate for seeing a provider is at ${{office.costPerHour}} per hour.</p>
    </div>
</template>

<script>
    import authService from "../services/AuthService";
    export default{
        name: 'office-info',
        data(){
            return {
                office: []
            }
        },
        created() {
            authService.getOfficeInfo().then( (response) =>{
                this.office = response.data;
            });
        }
    }
</script>

<style>
    .office-info{
        text-align: center;
    }
</style>