<template>
  <div style="margin-top: 20px">
    <Row align="middle">
      <Col span="20" offset="2"><Input search enter-button placeholder="图书搜索"/></Col>
    </Row>
    <Divider orientation="left" class="prop">本季新书</Divider>
    <Row>
      <Col span="20" offset="2"><slider></slider></Col>
    </Row>
    <Divider orientation="left" class="prop">为你推荐</Divider>
    <Row>
      <grid :books="this.books_rec"></grid>
    </Row>
    <Divider orientation="left" class="prop">大众品味</Divider>
    <Row>
      <grid :books="this.books_rec"></grid>
    </Row>
    <Divider orientation="left" class="prop">甄门别类</Divider>
    <Row>
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
  data () {
    return {
      books_rec: [
        {
          name: '白鹿原',
          pic: 'https://img3.doubanio.com/view/subject/l/public/s29935015.jpg',
          prop: '名族史诗巨著',
          id: 1
        },
        {
          name: '白鹿原',
          pic: 'https://img1.doubanio.com/view/subject/l/public/s30019177.jpg',
          prop: '名族史诗巨著',
          id: 12
        },
        {
          name: '白鹿原',
          pic: 'https://img3.doubanio.com/view/subject/l/public/s29984241.jpg',
          prop: '名族史诗巨著',
          id: 123
        },
        {
          name: '白鹿原',
          pic: 'https://img3.doubanio.com/view/subject/l/public/s29992106.jpg',
          prop: '名族史诗巨著',
          id: 1231
        },
        {
          name: '白鹿原',
          pic: 'https://img3.doubanio.com/view/subject/l/public/s29935015.jpg',
          prop: '名族史诗巨著',
          id: 12312
        },
        {
          name: '白鹿原',
          pic: 'https://img1.doubanio.com/view/subject/l/public/s30019177.jpg',
          prop: '名族史诗巨著',
          id: 123123
        },
        {
          name: '白鹿原',
          pic: 'https://img3.doubanio.com/view/subject/l/public/s29984241.jpg',
          prop: '名族史诗巨著',
          id: 1231231
        },
        {
          name: '白鹿原',
          pic: 'https://img3.doubanio.com/view/subject/l/public/s29992106.jpg',
          prop: '名族史诗巨著',
          id: 12312312
        }
      ]
    }
  }
}
</script>
<style>
  .ivu-divider-inner-text{
    font-weight: lighter;
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
