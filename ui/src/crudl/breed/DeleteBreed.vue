<template>
    <div class="card-body text-center">
        <h5 class="card-title">Sure you want to delete {{item.name}}</h5>
        <p>{{item.description}}</p>
        <b-button
            id="delete"
            class="btn-sm col-2"
            variant="danger"
            @click="deleteItem">
            Delete
        </b-button>
        <b-button
            class="btn-sm col-2"
            variant="primary"
            @click="cancel">
            Cancel
        </b-button>
        <div id="error" v-if="error">{{error}}</div>
    </div>
</template>

<script>
    export default {
        name: "DeleteBreed",
        props: ['item'],
        data() {
            return {
                error: '',
            }
        },
        methods: {
            deleteItem(){
                let self = this.item.links.self.href
                let payload = [self, this.item]
                console.log(payload)
                this.$store.dispatch('deleteBreed', payload)
                    .then(() => {
                        this.error = "success"
                        this.$notify('success filled', `Successfully deleted ${this.item.name}`, '', { duration: 3000, permanent: false })
                            setTimeout(function () {
                        this.$emit('createMode')
                        this.$emit('reloadMode')
                            }, 2000);
                    })
                .catch(() => {
                    this.error = "error"
                })
            },
            cancel(){
                this.$emit('createMode')
            }
        }
    }
</script>

<style scoped>

</style>
