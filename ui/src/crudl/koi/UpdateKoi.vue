<template>
    <b-form
        @submit="onSubmit"
        @reset="onReset">

        <b-form-group
            id="name"
            label="Name"
            label-for="Name">
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
            label-for="Description">
            <b-form-textarea
                id="description"
                v-model="form.description"
                type="text"
                required
                placeholder="Enter description"
            ></b-form-textarea>
        </b-form-group>

        <b-form-group
            id="gender"
            label="Gender"
            label-for="Gender">
            <b-form-radio-group
                v-model="form.sex"
                :options="genders"
                class="mb-3"
                value-field="item"
                text-field="name"
                disabled-field="notEnabled"
            >
            </b-form-radio-group>
        </b-form-group>

        <b-form-group
            id="birth"
            label="Birth"
            label-for="Birth">
            <b-form-datepicker id="birth" v-model="form.birth" class="mb-2">
            </b-form-datepicker>
        </b-form-group>

        <b-form-group
            id="subbreed"
            label="Subbreed"
            label-for="Subbreed">
            <b-form-select v-model="form.subBreed" class="mb-3 form-control">
                <template v-slot:first>
                    <b-form-select-option :value="null" disabled>-- Please select an option --</b-form-select-option>
                </template>
                <b-form-select-option-group v-for="(breed, index) in breeds" :label="breed.name">
                    <option
                        :class="subBreed.links.self.href == form.subBreed ? 'selected' : ''"
                        v-for="(subBreed, index) in breed.subBreeds"
                        :value="subBreed.links.self.href"
                    >
                        <span v-if="subBreed.links.self.href == form.subBreed">(selected) -</span>
                        {{subBreed.name}}
                    </option>
                </b-form-select-option-group>

            </b-form-select>
        </b-form-group>

        <b-form-group
            id="pond"
            label="Pond"
            label-for="Pond">
            <b-form-select v-model="form.pond" class="mb-3 form-control">
                <template v-slot:first>
                    <b-form-select-option :value="null" disabled>-- Please select an option --</b-form-select-option>
                </template>
                <option
                    :class="pond.links.self.href == form.pond ? 'selected' : ''"
                    v-for="(pond, index) in ponds"
                    :value="pond.links.self.href"
                >
                    <span v-if="pond.links.self.href == form.pond">(selected) -</span>
                    {{pond.name}}
                </option>
            </b-form-select>
        </b-form-group>


        <b-button type="submit" variant="primary">Submit</b-button>
        <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
</template>

<script>
    import ApiService from "../../services/api.service";
    export default {
        name: "UpdateKoi",
        props: ['ponds', 'breeds', 'item'],
        data() {
            return {
                genders: [
                    { item: 'male', name: 'male' },
                    { item: 'female', name: 'female'}
                ],
                subBreed: '',
                Pond: '',
                form: {
                    name: '',
                    description: '',
                    pond: '',
                    subBreed: '',
                    birth: new Date(),
                    sex: ''
                }
            }
        },
        methods: {
            onSubmit(evt) {
                evt.preventDefault()
                let self = this.item.links.self.href
                let payload = [self, this.form]
                console.log("Koi Module - updating data", payload)
                this.$store.dispatch("updateKoi", payload)
                    .then(() => {
                        this.addNotification('success filled', `${this.form.name} successfully updated`, 'notification')
                        this.onReset()
                        this.$emit('reloadMode')
                    })
            },
            onReset(evt) {
                this.form.name = ''
                this.form.description = ''
                this.form.pond = ''
                this.form.birth = new Date()
                this.form.sex = ''
                this.form.subBreed = ''
                this.$emit('createMode')
                this.addNotification('warning filled', `Reset Form`, 'notification')
            },
            setVals(item){
                this.form.name = item.name
                this.form.description = item.description
                this.form.sex = item.sex
                this.form.birth = item.birth

                console.log(item.links.subBreed.href)
                ApiService.query(item.links.subBreed.href).then(({ data }) => {
                    this.form.subBreed = data.links.self.href
                })
                ApiService.query(item.links.pond.href.split('{')[0]).then(({ data }) => {
                    this.form.pond = data.links.self.href
                })
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
