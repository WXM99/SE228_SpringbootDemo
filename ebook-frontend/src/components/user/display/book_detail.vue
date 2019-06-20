<template>
  <div style="margin:90px auto; margin-top: 90px; width: 1000px;">
    <Card class="detail">
    <Row type="flex" justify="center" align="middle" class="code-row-bg">
      <Col span="8">
        <img :src="this.book_info.cover_path" class="book-cover">
      </Col>
      <Col span="15" offset="1">
        <Row><h1 class="book-title">{{this.book_info.name}}<p style="float: right; margin-right: 100px">&nbsp;{{this.book_info.price}}¥</p></h1></Row>
        <Row class="info-box">
          <p class="info-item">作者: {{this.book_info.author}}</p>
          <!--<p class="info-item">出版社: {{this.book_info.press}}</p>-->
          <p class="info-item" v-if="this.book_info.ori_name !== null">原名: {{this.book_info.ori_name}}</p>
          <p class="info-item" v-if="this.book_info.translator !== null">译者: {{this.book_info.translator}}</p>
          <p class="info-item" v-if="this.book_info.publish_time !== null">出版时间: {{this.book_info.publish_time}}</p>
          <p class="info-item">ISBN: {{this.book_info.ISBN}}</p>
          <p class="info-item">库存: {{this.book_info.inventory}}</p>
          <p class="info-item">简介: {{this.book_info.intro}}</p>
        </Row>
        <Row><Tag v-for="tag in this.book_info.tags" :key="tag" style="font-size: 16px; margin-top: 50px">{{tag}}</Tag></Row>
        <Row>
          <Col span="12" offset="6"><Button type="primary" style="width: 100%; height: 50px; margin-top: 70px; font-size: 30px; line-height: 30px;" @click="buy">加入购物车</Button></Col>
        </Row>
      </Col>
    </Row>
    </Card>

    <Collapse simple>
      <Panel name="1" class="book-title-2">
        内容简介
        <p slot="content" class="book-content"> {{this.book_info.details}} </p>
      </Panel>
      <Panel name="2" class="book-title-2">
        作者简介
        <p slot="content" class="book-content"> {{this.book_info.author_info}} </p>
      </Panel>
      <Panel name="3" class="book-title-2">
        读者鉴
        <div slot="content">
          <div>
            <Button class="comment-box" @click="add_comment">
              添加评论
            </Button>
            <Card v-for="cm in this.book_info.comments" :key="cm.id" style="padding: 20px 50px; margin: 20px auto; border: 1px solid #eeeeee;">
              <Row>
                <Button type="primary" style="float: right; font-size: 16px; width: 90px">回复</Button>
                <p style="font-size: 30px; color: #aaaaaa">{{cm.username}}</p>
              </Row>
              <p style="color: #bbbbbb;  margin-top: 10px; float: right">{{cm.time.substr(0, 10)}}</p>
              <p style="text-align: left; margin-top: 10px; margin-bottom: 20px; font-size: 16px">{{cm.content}}</p>
              <Card v-for="rp in cm.floors" :key="rp.time">
                <a style="float: right; margin-bottom: 20px; color: #aaaaaa">回复</a>
                <p style="font-size: 16px; text-align: left; color: #aaaaaa">
                  <span style="color: #abc4ab;">@{{rp.from}}</span> 回复了
                  <span style="color: #abc4ab;">@{{rp.to_whom}}</span>:
                </p>
                <p style="text-align: right; float: right">{{rp.time.substr(0, 10)}}</p>
                <p style="color: #849984; text-align: left" >{{rp.content}}</p>
              </Card>
            </Card>
          </div>
        </div>
      </Panel>
    </Collapse>
    <Modal v-model="this.new_cm_model"
           title="添加评论">
      为《{{this.book_info.name}}》添加评论
    </Modal>
  </div>
</template>
<script>
import store from '../../../main'
export default {
  methods: {
    buy: function () {
      this.$axios({
        method: 'post',
        url: '/api/add_to_cart',
        data: {
          'isbn': Number(this.book_info.ISBN)
        },
        withCredentials: true
      }).then(response => {
        console.log('ADDED: \n', response)
        this.$Notice.success({
          title: '《' + this.book_info.name + '》已加入购物车',
          desc: '作者: ' + this.book_info.author + ' 价格: ' + this.book_info.price + '元'
        })
      })
    },
    add_comment: function () {
      this.new_cm_model = true
    }
  },
  component: {
    store
  },
  mounted () {
    this.$axios({
      method: 'post',
      url: '/api/find_whole_book',
      data: {
        'isbn': Number(this.$route.params.id)
      },
      withCredentials: true
    }).then(response => {
      console.log('response\n', response)
      if (response.data.bookInfoBrief.state === 1) {
        this.book_info.author = response.data.bookInfoBrief.author
        this.book_info.cover_path = response.data.bookInfoBrief.cover_path
        this.book_info.intro = response.data.bookInfoBrief.intro
        this.book_info.inventory = response.data.bookInfoBrief.inventory
        this.book_info.name = response.data.bookInfoBrief.name
        this.book_info.price = response.data.bookInfoBrief.price
        // details
        if (response.data.bookDetails !== null) {
          this.book_info.tags = response.data.bookDetails.tags
          this.book_info.press = response.data.bookDetails.press
          this.book_info.publish_time = response.data.bookDetails.publish_time
          this.book_info.author_info = response.data.bookDetails.author_intro
          this.book_info.details = response.data.bookDetails.introduction
        }
        // comments
        if (response.data.comments !== null) {
          this.book_info.comments = response.data.comments
        }
      } else {
        this.$Notice.error({
          title: '404错误',
          desc: this.$route.params.id + '不是已收录的图书ISBN。'
        })
        this.$router.push({path: '/'})
      }
    })
  },
  data () {
    return {
      id: this.$route.params.id,
      book_info: {
        name: '',
        author: '',
        price: 0,
        ISBN: this.$route.params.id,
        inventory: 0,
        ori_name: null,
        press: null,
        intro: '',
        cover_path: null,
        translator: null,
        publish_time: null,
        details: null,
        author_info: null,
        tags: null,
        comments: null
      },
      new_cm_model: false,
      reply_model: false
    }
  }
}
</script>
<style>
  .book-title{
    font-size: 40px;
    text-align: left;
    font-weight: normal;
    margin-left: 10px;
  }
  .book-title-2{
    font-size: 30px;
    text-align: left;
    font-weight: normal;
    border-bottom: solid #cacaca 1px;
    padding: 10px;
  }
  .book-cover{
    width: 80%;
  }
  .info-box{
    border-left: solid #cacaca 1px;
    text-align: left;
  }
  .info-item{
    margin-left: 10px;
    font-size: 20px;
    line-height: 40px;
  }
  .book-content{
    margin-top: 20px;
    text-align: left;
    white-space: pre-line;
    font-size: 16px;
    padding: 0 50px;
  }
  .ivu-collapse-content-box{
    padding: 0 50px;
  }
  .comment-box{
    width: 100%;
    padding: 10px 50px;
    margin: 10px auto;
    border: 1px solid #eeeeee;
    text-align: center;
    font-size: 30px;
    color: #abc4ab
  }
  .comment-box:hover{
    background: linear-gradient(to right, #acc6aa, #71a0a5) !important;
    color: #ffffff;
  }
</style>
