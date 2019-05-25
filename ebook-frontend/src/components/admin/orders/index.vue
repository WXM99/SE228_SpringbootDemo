<template>
  <div style="margin-top: 80px">
    <p class="search-title">订单管理</p>
    <Row align="middle" style="margin-top: 20px">
      <Col span="12" offset="6"><Input search enter-button placeholder="输入ISBN" style="border-color:  #acc6aa" v-model="book_name" @on-search="search"/></Col>
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
    search () {
      console.log(this.book_name)
      this.$axios({
        method: 'post',
        url: '/admin/get_book_order',
        data: {
          'isbn': Number(this.book_name)
        },
        withCredentials: true
      }).then(response => {
        console.log('API response\n', response)
        this.books_orders = response.data
      })
    }
  },
  mounted () {
  },
  data () {
    return {
      book_name: '',
      books_orders: []
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
