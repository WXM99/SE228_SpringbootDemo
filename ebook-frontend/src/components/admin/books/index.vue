<template>
  <div style="margin-top: 80px">
    <p class="search-title">图书管理</p>
    <Row align="middle" style="margin-top: 20px">
      <Col span="12" offset="4">
        <Input search enter-button placeholder="图书搜索" style="border-color:  #acc6aa" v-model="keyword" @on-search="search"/></Col>
      <Col span="4">
        <!--<router-link to="/admin/new_book">-->
        <Button type="primary" style="width: 90%; font-size: 24px" @click="ad_modal = true">新增图书</Button>
        <!--</router-link>-->
      </Col>
    </Row>
    <!--<Divider orientation="left" class="prop">关键字: {{keyword}}</Divider>-->
    <Card style="padding: 10px; margin: 30px" >
      <book-table :data_in="this.books_rec"></book-table>
      <Page :total="10" style="margin-top: 10px"/>
    </Card>
    <Modal
      v-model="ad_modal"
      title="新增图书"
      @on-ok="addBook">
      <div style="font-size: 30px; text-align: center">
        <Row align="middle" type="flex" >
          <Col span="3" style="font-size: 12px;">Cover</Col>
          <Col offset="6">
            <el-upload
              action="http://localhost:8080/img_upload"
              list-type="picture-card"
              :on-success="handleSuccess"
              :on-preview="handlePictureCardPreview"
              :limit="1"
              :multiple='false'
              :on-remove="handleRemove">
              <i class="el-icon-plus" v-if="add_book.cover_path === ''"></i>
            </el-upload>
          </Col>
        </Row>
        <Form :model="add_book" label-position="right" :label-width="100" style="margin-left: -40px">
          <FormItem label="Name">
            <Input v-model="add_book.name"></Input>
          </FormItem>
          <FormItem label="Author">
            <Input v-model="add_book.author"></Input>
          </FormItem>
          <FormItem label="Price">
            <Input v-model="add_book.price"></Input>
          </FormItem>
          <FormItem label="ISBN">
            <Input v-model="add_book.isbn"></Input>
          </FormItem>
          <FormItem label="Intro">
            <Input v-model="add_book.intro"></Input>
          </FormItem>
          <FormItem label="Inventory">
            <Input v-model="add_book.inventory"></Input>
          </FormItem>
        </Form>
      </div>
    </Modal>
    <el-dialog :visible.sync="dialogVisible">
      <img width="100%" :src="this.add_book.pic" alt="">
    </el-dialog>
  </div>
</template>
<script>
import bookTable from './manage_book_table'
export default {
  components: {
    bookTable
  },
  methods: {
    search: function () {
      this.keyword_last = this.keyword
      console.log(this.keyword)
      this.$axios({
        method: 'post',
        url: '/api/search_book',
        data: {
          'keyword': this.keyword
        },
        withCredentials: true
      }).then(response => {
        console.log('API response\n', response)
        this.books_rec = response.data
      })
    },
    addBook: function () {
      var newBook = this.add_book
      this.$axios({
        method: 'post',
        url: '/admin/add_book',
        data: {
          'isbn': newBook.isbn,
          'name': newBook.name,
          'price': Number(newBook.price),
          'inventory': Number(newBook.inventory),
          'author': newBook.author,
          'cover_path': newBook.cover_path,
          'intro': newBook.intro
        },
        withCredentials: true
      }).then(response => {
        console.log('API response\n', response)
        if (response.data.state === 303) {
          this.$Notice.error({
            title: '添加失败!',
            desc: newBook.isbn + '已经存在了.'
          })
        } else {
          this.books_rec.push(newBook)
          for (var i = this.books_rec.length - 1; i > 0; i--) {
            this.books_rec[i] = this.books_rec[i - 1]
          }
          this.books_rec[0] = newBook
          this.$Notice.success({
            title: '添加成功!',
            desc: '已经添加了《' + newBook.name + '》.'
          })
          this.add_book = {
            name: '',
            price: 0.0,
            author: '',
            pic: '',
            prop: '',
            ISBN: 0,
            inventory: 0
          }
        }
      })
    },
    handleSuccess (res, file) {
      // this.add_book.pic = file.url
      console.log(res.path)
      // console.log(file)
      this.add_book.cover_path = 'http://localhost:8080/' + res.path
      // document.querySelector('.el-upload.el-upload--picture-card').style = 'display: none'
    },
    handleRemove () {
      this.add_book.cover_path = ''
      // document.querySelector('el-upload.el-upload--picture-card').style = 'display: normal'
    },
    handlePictureCardPreview (file) {
      this.add_book.pic = file.url
      console.log(this.add_book.pic)
      this.dialogVisible = true
    }
  },
  mounted () {
    this.$axios({
      method: 'post',
      url: '/api/find_book_with_page',
      data: {
        'offset': 0,
        'limit': 8
      },
      withCredentials: true
    }).then(response => {
      console.log('API response\n', response)
      this.books_rec = response.data
    })
  },
  data () {
    return {
      empty: [],
      keyword: '',
      keyword_last: '',
      books_rec: [{
        name: 'null',
        price: null,
        inventory: null,
        author: null,
        intro: null,
        isbn: null,
        cover_path: null
      }],
      add_book: {
        name: '',
        price: 0,
        author: '',
        cover_path: '',
        intro: '',
        isbn: '',
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
  .ivu-table-wrapper{
    overflow: unset;
  }
</style>
