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
          name: 'Yukio Mishima',
          pic: require('../../../assets/book1.jpg'),
          prop: '探索内心的宁静',
          id: 1
        },
        {
          name: 'The Night Ocean',
          pic: require('../../../assets/book2.jpg'),
          prop: '迷失在夜的深海...',
          id: 2
        },
        {
          name: 'Obsessed',
          pic: require('../../../assets/book3.jpg'),
          prop: '花花世界, 情迷意乱.',
          id: 3
        },
        {
          name: 'MUSKULATUREN',
          pic: require('../../../assets/book4.jpg'),
          prop: 'MUSKULATUREN',
          id: 4
        },
        {
          name: 'Surface Breaks',
          pic: require('../../../assets/book5.jpg'),
          prop: '打破面具后的沉默',
          id: 5
        },
        {
          name: 'The Transcriptionist',
          pic: require('../../../assets/book6.jpg'),
          prop: '思想中的变与静',
          id: 6
        },
        {
          name: 'Mothers Stories',
          pic: require('../../../assets/book7.jpg'),
          prop: '听妈妈讲过去的故事...',
          id: 7
        },
        {
          name: 'Embodied Hope',
          pic: require('../../../assets/book8.jpg'),
          prop: '让希望与肉身共存',
          id: 8
        },
        {
          name: 'Yukio Mishima',
          pic: require('../../../assets/book1.jpg'),
          prop: '探索内心的宁静',
          id: 1
        },
        {
          name: 'The Night Ocean',
          pic: require('../../../assets/book2.jpg'),
          prop: '迷失在夜的深海...',
          id: 2
        },
        {
          name: 'Obsessed',
          pic: require('../../../assets/book3.jpg'),
          prop: '花花世界, 情迷意乱.',
          id: 3
        },
        {
          name: 'MUSKULATUREN',
          pic: require('../../../assets/book4.jpg'),
          prop: 'MUSKULATUREN',
          id: 4
        },
        {
          name: 'Surface Breaks',
          pic: require('../../../assets/book5.jpg'),
          prop: '打破面具后的沉默',
          id: 5
        },
        {
          name: 'The Transcriptionist',
          pic: require('../../../assets/book6.jpg'),
          prop: '思想中的变与静',
          id: 6
        },
        {
          name: 'Mothers Stories',
          pic: require('../../../assets/book7.jpg'),
          prop: '听妈妈讲过去的故事...',
          id: 7
        },
        {
          name: 'Embodied Hope',
          pic: require('../../../assets/book8.jpg'),
          prop: '让希望与肉身共存',
          id: 8
        },
        {
          name: 'Yukio Mishima',
          pic: require('../../../assets/book1.jpg'),
          prop: '探索内心的宁静',
          id: 1
        },
        {
          name: 'The Night Ocean',
          pic: require('../../../assets/book2.jpg'),
          prop: '迷失在夜的深海...',
          id: 2
        },
        {
          name: 'Obsessed',
          pic: require('../../../assets/book3.jpg'),
          prop: '花花世界, 情迷意乱.',
          id: 3
        },
        {
          name: 'MUSKULATUREN',
          pic: require('../../../assets/book4.jpg'),
          prop: 'MUSKULATUREN',
          id: 4
        },
        {
          name: 'Surface Breaks',
          pic: require('../../../assets/book5.jpg'),
          prop: '打破面具后的沉默',
          id: 5
        },
        {
          name: 'The Transcriptionist',
          pic: require('../../../assets/book6.jpg'),
          prop: '思想中的变与静',
          id: 6
        },
        {
          name: 'Mothers Stories',
          pic: require('../../../assets/book7.jpg'),
          prop: '听妈妈讲过去的故事...',
          id: 7
        },
        {
          name: 'Embodied Hope',
          pic: require('../../../assets/book8.jpg'),
          prop: '让希望与肉身共存',
          id: 8
        }
      ]
    }
  }
}
</script>
