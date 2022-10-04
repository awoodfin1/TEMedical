<template>
    <div class="update-office">
        <form class="update-office-form" v-on:submit.prevent="updateOffice()">
        </form>
    </div>
</template>

<script>
    import AuthService from '../services/AuthService';
    export default{
        name: 'update-office',
        data(){
            return{
                office: {},
            }
        },
        created() {
            AuthService.getOfficeInfo().then( (response) =>{
                this.office = response.data;
            });
        }
    }
</script>
