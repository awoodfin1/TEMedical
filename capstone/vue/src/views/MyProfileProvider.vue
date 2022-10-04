<template>
    <div class="my-profile-provider">
        <MyInfoProvider/>
        <input v-on:click.prevent="flipUpdate()" v-if="!isUpdate" type="button" name="updateProvider" value="Update Profile" class="updateProfileBtn">
        <update-provider v-if="isUpdate"/>
    </div>
</template>

<script>
    import UpdateProvider from '../components/UpdateProvider.vue';
    import MyInfoProvider from '../components/MyInfoProvider.vue';
    export default{
        name: 'my-profile-provider',
        components: { UpdateProvider, MyInfoProvider},
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
.my-profile-provider{
    display: flex;
    flex-direction: column;
}
</style>