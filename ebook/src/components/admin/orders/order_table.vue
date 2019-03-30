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
        <Button style="font-size: 16px" v-if="row.state === 0">正常</Button>
        <Button style="font-size: 16px" v-else type="error" ghost>异常</Button>
      </template>
    </Table>
  </div>
</template>
<script>
export default {
  methods: {
  },
  data () {
    return {
      columns: [
        {
          title: 'orderID',
          width: '150px',
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
              params.row.order_id)]
          }
        },
        {
          title: 'buyerID',
          width: '150px',
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
              params.row.buyer_id)]
          },
          align: 'center'
        },
        {
          title: 'bookISBN',
          width: '270px',
          key: 'bookISBN',
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
              params.row.bookISBN)
            ]
          }
        },
        {
          title: 'Time',
          key: 'time',
          width: '150px',
          sortable: true,
          render: (h, params) => {
            return h('div', {
              style: {
                fontSize: '20px'
              }
            }, params.row.time)
          }
        },
        {
          title: 'Ammount',
          key: 'ammount',
          sortable: true,
          render: (h, params) => {
            return h('div', {
              style: {
                fontSize: '20px'
              }
            }, params.row.ammount)
          }
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
  }
}
</script>
