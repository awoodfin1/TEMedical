import axios from 'axios';

export default {
    getAllReviews() {
        return axios.get('/reviews')
    },

    createReview(newReview) {
        return axios.post('/reviews', newReview)
    }
    

}