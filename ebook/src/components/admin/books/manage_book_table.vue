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
    <template slot-scope="{ row, index }" slot="action">
      <Button type="primary" style="font-size: 16px" @click="modify(index)">Modify</Button>
      <Button  style="font-size: 16px" @click="delete_bk(index)">Delete</Button>
    </template>
  </Table>
  <Modal
    v-model="md_modal"
    @on-ok="md_ok">
    <div slot="header" style="font-size: 30px; text-align: center">请修改《{{this.data_in[md_book_idx].name}}》信息</div>
    <div style="text-align: center">
      <Row align="middle" type="flex" >
        <Col span="3" style="font-size: 12px;">Cover</Col>
        <Col offset="6">
          <img :src="this.md_book.pic" style="height: 250px; border: solid 5px #ccc; box-shadow: 0px 0px 5px #ccc; margin-bottom: 20px">
        </Col>
      </Row>
      <Form :model="md_book" label-position="right" :label-width="100" style="margin-left: -40px">
        <FormItem label="Name">
          <Input v-model="md_book.name"></Input>
        </FormItem>
        <FormItem label="Price">
          <Input v-model="md_book.price"></Input>
        </FormItem>
        <FormItem label="ISBN">
          <Input v-model="md_book.ISBN"></Input>
        </FormItem>
        <FormItem label="Intro">
          <Input v-model="md_book.prop"></Input>
        </FormItem>
        <FormItem label="Inventory">
          <Input v-model="md_book.price"></Input>
        </FormItem>
      </Form>
    </div>
  </Modal>
    <Modal
      v-model="de_modal"
      @on-ok="de_ok">
      <div style="font-size: 30px; text-align: center">确定删除《{{this.data_in[this.de_book_idx].name}}》吗?</div>
    </Modal>
  </div>
</template>
<script>
export default {
  data () {
    return {
      dialogVisible: false,
      md_modal: false,
      de_modal: false,
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
          width: '180px',
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
        },
        {
          title: 'Invertory',
          width: '160px',
          key: 'price',
          sortable: true,
          render: (h, params) => {
            return h('div', {
              style: {
                fontSize: '18px'
              }
            }, params.row.price)
          }
        },
        {
          title: 'Action',
          width: '170px',
          padding: '0px',
          key: 'pic',
          slot: 'action',
          align: 'center'
        }
      ],
      md_book_idx: 0,
      de_book_idx: 0,
      md_book: {
        name: '',
        price: 0,
        ISBN: '',
        prop: '',
        pic: ''
      },
      de_book: null
    }
  },
  props: {
    data_in: {
      type: Array,
      default: () => []
    }
  },
  methods: {
    modify: function (index) {
      this.md_modal = true
      this.md_book_idx = index
      this.md_book = this.data_in[index]
    },
    md_ok: function () {
      this.data_in[this.md_book_idx] = this.md_book
      this.$Notice.success({
        title: '修改成功!',
        desc: '已经为《' + this.md_book.name + '》更新了信息.'
      })
      console.log(typeof this.md_book.pic)
    },
    delete_bk: function (index) {
      this.de_modal = true
      this.de_book = this.data_in[index]
      this.de_book_idx = index
    },
    de_ok: function () {
      this.data_in.splice(this.de_book_idx, 1)
      this.$Notice.success({
        title: '删除成功!',
        desc: '已经删除了《' + this.de_book.name + '》.'
      })
    }
  }
}
</script>
