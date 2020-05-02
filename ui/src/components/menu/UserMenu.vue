<template>
    <div v-if="authUser" class="header-icons d-inline-block align-middle">
        <div class="user d-inline-block">
        <b-dropdown class="dropdown-menu-right" right variant="empty" toggle-class="p-0" menu-class="mt-3" no-caret>
            <template slot="button-content">
                <span class="name mr-1 text-secondary">{{authUser.fullName}}</span>
                <span>
                    <img :alt="authUser.fullName"
                         src="https://www.searchpng.com/wp-content/uploads/2019/02/Men-Profile-Image-715x657.png"/>
                </span>
            </template>
            <b-dropdown-item @click="logout">Sign out</b-dropdown-item>
        </b-dropdown>
    </div>
    </div>
</template>

<script>
    export default {
        props: ['authUser'],
        data() {
            return {
                notifications: {}
            }
        },
        methods: {
            logout() {
                this.$router.push({name: "logout"})
            },


        }
    }
</script>
