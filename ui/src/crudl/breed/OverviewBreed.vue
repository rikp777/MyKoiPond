<template>
  <div>
    <b-card title="Breeds Overview">
      <template v-if="!isLoading">
        <b-row key="list">
          <b-colxx xxs="12" class="mb-3" v-for="(item,index) in items" :key="index">
            <div class="pl-2 d-flex flex-grow-1 min-width-zero">
              <div
                class="card-body align-self-center d-flex flex-column flex-lg-row justify-content-between min-width-zero align-items-lg-center">
                <p class="list-item-heading mb-0">{{item.name}}</p>
                <p class="mb-0 text-muted text-small w-50">{{item.description}}</p>
              </div>
            </div>
          </b-colxx>
        </b-row>
      </template>
      <template v-else>
        <div class="loading"></div>
      </template>

      <ul class="pagination" v-if="baseUrl">
        <li class="page-item" v-bind:class="{disabled: !page.prev}">
          <a class="page-link" href="#" v-on:click="refreshList(page.prev)">Previous</a>
        </li>
        <li class="page-item"
            v-for="(pageNumber, index) in page.total"
            v-on:click="refreshList(baseUrl, pageNumber)"
            :key="index">
          <a class="page-link" href="#">{{pageNumber}}</a>
        </li>
        <li class="page-item" v-bind:class="{disabled: !page.next}">
          <a class="page-link" href="#" v-on:click="refreshList(page.next)">Next</a>
        </li>
      </ul>

    </b-card>
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
          sizes: [4, 8, 12],

          size: 4,
          elements: 0,
          total: 0,
          number: 1,

          first: '',
          prev: '',
          self: '',
          next: '',
          last: '',
        }
      }
    },
    methods: {
      refreshList(url = this.baseUrl, pageNumber = 1) {
        // console.log(url)
        if (this.isLoading) return
        this.isLoading = true

        const params = {
          page: pageNumber,
          size: this.page.size
        }
        axios
          .get(url, {params})
          .then(({data}) => {
            // console.log(data)
            this.items = data._embedded.breeds

            this.page.size = data.page.size
            this.page.elements = data.page.totalElements
            this.page.total = data.page.totalPages
            this.page.number = data.page.number

            this.page.first = data._links.first.href
            this.page.prev = data._links.prev.href
            this.page.self = data._links.self.href
            this.page.next = data._links.next.href
            this.page.last = data._links.last.href
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
