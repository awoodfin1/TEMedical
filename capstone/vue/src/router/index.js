import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import Office from '../views/Office.vue'
import store from '../store/index'
import Appointment from '../views/Appointment.vue'
import Providers from '../views/Providers.vue'
import Provider from '../views/Provider.vue'
import MyAppointments from '../views/MyAppointments.vue'
import AppointmentDetail from '../views/AppointmentDetail.vue'
import MyProfilePatient from '../views/MyProfilePatient.vue'
import MyProfileProvider from '../views/MyProfileProvider.vue'
import Review from '../views/Review.vue'


Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/office",
      name: "office",
      component: Office,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/appointment",
      name: "appointment",
      component: Appointment,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/providers",
      name: "providers",
      component: Providers,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/providers/:providerId",
      name: "Provider",
      component: Provider,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/my-appointments",
      name: "my-appointments",
      component: MyAppointments,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/my-appointments/:apptId",
      name: "appointment-details",
      component: AppointmentDetail,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/patient/my-profile",
      name: "my-profile-patient",
      component: MyProfilePatient,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/provider/my-profile",
      name: "my-profile-provider",
      component: MyProfileProvider,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/reviews",
      name: "reviews",
      component: Review,
      meta: {
        requiresAuth: true
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
