<template>
    <div class="h-100">
        <div id="app-container" :class="getMenuType" v-if="isAuthenticated">
            <top-nav/>
            <sidebar/>
            <main>
                <div class="container-fluid">
                    <router-view/>
                </div>
            </main>
            <footer-component/>
        </div>
        <div v-else>
            <router-view/>
        </div>
    </div>
</template>

<script>
    import Sidebar from './containers/Sidebar'
    import TopNav from './containers/TopNav'
    import Footer from './containers/Footer'
    import {
        mapGetters
    } from 'vuex'

    export default {
        components: {
            'top-nav': TopNav,
            'sidebar': Sidebar,
            'footer-component': Footer
        },
        data() {
            return {}
        },
        computed: {
            ...mapGetters(['getMenuType', 'isAuthenticated'])
        }
    }
</script>
