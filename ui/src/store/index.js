import Vue from 'vue'
import Vuex from 'vuex'

import breeds from './modules/breeds'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {},
    mutations: {},
    actions: {},
    modules: {
        breeds
    }
})
