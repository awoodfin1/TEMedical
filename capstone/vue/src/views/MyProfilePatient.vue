<template>
    <div class="my-profile-patient">
        <my-info-patient/>
        <input v-on:click.prevent="flipUpdate()" v-if="!isUpdate" type="button" name="updatePatient" value="Update Profile" class="updateProfileBtn">
        <update-patient v-if="isUpdate"/>
    </div>
</template>

<script>
    import UpdatePatient from '../components/UpdatePatient.vue';
    import MyInfoPatient from '../components/MyInfoPatient.vue';
    export default{
        name: 'my-profile-patient',
        components: { UpdatePatient, MyInfoPatient },
        data(){
            return{
                isUpdate: false
            }
        },
        methods:{
            flipUpdate(){
                this.isUpdate = !this.isUpdate;
            }
        }
    }
</script>

<style>
    .my-profile-patient{
        display: flex;
        flex-direction: column;
    }
    </style>