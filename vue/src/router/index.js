import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from '../views/Main.vue'
import Covid19 from '../views/Covid19.vue'
import Prevention from '../views/Prevention.vue'
import Infection from '../views/Infection.vue'
import News from '../views/News.vue'
import NewsList from '../views/NewsList.vue'

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
        path: '/infection',
        name: 'infection',
        component: Infection
    },
    {
        path: '/news/:lang',
        name: 'news',
        component: News,
        props: true,
        children: [
            {
                // /user/:id/profile 과 일치 할 때
                // UserProfile은 User의 <router-view> 내에 렌더링 됩니다.
                path: '',
                component: NewsList
            }
        ]
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router