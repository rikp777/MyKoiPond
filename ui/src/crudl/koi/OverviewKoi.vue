<template>
    <div>
        <template>
            <b-row key="list">
                <b-col>
                    <b-tabs nav-class="separator-tabs ml-0 mb-5" content-class="tab-content" :no-fade="true">
                        <b-tab v-for="pond in items" :title="pond.name" :key="pond.name">
                            <b-row>
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Birth</th>
                                        <th>Gender</th>
                                        <th>Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr v-for="koi in pond.kois">
                                        <td>{{koi.name}}</td>
                                        <td>{{koi.birth}}</td>
                                        <td>{{koi.sex}}</td>
                                        <td>
                                            <b-button
                                                class="btn-sm"
                                                variant="primary"
                                                @click="updateMode(koi)">
                                                Update
                                            </b-button>
                                            <b-button
                                                class="btn-sm"
                                                variant="danger"
                                                @click="deleteMode(koi)">
                                                Delete
                                            </b-button>
                                            <div v-if="pond.name.includes('Quarantain')">
                                                <hr>
                                                <b-button
                                                    class="btn-sm"
                                                    variant="warning"
                                                    @click="parasiteMode(koi)">
                                                    Parasites
                                                </b-button>
                                            </div>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </b-row>
                        </b-tab>
                    </b-tabs>
                </b-col>
            </b-row>
        </template>
    </div>
</template>

<script>
    import {mapGetters} from 'vuex'

    export default {
        name: "OverviewKoi",
        data() {
            return {}
        },
        computed: {
            ...mapGetters({
                items: 'ponds',
                page: 'pondPage',
                isLoading: 'pondIsLoading',
                error: 'pondError'
            })
        },
        methods: {
            refreshList(pageNumber = 1) {
                console.log("Koi Overview - refresh list")
                const params = {
                    page: pageNumber,
                    size: 4
                }
                this.$store.dispatch("getAllPonds", params)
            },
            updateMode(item) {
                console.log("Koi Overview - UpdateMode")
                this.$emit('updateMode', item)
            },
            deleteMode(item){
                console.log("Koi Overview - DeleteMode")
                this.$emit('deleteMode', item)
            },
            parasiteMode(item){
                console.log("Koi Overview - ParasiteMode")
                this.$emit('parasiteMode', item)
            }
        },
        mounted() {
            this.refreshList()
        }
    }
</script>
