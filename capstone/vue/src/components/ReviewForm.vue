<template>
    <form v-on:submit.prevent="submitForm" class="reviewForm">
        <div>
            <label for="providerSelect">Please Select a Provider to Review:  </label><br />
            <select id="providerSelect" name="providerSelect" v-model="review.provider" required>
                <option v-for="provider in $store.state.providers" v-bind:key="provider.id" >
                    {{ provider.title }} {{ provider.firstName }} {{provider.lastName}} {{provider.postNominals}}
                </option>
            </select>
        </div>
        <div class="form-element">
            <label for="rating">Rating:  </label>
            <select id="rating" v-model.number="review.starRating">
                <option value="1">1 Star</option>
                <option value="2">2 Stars</option>
                <option value="3">3 Stars</option>
                <option value="4">4 Stars</option>
                <option value="5">5 Stars</option>
            </select>
        </div>
        <div>
            <label for="reviewText">Review your provider here:</label><br />
            <textarea id="reviewText" name="reviewText" rows="10" cols="40" v-model="review.reviewText"></textarea>
        </div>
            <input id="reviewSubmit" class="reviewBtn" type="submit" value="Save" />
            <input id="reviewCancel" class="reviewBtn" type="button" value="Cancel" v-on:click.prevent="resetForm" />               
    </form>
</template>

<script>
import ReviewService from '../services/ReviewService';
import ProviderService from '../services/ProviderService';

export default {
    name: "submitForm",
    data() {
        return {
            review: {
                provider: '',
                reviewText: '',
                starRating: ''
            },
        }       
    },
    methods: {
        submitForm() {
            ReviewService.createReview(this.review)
            .then(response => {
                if (response.status === 201) {                                      
                    ProviderService.getProviderIdByFullName(this.review.provider)
                    .then(result => {
                        if (result.status === 200) {
                            this.$router.push({name: "Provider", params: {providerId: result.data}});
                            this.resetForm();
                        }
                    })
                    
                }
            })
        },
        
        resetForm() {
            this.review = {};
        }
    }
}
</script>

<style scoped>
    .reviewBtn {
        justify-content: space-between;
    }

    #reviewCancel {
        color: red;
    }

    #reviewSubmit {
        
        background-color: rgb(174, 255, 174);
    }
</style>