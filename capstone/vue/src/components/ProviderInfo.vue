<template>
    <div class="provider-container">
        <div class = "provider-info">
            <h2 class="top-line">{{provider.title}} {{provider.firstName}} {{provider.lastName}} {{provider.postNominals}}</h2>
            <img class="provider-pic" v-bind:src="provider.photoUrl" alt="">
            <h3>{{provider.specialty}}</h3>
            <div id="rating-container" class="prev-info-detail">
                <h4 v-if="provider.rating">Provider Rating: {{roundRating()}}</h4>
                <img id="star" src="../images/star.png" alt="star">
            </div>
            <h4 class="prev-info-detail" v-if="provider.phoneNumber">Contact Info: {{provider.phoneNumber}}</h4>
            <h4 class="prev-info-detail">This provider speaks {{provider.language}}.</h4>
            <p>"{{provider.bio}}"</p>   
            <input v-if="!bookAppointment && !$store.state.user.provider" v-on:click.prevent="flipBoolean" type="button" name="bookAppointment" id="bookAppointment" value="Book Appointment">
            <!-- Implement Book Appointment Form HERE -->
            <div class="appointForm" v-if="!$store.state.user.provider">
                <h3 id="appt-form-title" v-if="bookAppointment">Please Fill Out This From To Book Your Appointment</h3>
                <appointment-form v-if="bookAppointment" v-bind:providerId="providerId"/>
            </div>
            <h3 v-if="!$store.state.user.provider && reviews.length !== 0">Provider Reviews: </h3>
            <div class="reviews" v-for="review in this.reviews" v-bind:key="review.id">
                <h4 id="prov-rate-text">Provider Rating: {{review.providerRating}}/5</h4>
                <h4 id="review-text">Review: {{review.reviewText}}</h4>
            </div>
        </div>
    </div>
</template>

<script>
    import ProviderService from "../services/ProviderService";
    import AppointmentForm from "./AppointmentForm.vue";
    import ReviewService from "../services/ReviewService";
    export default{
        name: 'provider-info',
        components: {AppointmentForm},
        props: {
            'providerId' : Number
        },
        data(){
            return {
                bookAppointment: false,
                provider: [],
                reviews: [],
            }
        },
        created() {
            ProviderService.getProvider(this.providerId).then( (response) =>{
                this.provider = response.data;
                this.getReviews();
            });
            
        },
        methods:{
            flipBoolean(){
                this.bookAppointment = !this.bookAppointment;
            },
            getReviews(){
                ReviewService.getReviewByProviderId(this.providerId).then((response) =>{
                    this.reviews = response.data;
                });
            },
            roundRating() {
                this.provider.rating = Number.parseFloat(this.provider.rating).toFixed(2);
                return this.provider.rating;
            }
        }
    }
</script>

<style>

    div .provider-info {
        /* display: flex;
        align-items: center;
        justify-content: space-evenly; */
        text-align: center;
    }

    .provider-container p {
        text-align: center;
    }

    .prev-info-detail {
        font-weight: normal;
    }

    .provider-pic{
        max-width: 300px;
        max-height: 250px;
        border-radius: 100px;
    }
    .reviews{
        border-color: black;
        border: 2px;
        border-radius: 10px;
        border-style: solid;
        margin: 0 10vw 10px 10vw;
    }

    #appt-form-title{
        color: rgb(0, 180, 242);
    }

    .appointForm {
        display: flex;
        flex-direction: column;
        align-items: center;
        box-shadow: 0 4px 5px 0 rgba(0,0,0,0.14), 0 1px 10px 0 rgba(0,0,0,0.12), 0 2px 4px -1px rgba(0,0,0,0.2);
        
        margin: 3% 14% 3% 14%;
    }

    #prov-rate-text {
        font-size: 15px;
    }

    #review-text {
        font-weight: normal;
        text-align: start;
        margin: 5px;
        font-size: 12px;
    }

    #star {
        height: 16px;
        margin-left: 5px;
    }

    #rating-container {
        display: flex;
        align-items: center;
        justify-content: center;
    }

    @media screen and (max-width: 1000px) {
        .appointForm {
            padding: 0 3vw 5px 3vw;
            margin: 5% 10px 5% 10px;
        }

        

    }

    
</style>