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
    background: rgba(174, 212, 162, 0.5);
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
          width: '150px',
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
                          id: params.row.ISBN
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
                      src: params.row.pic
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
          width: '350px',
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
              params.row.name)
            ]
          }
        },
        {
          title: 'Price',
          width: '150px',
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
              params.row.price + ('.00¥'))]
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
            }, params.row.name)
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
            }, params.row.prop)
          }
        },
        {
          title: 'ISBN',
          width: '150px',
          key: 'ISBN',
          sortable: true,
          render: (h, params) => {
            return h('div', {
              style: {
                fontSize: '18px'
              }
            }, params.row.ISBN)
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
  }
}
</script>
