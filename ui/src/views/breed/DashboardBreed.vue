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
                        :id="itemId"
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
    import  update from "../../crudl/breed/CreateBreed";

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
                itemId: null,
                reloadComp: 0,
            }
        },
        methods: {
            updateListener(id) {
                console.log('update' + id)
                this.itemId = id
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

