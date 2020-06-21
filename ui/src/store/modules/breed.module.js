import apiService from '../../services/api.service'

const apiUrl = "/breeds"

// Initial State
const state = {
    error: null,
    breeds: [],
    breed: {},
    isLoading: true,
    page: {
        total: 0
    }
}

// Getters
const getters = {
    breeds(state) {
        return state.breeds
    },
    breed(state) {
        return state.breed
    },
    breedPage(state){
        return state.page
    },
    breedIsLoading(state){
        return state.isLoading
    },
    breedError(state){
        return state.error
    }
}

// Actions
const actions = {
    getAllBreeds(context, params) {
        context.commit("startLoading")
        return apiService.query(apiUrl, params)
            .then(({data}) => {
                context.commit("setBreeds", data.embedded.breeds)
                context.commit("setPage", data.page)
                context.commit("endLoading")
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
    createBreed(context, payload) {
        console.log(payload)
        return apiService.post(apiUrl, payload)
            .then(({data}) => {
                context.commit("setBreed", data)
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
    updateBreed(context, [selfLink, payload]) {
        console.log(selfLink)
        console.log(payload)
        let id = apiService.getId(selfLink)
        console.log(id)
        return apiService.update(apiUrl, id, payload)
            .then(({data}) => {
                context.commit("setBreed", data)
            })
            .catch((error) => {
                context.commit("setError", true)
                throw error
            })
    },
    deleteBreed(context, [selfLink, payload]) {
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
    setBreeds(state, data) {
        state.breeds = data
    },
    setBreed(state, data){
        state.breed = data
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
