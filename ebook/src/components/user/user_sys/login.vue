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
      v-model="modal1"
      title="提示">
      <h1 style="text-align: center">您的账号已被管理员禁止!</h1>
    </Modal>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  components: {
  },
  mounted () {
    this.$axios({
      method: 'post',
      url: '/login',
      data: this.formInline,
      withCredentials: true
    }).then(response => {
      console.log('API: /login/submit/\n', response)
    })
  },
  comments: {
    axios
  },
  data () {
    return {
      modal1: false,
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
      this.$refs[name].validate((valid) => {
        if (valid) {
          console.log(this.formInline.user)
          if (this.formInline.user === 'forbidden') {
            this.modal1 = true
          } else if (this.formInline.user === 'admin') {
            this.$router.push({path: '/admin'})
          } else {
            this.$router.push({path: '/'})
          }
        } else {
          this.$Message.error('请完善信息!')
        }
      })
    }
  }
}
</script>
