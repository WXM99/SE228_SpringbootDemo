<template>
  <div style="margin-top: 80px">
    <Divider orientation="left" class="prop">收藏夹</Divider>
    <Row style="max-width: 1200px; margin: 0 auto;">
      <grid :books="this.books_rec"></grid>
    </Row>
    <Page :total="100" style="margin-top: 10px"/>
  </div>
</template>
<script>
import grid from '../book_grid'
export default {
  components: {
    grid
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
      books_rec: [
        {
          name: null,
          isbn: 1
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
  }
</style>
