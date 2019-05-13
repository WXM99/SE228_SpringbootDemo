<template>
  <div style="margin-top: 80px">
    <slider style="margin-top: -20px"></slider>
    <Row align="middle" style="margin-top: 20px" class="home-row">
      <Col span="22" offset="1"><Input @on-search="search" search enter-button placeholder="图书搜索" style="border-color:  #acc6aa" v-model="keyword"/></Col>
    </Row>
    <Divider orientation="left" class="prop">为你推荐</Divider>
    <Row class="home-row">
      <grid :books="this.books_rec"></grid>
    </Row>
    <Divider orientation="left" class="prop">大众品味</Divider>
    <Row class="home-row">
      <grid :books="this.books_rec"></grid>
    </Row>
    <Divider orientation="left" class="prop">甄门别类</Divider>
    <Row class="home-row">
      <grid :books="this.books_rec"></grid>
    </Row>
  </div>
</template>
<script>
import slider from './pic_slider'
import grid from './book_grid'
export default {
  components: {
    slider,
    grid
  },
  methods: {
    search: function () {
      this.$router.push({
        name: 'search_for',
        params: {
          keyword: this.keyword
        }
      })
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
      keyword: null,
      books_rec: null
    }
  }
}
</script>
<style scoped>
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
  .home-row{
    max-width: 1200px;
    margin: 0 auto;
  }
</style>
