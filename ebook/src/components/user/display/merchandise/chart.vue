<template>
  <div>
    <MenuItem name="1-4" >
      <Icon type="md-cart" />
      <span  @click="value4 = true">购物车</span>
    </MenuItem>
<Drawer :closable="false" width="640" v-model="value4" style="z-index: 999">
  <p style="font-size: 50px">购物车</p>
  <div class="demo-drawer-profile">
  </div>
  <Divider />
  <Divider />
  <Button style="margin-bottom: 5px; font-size: 20px;" type="primary">确认付款</Button>
  <Button style="margin-bottom: 5px; font-size: 20px;">清 空</Button>
</Drawer>
  </div>
</template>
<script>
export default {
  data () {
    return {
      value4: false,
      pStyle: {
        fontSize: '16px',
        color: 'rgba(0,0,0,0.85)',
        lineHeight: '24px',
        display: 'block',
        marginBottom: '16px'
      }
    }
  },
  methods: {
  }
}
</script>
