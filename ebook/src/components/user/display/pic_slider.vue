<template>
  <Carousel autoplay v-model="value2" loop :height="300">
    <CarouselItem>
      <div class="demo-carousel">
        <img class='slider-pic' :src='this.pics[0]'/>123</div>
    </CarouselItem>
    <CarouselItem>
      <div class="demo-carousel">
        <img class='slider-pic' :src='this.pics[1]'/></div>
    </CarouselItem>
    <CarouselItem>
      <div class="demo-carousel">
        <img class='slider-pic' :src='this.pics[2]'/></div>
    </CarouselItem>
    <CarouselItem>
      <div class="demo-carousel">
        <img class='slider-pic' :src='this.pics[3]'/></div>
    </CarouselItem>
  </Carousel>
</template>
<script>
export default {
  data () {
    return {
      value2: 0,
      pics: [
        'https://img3.doubanio.com/view/subject/l/public/s29935015.jpg',
        'https://img1.doubanio.com/view/subject/l/public/s30019177.jpg',
        'https://img3.doubanio.com/view/subject/l/public/s29984241.jpg',
        'https://img3.doubanio.com/view/subject/l/public/s29992106.jpg'
      ]
    }
  }
}
</script>
<style>
.slider-pic{
  width: 100%;
}
</style>
