<template>
  <div style="margin-top: 80px">
    <p class="search-title">用户管理</p>
    <Row align="middle" style="margin-top: 20px">
      <Col span="12" offset="6">
        <Input search enter-button placeholder="用户搜索" style="border-color:  #acc6aa" v-model="keywords" @on-search="search"/></Col>
    </Row>
    <!--<Divider orientation="left" class="prop">关键字: {{keyword}}</Divider>-->
    <Card style="padding: 10px; margin: 30px" >
      <user-table :data_in="users"></user-table>
      <Page :total="10" style="margin-top: 10px"/>
    </Card>
  </div>
</template>
<script>
import userTable from './manage_user_table'
export default {
  components: {
    userTable
  },
  methods: {
    search () {
      this.$axios({
        method: 'post',
        url: '/admin/search_user',
        data: {
          'username': this.keywords
        },
        withCredentials: true
      }).then(response => {
        console.log('API response\n', response)
        this.users = response.data
      })
    }
  },
  mounted () {
    this.$axios({
      method: 'post',
      url: '/admin/get_user_page',
      data: {
        'offset': 0,
        'limit': 999
      },
      withCredentials: true
    }).then(response => {
      console.log('API response\n', response)
      this.users = response.data
    })
  },
  data () {
    return {
      keywords: '',
      users: [],
      add_book: {
        name: '',
        price: 0,
        author: '',
        pic: '',
        prop: '',
        ISBN: '',
        inventory: 0
      },
      ad_modal: false,
      dialogVisible: false
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
