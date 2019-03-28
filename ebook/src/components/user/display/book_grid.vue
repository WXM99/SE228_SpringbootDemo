<template>
  <div>
  <Row>
    <Col span="5" offset="0" v-for="book in this.books" :key="book.id" style="margin-bottom: 30px; margin-left: 3%">
      <Card>
        <img :src="book.pic" style="width: 100%; height: 23vw" @click="viewBook(book.id)"/>
        <Row>
        <p style="font-size: 16px; font-weight: bold" @click="changeColor($event)">{{book.name}}</p>
        <p>{{book.prop}}</p>
        </Row>
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
      this.$router.push({
        name: 'book',
        params: {
          id: id
        }
      })
      // window.open(href)
    },
    changeColor (event) {
      if (event.target.style.color === 'rgb(216, 74, 45)') {
        event.target.style.color = '#000'
      } else {
        event.target.style.color = 'rgb(216, 74, 45)'
      }
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
