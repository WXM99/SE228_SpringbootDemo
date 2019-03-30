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

Vue.use(iView)
Vue.use(ElementUI)
Vue.use(Vuex)
/* store in vuex  */
const store = new Vuex.Store({
  state: {
    book_in_cart: {
      books: [
        {
          name: 'Yukio Mishima',
          pic: require('./assets/book1.jpg'),
          prop: '探索内心的宁静',
          ISBN: '9787559604057',
          price: 1,
          ammount: 1
        },
        {
          name: 'The Night Ocean',
          pic: require('./assets/book2.jpg'),
          prop: '迷失在夜的深海...',
          ISBN: '9787559604017',
          price: 2,
          ammount: 1
        },
        {
          name: 'Obsessed',
          pic: require('./assets/book3.jpg'),
          prop: '花花世界, 情迷意乱.',
          ISBN: '9787559632127',
          price: 3,
          ammount: 1
        },
        {
          name: 'MUSKULATUREN',
          pic: require('./assets/book4.jpg'),
          prop: 'MUSKULATUREN',
          ISBN: '9787559604051',
          price: 4,
          ammount: 1
        },
        {
          name: 'Surface Breaks',
          pic: require('./assets/book5.jpg'),
          prop: '打破面具后的沉默',
          ISBN: '9787559604123',
          price: 5,
          ammount: 1
        },
        {
          name: 'The Transcriptionist',
          pic: require('./assets/book6.jpg'),
          prop: '思想中的变与静',
          ISBN: '9787559604012',
          price: 6,
          ammount: 1
        },
        {
          name: 'Mothers Stories',
          pic: require('./assets/book7.jpg'),
          prop: '听妈妈讲过去的故事...',
          ISBN: '9787559605442',
          price: 7,
          ammount: 1
        },
        {
          name: 'Embodied Hope',
          pic: require('./assets/book8.jpg'),
          prop: '让希望与肉身共存',
          ISBN: '9787559604023',
          price: 8,
          ammount: 1
        }],
      sum: 0
    }
  },
  mutations: {
    addBook (state, book) {
      var duplicate = false
      for (var i = 0; i < this.state.book_in_cart.books.length; i++) {
        if (this.state.book_in_cart.books[i].ISBN === book.ISBN) {
          this.state.book_in_cart.books[i].ammount++
          duplicate = true
        }
      }
      if (!duplicate) {
        book.ammount = 1
        this.state.book_in_cart.books.push(book)
      }
      // update sum
      var addup = 0
      for (var j = 0; j < this.state.book_in_cart.books.length; j++) {
        addup += this.state.book_in_cart.books[j].price * this.state.book_in_cart.books[j].ammount
      }
      this.state.book_in_cart.sum = addup
    },
    reduceBook (state, book) {
      for (var i = 0; i < this.state.book_in_cart.books.length; i++) {
        if (this.state.book_in_cart.books[i].ISBN === book.ISBN) {
          if (this.state.book_in_cart.books[i].ammount > 1) {
            this.state.book_in_cart.books[i].ammount--
          } else {
            this.state.book_in_cart.books.splice(i, 1)
          }
          break
        }
      }
      // update sum
      var addup = 0
      for (var j = 0; j < this.state.book_in_cart.books.length; j++) {
        addup += this.state.book_in_cart.books[j].price * this.state.book_in_cart.books[j].ammount
      }
      this.state.book_in_cart.sum = addup
    },
    removeBook (state, book) {
      for (var i = 0; i < this.state.book_in_cart.books.length; i++) {
        if (this.state.book_in_cart.books[i].ISBN === book.ISBN) {
          this.state.book_in_cart.books.splice(i, 1)
          break
        }
      }
      // update sum
      var addup = 0
      for (var j = 0; j < this.state.book_in_cart.books.length; j++) {
        addup += this.state.book_in_cart.books[j].price * this.state.book_in_cart.books[j].ammount
      }
      this.state.book_in_cart.sum = addup
    },
    update (state, add) {
      var addup = 0
      for (var j = 0; j < this.state.book_in_cart.books.length; j++) {
        addup += this.state.book_in_cart.books[j].price * this.state.book_in_cart.books[j].ammount
      }
      this.state.book_in_cart.sum = addup
      this.state.book_in_cart.sum += add
    },
    clearUp (state, add) {
      this.state.book_in_cart.books = []
      this.state.book_in_cart.sum = add
      console.log(this.state.book_in_cart)
    }
  }
})
export default store

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
