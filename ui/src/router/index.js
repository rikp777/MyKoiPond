import Vue from "vue";
import VueRouter from 'vue-router';

import pond from './routes/pond.route'
import breed from './routes/breed.route'
import subBreed from './routes/subbreed.route'
import parasite from './routes/parasite.route'
import koi from './routes/koi.route'
import auth from './routes/auth.route'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Home',
        component: () => import(/* webpackChunkName: "app" */ '../views/docs/Welcome'),
    },
    ...pond,
    ...breed,
    ...subBreed,
    ...subBreed,
    ...parasite,
    ...koi,
    ...auth
]

const router = new VueRouter({
    linkActiveClass: "active",
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
