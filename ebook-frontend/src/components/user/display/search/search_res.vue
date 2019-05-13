<template>
  <div style="margin-top: 80px">
    <p class="search-title">图书检索</p>
    <Row align="middle" style="margin-top: 20px">
      <Col span="12" offset="6"><Input @on-search="search" search enter-button placeholder="图书搜索" style="border-color:  #acc6aa" v-model="keyword"/></Col>
    </Row>
    <!--<Divider orientation="left" class="prop">关键字: {{keyword}}</Divider>-->
    <Card style="padding: 10px; margin: 30px" >
      <p v-if="keyword_last !== '-'" style="text-align: center; font-size: 20px; font-weight: bolder">关键字: {{keyword_last}}</p>
    <book-table :data_in="this.books_rec"></book-table>
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
  data () {
    return {
      keyword: this.$route.params.keyword,
      keyword_last: this.$route.params.keyword,
      books_rec: [{
        name: 'null',
        price: null,
        inventory: null,
        author: null,
        intro: null,
        isbn: null,
        cover_path: null
      }]
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
