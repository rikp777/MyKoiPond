import apiService from '../../services/api.service'

const apiUrl = "/parasites"

// Initial State
const state = {
    error: null,
    Parasites: [],
    Parasite: {},
    isLoading: true,
    page: {
        total: 0
    }
}

// Getters
const getters = {
    Parasites(state) {
        return state.Parasites
    },
    Parasite(state) {
        return state.Parasite
    },
    ParasitePage(state){
        return state.page
    },
    ParasiteIsLoading(state){
        return state.isLoading
    },
    ParasiteError(state){
        return state.error
    }
}

// Actions
const actions = {
    getAllParasites(context, params) {
        context.commit("startLoading")
        return apiService.query(apiUrl, params)
            .then(({data}) => {
                context.commit("setParasites", data.embedded.parasites)
                context.commit("setPage", data.page)
                context.commit("endLoading")
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
    createParasite(context, payload) {
        // alert(JSON.stringify(payload))
        return apiService.post(apiUrl, payload)
            .then(({data}) => {
                context.commit("setParasite", data)
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
    updateParasite(context, [selfLink, payload]) {
        console.log(selfLink)
        console.log(payload)
        let id = apiService.getId(selfLink)
        console.log(id)
        return apiService.update(apiUrl, id, payload)
            .then(({data}) => {
                context.commit("setParasite", data)
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
    deleteParasite(context, [selfLink, payload]) {
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
    setParasites(state, data) {
        state.Parasites = data
    },
    setParasite(state, data){
        state.Parasite = data
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
