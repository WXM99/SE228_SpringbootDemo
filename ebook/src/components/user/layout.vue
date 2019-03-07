<style scoped>
  .layout{
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
    height: 100%;
    margin-top: -5px;
  }
  .ivu-layout.ivu-layout-has-sider{
    height: 100%;
  }
  .layout-header-bar{
    background: #fff;
    box-shadow: 0 1px 1px rgba(0,0,0,.1);
  }
  .ivu-layout-sider{
    background: #ffffff;
    height: 100%;
  }
  #app > div > div > div.ivu-layout-sider > div.ivu-layout-sider-children > ul{
    height: 100%;
  }
  .layout-logo-left{
    width: 90%;
    height: 30px;
    background: #ffffff;
    border-radius: 3px;
    margin: 15px auto;
  }
  .menu-icon{
    transition: all .3s;
    float: left;
    margin-top: 20px!important;
  }
  .rotate-icon{
    transform: rotate(-90deg);
    float: left;
    margin-top: 20px!important;
  }
  .menu-item span{
    display: inline-block;
    overflow: hidden;
    width: 69px;
    text-overflow: ellipsis;
    white-space: nowrap;
    vertical-align: bottom;
    transition: width .2s ease .2s;
  }
  .ivu-menu-vertical.ivu-menu-light:after{
    display: none;
  }
  .menu-item i{
    transform: translateX(0px);
    transition: font-size .2s ease, transform .2s ease;
    vertical-align: middle;
    font-size: 32px;
  }
  .collapsed-menu span{
    width: 0px;
    transition: width .2s ease;
  }
  .collapsed-menu i{
    transform: translateX(5px);
    transition: font-size .2s ease .2s, transform .2s ease .2s;
    vertical-align: middle;
    font-size: 32px;
    margin-left: -5px;
  }
  .ivu-icon.ivu-icon-ios-person{
    margin-top: 5px;
  }
  .ivu-menu-vertical .ivu-menu-item, .ivu-menu-vertical .ivu-menu-submenu-title{
    padding: 14px 14px;
  }
</style>
<template>
  <div class="layout">
    <Layout>
      <Sider ref="side1" hide-trigger collapsible :collapsed-width="78" v-model="isCollapsed">
        <Menu active-name="1-1" width="auto" :class="menuitemClasses">
          <MenuItem name="1-1">
            <Icon type="ios-person" size="large" />
            <span>Username</span>
          </MenuItem>
          <MenuItem name="1-2">
            <Icon type="ios-search"></Icon>
            <span>出售图书</span>
            </MenuItem>
          <MenuItem name="1-3">
            <Icon type="ios-settings"></Icon>
            <span>分类查找</span>
            </MenuItem>
          <MenuItem name="1-4">
            <Icon type="ios-settings"></Icon>
            <span>购物车</span>
          </MenuItem>
          <MenuItem name="1-5">
            <Icon type="ios-settings"></Icon>
            <span>收藏夹</span>
          </MenuItem>
          <MenuItem name="1-6">
            <Icon type="ios-settings"></Icon>
            <span>交易记录</span>
          </MenuItem>
        </Menu>
      </Sider>
      <Layout>
        <Header :style="{padding: 0}" class="layout-header-bar">
          <Row>
            <Col span="2"><Icon @click.native="collapsedSider" :class="rotateIcon" :style="{margin: '0 20px'}" type="md-menu" size="24"></Icon></Col>
            <Col span="19"><h1>ebook 在线图书交易平台</h1></Col>
            <Col span="3" style="height: 50px">
              <el-switch
                v-model="isDark"
                @change="changeTheme"
                active-text="夜间"
                inactive-text="日间">
              </el-switch>
            </Col>
          </Row>
        </Header>
        <router-view></router-view>
      </Layout>
    </Layout>
  </div>
</template>
<script>
export default {
  data () {
    return {
      isCollapsed: false,
      isDark: false
    }
  },
  mounted: function () {
    let menubk = document.querySelector('#app > div > div')
    menubk.style.backgroundColor = '#ffffff'
  },
  computed: {
    rotateIcon () {
      return [
        'menu-icon',
        this.isCollapsed ? 'rotate-icon' : ''
      ]
    },
    menuitemClasses () {
      return [
        'menu-item',
        this.isCollapsed ? 'collapsed-menu' : ''
      ]
    }
  },
  methods: {
    collapsedSider () {
      this.$refs.side1.toggleCollapse()
    },
    changeTheme () {
      console.log(this.isDark)
      let bkg = document.querySelector('#app > div > div > div.ivu-layout')
      let menubk = document.querySelector('#app > div > div')
      let app = document.querySelector('#app')
      let prop1 = document.querySelector('#app > div > div > div.ivu-layout > div:nth-child(2) > div:nth-child(2) > span')
      let prop2 = document.querySelector('#app > div > div > div.ivu-layout > div:nth-child(2) > div:nth-child(4) > span')
      let prop3 = document.querySelector('#app > div > div > div.ivu-layout > div:nth-child(2) > div:nth-child(6) > span')
      let prop4 = document.querySelector('#app > div > div > div.ivu-layout > div:nth-child(2) > div:nth-child(8) > span')
      let menu = document.querySelector('.ivu-menu')
      let sider = document.querySelector('.ivu-layout-sider')
      let item = document.querySelector('#app > div > div > div.ivu-layout-sider > div.ivu-layout-sider-children > ul')
      let top = document.querySelector('.ivu-layout-header')
      let daytime = document.querySelector('div > div > div.ivu-layout > div.layout-header-bar.ivu-layout-header > div > div.ivu-col.ivu-col-span-3 > div > span.el-switch__label.el-switch__label--left > span')
      if (this.isDark === true) {
        bkg.style.backgroundColor = '#17233d'
        top.style.backgroundColor = '#283d6b'
        app.style.color = '#ffffff'
        prop1.style.color = '#ffffff'
        prop2.style.color = '#ffffff'
        prop3.style.color = '#ffffff'
        prop4.style.color = '#ffffff'
        menu.style.color = '#ffffff'
        daytime.style.color = '#ffffff'
        item.style.backgroundColor = '#464f76'
        menubk.style.backgroundColor = '#464f76'
        sider.style.backgroundColor = '#464f76'
      } else {
        bkg.style.backgroundColor = '#f5f7f9'
        top.style.backgroundColor = '#f5f7f9'
        app.style.color = '#17233d'
        prop1.style.color = '#17233d'
        prop2.style.color = '#17233d'
        prop3.style.color = '#17233d'
        prop4.style.color = '#17233d'
        menu.style.color = '#17233d'
        daytime.style.color = '#464f76'
        item.style.backgroundColor = '#ffffff'
        menubk.style.backgroundColor = '#ffffff'
        sider.style.backgroundColor = '#ffffff'
      }
    }
  }
}
</script>
