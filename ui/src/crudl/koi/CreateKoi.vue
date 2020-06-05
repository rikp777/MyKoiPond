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
            <b-form-group>
                <b-form-radio v-model="form.sex" name="some-radios" value="Male">Male</b-form-radio>
                <b-form-radio v-model="form.sex" name="some-radios" value="Female">Female</b-form-radio>
            </b-form-group>
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
            <b-form-select v-model="form.subbreed" class="mb-3 form-control">
                <template v-slot:first>
                    <b-form-select-option :value="null" disabled>-- Please select an option --</b-form-select-option>
                </template>
                <b-form-select-option-group v-for="(breed, index) in breeds" :label="breed.name">
                    <option
                        v-for="(subBreed, index) in breed.subBreeds"
                        :value="subBreed.links"
                    >
                        {{subBreed.name}}
                    </option>
<!--                    <b-form-select-option-->
<!--                        v-for="(subBreed, index) in breed.subBreeds"-->
<!--                        :key="index"-->
<!--                        :value="subBreed.links.self.href">-->
<!--                        {{subBreed.name}}-->
<!--                    </b-form-select-option>-->
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
                    v-for="(pond, index) in ponds"
                    :key="index"
                    :value="pond.links.self.href">
                    {{pond.name}}
                </option>
            </b-form-select>
        </b-form-group>


        <b-button type="submit" variant="primary">Submit</b-button>
        <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
</template>

<script>
    export default {
        name: "CreateKoi",
        props: ['ponds', 'breeds'],
        data() {
            return {
                show: true,
                form: {
                    name: '',
                    description: '',
                    pond: '',
                    subbreed: '',
                    birth: new Date(),
                    sex: ''
                }
            }
        },
        computed: {

        },
        methods: {
            onSubmit(evt) {
                evt.preventDefault()
                let payload = [this.form]
                console.log("Koi Module - updating data", payload)
                this.$store.dispatch("createKoi", payload)
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
