<script>
import axios from 'axios';
const URL = "http://localhost:8080/api/v1";
export default {
    data() {
        return {
            deleted: false
        }
    },
    props:{
        pizza:{}
    },
    methods:{
        deletePizza(id){
            axios.delete(URL + "/pizzas/" + id)
                .then(res => this.deleted = true)
                .catch(err => console.log(err));
        }
    }
}
</script>
<template lang="">
    <li
    v-if="!deleted"
    >
        {{ pizza.name }} - 
        <button @click="deletePizza(pizza.id)">X</button>
    </li>
</template>
<style lang="">
    
</style>