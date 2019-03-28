import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)
function loadView (view) {
  return () => import(/* webpackChunkName: "view-[request]" */ `../components/${view}.vue`)
}

Vue.use(Router)

export default new Router({
  // ordinary user pages
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
        },
        {
          path: 'search_for/:keyword',
          name: 'search_for',
          component: loadView('user/display/search/search_res')
        },
        {
          path: 'collections',
          name: 'collections',
          component: loadView('user/display/collections/collection')
        },
        {
          path: 'sell',
          name: 'sell',
          component: loadView('user/display/sellers/sell')
        }
      ]
    },
    // user account pages
    {
      path: '/user/register',
      name: 'register',
      component: loadView('user/user_sys/register')
    },
    {
      path: '/user/login',
      name: 'login',
      component: loadView('user/user_sys/login')
    }
  ]
})
