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
  mounted () {
    this.$axios({
      method: 'post',
      url: 'api/get_all_book',
      withCredentials: true
    }).then(response => {
      console.log('API response\n', response)
      this.data5 = response.data
    })
  },
  data () {
    return {
      data5: [
        {
          name: null,
          isbn: null,
          price: null
        }
      ]
    }
  }
}
</script>
