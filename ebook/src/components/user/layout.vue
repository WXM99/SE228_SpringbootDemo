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
    box-shadow: 0 1px 2px #2e3347;
  }
  .ivu-layout-sider{
    background: #ffffff;
    box-shadow: 1px 0px 2px #2e3347;
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
          <router-link to="/">
          <MenuItem name="1-0">
            <Icon type="md-home" />
            <span>主页</span>
          </MenuItem>
          </router-link>
          <MenuItem name="1-2">
            <Icon type="md-log-out" />
            <span>出售图书</span>
            </MenuItem>
          <router-link to="market">
          <MenuItem name="1-3">
            <Icon type="md-apps" />
            <span>分类浏览</span>
            </MenuItem>
          </router-link>
          <MenuItem name="1-4">
            <Icon type="md-cart" />
            <span>购物车</span>
          </MenuItem>
          <MenuItem name="1-5">
            <Icon type="md-albums" />
            <span>收藏夹</span>
          </MenuItem>
          <MenuItem name="1-6">
            <Icon type="md-list" />
            <span>交易记录</span>
          </MenuItem>
          <MenuItem name="1-7">
            <Icon type="ios-settings"></Icon>
            <span>个人中心</span>
          </MenuItem>
        </Menu>
      </Sider>
      <Layout>
        <Header :style="{padding: 0}" class="layout-header-bar">
          <Row>
            <Col span="2"><Icon @click.native="collapsedSider" :class="rotateIcon" :style="{margin: '0 20px'}" type="md-menu" size="24"></Icon></Col>
            <Col span="20"><h1>ebook 在线图书交易平台</h1></Col>
            <el-switch
              style="float: right; margin-top: -40px; margin-right: 5px"
              v-model="isDark"
              @change="changeTheme"
              active-text="夜间"
              inactive-text="日间">
            </el-switch>
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
      let css = document.querySelector('#css-table')
      if (this.isDark) {
        css.setAttribute('href', './static/dark_theme.css')
      } else {
        css.setAttribute('href', './static/light_theme.css')
      }
    }
  }
}
</script>
