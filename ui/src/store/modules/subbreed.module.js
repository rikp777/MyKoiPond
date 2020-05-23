import apiService from '../../services/api.service'

const apiUrl = "/subbreeds"

// Initial State
const state = {
    error: null,
    subBreeds: [],
    subBreed: {},
    isLoading: true,
    page: {
        total: 0
    }
}

// Getters
const getters = {
    subBreeds(state) {
        return state.subBreeds
    },
    subBreed(state) {
        return state.subBreed
    },
    subBreedPage(state){
        return state.page
    },
    subBreedIsLoading(state){
        return state.isLoading
    },
    subBreedError(state){
        return state.error
    }
}

// Actions
const actions = {
    getAllSubBreeds(context, params) {
        context.commit("startLoading")
        return apiService.query(apiUrl, params)
            .then(({data}) => {
                context.commit("setSubBreeds", data.embedded.subbreeds)
                context.commit("setPage", data.page)
                context.commit("endLoading")
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
    createSubBreeds(context, payload) {
        return apiService.post(apiUrl, payload)
            .then(({data}) => {
                context.commit("setSubBreed", data)
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
    updateSubBreeds(context, [selfLink, payload]) {
        let id = apiService.getId(selfLink)
        return apiService.update(apiUrl, id, payload)
            .then(({data}) => {
                context.commit("setSubBreed", data)
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
    deleteSubBreeds(context, [selfLink, payload]) {
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
    setSubBreeds(state, data) {
        state.subBreeds = data
    },
    setSubBreed(state, data){
        state.subBreed = data
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
