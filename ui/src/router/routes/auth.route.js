import Index from "../../views/auth/Index.vue";
import Login from "../../views/auth/Login.vue";
import Logout from "../../views/auth/Logout.vue";

export default [
    {
        path: '/auth',
        component: Index,
        children: [
            {
                name: 'login',
                path: '',
                component: Login,
            },
            {
                name: 'logout',
                path: '',
                component: Logout,
            },
        ]
    }
]
