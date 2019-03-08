<style>
  .demo-tabs-style2 > .ivu-tabs.ivu-tabs-card > .ivu-tabs-bar .ivu-tabs-tab{
    border-radius: 0;
    background: #fff;
  }
  .demo-tabs-style2 > .ivu-tabs.ivu-tabs-card > .ivu-tabs-bar .ivu-tabs-tab-active{
    border-top: 1px solid #3399ff;
  }
  .demo-tabs-style2 > .ivu-tabs.ivu-tabs-card > .ivu-tabs-bar .ivu-tabs-tab-active:before{
    content: '';
    display: block;
    width: 100%;
    height: 1px;
    background: #3399ff;
    position: absolute;
    top: 0;
    left: 0;
  }
  .ivu-tabs-nav{
    padding-left: 20px;
  }
</style>
<template>
  <Row>
    <Col span="24" class="demo-tabs-style2" style="margin-top: 20px">
      <Tabs type="card">
        <TabPane label="标签一"> <grid :books="this.books_rec"></grid></TabPane>
        <TabPane label="标签二"> <grid :books="this.books_rec"></grid></TabPane>
        <TabPane label="标签三"> <grid :books="this.books_rec"></grid></TabPane>
        <TabPane label="标签一"> <grid :books="this.books_rec"></grid></TabPane>
        <TabPane label="标签二"> <grid :books="this.books_rec"></grid></TabPane>
        <TabPane label="标签三"> <grid :books="this.books_rec"></grid></TabPane>
        <TabPane label="标签一"> <grid :books="this.books_rec"></grid></TabPane>
        <TabPane label="标签二"> <grid :books="this.books_rec"></grid></TabPane>
        <TabPane label="标签三"> <grid :books="this.books_rec"></grid></TabPane>
        <TabPane label="标签一"> <grid :books="this.books_rec"></grid></TabPane>
        <TabPane label="标签二"> <grid :books="this.books_rec"></grid></TabPane>
        <TabPane label="标签三"> <grid :books="this.books_rec"></grid></TabPane>
      </Tabs>
    </Col>
  </Row>
</template>
<script>
import grid from './book_grid'
export default {
  components: {
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
        },
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
