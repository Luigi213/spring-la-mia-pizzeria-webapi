<script>
import axios from "axios";
const URL = "http://localhost:8080/api/v1";

export default{
    data() {
        return {
            pizza: {
                name: "",
                description: "",
                urlPhoto: "",
                price: ""
            }
        };
    },
    methods: {

        createPizza() {
            console.log("pre create", JSON.stringify(this.pizza));

            axios.post(URL+ "/pizzas", this.pizza)
            .then(res => {

                this.$router.push('/');
            })
            .catch(err => console.log(err));
        }
    },
    mounted() {

        console.log("book create mounted");
    }
}
</script>
<template lang="">
    <router-link  to="/">Torna Indietro</router-link>
    <form @submit.prevent="createPizza">
        <div>
            <label for="name">Name</label>
            <input type="text" name="name" id="name" v-model="pizza.name">
        </div>
        <div>
            <label for="description">Description</label>
            <input type="text" name="description"  v-model="pizza.description" id="description">
        </div>
        <div>
            <label for="urlPhoto">urlPhoto</label>
            <input type="text" name="urlPhoto"  v-model="pizza.urlPhoto" id="urlPhoto">
        </div>
        <div>
            <label for="price">Price</label>
            <input type="number" name="price"  v-model="pizza.price" id="price">
        </div>
        <input type="submit" value="CREATE">
    </form>
</template>
<style lang="">
    
</style>