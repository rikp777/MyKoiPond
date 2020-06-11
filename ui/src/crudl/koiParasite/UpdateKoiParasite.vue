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
            <b-form-textarea
                id="description"
                v-model="form.description"
                type="text"
                required
                placeholder="Enter description"
            ></b-form-textarea>
        </b-form-group>


        <b-button type="submit" variant="primary" size="xs">Submit</b-button>
        <b-button type="reset" variant="danger" size="xs">Reset</b-button>
    </b-form>
</template>

<script>
    export default {
        name: "UpdateKoiParasite",
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
                let self = this.item.links.self.href
                let payload = [self, this.form]
                console.log("Pond Module - updating data", payload)
                this.$store.dispatch("updatePond", payload)
                    .then(() => {
                        this.addNotification('success filled', `${this.form.name} successfully updated`, 'notification')
                        this.onReset()
                        this.$emit('reloadMode')
                    })
            },
            onReset(evt) {
                this.form.name = ''
                this.form.description = ''
                this.$emit('createMode')
                this.addNotification('warning filled', `Reset Form`, 'notification')
            },
            setVals(item){
                this.form.name = item.name
                this.form.description = item.description
            },
            addNotification(type, title, message){
                this.$notify(type, title, message, { duration: 3000, permanent: false })
            }
        },
        mounted() {
            this.setVals(this.item)
            this.addNotification('success filled', `${this.item.name} successfully loaded`, 'notification')
        },
        watch: {
            item: function(newVal, oldVal) { // watch it
                this.setVals(newVal)
                this.addNotification('success filled', `${oldVal.name} replaced with ${this.item.name} successfully loaded`, 'notification')
            }
        }
    }
</script>

<style scoped>

</style>
