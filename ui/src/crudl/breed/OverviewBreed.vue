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
                        </div>
                    </div>
                </b-colxx>
            </b-row>
        </template>
        <template v-else>
            ...loading
        </template>

        <paginate
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
        name: "OverviewBreed",
        data() {
            return {}
        },
        computed: {
            ...mapGetters({
                items: 'breeds',
                page: 'breedPage',
                isLoading: 'breedIsLoading'
            })
        },
        methods: {
            refreshList(pageNumber = 1) {
                console.log("refresh list")
                const params = {
                    page: pageNumber,
                    size: 4
                }
                this.$store.dispatch("getAllBreeds", params)
            },
            updateMode(item) {
                //console.log(item.constructor.name)
                this.$emit('updateMode', item)
            }
        },
        mounted() {
            this.refreshList()
        }
    }
</script>
