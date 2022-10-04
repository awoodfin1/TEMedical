<template>
  <div id="app">
    <div id="app-header">
      <img id="company-logo" src="./images/full logo.png" alt="Company Logo">
    </div>
    <div id="med-nav">
      <menu>
        <li>
          <router-link class="left-nav" v-bind:to="{ name: 'home' }">Home</router-link>
        </li>
        <li v-if="this.$store.state.token != '' && !this.$store.state.user.provider">
          <router-link class="left-nav" v-bind:to="{ name: 'my-appointments' }">Appointments</router-link>
        </li>
        <li v-if="$store.state.token != '' && !this.$store.state.user.provider">
          <router-link class="left-nav" v-bind:to="{ name: 'reviews' }">Reviews</router-link>
        </li>
        <li v-if="$store.state.token != '' && !$store.state.user.provider">
          <router-link class="left-nav" v-bind:to="{ name: 'my-profile-patient' }">Patient Profile</router-link>
        </li>
        <li v-if="$store.state.token != '' && $store.state.user.provider">
          <router-link class="left-nav" v-bind:to="{ name: 'my-profile-provider' }">Provider Profile</router-link>
        </li>
        <li v-if="$store.state.token != ''">
          <router-link class="left-nav" v-bind:to="{ name: 'logout' }">Logout</router-link>
        </li>
      </menu>
      
    </div>
    <router-view id="view" />
    <aside>
      <img id="doctor" src="./images/doctor.png" alt="Doctor">
    </aside>
    <div id="app-footer">
      <office-info/>
    </div>
  </div>
</template>

<script>
import OfficeInfo from "./components/OfficeInfo.vue";

export default {
  name: "app-footer",
  components: { 
    OfficeInfo 
  }
}
</script>


<style>
body {
  margin: 0;
  padding: 0;
}

#app {
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

#app-header {
  grid-area: app-header;
}
#med-nav {
  grid-area: med-nav;
}
.office {
  grid-area: office;
}
aside {
  grid-area: aside;
}
#app-footer {
  grid-area: app-footer;
}

div#app {
  display: grid;
  grid-template-columns: 200px 1fr 280px;
  grid-template-rows: 80px 1fr 1fr;
  gap: 15px;
  grid-template-areas:
    "app-header app-header app-header"
    "med-nav office aside"
    "app-footer app-footer app-footer";
}

#app-header {
  box-shadow: 0 4px 5px 0 rgba(0,0,0,0.14), 0 1px 10px 0 rgba(0,0,0,0.12), 0 2px 4px -1px rgba(0,0,0,0.2);
  padding: 5px;
  background: linear-gradient(40deg, white 35%, rgb(0, 180, 242) 65%);
  
  grid-area: app-header;
  display: flex;
  
  align-items: center;
}

#app-header img {
  
  height: 100%;
}

#med-nav menu {
  box-shadow: 1px 0 0 0 rgba(0,0,0,0.25);
}

#med-nav menu li {
  list-style: none;
  padding: 13px 0;
}

#med-nav menu li:hover {
  background-color: rgb(174, 255, 174);
  border-radius: 5px 30px 30px 5px;
}

#med-nav menu li .left-nav {
    text-decoration: none;
    font-size: 1.2rem;
    color: rgb(0, 180, 242);
  }

aside img {
  height: 500px;
}

#app-footer {
  background: linear-gradient(40deg, rgb(0, 180, 242) 35%, white 65%);
  box-shadow: 0 -4px 5px 0 rgba(0,0,0,0.14), 0 -1px 10px 0 rgba(0,0,0,0.12), 0 -2px 4px -1px rgba(0,0,0,0.2);
  
  margin-bottom: 25%;
  height: 20vh;
  bottom: 0;
  
}

h1 {
  color:rgb(0, 180, 242);
}

@media screen and (max-width: 1000px) {
  div#app {
    grid-template-columns: 1fr;
    grid-template-rows: 1fr;
    justify-items: center;
    gap: none;
    grid-template-areas:
      "app-header"
      "med-nav"
      "office"
      "app-footer"
      "aside";
  }

  #app-header {
  background: linear-gradient(40deg, white 55%, rgb(0, 180, 242));
  height: auto;
  width: 100%;
  padding: 0;
  
  }

  #app-header img {
    height: 80px;
    padding-left: 10px;
    padding-right: 10px;
  }

  #med-nav {
    padding-right: 38px;
  }

  #med-nav menu {
    margin: 5px auto;
    box-shadow: none; 
  }

  #med-nav menu li {
    display: inline-block;
    padding: 0 7px; 
  }

  #app-footer {
    width: 100%;
    height: 30vh;
  }  
}

@media screen and (max-width: 660px) {
  #app-header {
    background: none;
    background-color: white;
    justify-content: center;
  }
}

@media screen and (max-width: 380px) {
  #app-footer {
    height: 40vh;
  } 
}

</style>