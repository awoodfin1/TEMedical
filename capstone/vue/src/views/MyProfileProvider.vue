<template>
    <div class="my-profile-provider">
        <MyInfoProvider/>
        <input v-on:click.prevent="flipUpdate()" v-if="!isUpdate" type="button" name="updateProvider" value="Update Profile" class="updateProfileBtn">
        <update-provider v-if="isUpdate"/>
        <input v-on:click.prevent="flipOfficeUpdate()" v-if="!officeUpdate" type="button" name="updateOffice" value="Update Office Info" class="updateOfficeBtn">
        <update-office v-if="officeUpdate"/>
    </div>
</template>

<script>
    import UpdateProvider from '../components/UpdateProvider.vue';
    import MyInfoProvider from '../components/MyInfoProvider.vue';
    import UpdateOffice from '../components/UpdateOffice.vue';
    export default{
        name: 'my-profile-provider',
        components: { UpdateProvider, MyInfoProvider, UpdateOffice },
        data(){
            return{
                isUpdate: false,
                officeUpdate: false,
            }
        },
        methods:{
            flipUpdate(){
                this.isUpdate = !this.isUpdate;
            },
            flipOfficeUpdate(){
                this.officeUpdate = !this.officeUpdate;
            }
        }
    }
</script>

<style>
.my-profile-provider{
    display: flex;
    flex-direction: column;
}
</style>