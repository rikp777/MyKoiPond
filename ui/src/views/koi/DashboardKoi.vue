<template>
    <div>
        <h1>Koi Dashboard</h1>
        <b-row>
            <b-colxx xl="7" lg="12" class="mb-4">
                <b-card :title="'parasite Overview - ' + item.name" v-if="parasiteItem">
                    <overview-parasite
                        :item="item"
                    ></overview-parasite>
                </b-card>
                <b-card title="delete" v-if="deleteItem">
                    <del
                        :item="item"
                        @createMode="createItemListener"
                        @reloadMode="reloadCompListener"
                    ></del>
                </b-card>

                <b-card title="create" v-if="createItem && !deleteItem">
                    <create
                        :ponds="ponds"
                        :breeds="breeds"
                        @reloadMode="reloadCompListener"
                    ></create>
                </b-card>
                <b-card title="update" v-else-if="updateItem && !deleteItem">
                    <update
                        :ponds="ponds"
                        :breeds="breeds"
                        :item="item"
                        @createMode="createItemListener"
                        @reloadMode="reloadCompListener"
                    ></update>
                </b-card>
                <b-card title="details">
                    <detail
                        :item="item">
                    </detail>
                </b-card>

            </b-colxx>
            <b-colxx xl="5" lg="12" class="mb-4">
                <b-card title="overview" >
                    <overview
                        :key="reloadComp"
                        @updateMode="updateItemListener"
                        @deleteMode="deleteItemListener"
                        @reloadMode="reloadCompListener"
                        @parasiteMode="parasiteItemListener"
                    ></overview>
                </b-card>
            </b-colxx>
        </b-row>
    </div>

</template>

<script>
    import overview from "../../crudl/koi/OverviewKoi";
    import create from "../../crudl/koi/CreateKoi";
    import update from "../../crudl/koi/UpdateKoi";
    import del from "../../crudl/koi/DeleteKoi";
    import detail from "../../crudl/koi/DetailKoi";

    import overviewParasite from "../../crudl/koiParasite/OverviewKoiParasite";

    import {mapGetters} from "vuex";

    export default {
        name: "DashboardParasite",
        components: {
            detail,
            del,
            update,
            create,
            overview,
            overviewParasite
        },
        data() {
            return {
                parasiteItem: false,
                deleteItem: false,
                updateItem: false,
                createItem: true,
                item: Object,
                reloadComp: 0,
            }
        },
        methods: {
            updateItemListener(item) {
                this.addNotification('success filled', `Update Mode`, '')
                this.item = item
                this.deleteItem = false
                this.updateItem = true
                this.createItem = false
                this.parasiteItem = false
            },
            reloadCompListener() {
                this.reloadComp += 1
            },
            createItemListener() {
                this.addNotification('success filled', `Create Mode`, '')
                this.deleteItem = false
                this.updateItem = false
                this.createItem = true
                this.parasiteItem = false
            },
            deleteItemListener(item){
                this.addNotification('error filled', `Delete Mode`, '')
                this.item = item
                this.deleteItem = true
            },
            parasiteItemListener(item){
                this.addNotification('warning filled', `Parasite Mode`, '')
                this.item = item
                this.deleteItem = false
                this.updateItem = false
                this.createItem = false
                this.parasiteItem = true
            },
            addNotification(type, title, message){
                this.$notify(type, title, message, { duration: 3000, permanent: false })
            },
            refreshList() {
                this.$store.dispatch("getAllPonds")
                this.$store.dispatch("getAllBreeds")
            },
        },
        computed: {
            ...mapGetters({
                ponds: 'ponds',
                breeds: 'breeds'
            })
        },
        mounted() {
            this.refreshList()
        }
    }
</script>

