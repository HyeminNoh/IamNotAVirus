import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from '../views/Main.vue'
import Covid19 from '../views/Covid19.vue'
import Prevention from '../views/Prevention.vue'
import Infection from '../views/Infection.vue'
Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'main',
        component: Main
    },
    {
        path: '/covid19',
        name: 'covid19',
        component: Covid19
    },
    {
        path: '/prevention',
        name: 'prevention',
        component: Prevention
    },
    {
        path: '/infection',
        name: 'infection',
        component: Infection
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router