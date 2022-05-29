import VueRouter from 'vue-router'
import vue from 'vue'

vue.use(VueRouter)

import Main from '@/views/Main.vue'
import PcPay from '@/views/PcPay.vue'
import PayComplete from '@/views/PayComplete.vue'

const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/',
            component: Main,
            name: 'Main'
        },
        {
            path: '/PcPay',
            component: PcPay,
            name: 'PcPay'
        },
        {
            path: '/PayComplete',
            component: PayComplete,
            name: 'PayComplete'
        }        
    ]
})

export { router }