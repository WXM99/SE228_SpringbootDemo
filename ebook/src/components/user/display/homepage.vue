<template>
  <div style="margin-top: 20px">
    <Row align="middle">
      <Col span="22" offset="1"><Input search enter-button placeholder="图书搜索"/></Col>
    </Row>
    <Divider orientation="left" class="prop">本季新书</Divider>
    <Row>
      <Col span="22" offset="1"><slider></slider></Col>
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
