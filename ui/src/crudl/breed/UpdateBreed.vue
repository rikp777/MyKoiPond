<template>
    <b-form
        @submit="onSubmit"
        @reset="onReset"
    >


        <b-form-group
            id="name"
            label="Name"
            label-for="name">
            <b-form-input
                id="name"
                v-model="form.name"
                type="text"
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
                type="text"
                required
                placeholder="Enter description"
            ></b-form-input>
        </b-form-group>


        <b-button type="submit" variant="primary">Submit</b-button>
        <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
</template>

<script>
    export default {
        name: "UpdateBreed",
        props: ['item'],
        data() {
            return {
                form: {
                    name: '',
                    description: ''
                }
            }
        },
        methods: {
            onSubmit(evt) {
                evt.preventDefault()
                this.$store.dispatch("createBreed", this.form)
                    .then(() => {
                        this.onReset()
                        this.$emit('reloadMode')
                    })
            },
            onReset(evt) {
                this.form.name = ''
                this.form.description = ''
            },
            cancel(){
                this.$emit('reloadMode')
                this.$emit('createMode')
            }
        },
        mounted() {
            this.form = this.item
        },
        watch: {
            item: function(newVal, oldVal) { // watch it
                this.form = newVal
            }
        }
    }
</script>

<style scoped>

</style>
