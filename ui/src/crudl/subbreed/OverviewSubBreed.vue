<template>
    <div>
        <template v-if="!isLoading">
            <b-row key="list">
                <b-colxx xxs="12" class="mb-3" v-for="(item,index) in items" :key="index">
                    <div class="pl-2 d-flex flex-grow-1 min-width-zero">
                        <div
                            class="card-body align-self-center d-flex flex-column flex-lg-row justify-content-between min-width-zero align-items-lg-center">
                            <p class="list-item-heading mb-0">{{item.name}}</p>
                            <p class="mb-0 text-muted text-small w-50">{{item.description}}</p>
                            <b-button
                                class="btn-sm"
                                variant="primary"
                                @click="updateMode(item)">
                                Update
                            </b-button>
                            <b-button
                                class="btn-sm"
                                variant="danger"
                                @click="deleteMode(item)">
                                Delete
                            </b-button>
                        </div>
                    </div>
                </b-colxx>
            </b-row>
        </template>
        <template v-else>
            <div v-if="error">
                <div class="card-body text-center">
                    <h5 class="card-title">Failed to load data</h5>
                    <b-button
                        class="btn-sm col-2"
                        variant="primary"
                        @click="refreshList">
                        Reload data
                    </b-button>
                </div>
            </div>
            <div v-else>
                <div class="card-body text-center">
                    <h5 class="card-title">Loading data...</h5>
                </div>
            </div>
        </template>

        <paginate
            v-if="!error"
            v-model="page.self"
            :page-count="page.total"
            :margin-pages="2"
            :page-range="3"
            :container-class="'pagination'"
            :page-class="'page-item'"
            :page-link-class="'page-link'"
            :prev-class="'page-item'"
            :prev-link-class="'page-link'"
            :next-class="'page-item'"
            :next-link-class="'page-link'"
            :break-view-class="'break-view'"
            :break-view-link-class="'break-view-link'"
            :first-last-button="true"
            :click-handler="refreshList"
        ></paginate>
    </div>
</template>

<script>
    import {mapGetters} from 'vuex'

    export default {
        name: "OverviewSubBreed",
        data() {
            return {}
        },
        computed: {
            ...mapGetters({
                items: 'subBreeds',
                page: 'subBreedPage',
                isLoading: 'subBreedIsLoading',
                error: 'subBreedError'
            })
        },
        methods: {
            refreshList(pageNumber = 1) {
                console.log("SubBreed Overview - refresh list")
                const params = {
                    page: pageNumber,
                    size: 4
                }
                this.$store.dispatch("getAllSubBreeds", params)
            },
            updateMode(item) {
                console.log("SubBreed Overview - UpdateMode")
                this.$emit('updateMode', item)
            },
            deleteMode(item){
                console.log("SubBreed Overview - DeleteMode")
                this.$emit('deleteMode', item)
            }
        },
        mounted() {
            this.refreshList()
        }
    }
</script>
