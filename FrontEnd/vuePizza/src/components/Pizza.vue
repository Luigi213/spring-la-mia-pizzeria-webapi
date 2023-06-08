<script>
import PizzaSingle from './PizzaSingle.vue';
import axios from 'axios';
const URL = "http://localhost:8080/api/v1";

export default {
    components:{
        PizzaSingle
    },
    data() {
        return {
            pizzas: [],
            search: "",
        }
    },
    methods:{
        getPizza() {
            axios.get(URL + "/pizzas")
                .then(res => {
                    
                    const pizzas = res.data;

                    this.pizzas = pizzas;

                })
                .catch(err => console.log(err));
        },
        paroleFiltrate() {
            axios.get(URL + "/pizzas" + "?name=" + this.search)
                .then(res => {
                    
                    const pizzas = res.data;

                    this.pizzas = pizzas;
                    
                })
                .catch(err => console.log(err));
        }
    },
    mounted(){
        this.getPizza()
    }
}
</script>
<template lang="">
    <div>
        <h1>lista di pizze</h1>
        <div>
            <router-link to="/pizzas/create">Pizza create</router-link>
        </div>
        <input type="text" v-model="search" @keyup="paroleFiltrate()">
        <PizzaSingle v-for="pizza in pizzas" :pizza="pizza"/>
    </div>
</template>
<style lang="">
    
</style>