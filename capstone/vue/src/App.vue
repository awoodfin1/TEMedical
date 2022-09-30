<template>
  <div id="app">
    <div id="header">
      <img id="snake" src="green snake.jpg" alt="Medical Snake Logo">
      <img id="company" src="company name.jpg" alt="TE Medical">
    </div>
    <div id="nav">
      <menu>
        <li>
          <router-link class="left-nav" v-bind:to="{ name: 'home' }">Home</router-link>
        </li>
        <li>
          <router-link class="left-nav" v-bind:to="{ name: 'office' }" v-if="$store.state.token != ''">Office Info</router-link>
        </li>
        <li>
          <router-link class="left-nav" v-bind:to="{ name: 'appointment' }" v-if="$store.state.token != ''">Availability</router-link>
        </li>
        <li>
          <router-link class="left-nav" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        </li>
      </menu>
      
    </div>
    <router-view id="view" />
    <aside>
      <img id="doctor" src="doctor.png" alt="Doctor">
    </aside>
    <div id="footer">
      <p>Phone and Address</p>
    </div>
  </div>
</template>

<style>
body {
  margin: 0;
  padding: 0;
}

#app {
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

#header {
  grid-area: header;
}
#nav {
  grid-area: nav;
}
.office {
  grid-area: office;
}
aside {
  grid-area: aside;
}
#footer {
  grid-area: footer;
}

div#app {
  display: grid;
  grid-template-columns: 180px 1fr 250px;
  grid-template-rows: 80px 1fr 1fr;
  gap: 15px;
  grid-template-areas:
    "header header header"
    "nav office aside"
    "nav office aside"
    "footer footer footer";
}

#header {
  box-shadow: 0 4px 5px 0 rgba(0,0,0,0.14), 0 1px 10px 0 rgba(0,0,0,0.12), 0 2px 4px -1px rgba(0,0,0,0.2);
  padding: 5px;
  
  grid-area: header;
  display: flex;
  
  align-items: center;
}

#header img {
  height: 100%;
}

#nav menu li {
  list-style: none;
  padding: 13px 0;
}

#nav menu li:hover {
  background-color: rgb(174, 255, 174);
  border-radius: 5px 30px 30px 5px;
}

#nav menu li .left-nav {
    text-decoration: none;
    font-size: 1.2rem;
    color: rgb(0, 180, 242);
  }

aside img {
  height: 100%;
}

#footer {
  margin-left: 42px;
}
</style>