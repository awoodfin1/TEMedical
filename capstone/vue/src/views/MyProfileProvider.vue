<template>
    <div class="my-profile-provider">
        <MyInfoProvider/>
        <input id="provider-update-btn" v-on:click.prevent="flipUpdate()" v-if="!isUpdate" type="button" name="updateProvider" value="Update Profile" class="updateProfileBtn">
        <update-provider v-if="isUpdate"/>
        <input id="office-update-btn" v-on:click.prevent="flipOfficeUpdate()" v-if="!officeUpdate" type="button" name="updateOffice" value="Update Office Info" class="updateOfficeBtn">
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

#provider-update-btn, #office-update-btn {
        margin-bottom: 10px;
        margin-left: 325px;
        margin-right: 325px;
        padding: 20px 40px 20px 40px;
        background-color: rgb(174, 255, 174);
        border-radius: 10px;
}
</style>