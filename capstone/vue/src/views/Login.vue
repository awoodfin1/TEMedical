<template>
    <div id="login" class="text-center">
      <form class="form-signin" @submit.prevent="login">
        <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
        <div
          class="alert alert-danger"
          role="alert"
          v-if="invalidCredentials"
        >Invalid username and password!</div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >Thank you for registering, please sign in.</div>
        <label for="username" class="sr-only"></label>
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
        <br>
        <label for="password" class="sr-only"></label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        <br>
        <router-link id="login-link" :to="{ name: 'register' }">Need an account?</router-link>
        <br>
        <button type="submit">Sign in</button>
      </form>
    </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  created() {
    scroll(0,0);
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            
            authService.getDisplayApptUpdate().then( (result) => {
              if (result.status === 200) {
                this.$store.commit("SET_DISPLAY_APPT_UPDATE", result.data);
                this.$router.push("/");
              }

            });
            // this.$store.commit("SET_ISPROVIDER", response.data.provider);
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>
  .text-center {
    display: flex;
    flex-direction: column;
    align-items: center;
    box-shadow: 0 4px 5px 0 rgba(0,0,0,0.14), 0 1px 10px 0 rgba(0,0,0,0.12), 0 2px 4px -1px rgba(0,0,0,0.2);
    margin: 3% 5% 12% 5%;
}

#login-link {
  text-decoration: underline;
}

@media screen and (max-width: 1000px) {
  .text-center {
    padding: 0 35px 30px 35px;
    margin: 3% 8% 8% 8%;
  }
}
  
</style>