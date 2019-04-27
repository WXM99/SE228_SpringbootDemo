<template>
  <div style="margin-top: 80px">
    <!--<Divider orientation="left" class="time">关键字: {{keyword}}</Divider>-->
    <Card style="padding: 10px; margin: 30px" >
      <Row align="middle" type="flex" justify="center">
        <Col span="8">
          <Tooltip>
            <img :src="this.myAvatar"
                 class="avator-big">
            <div slot="content" style="font-size: 50px;">{{this.myName}}</div>
          </Tooltip>
        </Col>
        <Col span="16">
          <h1 style="font-size: 50px;text-align: left">个人信息</h1>
          <h1 style="font-size: 30px;text-align: left">用户名: {{this.myName}}</h1>
          <h1 style="font-size: 30px;text-align: left">邮箱: {{this.myEmail}}</h1>
          <h1 style="font-size: 30px;text-align: left">最近收藏:</h1>
          <Row align="middle" type="flex" justify="center" >
            <Col v-for="book in book_collect"
                 :key="book.isbn"
                 span="4">
              <Card style="width: 95%;padding: -5px"
                    class="book-collect">
                <img :src="book.cover_path" style="width: 100%" @click="viewBook(book.isbn)">
              </Card>
            </Col>
            <Col span="4">
              <router-link to="/collections">
              <Card style="width: 95%;" class="book-collect">
                <div style="font-weight: bolder; font-size: 200%; color: #fff; text-align: center">More</div>
              </Card>
              </router-link>
            </Col>
          </Row>
        </Col>
      </Row>
      <Divider></Divider>
      <h1 style="font-size: 50px;">交易历史</h1>
      <span style="font-size: 16px;padding: 20px">选择时间段: </span>
      <DatePicker type="daterange"
                  placement="bottom-end"
                  placeholder="Select date"
                  style="width: 200px; margin-bottom:10px;"
                  @on-change="timeFilter(time_span)"
                  v-model="time_span"></DatePicker>
      <Row>
      <book-table :data_in="books_rec"></book-table>
      </Row>
      <Page :total="100" style="margin-top: 10px"/>
    </Card>
  </div>
</template>
<script>
import grid from '../book_grid'
import bookTable from '../../../admin/orders/order_table'
export default {
  components: {
    grid,
    bookTable
  },
  methods: {
    search: function () {
      this.$router.push({
        name: 'search_for',
        params: {
          keyword: this.keyword
        }
      })
    },
    viewBook (id) {
      console.log(id)
      this.$router.push({
        name: 'book',
        params: {
          id: id
        }
      })
      // window.open(href)
    },
    timeFilter (timespan) {
      console.log(timespan[0])
      console.log(timespan[1])
      if (timespan[0] !== '') {
        this.$axios({
          method: 'post',
          url: '/api/get_orders_by_date',
          data: {
            'from': timespan[0],
            'to': timespan[1]
          },
          withCredentials: true
        }).then(response => {
          console.log('DATE\n', response)
          this.books_rec = response.data
        })
      } else {
        this.$axios({
          method: 'get',
          url: '/api/get_my_orders',
          withCredentials: true
        }).then(response => {
          console.log('API response\n', response)
          this.books_rec = response.data
        })
      }
    }
  },
  mounted () {
    this.$axios({
      method: 'get',
      url: '/api/get_my_orders',
      withCredentials: true
    }).then(response => {
      console.log('API response\n', response)
      this.books_rec = response.data
    })
    this.$axios({
      method: 'get',
      url: '/api/get_my_info',
      withCredentials: true
    }).then(response => {
      console.log('API response\n', response)
      this.myName = response.data.username
      this.myEmail = response.data.email
      if (response.data.avatar_path === 'none') {
        this.myAvatar = 'https://i.loli.net/2017/08/21/599a521472424.jpg'
      } else {
        this.myAvatar = response.data.avatar_path
      }
    })
    this.$axios({
      method: 'post',
      url: '/api/find_book_with_page',
      data: {
        'offset': 0,
        'limit': 5
      },
      withCredentials: true
    }).then(response => {
      this.book_collect = response.data
    })
  },
  data () {
    return {
      myName: null,
      myAvatar: null,
      myEmail: null,
      time_span: null,
      books_rec: [
        {
          buyer: {username: null},
          finish_at: ' '
        }
      ],
      book_collect: [
        {
          cover_path: '',
          isbn: null
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
  .avator-big{
    border-radius: 50%;
    width: 80%;
  }
  .avator-big:hover{
    box-shadow: 0px 0px 10px #4c5846;
  }
  .vertical-center-modal{
    display: flex;
    align-items: center;
    justify-content: center;
    top: 0;
  }
  /*.ivu-card-body{*/
    /*padding: 5px;*/
  /*}*/
</style>
