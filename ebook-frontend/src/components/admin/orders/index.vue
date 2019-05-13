<template>
  <div style="margin-top: 80px">
    <p class="search-title">订单管理</p>
    <Row align="middle" style="margin-top: 20px">
      <Col span="12" offset="6"><Input search enter-button placeholder="订单搜索" style="border-color:  #acc6aa"/></Col>
    </Row>
    <!--<Divider orientation="left" class="prop">关键字: {{keyword}}</Divider>-->
    <Card style="padding: 10px; margin: 30px" >
      <order-table :data_in="this.books_orders"></order-table>
      <Page :total="100" style="margin-top: 10px"/>
    </Card>
  </div>
</template>
<script>
import orderTable from './order_table'
import orderBook from '../books/book_in_order'
export default {
  components: {
    orderTable,
    orderBook
  },
  methods: {
  },
  mounted () {
  },
  data () {
    return {
      books_orders: [
        {
          order_id: 1,
          state: 0,
          bookISBN: 9891234124321,
          buyer_id: 1,
          ammount: 1,
          time: '2019/02/01'
        },
        {
          order_id: 2,
          state: 0,
          bookISBN: 9891234125131,
          buyer_id: 2,
          ammount: 1,
          time: '2019/03/01'
        },
        {
          order_id: 3,
          state: 0,
          bookISBN: 9891234124321,
          buyer_id: 2,
          ammount: 1,
          time: '2019/03/08'
        },
        {
          order_id: 4,
          state: 0,
          bookISBN: 9891234124321,
          buyer_id: 8,
          ammount: 1,
          time: '2019/03/08'
        },
        {
          order_id: 5,
          state: 0,
          bookISBN: 1291234124321,
          buyer_id: 1,
          ammount: 1,
          time: '2019/03/11'
        },
        {
          order_id: 6,
          state: 0,
          bookISBN: 9842234124321,
          buyer_id: 5,
          ammount: 2,
          time: '2019/03/12'
        },
        {
          order_id: 7,
          state: 0,
          bookISBN: 9891555124321,
          buyer_id: 1,
          ammount: 10,
          time: '2018/11/11'
        },
        {
          order_id: 8,
          state: 0,
          bookISBN: 9891234123451,
          buyer_id: 2,
          ammount: 11,
          time: '2018/11/11'
        },
        {
          order_id: 9,
          state: 0,
          bookISBN: 9891231234321,
          buyer_id: 3,
          ammount: 4,
          time: '2018/12/01'
        },
        {
          order_id: 10,
          state: 0,
          bookISBN: 9891235624321,
          buyer_id: 4,
          ammount: 1,
          time: '2019/02/11'
        }
      ]
    }
  }
}
</script>
<style>
  .ivu-divider-inner-text{
    font-weight: normal;
    font-size: 30px;
  }
  .ivu-input-group .ivu-input{
    height: 50px;
    font-size: 30px;
  }
  .ivu-card-bordered{
    border: 0px;
  }
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
  .el-upload.el-upload--picture-card{
    margin-bottom: 20px;
  }
</style>
