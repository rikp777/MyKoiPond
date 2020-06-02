<template>
    <div>
        <h1>Pond Dashboard</h1>
        <b-row>
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
    import overview from "../../crudl/pond/OverviewPond";

    export default {
        name: "DashboardPond",
        components: {
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

