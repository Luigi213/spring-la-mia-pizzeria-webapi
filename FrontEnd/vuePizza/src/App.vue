<script>
import { RouterLink, RouterView } from 'vue-router'
import Home from "./views/Home.vue"
export default {
  components:{
    Home
  },
  data() {
    return {
      
    }
  }
}
</script>

<template>
  <header>
    <router-view></router-view>
  </header>
</template>

<style scoped>

</style>
