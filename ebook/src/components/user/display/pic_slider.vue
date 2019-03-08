<template>
  <Carousel autoplay v-model="value2" loop :height="300">
    <CarouselItem v-for="pic in this.books" :key="pic.id">
      <div class="demo-carousel">
        <img class='slider-pic' :src="pic.pic" @click="viewBook(pic.id)"/>
      </div>
    </CarouselItem>
  </Carousel>
</template>
<script>
export default {
  data () {
    return {
      value2: 0,
      books: [
        {
          name: '13',
          pic: 'https://img3.doubanio.com/view/subject/l/public/s29935015.jpg',
          id: 1
        },
        {
          name: '13',
          pic: 'https://img1.doubanio.com/view/subject/l/public/s30019177.jpg',
          id: 1
        },
        {
          name: '13',
          pic: 'https://img3.doubanio.com/view/subject/l/public/s29984241.jpg',
          id: 1
        },
        {
          name: '13',
          pic: 'https://img3.doubanio.com/view/subject/l/public/s29992106.jpg',
          id: 1
        }
      ]
    }
  },
  methods: {
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
}
</script>
<style>
.slider-pic{
  width: 100%;
}
</style>
