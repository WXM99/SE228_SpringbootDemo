<template>
  <div>
  <Row>
    <Col span="5" offset="0" v-for="book in this.books" :key="book.id" style="margin-bottom: 30px; margin-left: 3%">
      <Card>
        <p slot="title" style="margin-top: 5px">{{book.name}}</p>
        <img :src="book.pic" style="width: 100%; height: 22vw" @click="viewBook(book.id)"/>
        <p>{{book.prop}}</p>
      </Card>
    </Col>
  </Row>
  </div>
</template>
<script>
export default {
  props: {
    books: {
      type: Array,
      default: () => []
    }
  },
  methods: {
    viewBook (id) {
      console.log(id)
      const { href } = this.$router.resolve({
        name: 'book',
        params: {
          id: id
        }
      })
      window.open(href)
    }
  }
}
</script>
<style>
  .ivu-card-body{
    padding: 0px;
  }
  .ivu-card-head{
    padding: 0px;
  }
</style>
