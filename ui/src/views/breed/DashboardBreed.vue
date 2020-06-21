<template>
    <div>
        <h1>Breed Dashboard {{deleteItem}}</h1>
        <b-row>
            <b-colxx xl="6" lg="12" class="mb-4">

                <b-card title="delete" v-if="deleteItem">
                    <deletee
                        :item="item"
                        @createMode="createItemListener"
                        @reloadMode="reloadCompListener"
                    ></deletee>
                </b-card>

                <b-card title="create" v-if="!updateItem && !deleteItem">
                    <create
                        @reloadMode="reloadCompListener"
                    ></create>
                </b-card>
                <b-card title="update" v-else-if="!deleteItem">
                    <update
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
            <b-colxx xl="6" lg="12" class="mb-4">
                <b-card title="overview" >
                    <overview
                        :key="reloadComp"
                        @updateMode="updateItemListener"
                        @deleteMode="deleteItemListener"
                        @reloadMode="reloadCompListener"
                    ></overview>
                </b-card>
            </b-colxx>
        </b-row>
    </div>

</template>

<script>
    import overview from "../../crudl/breed/OverviewBreed";
    import  create from "../../crudl/breed/CreateBreed";
    import  update from "../../crudl/breed/UpdateBreed";
    import deletee from "../../crudl/breed/DeleteBreed";
    import detail from "../../crudl/breed/DetailBreed";

    export default {
        name: "DashboardBreed",
        components: {
            detail,
            deletee,
            update,
            create,
            overview
        },
        data() {
            return {
                deleteItem: false,
                updateItem: false,
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
            },
            reloadCompListener() {
                this.reloadComp += 1
            },
            createItemListener() {
                this.addNotification('success filled', `Create Mode`, '')
                this.deleteItem = false
                this.updateItem = false
            },
            deleteItemListener(item){
                this.addNotification('error filled', `Delete Mode`, '')
                this.item = item
                this.deleteItem = true
            },
            addNotification(type, title, message){
                this.$notify(type, title, message, { duration: 3000, permanent: false })
            }
        }
    }
</script>

