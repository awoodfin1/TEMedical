<template>
    <div class="cards">
        <div class="filter">
            <table id="filter-table">
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
            </table>
        </div>
        <router-link class="card" v-for="provider in $store.state.providers" v-bind:key="provider.id" v-bind:to="{name: 'Provider', params: {providerId:provider.id}}">
            <img class="profile-pic" v-bind:src="provider.photoUrl" alt="">
            <h3>{{provider.title}} {{provider.firstName}} {{provider.lastName}} {{provider.postNominals}}</h3>
            <h3>{{provider.specialty}}</h3>
            <h4 v-if="provider.rating">Provider Rating: {{provider.rating}}</h4>
        </router-link> 
    </div>
</template>

<script>
    export default{
        name: 'provider-card',
        data() {
            return {
                filter: {
                    title: "",
                    firstName: "",
                    lastName: "",
                    postNominals: "",
                    specialty: "",
                    gender: "",
                    language: "",
                    rating: Number,
                    phoneNumber: "",
                    bio: ""
                }
            }
        },
        computed: {
            filteredList() {
                let filteredProviders = this.$state.store.providers;
                if (this.filter.title !== "") {
                    filteredProviders = filteredProviders.filter((provider) =>
                    provider.title
                        .toLowerCase()
                        .includes(this.filter.title.toLowerCase())
                    );
                }
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
                if (this.filter.postNominals !== "") {
                    filteredProviders = filteredProviders.filter((provider) =>
                    provider.postNominals
                        .toLowerCase()
                        .includes(this.filter.postNominals.toLowerCase())
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
                if (this.filter.rating !== "") {
                    filteredProviders = filteredProviders.filter((provider) =>
                    provider.rating
                        .toLowerCase()
                        .includes(this.filter.rating.toLowerCase())
                    );
                }
                if (this.filter.phoneNumber !== "") {
                    filteredProviders = filteredProviders.filter((provider) =>
                    provider.phoneNumber
                        .toLowerCase()
                        .includes(this.filter.phoneNumber.toLowerCase())
                    );
                }
                if (this.filter.bio !== "") {
                    filteredProviders = filteredProviders.filter((provider) =>
                    provider.bio
                        .toLowerCase()
                        .includes(this.filter.bio.toLowerCase())
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