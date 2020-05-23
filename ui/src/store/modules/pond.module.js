import apiService from '../../services/api.service'

const apiUrl = "/breeds"

// Initial State
const state = {
    error: null,
    ponds: [],
    pond: {},
    isLoading: true,
    page: {
        total: 0
    }
}

// Getters
const getters = {
    ponds(state) {
        return state.ponds
    },
    pond(state) {
        return state.pond
    },
    pondPage(state){
        return state.page
    },
    pondIsLoading(state){
        return state.isLoading
    },
    pondError(state){
        return state.error
    }
}

// Actions
const actions = {
    getAllPonds(context, params) {
        context.commit("startLoading")
        return apiService.query(apiUrl, params)
            .then(({data}) => {
                context.commit("setPonds", data.embedded.ponds)
                context.commit("setPage", data.page)
                context.commit("endLoading")
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
    createPond(context, payload) {
        // alert(JSON.stringify(payload))
        return apiService.post(apiUrl, payload)
            .then(({data}) => {
                context.commit("setPond", data)
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
    updatePond(context, [selfLink, payload]) {
        console.log(selfLink)
        console.log(payload)
        let id = apiService.getId(selfLink)
        console.log(id)
        return apiService.update(apiUrl, id, payload)
            .then(({data}) => {
                context.commit("setPond", data)
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
    deletePond(context, [selfLink, payload]) {
        let id = apiService.getId(selfLink)
        return apiService.delete(apiUrl, id)
            .then(() => {
                alert('deleted successfully')
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
}

// Mutations
const mutations = {
    setError(state, data){
        state.error = data
    },
    startLoading(state) {
        state.error = false
        state.isLoading = true
    },
    endLoading(state) {
        state.isLoading = false
    },
    setPonds(state, data) {
        state.ponds = data
    },
    setPond(state, data){
        state.pond = data
    },
    setPage(state, data){
        state.page.total = data.totalPages -1
    }
}

export default {
    state,
    getters,
    actions,
    mutations
}
