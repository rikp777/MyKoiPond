<template>
    <b-form
        @submit="onSubmit"
        @reset="onReset">


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
        name: "CreateParasite",
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
            onSubmit(evt) {
                evt.preventDefault()
                let payload = [this.form]
                console.log("Parasite Module - updating data", payload)
                this.$store.dispatch("createParasite", payload)
                    .then(() => {
                        this.addNotification('success filled', `${this.form.name} successfully created`, 'notification')
                        this.onReset()
                        this.$emit('reloadMode')
                    })
            },
            onReset(evt) {
                this.form.name = ''
                this.form.description = ''
                this.addNotification('warning filled', `Reset Form`, 'notification')
            },
            addNotification(type, title, message){
                this.$notify(type, title, message, { duration: 3000, permanent: false })
            }
        }
    }
</script>

<style scoped>

</style>
