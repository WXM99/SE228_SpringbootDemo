<template>
  <div style="margin-top: 80px">
    <p class="search-title">用户管理</p>
    <Row align="middle" style="margin-top: 20px">
      <Col span="12" offset="6"><Input search enter-button placeholder="用户搜索" style="border-color:  #acc6aa"/></Col>
    </Row>
    <!--<Divider orientation="left" class="prop">关键字: {{keyword}}</Divider>-->
    <Card style="padding: 10px; margin: 30px" >
      <user-table :data_in="books_rec"></user-table>
      <Page :total="100" style="margin-top: 10px"/>
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
  },
  mounted () {
  },
  data () {
    return {
      books_rec: [
        {
          name: 'userI',
          state: 0,
          email: 'sample1@xx.com',
          id: 1
        },
        {
          name: 'userII',
          state: 0,
          email: 'sample2@xx.com',
          id: 2
        },
        {
          name: 'userIII',
          state: 1,
          email: 'sample3@xx.com',
          id: 3
        },
        {
          name: 'userIV',
          state: 0,
          email: 'sample4@xx.com',
          id: 4
        },
        {
          name: 'userV',
          state: 0,
          email: 'sample5@xx.com',
          id: 5
        },
        {
          name: 'userVI',
          state: 0,
          email: 'sample6@xx.com',
          id: 6
        },
        {
          name: 'userVII',
          state: 0,
          email: 'sample7@xx.com',
          id: 7
        },
        {
          name: 'userIIX',
          state: 1,
          email: 'sample8@xx.com',
          id: 8
        },
        {
          name: 'userIX',
          state: 0,
          email: 'sample9@xx.com',
          id: 9
        }
      ],
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
