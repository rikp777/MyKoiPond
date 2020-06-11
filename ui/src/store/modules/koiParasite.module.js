import apiService from '../../services/api.service'

let koi_id = 1
const apiUrl = `/kois/${koi_id}/koiParasites`//related to pond

// Initial State
const state = {
    error: null,
    koiParasites: [],
    koiParasite: {},
    isLoading: true,
    page: {
        total: 0
    }
}

// Getters
const getters = {
    koiParasites(state) {
        return state.koiParasites
    },
    koiParasite(state) {
        return state.koiParasite
    },
    koiParasitePage(state){
        return state.page
    },
    koiParasiteIsLoading(state){
        return state.isLoading
    },
    koiParasiteError(state){
        return state.error
    }
}

// Actions
const actions = {
    getAllKoiParasites(context, params) {
        context.commit("startLoading")
        return apiService.query(apiUrl)
            .then(({data}) => {
                context.commit("setKoiParasites", data.embedded.koiParasites)
                if(data.page) {
                    context.commit("setPage", data.page)
                }
                context.commit("endLoading")
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
    createKoiParasite(context, payload) {
        // alert(JSON.stringify(payload))
        return apiService.post(apiUrl, payload)
            .then(({data}) => {
                context.commit("setKoiParasite", data)
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
    updateKoiParasite(context, [selfLink, payload]) {
        console.log(selfLink)
        console.log(payload)
        let id = apiService.getId(selfLink)
        console.log(id)
        return apiService.update(apiUrl, id, payload)
            .then(({data}) => {
                context.commit("setKoiParasite", data)
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
    deleteKoiParasite(context, [selfLink, payload]) {
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
    setKoiParasites(state, data) {
        state.koiParasites = data
    },
    setKoiParasite(state, data){
        state.koiParasite = data
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
