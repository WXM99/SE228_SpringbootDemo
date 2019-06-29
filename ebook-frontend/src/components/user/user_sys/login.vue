login page
<style>
  body{
    background: url("../../../assets/user_bkgd.png");
    background-position: center 10%;
    background-size:cover;
    min-height: 100%;
  }
  .reg-bk{
    width: 100%;
    height: 50vw;
    background: linear-gradient(rgba(29, 38, 49, 0.73), rgba(227, 151, 70, 0));
  }
  .login-card{
    background: rgba(123, 163, 192, 0.82);
    -webkit-backdrop-filter: saturate(180%) blur(20px);
    backdrop-filter: blur(20px);
    border-radius: 30px;
    margin-top: 200px;
    box-shadow: 0px 5px 20px rgba(29, 38, 49, 0.8);
    padding: 20px;
  }
  .ivu-input-group .ivu-input{
    height: 50px;
    font-size: 30px;
  }
</style>
<template>
  <div class="reg-bk">
    <Col span="8" offset="8" class="login-card">
      <h1 style="color: white; font-size: 60px; font-weight: lighter">登 录</h1>
      <router-link to="/user/register">
        <Button style="height: 50px; width: 100px; font-size: 25px; margin-top: 10px">注 册</Button>
      </router-link>
      <Form ref="formInline" :model="formInline" :rules="ruleInline" inline style="margin-top: 10px">
        <Row>
          <FormItem prop="user" style="width: 80%;">
            <Input type="text" v-model="formInline.user" placeholder="Username">
              <Icon type="ios-person-outline" slot="prepend"></Icon>
            </Input>
          </FormItem>
        </Row>
        <Row>
          <FormItem prop="password" style="width: 80%;">
            <Input type="password" v-model="formInline.password" placeholder="Password">
              <Icon type="ios-lock-outline" slot="prepend"></Icon>
            </Input>
          </FormItem>
        </Row>
        <Row>
          <FormItem>
            <Button type="primary" @click="handleSubmit('formInline')" style="height: 50px; width: 100px; font-size: 25px; margin-top: 10px">登录</Button>
          </FormItem>
        </Row>
      </Form>
    </Col>
    <Modal
      v-model="model1"
      title="提示">
      <h1 style="text-align: center">密码错误！</h1>
    </Modal>
    <Modal
      v-model="model2"
      title="提示">
      <h1 style="text-align: center">用户名"{{this.formInline.user}}"不存在，请先注册。</h1>
    </Modal>
    <Modal
      v-model="model3"
      title="提示">
      <h1 style="text-align: center">用户"{{this.formInline.user}}"被管理员禁封，无法登陆！</h1>
    </Modal>
  </div>
</template>
<script>
import axios from 'axios'
import Cookies from 'js-cookie'
export default {
  components: {
  },
  mounted () {
    let isLogin = Cookies.get('login')
    if (isLogin === 'ADMIN') {
      this.$router.push({name: 'ad_index'})
    } else if (isLogin === 'USER') {
      this.$router.push({name: 'homepage'})
    }
  },
  comments: {
    axios
  },
  data () {
    return {
      model1: false,
      model2: false,
      model3: false,
      formInline: {
        user: '',
        password: ''
      },
      ruleInline: {
        user: [
          { required: true, message: 'Please fill in the user name', trigger: 'blur' }
        ],
        password: [
          { required: true, message: 'Please fill in the password.', trigger: 'blur' },
          { type: 'string', min: 1, message: 'The password length cannot be less than 1 bits', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    handleSubmit (name) {
      // console.log(this.formInline)
      this.$refs[name].validate((valid) => {
        if (valid) {
          this.$axios({
            method: 'post',
            url: '/login',
            dataType: 'application/x-www-form-urlencoded',
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded'
            },
            params: {'username': this.formInline.user, 'password': this.formInline.password},
            withCredentials: true
          }).then(response => {
            // console.log('API: /login/submit/\n', response)
            if (response.data.status === 200 && response.data.roles === '[USER]') {
              Cookies.set('login', 'USER', { expires: 1, path: '' })
              Cookies.set('name', response.data.user)
              this.$router.push({path: '/'})
            } else if (response.data.status === 200 && response.data.roles === '[ROLE_ADMIN]') {
              Cookies.set('login', 'ADMIN', { expires: 1, path: '' })
              Cookies.set('name', response.data.user)
              this.$router.push({path: '/admin'})
            } else {
              this.$axios({
                method: 'post',
                url: '/api/find_a_user',
                data: {'username': this.formInline.user},
                withCredentials: true
              }).then(response => {
                console.log('API: /login/submit/\n', response)
                let status = response.data.state
                if (status === 404) {
                  this.model2 = true
                } else if (status === 1) {
                  this.model1 = true
                } else {
                  this.model3 = true
                }
              })
            }
          })
        } else {
          this.$Message.error('请完善信息!')
        }
      })
    }
  }
}
</script>
