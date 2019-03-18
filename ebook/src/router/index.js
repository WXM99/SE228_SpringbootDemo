import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)
function loadView (view) {
  return () => import(/* webpackChunkName: "view-[request]" */ `../components/${view}.vue`)
}

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: loadView('user/layout'),
      children: [
        {
          path: '',
          name: 'homepage',
          component: loadView('user/display/homepage')
        },
        {
          path: 'market',
          name: 'market',
          component: loadView('user/display/market')
        },
        {
          path: 'book_detail/:id',
          name: 'book',
          component: loadView('user/display/book_detail')
        }
      ]
    },
    {
      path: '/user/register',
      name: 'register',
      component: loadView('user/user_sys/register')
    }
  ]
})
