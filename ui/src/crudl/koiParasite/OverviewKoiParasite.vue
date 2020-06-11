<template>
    <div>
        <template v-if="!isLoading">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Date</th>
                    <th scope="col">Parasite</th>
                    <th scope="col">Comment</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="(item, index) in items" :key="index">
                    <td>{{item.date}}</td>
                    <td>{{item.parasite.name}}</td>
                    <td>{{item.comment}}</td>
                    <td>
                        <b-button
                            size="xs"
                            variant="primary"
                            @click="updateItemListener(item)">
                            Update
                        </b-button>
                        <b-button
                            size="xs"
                            variant="danger"
                            @click="deleteItemListener(item)">
                            Delete
                        </b-button>
                    </td>
                </tr>
                </tbody>
            </table>
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
            v-if="!error && page.total"
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
        <template>
            <b-card title="create" v-if="!updateItem && !deleteItem" class="mb-3">
                <create-koi-parasite
                    @reloadMode="reloadCompListener"
                ></create-koi-parasite>
            </b-card>
            <b-card title="update" v-else-if="!deleteItem" class="mb-3">
                <update-koi-parasite
                    :item="item"
                    @createMode="createItemListener"
                    @reloadMode="reloadCompListener"
                ></update-koi-parasite>
            </b-card>

            <b-card title="delete" v-if="deleteItem" class="mb-3">
                <delete-koi-parasite
                    :item="item"
                    @createMode="createItemListener"
                    @reloadMode="reloadCompListener"
                ></delete-koi-parasite>
            </b-card>
        </template>
    </div>
</template>

<script>
    import {mapGetters} from 'vuex'
    import CreateKoiParasite from "./CreateKoiParasite";
    import UpdateKoiParasite from "./UpdateKoiParasite";
    import DeleteKoiParasite from "./DeleteKoiParasite";

    export default {
        name: "OverviewKoiParasite",
        components: {DeleteKoiParasite, UpdateKoiParasite, CreateKoiParasite},
        props: ['item'],
        data() {
            return {
                deleteItem: false,
                updateItem: false,
            }
        },
        computed: {
            ...mapGetters({
                items: 'koiParasites',
                page: 'koiParasitePage',
                isLoading: 'koiParasiteIsLoading',
                error: 'koiParasiteError'
            })
        },
        methods: {
            refreshList(pageNumber = 1) {
                this.$store.dispatch("getAllKoiParasites")
            },

            updateItemListener(item){
                this.item = item
                this.deleteItem = false
                this.updateItem = true
            },
            createItemListener() {
                this.deleteItem = false
                this.updateItem = false
            },
            deleteItemListener(item){
                this.item = item
                this.deleteItem = true
            },

            reloadCompListener() {
                this.reloadComp += 1
            },
        },
        mounted() {
            this.refreshList()
        }
    }
</script>
