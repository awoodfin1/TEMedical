<template>
    <div class="review">
        <h1>Add a Review</h1>
        <p>How was your care?</p>
        <review-form/>

    </div>
</template>

<script>
import ReviewForm from '../components/ReviewForm.vue';

export default {
    name: "review",
    components: {
        ReviewForm
    },
}
</script>
