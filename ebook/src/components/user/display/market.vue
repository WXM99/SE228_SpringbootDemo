<style>
  .ivu-table th{
    text-align: center !important;
    font-size: 30px;
  }
</style>
<template>
  <div style="width: 90%; margin-left:5%; margin-top: 100px">
    <Card style="padding: 20px">
    <Tabs type="card" style="min-height: 700px">
      <TabPane label="计算机">
        <book-table :data_in="data5"></book-table>
        <Page :total="100" style="margin-top: 10px"/>
      </TabPane>
      <TabPane label="中文小说">
        <book-table :data_in="data5"></book-table>
        <Page :total="100" style="margin-top: 10px"/>
      </TabPane>
      <TabPane label="英文小说">
        <book-table :data_in="data5"></book-table>
        <Page :total="100" style="margin-top: 10px"/>
      </TabPane>
    </Tabs>
    </Card>
  </div>
</template>
<script>
import bookTable from './book_table'
export default {
  components: {
    bookTable
  },
  data () {
    return {
      data5: [
        {
          name: 'Yukio Mishima',
          pic: require('../../../assets/book1.jpg'),
          prop: '探索内心的宁静',
          ISBN: 9787559604057,
          price: 1
        },
        {
          name: 'The Night Ocean',
          pic: require('../../../assets/book2.jpg'),
          prop: '迷失在夜的深海...',
          ISBN: 9787559604017,
          price: 2
        },
        {
          name: 'Obsessed',
          pic: require('../../../assets/book3.jpg'),
          prop: '花花世界, 情迷意乱.',
          ISBN: 9787559632127,
          price: 3
        },
        {
          name: 'MUSKULATUREN',
          pic: require('../../../assets/book4.jpg'),
          prop: 'MUSKULATUREN',
          ISBN: 9787559604051,
          price: 4
        },
        {
          name: 'Surface Breaks',
          pic: require('../../../assets/book5.jpg'),
          prop: '打破面具后的沉默',
          ISBN: 9787559604123,
          price: 5
        },
        {
          name: 'The Transcriptionist',
          pic: require('../../../assets/book6.jpg'),
          prop: '思想中的变与静',
          ISBN: 9787559604012,
          price: 6
        },
        {
          name: 'Mothers Stories',
          pic: require('../../../assets/book7.jpg'),
          prop: '听妈妈讲过去的故事...',
          ISBN: 9787559605442,
          price: 7
        },
        {
          name: 'Embodied Hope',
          pic: require('../../../assets/book8.jpg'),
          prop: '让希望与肉身共存',
          ISBN: 9787559604023,
          price: 8
        }
      ]
    }
  }
}
</script>
