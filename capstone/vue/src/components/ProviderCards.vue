<template>
    <div class="cards">
        <div class="filter">
            <table id="filter-table">
                <thead>
                    <tr>
                        <th class="table-first-name">First Name</th>
                        <th class="table-last-name">Last Name</th>
                        <th class="table-special">Specialty</th>
                        <th class="table-language">Language</th>
                        <th class="table-gender">Gender</th>
                        <th class="table-rating">Rating</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="table-first-name">
                            <input type="text" id="first-name-filter" v-model="filter.firstName">
                        </td>
                        <td class="table-last-name">
                            <input type="text" id="last-name-filter" v-model="filter.lastName">
                        </td>
                        <td class="table-special">
                            <input type="text" id="specialty-filter" v-model="filter.specialty">
                        </td>
                        <td class="table-language">
                            <input type="text" id="language-filter" v-model="filter.language">
                        </td>
                        <td class="table-gender" id="table-gender">
                            <select name="gender-filter" id="gender-filter" v-model="filter.gender">
                                <option value=""></option>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                            </select>
                        </td>
                        <td class="table-rating" id="table-rating">
                            <select name="rating-filter" id="rating-filter" v-model="filter.rating">
                                <option value=""></option>
                                <option value=1>1 Star</option>
                                <option value=2>2 Stars</option>
                                <option value=3>3 Stars</option>
                                <option value=4>4 Stars</option>
                                <option value=5>5 Stars</option>
                            </select>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <router-link class="card" v-for="provider in filteredList" v-bind:key="provider.id" v-bind:to="{name: 'Provider', params: {providerId:provider.id}}">
            <img class="profile-pic" v-bind:src="provider.photoUrl" alt="">
            <h3>{{provider.title}} {{provider.firstName}} {{provider.lastName}} {{provider.postNominals}}</h3>
            <h3>{{provider.specialty}}</h3>
            <div id="card-rating-container">
                <h4 v-if="provider.rating > 0">Provider Rating: {{roundedRating(provider.rating)}}</h4>
                <img id="star" src="../images/star.png" alt="star">
            </div>
        </router-link> 
    </div>
</template>

<script>
    export default{
        name: 'provider-card',
        data() {
            return {
                filter: {
                    firstName: "",
                    lastName: "",
                    specialty: "",
                    gender: "",
                    language: "",
                    rating: 0
                }
            }
        },
        methods: {
            roundedRating(rating) {
                rating = Number.parseFloat(rating).toFixed(2);
                return rating;
            }
        },
        computed: {
            filteredList() {
                let filteredProviders = this.$store.state.providers;
                console.log(filteredProviders);
                if (this.filter.firstName !== "") {
                    filteredProviders = filteredProviders.filter((provider) =>
                    provider.firstName
                        .toLowerCase()
                        .includes(this.filter.firstName.toLowerCase())
                    );
                }
                if (this.filter.lastName !== "") {
                    filteredProviders = filteredProviders.filter((provider) =>
                    provider.lastName
                        .toLowerCase()
                        .includes(this.filter.lastName.toLowerCase())
                    );
                }
                if (this.filter.specialty !== "") {
                    filteredProviders = filteredProviders.filter((provider) =>
                    provider.specialty
                        .toLowerCase()
                        .includes(this.filter.specialty.toLowerCase())
                    );
                }
                if (this.filter.gender !== "") {
                    filteredProviders = filteredProviders.filter((provider) =>
                    provider.gender
                        .includes(this.filter.gender)
                    );
                }
                if (this.filter.language !== "") {
                    filteredProviders = filteredProviders.filter((provider) =>
                    provider.language
                        .toLowerCase()
                        .includes(this.filter.language.toLowerCase())
                    );
                }
                if (this.filter.rating !== 0) {
                    filteredProviders = filteredProviders.filter((provider) =>
                    provider.rating >= this.filter.rating
                    );
                }
                return filteredProviders;
            }
        }
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
    box-shadow: 0 4px 5px 0 rgba(0,0,0,0.5), 0 1px 10px 0 rgba(0,0,0,0.7), 0 2px 4px -1px rgba(0,0,0,0.9);
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

#card-rating-container {
    display: flex;
    align-items: center;
    justify-content: center;
}

#gender-filter {
    height: 21px;
}

#rating-filter {
    height: 21px;
}

@media screen and (max-width: 1000px) {
    .card {
        max-width: 300px;
    }
}

#table-gender{
    padding-top: 15px;
}

#table-rating{
    padding-top: 15px;
}
</style>