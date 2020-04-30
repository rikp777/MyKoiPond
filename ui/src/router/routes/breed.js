import Index from '../../views/breed/Dashboard'
import List from '../../components/breeds/BreedList.vue'

export default [
    {
        path: '/breed',
        component: Index,
        children: [
            {
                name: 'articleList',
                path: 'overview',
                component: List
            }
        ]
    }
]
