<template>
  <b-card title="Create Breed">
    <b-form
      @submit="onSubmit"
      @reset="onReset"
      v-if="show">


      <b-form-group
        id="name"
        label="Name"
        label-for="name">
        <b-form-input
          id="name"
          v-model="form.name"
          type="name"
          required
          placeholder="Enter name"
        ></b-form-input>
      </b-form-group>

      <b-form-group
        id="description"
        label="Description"
        label-for="description">
        <b-form-input
          id="description"
          v-model="form.description"
          type="description"
          required
          placeholder="Enter description"
        ></b-form-input>
      </b-form-group>


      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
  </b-card>
</template>

<script>
  export default {
    name: "CreateBreed",
    data() {
      return {
        show: true,
        form: {
          name: '',
          description: ''
        }
      }
    },
    methods: {
      onSubmit(evt){
        evt.preventDefault()
        this.$store.dispatch("createBreed", this.form)
          .then(() => {
            //Action
          })
      },
      onReset(evt) {
        this.form.name = ''
        this.form.description = ''
      }
    }
  }
</script>

<style scoped>

</style>
