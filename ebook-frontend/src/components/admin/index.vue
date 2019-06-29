<template>
  <div style="margin-top: 80px; padding: 20px; height: 100%">
    <Row align="middle" type="flex" justify="center" style="height: 20%">
    <h1 class="ad-title">欢迎使用Ebook图书交易网站管理系统</h1>
    </Row>
    <Row align="middle" type="flex" justify="center" style="margin-bottom: 20px; margin-top: 20px;">
      <Col span="12"><div class="md-wrapper">
        <router-link to="/admin/book">
        <Card class="ad-card">
          图书管理<br>
          <Icon type="ios-book" size="130" />
        </Card>
        </router-link>
      </div></Col>
      <Col span="12"><div class="md-wrapper">
        <router-link to="/admin/user">
        <Card class="ad-card">用户管理<br>
          <Icon type="ios-contact" size="130" />
        </Card>
        </router-link>
      </div></Col>
    </Row>
    <Row align="middle" type="flex" justify="center" style="margin-bottom: 20px; margin-top: 20px;">
      <Col span="12"><div class="md-wrapper">
        <router-link to="/admin/order">
        <Card class="ad-card">
          图书销量<br>
          <Icon type="md-reorder" size="130" />
        </Card>
        </router-link>
      </div></Col>
      <Col span="12"><div class="md-wrapper">
        <router-link to="/admin/data">
        <Card class="ad-card">用户消费<br>
          <Icon type="ios-cube" size="130" />
        </Card>
        </router-link>
      </div></Col>
    </Row>
  </div>
</template>
<style scoped>
  .ad-card{
    font-size: 50px;
    width: 100%;
    color: #fff;
    height: 250px;
    border: 0px;
  }
  .ad-card:hover{
    transform: scale(1.05);
  }
  .ad-title{
    font-size: 50px;
    margin-top: auto;
    margin-bottom: auto;
  }
  .md-wrapper{
    overflow: hidden;
    width: 100%;
    padding: 0px 10px;
  }
</style>
