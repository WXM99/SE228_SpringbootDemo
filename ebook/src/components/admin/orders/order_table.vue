<style>
  .ivu-table th{
    text-align: center !important;
    font-size: 30px;
  }
  .ivu-table-cell{
    text-align: center !important;
    padding: 0px;
  }
  .ivu-tooltip-inner{
    padding: 5px;
    border-radius: 4px;
  }
</style>
<template>
  <div>
    <Table border :columns="columns" :data="this.data_in">
      <template slot-scope="{ row, index }" slot="state">
        <Button style="font-size: 16px" v-if="row.state === 1" type="primary">已完成</Button>
        <Button style="font-size: 16px" v-else>购物车</Button>
      </template>
      <template slot-scope="{ row, index }" slot="books">
        <Button style="font-size: 16px" type="primary" @click="viewBooks(index)">view books</Button>
      </template>
    </Table>
    <Modal
      v-model="books_show"
      width="1300">
      <div slot="header" style="font-size: 30px; text-align: center">订单记录</div>
      <div>
        <h1 style="text-align: center">订单ID: {{this.order_inspect}}</h1>
        <order-book :data_in="this.books"></order-book>
      </div>
    </Modal>
  </div>
</template>
<script>
import orderBook from '../books/book_in_order'
export default {
  methods: {
    viewBooks (index) {
      let orderid = this.data_in[index].orderID
      this.order_inspect = orderid
      this.$axios({
        method: 'post',
        url: '/api/get_my_books_in_order',
        data: {
          'orderid': orderid
        },
        withCredentials: true
      }).then(response => {
        let items = response.data
        this.books = items
        this.books_show = true
      })
      // this.books_show = true
      // console.log(orderid)
    }
  },
  data () {
    return {
      books_show: false,
      order_inspect: null,
      books: [],
      columns: [
        {
          title: 'orderID',
          key: 'order_id',
          sortable: true,
          render: (h, params) => {
            return [
              h('div', {
                style: {
                  width: '100%',
                  fontSize: '40px'
                }
              },
              params.row.orderID)]
          }
        },
        {
          title: 'buyer',
          padding: '0px',
          key: 'buyer_id',
          sortable: true,
          render: (h, params) => {
            return [
              h('div', {
                style: {
                  width: '100%',
                  fontSize: '40px'
                }
              },
              params.row.buyer.username)]
          },
          align: 'center'
        },
        {
          title: 'tot_price',
          key: 'books',
          sortable: true,
          render: (h, params) => {
            return [
              h('div', {
                style: {
                  width: '100%',
                  fontSize: '30px',
                  fontWeight: 'bolder'
                }
              },
              params.row.tot_price + '¥')
            ]
          }
        },
        {
          title: 'Time',
          key: 'time',
          sortable: true,
          render: (h, params) => {
            return h('div', {
              style: {
                fontSize: '20px'
              }
            }, params.row.finish_at !== null ? params.row.finish_at.substr(0, 10) : '(未完成)')
          }
        },
        {
          title: 'Books',
          width: '120px',
          key: 'orderID',
          slot: 'books',
          align: 'center'
        },
        {
          title: 'State',
          width: '120px',
          key: 'state',
          sortable: true,
          slot: 'state',
          align: 'center'
        }
      ]
    }
  },
  props: {
    data_in: {
      type: Array,
      default: () => []
    }
  },
  components: {
    orderBook
  }
}
</script>
