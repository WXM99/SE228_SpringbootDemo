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
  .ivu-table-wrapper{
    overflow: unset;
  }
</style>
<template>
  <Table border :columns="columns" :data="this.data_in"></Table>
</template>
<script>
export default {
  data () {
    return {
      columns: [
        {
          width: '100px',
          padding: '0px',
          title: 'Cover',
          key: 'pic',
          render: (h, params) => {
            return [
              h('Tooltip', {
                props: {
                  placement: 'right'
                }
              }, [
                h('Button', {
                  props: {
                    type: 'primary',
                    size: 'large'
                  },
                  style: {
                    marginRight: '5px',
                    width: '100%',
                    marginTop: '0px',
                    fontSize: '20px'
                  },
                  on: {
                    click: () => {
                      this.$router.push({
                        name: 'book',
                        params: {
                          id: params.row.book.isbn
                        }
                      })
                    }
                  }
                }, 'View'),
                h('div', {
                  slot: 'content'
                }, [
                  h('img', {
                    attrs: {
                      src: params.row.book.cover_path
                    },
                    style: {
                      width: '120px'
                    }
                  })
                ])
              ])
            ]
          }
        },
        {
          title: 'Name',
          key: 'name',
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
              params.row.book.name)
            ]
          }
        },
        {
          title: 'Bought at',
          key: 'price',
          sortable: true,
          render: (h, params) => {
            return [
              h('div', {
                style: {
                  width: '100%',
                  fontSize: '40px'
                }
              },
              params.row.curr_price + ('¥'))]
          }
        },
        {
          title: 'Amount',
          key: 'price',
          sortable: true,
          render: (h, params) => {
            return [
              h('div', {
                style: {
                  width: '100%',
                  fontSize: '40px'
                }
              },
              params.row.amount)]
          }
        },
        {
          title: 'Author',
          key: 'name',
          sortable: true,
          render: (h, params) => {
            return h('div', {
              style: {
                fontSize: '20px'
              }
            }, params.row.book.author)
          }
        },
        {
          title: 'Intro',
          key: 'prop',
          render: (h, params) => {
            return h('div', {
              style: {
                fontSize: '20px'
              }
            }, params.row.book.intro)
          }
        },
        {
          title: 'ISBN',
          key: 'ISBN',
          sortable: true,
          render: (h, params) => {
            return h('div', {
              style: {
                fontSize: '18px'
              }
            }, params.row.book.isbn)
          }
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
  name: 'booksInOrder'
}
</script>
