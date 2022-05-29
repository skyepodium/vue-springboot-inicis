import VueRouter from 'vue-router'
import vue from 'vue'

vue.use(VueRouter)

import Main from '@/views/Main.vue'

const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/',
            component: Main,
            name: 'Main'
        }  
    ]
})

export { router }