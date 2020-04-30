<template>
    <div>
        <table class="table table-hover">
            <thead class="thead-inverted">
                <tr>
                    <th><i class="fa fa-user"></i>name</th>
                    <th><i class="fa fa-user-secret"></i>description</th>
                </tr>
            </thead>
           <tbody>
                <tr v-if="loadingList">
                    <td colspan="3" class="text-center"><i class="fa fa-spinner fa-pulse fa-2x"></i></td>
                </tr>
                <tr v-else-if="allBreeds" v-for="(breed, index) in allBreeds" :key="index"
                    v-on:click="showBreed(breed._links.self.href)" style="cursor: pointer"
                    v-bind:class="{'table-active': currentBreed && currentBreed.id == breed.id}">
                    <td>{{breed.name}}</td>
                    <td>{{breed.description}}</td>
                    <td>
                        <button class="btn btn-sm btn-danger" v-on:click.stop="deleteBreed(breed._links.self)"><i class="fa fa-trash"></i> </button>
                    </td>
                </tr>
           </tbody>
        </table>
        <ul class="pagination" v-if="baseUrl">
            <li class="page-item" v-bind:class="{disabled: !page._links.prev}">
                <a class="page-link" href="#" v-on:click="refreshList(page._links.prev.href)">Previous</a>
            </li>
            <li class="page-item"
                v-for="(pageNumber, index) in page.totalPages"
                v-on:click="refreshList(baseUrl, pageNumber)"
                :key="index">
                <a class="page-link" href="#">{{pageNumber}}</a>
            </li>
            <li class="page-item" v-bind:class="{disabled: !page._links.next}">
                <a class="page-link" href="#" v-on:click="refreshList(page._links.next.href)">Next</a>
            </li>
        </ul>

        <div class="card">
            <div class="card-body">
            <div class="card-title"><h4>Breed info</h4></div>

                <div v-if="loadingBreed" class="text-center">...loading</div>
                <div v-else-if="currentBreed">
                    <table class="table table-sm table-responsive">
                        <tbody>
                            <tr>
                                <td><strong><i class="fa fa-user"></i></strong></td>
                                <td>{{currentBreed.name}}</td>
                            </tr>
                            <tr>
                                <td><strong><i class="fa fa-user"></i></strong></td>
                                <td>{{currentBreed.description}}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'BreedsList',
    data () {
        return {
            baseUrl: 'http://localhost:7070/api/breeds',
            form: { name: '', description: '' },
            allBreeds: null,
            currentBreed: null,
            currentPage: 1,
            loadingList: false,
            loadingBreed: false,
            page: { size: 6, totalPages: 0, _links: {} }
        }
    },
    created: function () {
        this.refreshList()
    },

    methods: {
        refreshList (url = this.baseUrl, pageNumber = 1) {
            console.log(url)
            if (this.loadingList) return
            this.loadingList = true

            const params = {
                page: pageNumber,
                size: this.page.size
            }
            axios.get(url, { params })
                .then(({ data }) => {
                    console.log(data)
                    this.allBreeds = data._embedded.breeds
                    this.page._links = data._links
                    this.page.totalPages = data.page.totalPages
                    this.page.number = pageNumber
                })
                .catch(error => console.log(error))
                .finally(() => {
                    this.loadingList = false
                })
        },
        showBreed (url) {
            if (this.loadingBreed) return

            this.loadingBreed = true

            axios.get(url)
                .then(({ data }) => {
                    console.log(data)
                    this.currentBreed = data
                })
                .catch(error => console.log(error))
                .finally(() => {
                    console.log('klaar')
                    this.loadingBreed = false
                })
        }
    }
}
</script>

<style scoped>

</style>
