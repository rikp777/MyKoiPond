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
                                <button>update</button>
                            </div>
                        </div>
                    </b-colxx>
                </b-row>
            </template>
            <template v-else>
                <div class="loading"></div>
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


            <!--            <b-pagination v-model="page.self" :total-rows="page.total" size="lg"></b-pagination>-->

<!--            <nav aria-label="Page navigation example">-->
<!--                <ul class="pagination">-->
<!--                    <li class="page-item" v-bind:class="{disabled: !page.prev}">-->
<!--                        <a class="page-link" href="#" v-on:click="refreshList(page.prev)">Previous</a>-->
<!--                    </li>-->

<!--                    <li class="page-item" v-bind:class="{disabled: !page.next}">-->
<!--                        <a class="page-link" href="#" v-on:click="refreshList(page.next)">Next</a>-->
<!--                    </li>-->
<!--                </ul>-->
<!--            </nav>-->

            <!--            <ul class="pagination" v-if="baseUrl">-->
            <!--                <li class="page-item" v-bind:class="{disabled: !page.prev}">-->
            <!--                    <a class="page-link" href="#" v-on:click="refreshList(page.prev)">Previous</a>-->
            <!--                </li>-->
            <!--                <li class="page-item"-->
            <!--                    v-for="(pageNumber, index) in page.total"-->
            <!--                    v-on:click="refreshList(baseUrl, pageNumber)"-->
            <!--                    :key="index">-->
            <!--                    <a class="page-link" href="#">{{pageNumber}}</a>-->
            <!--                </li>-->
            <!--                <li class="page-item" v-bind:class="{disabled: !page.next}">-->
            <!--                    <a class="page-link" href="#" v-on:click="refreshList(page.next)">Next</a>-->
            <!--                </li>-->
            <!--            </ul>-->
    </div>
</template>

<script>
    import axios from 'axios'
    import VuePaginator from 'vuejs-paginate'

    export default {
        name: "OverviewBreed",
        components: {
            VPaginator: VuePaginator
        },
        data() {
            return {
                isLoading: false,
                baseUrl: 'http://localhost:7070/api/breeds',

                items: [],

                page: {
                    size: 4,
                    total: 0,
                    self: '',
                }
            }
        },
        methods: {
            refreshList(pageNumber = 1) {
                // console.log(url)
                if (this.isLoading) return
                this.isLoading = true

                const params = {
                    page: pageNumber,
                    size: this.page.size
                }

                // this.$store.dispatch("getAllBreeds", params).then(() => {
                //     this.$store.dispatch("getAllBreeds");
                // })
                axios
                    .get(this.baseUrl, {params})
                    .then(({data}) => {
                        this.page.total = data.page.totalPages
                        this.items = data.embedded.breeds
                        this.page.self = pageNumber
                    })
                    .catch(error => console.log("error jonguh"))
                    .finally(() => {
                        this.isLoading = false
                    })
            },
        },
        mounted() {
            this.refreshList()
        }
    }
</script>

<style scoped>

</style>
