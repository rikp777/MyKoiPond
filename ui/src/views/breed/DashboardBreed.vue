<template>
    <div>
        <h1>Breed Dashboard</h1>
        <b-row>
            <b-colxx xl="6" lg="12" class="mb-4">
                <b-card title="create" v-if="!update">
                    <create
                        @reloadMode="reloadListener"
                    ></create>
                </b-card>
                <b-card title="update" v-else>
                    <update
                        :item="item"
                        @createMode="createListener"
                        @reloadMode="reloadListener"
                    ></update>
                </b-card>
            </b-colxx>
            <b-colxx xl="6" lg="12" class="mb-4">
                <b-card title="overview" >
                    <overview
                        :key="reloadComp"
                        @updateMode="updateListener"
                        @refreshMode="reloadListener"
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

    export default {
        name: "DashboardBreed",
        components: {
            update,
            create,
            overview
        },
        data() {
            return {
                update: false,
                item: Object,
                reloadComp: 0,
            }
        },
        methods: {
            updateListener(item) {
                console.log('update' + JSON.stringify(item))
                console.log(item)
                this.item = item
                this.update = true
            },
            reloadListener() {
                this.reloadComp += 1
            },
            createListener() {
                console.log('create')
                this.update = false
            }
        }
    }
</script>

