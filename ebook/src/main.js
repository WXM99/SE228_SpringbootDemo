// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import iView from 'iview'
import 'iview/dist/styles/iview.css'
import Vuex from 'vuex'
import axios from '../node_modules/axios'

Vue.use(iView)
Vue.use(ElementUI)
Vue.use(Vuex)
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'
axios.defaults.withCredentials = true // ajax with coockie
Vue.prototype.$axios = axios
Vue.prototype.$ajax = axios
/* axios base url: change it when dispatch or integrate testing */
axios.defaults.baseURL = 'http://localhost:8080'
/* store in vuex  */
const store = new Vuex.Store({
  state: {
    items: []
  },
  mutations: {
    addBook (state, book) {
      var duplicate = false
      for (var i = 0; i < this.state.book_in_cart.books.length; i++) {
        if (this.state.book_in_cart.books[i].isbn === book.isbn) {
          this.state.book_in_cart.books[i].amount++
          duplicate = true
        }
      }
      if (!duplicate) {
        book.amount = 1
        this.state.book_in_cart.books.push(book)
      }
      // update sum
      var addup = 0
      for (var j = 0; j < this.state.book_in_cart.books.length; j++) {
        addup += this.state.book_in_cart.books[j].price * this.state.book_in_cart.books[j].amount
      }
      this.state.book_in_cart.sum = addup
    },
    reduceBook (state, book) {
      for (var i = 0; i < this.state.book_in_cart.books.length; i++) {
        if (this.state.book_in_cart.books[i].isbn === book.isbn) {
          if (this.state.book_in_cart.books[i].amount > 1) {
            this.state.book_in_cart.books[i].amount--
          } else {
            this.state.book_in_cart.books.splice(i, 1)
          }
          break
        }
      }
      // update sum
      var addup = 0
      for (var j = 0; j < this.state.book_in_cart.books.length; j++) {
        addup += this.state.book_in_cart.books[j].price * this.state.book_in_cart.books[j].amount
      }
      this.state.book_in_cart.sum = addup
    },
    removeBook (state, book) {
      for (var i = 0; i < this.state.book_in_cart.books.length; i++) {
        if (this.state.book_in_cart.books[i].isbn === book.isbn) {
          this.state.book_in_cart.books.splice(i, 1)
          break
        }
      }
      // update sum
      var addup = 0
      for (var j = 0; j < this.state.book_in_cart.books.length; j++) {
        addup += this.state.book_in_cart.books[j].price * this.state.book_in_cart.books[j].amount
      }
      this.state.book_in_cart.sum = addup
    },
    update (state, add) {
      var addup = 0
      for (var j = 0; j < this.state.book_in_cart.books.length; j++) {
        addup += this.state.book_in_cart.books[j].price * this.state.book_in_cart.books[j].amount
      }
      this.state.book_in_cart.sum = addup
      this.state.book_in_cart.sum += add
    },
    clearUp (state, add) {
      this.state.book_in_cart.books = []
      this.state.book_in_cart.sum = add
      console.log(this.state.book_in_cart)
    },
    updateBooks (state, books) {
      this.state.items = books
    }
  }
})
export default store

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  axios,
  components: { App },
  template: '<App/>'
})
