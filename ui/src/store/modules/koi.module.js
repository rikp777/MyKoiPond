import apiService from '../../services/api.service'

let pond_id = 1
const apiUrl = `/ponds/${pond_id}/kois`//related to pond

// Initial State
const state = {
    error: null,
    kois: [],
    koi: {},
    isLoading: true,
    page: {
        total: 0
    }
}

// Getters
const getters = {
    kois(state) {
        return state.kois
    },
    koi(state) {
        return state.koi
    },
    koiPage(state){
        return state.koi
    },
    koiIsLoading(state){
        return state.isLoading
    },
    koiError(state){
        return state.error
    }
}

// Actions
const actions = {
    getAllKois(context, params) {
        console.log("raak")
        context.commit("startLoading")
        return apiService.query(apiUrl, params)
            .then(({data}) => {
                context.commit("setKois", data.embedded.kois)
                if(data.page){
                    context.commit("setPage", data.page)
                }
                context.commit("endLoading")
            })
            .catch((error) => {
                console.log("error sdfs")
                context.commit("setError", true)
                throw error
            })
    },
    createKoi(context, payload) {
        // alert(JSON.stringify(payload))
        return apiService.post(apiUrl, payload)
            .then(({data}) => {
                context.commit("setKoi", data)
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
    updateKoi(context, [selfLink, payload]) {
        console.log(selfLink)
        console.log(payload)
        let id = apiService.getId(selfLink)
        console.log(id)
        return apiService.update(apiUrl, id, payload)
            .then(({data}) => {
                context.commit("setKoi", data)
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
    deleteKoi(context, [selfLink, payload]) {
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
    setKois(state, data) {
        state.kois = data
        console.log(state.kois)
    },
    setKoi(state, data){
        state.koi = data
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
