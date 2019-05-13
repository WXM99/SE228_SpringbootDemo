<style scoped>
  .layout{
    /*border: 1px solid #d7dde4;*/
    background: #f5f7f9;
    position: relative;
    /*border-radius: 4px;*/
    overflow: hidden;
  }
  .layout-logo{
    width: 100px;
    height: 30px;
    background: #5b6270;
    border-radius: 3px;
    float: left;
    position: relative;
    top: 15px;
    left: 20px;
  }
  .layout-nav{
    width: 520px;
    margin: 0 auto;
    margin-right: 20px;
  }
  .layout-footer-center{
    text-align: center;
  }
  .ebk-logo{
    background: url("../../assets/ebook-logo.svg");
    height: 55px;
    width: 55px;
    float: left;
  }
  .ebk-logo:hover{
    transform: scale(1.1);
  }
  .ad-bg{
  }
  .ivu-menu-item{
    margin-top: 0px;
  }
</style>
<template>
  <div class="layout ad-bg">
    <Layout>
      <Header style="z-index: 99">
        <Menu mode="horizontal" theme="dark" active-name="1">
          <router-link to="/admin">
            <div class="layout-logo" style="background: rgba(255,255,255,0); margin-top: -10px; width: 300px;">
              <img class="ebk-logo"><p style="font-size: 30px; font-weight: lighter; color: #fff;">Ebook<span style="font-weight: bolder">管理系统</span></p>
            </div>
          </router-link>
          <div class="layout-nav" style="width: 800px;">
            <router-link to="/admin/book">
              <MenuItem name="1-2">
                <Icon type="ios-book" />
                <span>图书管理</span>
              </MenuItem>
            </router-link>
            <router-link to="/admin/user">
              <MenuItem name="1-3">
                <Icon type="ios-contact" />
                <span>用户管理</span>
              </MenuItem>
            </router-link>
            <router-link  to="/admin/order">
              <MenuItem name="1-5">
                <Icon type="md-reorder" />
                <span>订单管理</span>
              </MenuItem>
            </router-link>
            <router-link  to="/admin/data">
              <MenuItem name="1-5">
                <Icon type="ios-cube" />
                <span>信息统计</span>
              </MenuItem>
            </router-link>
            <el-switch
              style="float: right; margin-right: -55px; margin-top: 20px;"
              v-model="isDark"
              @change="changeTheme"
              active-text="夜间"
              inactive-text="日间">
            </el-switch>
            <Tooltip placement="bottom" theme="light">
              <Avatar src="https://i.loli.net/2017/08/21/599a521472424.jpg" style="margin-left: -20px"/>
              <div slot="content">
                <Row><p style="text-align: center; font-size: 25px;" class="user-info">欢迎你! 管理员</p></Row>
                <router-link to="/user/login">
                  <Button style="margin-bottom: 5px; font-size: 20px; width: 100%">退出登录</Button>
                </router-link>
              </div>
            </Tooltip>
          </div>
        </Menu>
      </Header>
      <Content>
        <router-view></router-view>
      </Content>
      <Footer class="layout-footer-center" style="float: bottom">2019 &copy; Wei Xiao-Miao SE218</Footer>
    </Layout>
  </div>
</template>
<script>
export default {
  data () {
    return {
      isDark: false
    }
  },
  methods: {
    changeTheme () {
      console.log(this.isDark)
      let css = document.querySelector('#css-table')
      if (this.isDark) {
        css.setAttribute('href', './static/dark_theme.css')
      } else {
        css.setAttribute('href', './static/light_theme.css')
      }
    }
  },
  components: {
  }
}
</script>
