<template>
    <div class="office-container">
        <div class = "office-info">
            <h4 class="top-line">Address: {{office.streetAddress}}, {{office.city}}, {{office.stateAbbr}} {{office.zipcode}}</h4>
            <h3 class="pipe-decor">||</h3>
            <h4 class="top-line">Hours: {{office.openTime}} - {{office.closeTime}}</h4>
            <h3 class="pipe-decor">||</h3>
            <h4 class="top-line">Phone: {{office.phoneNumber}}</h4>           
            
        </div>
        <p>Additional information: Our current rate for seeing a provider is at ${{office.costPerHour}} per hour.</p>
        <h4 class ="office-message" v-if="office.displayMessage">{{office.message}}</h4>
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

    div .office-info {
        display: flex;
        align-items: center;
        justify-content: space-evenly;
    }

    .office-container p {
        text-align: center;
    }

    @media screen and (max-width: 1000px) {

        div .office-info {
        display: list-item;
        list-style: none;
        align-items: center;
        margin-left: 5vw;
        }

        .pipe-decor {
            display: none;
        }

        div .office-info::marker {
            display: none;
            
        }
    }

    .office-message{
        color: red;
        text-align: center;
    }
</style>