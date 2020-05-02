<template>
  <div>
    <h1>Breed Dashboard</h1>
    <b-row>
      <b-colxx xl="6" lg="12" class="mb-4">
        <overview-breed></overview-breed>
      </b-colxx>
      <b-colxx xl="6" lg="12" class="mb-4">
        <create-breed></create-breed>
      </b-colxx>
    </b-row>
  </div>

</template>

<script>
  import OverviewBreed from "../../crudl/breed/OverviewBreed";
  import CreateBreed from "../../crudl/breed/CreateBreed";

  export default {
    name: "DashboardBreed",
    components: {
      CreateBreed,
      OverviewBreed
    }
  }
</script>

<style scoped>

</style>
