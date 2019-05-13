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
  <Row v-for="bk in books" :key="bk.itemID">
    <Row>
      <Col span="6">
        <img :src="bk.book.cover_path" style="width: 100%; box-shadow: 0px 0px 10px #888" class="cart-book">
      </Col>
      <Col span="16" offset="1">
        <h1>《{{bk.book.name}}》</h1>
        <h1> &nbsp;&nbsp;单价: {{bk.curr_price}}¥</h1>
        <h1> &nbsp;&nbsp;ISBN: {{bk.book.isbn}}</h1>
        <h1> &nbsp;&nbsp;数量: × {{bk.amount}}</h1>
        <h1> &nbsp;&nbsp;总价: {{bk.curr_price*bk.amount}}¥</h1>
        <Button type="primary" class="cart-btn" @click="addbook(bk)">增加</Button>
        <Button class="cart-btn" @click="reducebook(bk)">减少</Button>
        <!--<Button class="cart-btn" @click="removebook(bk)">移除</Button>-->
      </Col>
    </Row>
    <Divider />
  </Row>
  <h1>总价: </h1><h1 style="font-size: 50px; font-weight: lighter">{{this.sum}}¥</h1>
  <Button style="margin-bottom: 5px; font-size: 20px;" type="primary" @click="giveCode">确认付款</Button>
  <Button style="margin-bottom: 5px; font-size: 20px;" @click="clear">清 空</Button>
  <Modal
    title="打开支付宝扫一扫"
    v-model="modal"
    @on-ok="finish"
    class-name="vertical-center-modal">
    <p style="text-align: center; font-size: 25px">付款金额：{{this.sum}}¥</p>
    <img src="../../../../assets/QRcode.png" style="width: 100%">
  </Modal>
</Drawer>
  </div>
</template>
<script>
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
      books: [],
      sum: 0
    }
  },
  mounted () {
    this.updateCart()
  },
  component: {
  },
  methods: {
    addbook: function (book) {
      this.$axios({
        method: 'post',
        url: '/api/add_to_cart',
        data: {
          'isbn': book.book.isbn
        },
        withCredentials: true
      }).then(response => {
        console.log('ADDED: \n', response)
        this.updateCart()
      })
    },
    reducebook: function (book) {
      this.$axios({
        method: 'post',
        url: '/api/remove_from_cart',
        data: {
          'isbn': book.book.isbn
        },
        withCredentials: true
      }).then(response => {
        console.log('REMOVED: \n', response)
        this.updateCart()
      })
    },
    removebook: function (book) {
      // store.commit('removeBook', book)
      // this.updateSum()
      // this.sum = store.state.book_in_cart.sum
    },
    clear: function () {
      this.$axios({
        method: 'get',
        url: '/api/clear_cart',
        withCredentials: true
      }).then(response => {
        console.log('CLEARED: \n', response)
        this.updateCart()
      })
    },
    updateCart: function () {
      this.$axios({
        method: 'get',
        url: '/api/get_cart',
        withCredentials: true
      }).then(response => {
        console.log('CART: \n', response)
        this.books = response.data
        let tot = 0.0
        for (var i = 0; i < this.books.length; i++) {
          tot += this.books[i].curr_price * this.books[i].amount
        }
        this.sum = tot
      })
    },
    showCart: function () {
      this.updateCart()
      this.value4 = true
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
        this.$axios({
          method: 'get',
          url: '/api/ensure_payment',
          withCredentials: true
        }).then(response => {
          console.log('BOUGHT: \n', response)
          if (response.data.itemID === null) {
            this.$Notice.success({
              title: '购物成功!',
              desc: '您的支付宝账户已经扣款' + this.sum + '元.'
            })
          } else {
            let lack = response.data.book
            let inventory = lack.inventory
            let name = lack.name
            this.$Notice.info({
              title: '储存不足！',
              desc: name + ' 仅剩' + inventory + '本，请调整购买数量或联系管理员。'
            })
          }
          this.updateCart()
        })
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
