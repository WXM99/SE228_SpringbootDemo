<template>
  <div style="margin: 30px; margin-top: 90px">
    <Card class="detail">
    <Row type="flex" justify="center" align="middle" class="code-row-bg">
      <Col span="8">
        <img :src="this.book_info.pic" class="book-cover">
      </Col>
      <Col span="15" offset="1">
        <Row><h1 class="book-title">{{this.book_info.name}}<p style="float: right">&nbsp;{{this.book_info.price}}.00¥</p></h1></Row>
        <Row class="info-box">
          <p class="info-item">作者: {{this.book_info.author}}</p>
          <p class="info-item">出版社: {{this.book_info.press}}</p>
          <p class="info-item" v-if="this.book_info.ori_name !== null">原名: {{this.book_info.ori_name}}</p>
          <p class="info-item" v-if="this.book_info.translator !== null">译者: {{this.book_info.translator}}</p>
          <p class="info-item">出版时间: {{this.book_info.publish_time}}</p>
          <p class="info-item">ISBN: {{this.book_info.ISBN}}</p>
        </Row>
        <Row><Tag v-for="tag in this.book_info.tags" :key="tag" style="font-size: 16px">{{tag}}</Tag></Row>
        <Row>
          <Col span="12" offset="6"><Button type="primary" style="width: 100%; height: 50px; margin-top: 20px; font-size: 30px; line-height: 30px" @click="buy">加入购物车</Button></Col>
        </Row>
      </Col>
    </Row>
    </Card>

    <Collapse simple>
      <Panel name="1" class="book-title-2">
        内容简介
        <p slot="content" class="book-content"> {{this.book_info.details}} </p>
      </Panel>
      <Panel name="2" class="book-title-2">
        作者简介
        <p slot="content" class="book-content"> {{this.book_info.author_info}} </p>
      </Panel>
      <Panel name="3" class="book-title-2">
        读者鉴
        <div slot="content">
          <div>
            <Card v-for="cm in this.book_info.comments" :key="cm.name">
              <Row>
                <Col span="4"><p style="font-size: 18px">{{cm.name}}</p></Col>
                <Col span="5" offset="15" style="margin-top: -5px"><Rate disabled v-model="cm.scores" /></Col>
              </Row>
              <p>{{cm.content}}</p>
            </Card>
          </div>
        </div>
      </Panel>
    </Collapse>
  </div>
</template>
<script>
import store from '../../../main'
export default {
  methods: {
    buy: function () {
      store.commit('addBook', this.book_info)
      store.commit('update', 0)
      this.$Notice.success({
        title: '《' + this.book_info.name + '》已加入购物车',
        desc: '作者: ' + this.book_info.author + ' 价格: ' + this.book_info.price + '元'
      })
    }
  },
  component: {
    store
  },
  data () {
    return {
      id: this.$route.params.id,
      book_info: {
        name: '摇摆',
        author: '[日]西川美和',
        press: '北京十月文艺出版社',
        ori_name: 'ゆれる',
        translator: '崔健',
        publish_time: '2019-3-1',
        pages: 123,
        price: 45.00,
        ISBN: '9787530218853',
        ammount: 1,
        pic: require('../../../assets/book8.jpg'),
        details: '★是枝裕和、小田切让、香川照之倾力推荐！\n' +
          '\n' +
          '★11项电影大奖导演西川美和成名作\n' +
          '\n' +
          '★现代家庭中的罗生门。一个女人的死让兄弟俩反目成仇，究竟是意外还是谋杀？真相复杂难辨，这个家积攒了30年的怨恨爆发了。\n' +
          '\n' +
          '————————————————————————————————————\n' +
          '\n' +
          '《摇摆》故事简介：早川稔和早川猛两兄弟在一个家里长大，和同一个女人——智惠子有着说不清道不明的关系。哥哥稔像母亲，隐忍温和，留在闭塞的小镇经营加油站，照顾家人；弟弟猛像父亲，坦率火爆，和家人闹翻后去了东京做摄影师，很少回家。\n' +
          '\n' +
          '他们本质上不是一类人，却被同一根血脉捆在一起。他们羡慕对方的世界，又不肯踏出自己的王国半步。他们毫无保留地爱着对方，也不可避免地恨着对方。但他们把情绪掩饰得很好，小心翼翼地维系表面的和平。\n' +
          '\n' +
          '母亲去世一周年，猛回到小镇。两兄弟和智惠子一起郊游，智惠子突然从摇摆的吊桥上坠河身亡。30年来对命运的不甘、对生活的愤懑，还有身为男人不可被挑战的尊严和骄傲，终于要随着智惠子的死浮出水面……\n' +
          '\n' +
          '————————————————————————————————————\n' +
          '\n' +
          '★《摇摆》是现代版家庭中的罗生门，处在案情旋涡中的两兄弟数次推翻先前的证词，让真相越来越模糊，也让人性中真实残酷的部分越来越清晰。\n' +
          '\n' +
          '★在走过那座吊桥前，我们做了30年的兄弟。\n' +
          '\n' +
          '★家，究竟是幸福的起点，还是不幸的根源？\n' +
          '\n' +
          '★《摇摆》具备一部好看小说的多种要素：复杂的恋情、难解的真相、说不透的人性、亲密的人之间的温情与决绝。\n' +
          '\n' +
          '★同名电影由小田切让、香川照之主演，代表日本受邀参加戛纳国际电影节，获蓝丝带奖、日本电影学院奖等11项知名大奖。\n' +
          '\n' +
          '★最近20年，日本电影的多样性不断遭到破坏，我想通过坚持原创来对抗这一现状，而西川美和导演在这一点上做得比我更好。——是枝裕和\n' +
          '\n' +
          '★兄弟仅仅因为血脉相连，就无法逃离彼此的人生。人与人的关系脆弱而危险，但我想在《摇摆》中以兄弟为主题，借助人与人之间难以割舍的东西，寻求人际关系的更多可能。——西川美和\n' +
          '\n' +
          '★读完《摇摆》后我震惊不已，没想到一个年轻女子可以写出这么洞悉兄弟之间繁复心情的作品，西川美和令我肃然起敬。——香川照之\n' +
          '\n' +
          '★起初看到《摇摆》这个故事时，我就特别感兴趣，很想出演。《摇摆》是我跨入而立之年的代表作，我将此前学到的所有，都倾注到了《摇摆》中。——小田切让\n' +
          '\n' +
          '★夫妻或恋人相处不愉快时可以分手，父母有可能早于自己离世，而手足之间的感情永远割舍不断，即便不喜欢也必须连在一起，仔细想想很不可思议。《摇摆》吸引我的就是这一点。——伊坂幸太郎',
        author_info: '西川美和\n' +
          '\n' +
          '1974年生，日本知名导演、编剧、作家。\n' +
          '\n' +
          '她是日本知名导演，是创意不断的编剧，也是一位不可多得的作家。\n' +
          '\n' +
          '她自编自导了多部反映人性残酷与温情的电影，摘得日本影坛多项大奖的桂冠。\n' +
          '\n' +
          '她是是枝裕和惺惺相惜的好友，两人更一同创办电影制作公司，扶植年轻导演。\n' +
          '\n' +
          '她在文学方面亦拥有过人 天赋，作品多次入围“直木奖”“山本周五郎奖”“三岛由纪夫奖”等日本重要文学奖项，得到江国香织、西加奈子等直木奖得主的一致盛赞。\n' +
          '\n' +
          '有媒体称：“同样是讲故事，作家使用文字，导演运用影像，很少有人二者兼擅，而西川美和是个例外。”\n' +
          '\n' +
          '代表作有《摇摆》《永久的托词》等。',
        tags: ['日本', ' 西川美和', '小说', '日本文学', '人性', '摇摆', '2019', '文学日本'],
        comments: [
          {
            name: '白明宇',
            content: '我读了这本书不止一遍。第一次读时，我被人与人之间因自私而产生的无法抹平的隔阂震惊到；第二次读时，我不敢相信人的记忆是这么不靠谱，经常偷偷说谎，模糊真相，直到篡改到对自己最有利的程度，那我过去的人生，有多少是真，有多少是假？第三次读时，暗藏在书中的细节让我细思极恐，才感受到不同视角嵌合起来逐渐拼出真相的美；第四次读时，我终于不争气地流泪了：原来就算人性再自私，命运再残酷，生活再魔幻，跌跌撞撞一路，人最终也只是想回家啊。',
            scores: 5
          },
          {
            name: '心有戚戚',
            content: '喜欢是枝裕和的人，也会喜欢西川美和的。细腻动人。',
            scores: 5
          },
          {
            name: '爱的魔力',
            content: '描述细腻的日本家庭，看似老实的哥哥和"离经叛道"的弟弟，很微妙的关系。',
            scores: 4
          },
          {
            name: 'Spin\'ound',
            content: '具备一部好看小说的多种要素：复杂的恋情、难解的真相、说不透的人性、亲密的人之间的温情与决绝。',
            scores: 5
          }
        ]
      }
    }
  }
}
</script>
<style>
  .book-title{
    font-size: 40px;
    text-align: left;
    font-weight: normal;
    margin-left: 10px;
  }
  .book-title-2{
    font-size: 30px;
    text-align: left;
    font-weight: normal;
    border-bottom: solid #cacaca 1px;
    padding: 10px;
  }
  .book-cover{
    width: 100%;
  }
  .info-box{
    border-left: solid #cacaca 1px;
    text-align: left;
  }
  .info-item{
    margin-left: 10px;
    font-size: 20px;
    line-height: 40px;
  }
  .book-content{
    margin-top: 20px;
    text-align: left;
    white-space: pre-line;
    font-size: 16px;
  }
</style>
