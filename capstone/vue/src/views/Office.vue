<template>
    <div class = "office">
    </div>
</template>

<script>
    import authService from "../services/AuthService";
    export default {
      name: "office",
      data() {
        return {
          user: {
            username: "",
            password: ""
          },
          invalidCredentials: false
        };
      },
      methods: {
        login() {
          authService
            .login(this.user)
            .then(response => {
              if (response.status == 200) {
                this.$store.commit("SET_AUTH_TOKEN", response.data.token);
                this.$store.commit("SET_USER", response.data.user);
                this.$router.push("/home");
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