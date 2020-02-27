import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from '../views/Main.vue'
import Covid19 from '../views/Covid19.vue'
import Prevention from '../views/Prevention.vue'
import Infection from '../views/Infection.vue'
import News from '../views/News.vue'

Vue.use(VueRouter);

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
        path: '/infection/:lang',
        name: 'infection',
        component: Infection,
        props: true,
        meta: {
            reload: true,
        }
    },
    {
        path: '/news/:lang',
        name: 'news',
        component: News,
        props: true,
        meta: {
            reload: true,
        }
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router