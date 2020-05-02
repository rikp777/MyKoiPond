import Vue from "vue";
import VueRouter from 'vue-router';

import breed from './routes/breed.route'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import(/* webpackChunkName: "app" */ '../views/app'),
  },
  ...breed
]

const router = new VueRouter({
  linkActiveClass: "active",
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
