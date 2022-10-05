<template>
    <div class="cards">
        <div class="filter">
            <table id="filter-table">
                <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Specialty</th>
                        <th>Gender</th>
                        <th>Language</th>
                        <th>Provider Rating</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <input type="text" id="first-name-filter" v-model="filter.firstName">
                        </td>
                        <td>
                            <input type="text" id="last-name-filter" v-model="filter.lastName">
                        </td>
                        <td>
                            <select name="specialty-filter" id="specialty-filter" v-model="filter.specialty">
                                <option v-for="provider in $store.state.providers" v-bind:key="provider.id">{{ provider.specialty }}</option>
                            </select>
                        </td>
                        <td>
                            <select name="gender-filter" id="gender-filter" v-model="filter.gender">
                                <option v-for="provider in $store.state.providers" v-bind:key="provider.id">{{ provider.gender }}</option>
                            </select>
                        </td>
                        <td>
                            <input type="text" id="language-filter" v-model="filter.language">
                        </td>
                        <td>
                            <select name="rating-filter" id="rating-filter" v-model="filter.rating">
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
            <h4 v-if="provider.rating">Provider Rating: {{roundedRating(provider.rating)}}</h4>
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
                rating = rating.toFixed(2);
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
                        .toLowerCase()
                        .includes(this.filter.gender.toLowerCase())
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