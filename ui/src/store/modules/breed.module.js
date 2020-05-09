import apiService from '../../services/api.service'

const apiUrl = "/breeds"

// Initial State
const state = {
    errors: null,
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
                throw error
            })
    },
    createBreed(context, payload) {
        // alert(JSON.stringify(payload))
        return apiService.post(apiUrl, payload)
            .then(({data}) => {
                context.commit("setBreed", data)
            })
            .catch((error) => {
                throw error
            })
    },
    updateBreed(context, selfLink, payload) {
        return apiService.put(selfLink, payload)
            .then(({data}) => {
                context.commit("setBreed", data)
            })
            .catch((error) => {
                throw error
            })
    },
    deleteBreed(context, selfLink) {
        return apiService.delete(selfLink)
            .then(() => {

            })
            .catch((error) => {
                throw error
            })
    }
}

// Mutations
const mutations = {
    startLoading(state) {
        state.isLoading = true
    },
    endLoading(state) {
        state.isLoading = false
    },
    setBreeds(state, data) {
        state.breeds = data
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
