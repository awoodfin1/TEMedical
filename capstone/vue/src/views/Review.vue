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
    created() {
      scroll(0,0);
    }
}
</script>

<style>
.review{
  display: flex;
  flex-direction: column;
  align-items: center;
  box-shadow: 0 4px 5px 0 rgba(0,0,0,0.14), 0 1px 10px 0 rgba(0,0,0,0.12), 0 2px 4px -1px rgba(0,0,0,0.2);
  padding: 0 15px 0 15px;
  margin: 3% 10% 3% 10%;
}

@media screen and (max-width: 1000px) {
  .review {
    padding: 0 5vw 30px 5vw;
    margin: 3% 15% 5% 15%;
  }
}
</style>
