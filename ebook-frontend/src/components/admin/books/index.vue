<template>
  <div style="margin-top: 80px">
    <p class="search-title">图书管理</p>
    <Row align="middle" style="margin-top: 20px">
      <Col span="12" offset="4"><Input search enter-button placeholder="图书搜索" style="border-color:  #acc6aa" v-model="keyword"/></Col>
      <Col span="4">
        <!--<router-link to="/admin/new_book">-->
        <Button type="primary" style="width: 90%; font-size: 24px" @click="ad_modal = true">新增图书</Button>
        <!--</router-link>-->
      </Col>
    </Row>
    <!--<Divider orientation="left" class="prop">关键字: {{keyword}}</Divider>-->
    <Card style="padding: 10px; margin: 30px" >
      <book-table :data_in="books_rec"></book-table>
      <Page :total="100" style="margin-top: 10px"/>
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
              action="https://jsonplaceholder.typicode.com/posts/"
              list-type="picture-card"
              :on-success="handleSuccess"
              :on-preview="handlePictureCardPreview"
              :limit="1"
              :multiple='false'
              :on-remove="handleRemove">
              <i class="el-icon-plus" v-if="add_book.pic === ''"></i>
            </el-upload>
          </Col>
        </Row>
        <Form :model="add_book" label-position="right" :label-width="100" style="margin-left: -40px">
          <FormItem label="Name">
            <Input v-model="add_book.name"></Input>
          </FormItem>
          <FormItem label="Price">
            <Input v-model="add_book.price"></Input>
          </FormItem>
          <FormItem label="ISBN">
            <Input v-model="add_book.ISBN"></Input>
          </FormItem>
          <FormItem label="Intro">
            <Input v-model="add_book.prop"></Input>
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
      this.$router.push({
        name: 'search_for',
        params: {
          keyword: this.keyword
        }
      })
    },
    addBook: function () {
      var newBook = this.add_book
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
        price: 0,
        author: '',
        pic: '',
        prop: '',
        ISBN: 0,
        inventory: 0
      }
    },
    handleSuccess (res, file) {
      this.add_book.pic = file.url
      console.log(this.add_book.pic)
      // document.querySelector('.el-upload.el-upload--picture-card').style = 'display: none'
    },
    handleRemove () {
      this.add_book.pic = ''
      // document.querySelector('el-upload.el-upload--picture-card').style = 'display: normal'
    },
    handlePictureCardPreview (file) {
      this.add_book.pic = file.url
      console.log(this.add_book.pic)
      this.dialogVisible = true
    }
  },
  mounted () {
    if (this.keyword === '-') {
      this.keyword = '请输入关键字'
    }
  },
  data () {
    return {
      keyword: this.$route.params.keyword,
      keyword_last: this.$route.params.keyword,
      books_rec: [
        {
          name: 'Yukio Mishima',
          pic: require('../../../assets/book1.jpg'),
          prop: '探索内心的宁静',
          ISBN: 9787559604057,
          price: 108
        },
        {
          name: 'The Night Ocean',
          pic: require('../../../assets/book2.jpg'),
          prop: '迷失在夜的深海...',
          ISBN: 9787559604017,
          price: 21
        },
        {
          name: 'Obsessed',
          pic: require('../../../assets/book3.jpg'),
          prop: '花花世界, 情迷意乱.',
          ISBN: 9787559632127,
          price: 33
        },
        {
          name: 'MUSKULATUREN',
          pic: require('../../../assets/book4.jpg'),
          prop: 'MUSKULATUREN',
          ISBN: 9787559604051,
          price: 123
        },
        {
          name: 'Surface Breaks',
          pic: require('../../../assets/book5.jpg'),
          prop: '打破面具后的沉默',
          ISBN: 9787559604123,
          price: 51
        },
        {
          name: 'The Transcriptionist',
          pic: require('../../../assets/book6.jpg'),
          prop: '思想中的变与静',
          ISBN: 9787559604012,
          price: 66
        },
        {
          name: 'Mothers Stories',
          pic: require('../../../assets/book7.jpg'),
          prop: '听妈妈讲过去的故事...',
          ISBN: 9787559605442,
          price: 27
        },
        {
          name: 'Embodied Hope',
          pic: require('../../../assets/book8.jpg'),
          prop: '让希望与肉身共存',
          ISBN: 9787559604023,
          price: 84
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
