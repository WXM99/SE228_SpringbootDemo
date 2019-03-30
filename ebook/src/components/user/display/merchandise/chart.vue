<template>
  <div>
    <MenuItem name="1-4" >
      <Icon type="md-cart" />
      <span  @click="showCart">购物车</span>
    </MenuItem>
<Drawer :closable="false" width="640" v-model="value4" style="z-index: 999">
  <p style="font-size: 50px">购物车 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;book × {{this.books.length}}</p>
  <div class="demo-drawer-profile">
  </div>
  <Divider />
  <div v-if="this.sum === 0" style="margin-bottom: 50px;">
    <img src="../../../../assets/empty.png" style="width: 100%">
    <div style="text-align: center; font-size: 30px; margin-top: -200px; color: #aaaaaa">空空如也, 快去选购吧!</div>
  </div>
  <Row v-for="bk in books" :key="bk.ISBN">
    <Row>
      <Col span="6">
        <img :src="bk.pic" style="width: 100%; box-shadow: 0px 0px 10px #888" class="cart-book">
      </Col>
      <Col span="16" offset="1">
        <h1>《{{bk.name}}》</h1>
        <h1> &nbsp;&nbsp;单价: {{bk.price}}.00¥</h1>
        <h1> &nbsp;&nbsp;ISBN: {{bk.ISBN}}</h1>
        <h1> &nbsp;&nbsp;数量: × {{bk.ammount}}</h1>
        <h1> &nbsp;&nbsp;总价: {{bk.price*bk.ammount}}.00¥</h1>
        <Button type="primary" class="cart-btn" @click="addbook(bk)">增加</Button>
        <Button class="cart-btn" @click="reducebook(bk)">减少</Button>
        <Button class="cart-btn" @click="removebook(bk)">移除</Button>
      </Col>
    </Row>
    <Divider />
  </Row>
  <h1>总价: </h1><h1 style="font-size: 50px; font-weight: lighter">{{this.sum}}.00¥</h1>
  <Button style="margin-bottom: 5px; font-size: 20px;" type="primary" @click="giveCode">确认付款</Button>
  <Button style="margin-bottom: 5px; font-size: 20px;" @click="clear">清 空</Button>
  <Modal
    title="打开支付宝扫一扫"
    v-model="modal"
    @on-ok="finish"
    class-name="vertical-center-modal">
    <img src="../../../../assets/QRcode.png" style="width: 100%">
  </Modal>
</Drawer>
  </div>
</template>
<script>
import store from '../../../../main'
export default {
  data () {
    return {
      value4: false,
      modal: false,
      pStyle: {
        fontSize: '16px',
        color: 'rgba(0,0,0,0.85)',
        lineHeight: '24px',
        display: 'block',
        marginBottom: '16px'
      },
      books: store.state.book_in_cart.books,
      sum: store.state.book_in_cart.sum
    }
  },
  mounted () {
    this.updateSum()
    this.sum = store.state.book_in_cart.sum
  },
  component: {
    store
  },
  methods: {
    addbook: function (book) {
      store.commit('addBook', book)
      this.updateSum()
      this.sum = store.state.book_in_cart.sum
    },
    reducebook: function (book) {
      store.commit('reduceBook', book)
      this.updateSum()
      this.sum = store.state.book_in_cart.sum
    },
    removebook: function (book) {
      store.commit('removeBook', book)
      this.updateSum()
      this.sum = store.state.book_in_cart.sum
    },
    clear: function () {
      store.commit('clearUp', 0)
      this.sum = 0
      this.books = []
    },
    updateSum: function () {
      store.commit('update', 0)
      this.books = store.state.book_in_cart.books
      this.sum = store.state.book_in_cart.sum
    },
    showCart: function () {
      this.value4 = true
      this.updateSum()
    },
    giveCode: function () {
      if (this.sum > 0) {
        this.modal = true
      } else {
        this.$Notice.info({
          title: '购物车为空!',
          desc: '请您先选购后再进行购买.'
        })
      }
    },
    finish: function () {
      if (this.sum > 0) {
        this.$Notice.success({
          title: '购物成功!',
          desc: '您的支付宝账户已经扣款' + this.sum + '元.'
        })
        this.clear()
      } else {
        this.$Notice.info({
          title: '购物车为空!',
          desc: '请您先选购后再进行购买.'
        })
      }
    }
  }
}
</script>
<style>
.cart-btn{
  width: 20%!important;
  margin-left: 15px!important;
  font-size: 20px!important;
  padding: 2px!important;
}
.ivu-modal-header-inner{
  text-align: center;
  font-size: 20px;
}
</style>
