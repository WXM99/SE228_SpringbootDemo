<template>
  <div style="margin-top: 80px">
    <!--<Divider orientation="left" class="time">关键字: {{keyword}}</Divider>-->
    <Card style="padding: 10px; margin: 30px" >
      <Row align="middle" type="flex" justify="center">
        <Col span="8">
          <Tooltip>
            <img src="https://i.loli.net/2017/08/21/599a521472424.jpg"
                 class="avator-big">
            <div slot="content" style="font-size: 50px;">Username</div>
          </Tooltip>
        </Col>
        <Col span="16">
          <h1 style="font-size: 50px;text-align: left">个人信息</h1>
          <h1 style="font-size: 30px;text-align: left">用户名: Username</h1>
          <h1 style="font-size: 30px;text-align: left">邮箱: sample@sample.com</h1>
          <h1 style="font-size: 30px;text-align: left">最近收藏:</h1>
          <Row align="middle" type="flex" justify="center" >
            <Col v-for="book in book_collect"
                 :key="book.ISBN"
                 span="4">
              <Card style="width: 95%;"
                    class="book-collect">
                <img :src="book.pic" style="width: 100%" @click="viewBook(book.ISBN)">
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
import bookTable from '../history_table'
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
      console.log(timespan)
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
      time_span: null,
      books_rec: [
        {
          name: 'Yukio Mishima',
          pic: require('../../../../assets/book1.jpg'),
          time: '2019/02/03',
          ISBN: 9787559604057,
          price: 1
        },
        {
          name: 'The Night Ocean',
          pic: require('../../../../assets/book2.jpg'),
          time: '2019/01/06',
          ISBN: 9787559604017,
          price: 2
        },
        {
          name: 'Obsessed',
          pic: require('../../../../assets/book3.jpg'),
          time: '2018/12/03',
          ISBN: 9787559632127,
          price: 3
        },
        {
          name: 'MUSKULATUREN',
          pic: require('../../../../assets/book4.jpg'),
          time: '2019/01/03',
          ISBN: 9787559604051,
          price: 4
        },
        {
          name: 'Surface Breaks',
          pic: require('../../../../assets/book5.jpg'),
          time: '2019/03/22',
          ISBN: 9787559604123,
          price: 5
        },
        {
          name: 'The Transcriptionist',
          pic: require('../../../../assets/book6.jpg'),
          time: '2018/11/11',
          ISBN: 9787559604012,
          price: 6
        },
        {
          name: 'Mothers Stories',
          pic: require('../../../../assets/book7.jpg'),
          time: '2018/12/13',
          ISBN: 9787559605442,
          price: 7
        },
        {
          name: 'Embodied Hope',
          pic: require('../../../../assets/book8.jpg'),
          time: '2019/03/23',
          ISBN: 9787559604023,
          price: 8
        }
      ],
      book_collect: [
        {
          name: 'MUSKULATUREN',
          pic: require('../../../../assets/book4.jpg'),
          time: '2019/02/03',
          ISBN: 9787559604051,
          price: 4
        },
        {
          name: 'Surface Breaks',
          pic: require('../../../../assets/book5.jpg'),
          time: '2019/02/03',
          ISBN: 9787559604123,
          price: 5
        },
        {
          name: 'The Transcriptionist',
          pic: require('../../../../assets/book6.jpg'),
          time: '2019/02/03',
          ISBN: 9787559604012,
          price: 6
        },
        {
          name: 'Mothers Stories',
          pic: require('../../../../assets/book7.jpg'),
          time: '2019/02/03',
          ISBN: 9787559605442,
          price: 7
        },
        {
          name: 'Embodied Hope',
          pic: require('../../../../assets/book8.jpg'),
          time: '2019/02/03',
          ISBN: 9787559604023,
          price: 8
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
</style>
