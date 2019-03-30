<template>
  <div style="margin-top: 80px">
    <p class="search-title">图书检索</p>
    <Row align="middle" style="margin-top: 20px">
      <Col span="12" offset="6"><Input @on-search="search" search enter-button placeholder="图书搜索" style="border-color:  #acc6aa" v-model="keyword"/></Col>
    </Row>
    <!--<Divider orientation="left" class="prop">关键字: {{keyword}}</Divider>-->
    <Card style="padding: 10px; margin: 30px" >
      <p v-if="keyword_last !== '-'" style="text-align: center; font-size: 20px; font-weight: bolder">关键字: {{keyword_last}}</p>
    <book-table :data_in="books_rec"></book-table>
      <Page :total="100" style="margin-top: 10px"/>
    </Card>
  </div>
</template>
<script>
import grid from '../book_grid'
import bookTable from '../book_table'
export default {
  components: {
    grid,
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
          pic: require('../../../../assets/book1.jpg'),
          prop: '探索内心的宁静',
          ISBN: 9787559604057,
          price: 1
        },
        {
          name: 'The Night Ocean',
          pic: require('../../../../assets/book2.jpg'),
          prop: '迷失在夜的深海...',
          ISBN: 9787559604017,
          price: 2
        },
        {
          name: 'Obsessed',
          pic: require('../../../../assets/book3.jpg'),
          prop: '花花世界, 情迷意乱.',
          ISBN: 9787559632127,
          price: 3
        },
        {
          name: 'MUSKULATUREN',
          pic: require('../../../../assets/book4.jpg'),
          prop: 'MUSKULATUREN',
          ISBN: 9787559604051,
          price: 4
        },
        {
          name: 'Surface Breaks',
          pic: require('../../../../assets/book5.jpg'),
          prop: '打破面具后的沉默',
          ISBN: 9787559604123,
          price: 5
        },
        {
          name: 'The Transcriptionist',
          pic: require('../../../../assets/book6.jpg'),
          prop: '思想中的变与静',
          ISBN: 9787559604012,
          price: 6
        },
        {
          name: 'Mothers Stories',
          pic: require('../../../../assets/book7.jpg'),
          prop: '听妈妈讲过去的故事...',
          ISBN: 9787559605442,
          price: 7
        },
        {
          name: 'Embodied Hope',
          pic: require('../../../../assets/book8.jpg'),
          prop: '让希望与肉身共存',
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
</style>
