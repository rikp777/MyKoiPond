const state = {}

const mutations = {
    'SET_BREEDS' (state, breeds) {
        state.breeds = breeds
    }
}

const actions = {
    save: ({ commit }, breed) => {
        commit()
    }
}

const getters = {
    breeds: state => {
        return state.breeds
    }
}

export default {
    state,
    mutations,
    actions,
    getters
}
