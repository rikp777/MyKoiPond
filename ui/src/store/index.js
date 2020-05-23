import Vue from 'vue'
import Vuex from 'vuex'

import app from '../main'
import menu from './modules/menu'
import user from './modules/user'
import breed from './modules/breed.module'
import subBreed from './modules/subbreed.module'
import koi from './modules/koi.module'
import parasite from './modules/parasite.module'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {},
    mutations: {
        changeLang(state, payload) {
            app.$i18n.locale = payload
            localStorage.setItem('currentLanguage', payload)
        }
    },
    actions: {
        setLang({commit}, payload) {
            commit('changeLang', payload)
        }
    },
    modules: {
        menu,
        user,
        breed,
        subBreed,
        koi,
        parasite
    }
})
