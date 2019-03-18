<template>
  <Carousel autoplay v-model="value2" loop :height="500">
    <CarouselItem v-for="pic in this.books" :key="pic.id">
      <div class="demo-carousel">
        <div>
          <img :src="pic.pic" class="slider-pic"/>
          <div class="pic-info">
            <Row>
              <Col span="6"><img :src="pic.pic" class="pic-small" @click="viewBook(pic.id)"></Col>
              <Col span="15" offset="3" style="color: white">
                <div class="pic-wrap">
                  <div style="transform: translate(-150px, 100px)">
                    <Row style="font-size: 50px; font-style: italic;margin-left: 20%">{{pic.name}}</Row>
                    <Rate disabled v-model="pic.rate" style="margin-left: 20%; margin-top: 0px; font-size: 50px"/>
                    <div style="width: 70%; font-size: 22px; margin-top: 30px; margin-left: 25%"> {{pic.prompt}}</div>
                  </div>
                </div>
              </Col>
            </Row>
          </div>
        </div>
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
          name: 'Mother Stories',
          pic: require('../../../assets/book7.jpg'),
          prompt: 'The target property of the Event interface is a reference to the object that dispatched the event. It is different from Event.currentTarget when the event handler is called during the bubbling or capturing phase of the event.',
          id: 1,
          rate: 4.5
        },
        {
          name: 'Embedded Hope',
          pic: require('../../../assets/book8.jpg'),
          prompt: 'The target property of the Event interface is a reference to the object that dispatched the event. It is different from Event.currentTarget when the event handler is called during the bubbling or capturing phase of the event.',
          id: 2,
          rate: 5
        },
        {
          name: 'Transitionist',
          pic: require('../../../assets/book6.jpg'),
          prompt: 'The target property of the Event interface is a reference to the object that dispatched the event. It is different from Event.currentTarget when the event handler is called during the bubbling or capturing phase of the event.',
          id: 3,
          rate: 4
        },
        {
          name: 'Surface Breaks',
          pic: require('../../../assets/book5.jpg'),
          prompt: 'The target property of the Event interface is a reference to the object that dispatched the event. It is different from Event.currentTarget when the event handler is called during the bubbling or capturing phase of the event.',
          id: 4,
          rate: 5
        }
      ]
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
.slider-pic{
  width: 101%;
  height: 1300px;
  filter: blur(20px);
  transform: translate(-3px, -500px);
}
  .pic-info{
    height: 500px;
    transform: translate(-3px, -700px);
    margin-top: -550px;
  }
  .pic-small{
    height: 350px;
    width: 240px;
    border: solid 5px #fff;
    box-shadow: 0px 0px 25px #000;
    transform: translate(100px, 0px);
  }
  .pic-wrap{
    height: 600px;
    width: 100%;
    background: rgba(0, 0, 0, 0.51);
    margin-top: -100px
  }
  .pic-wrap:hover{
    background: rgba(0, 0, 0, 0.76);
  }
</style>
