<template>  
<div class="row" style="margin-bottom: 10px;">    
  <div class="col-sm-12 btn btn-success">    
   How to fetch data from WEB API in Vue.js Application  
  </div>    
</div>   
    <div>  
<table class="table">  
        <thead>  
        <th>Id</th>  
        <th>Korisnicko Ime</th>  
        <th>Ime</th>  
        <th>Prezime</th>  
        <th>Datum Rodjenja</th>  
        <th>Pol</th>
        <th>Uloga</th>  
        </thead>  
        <tbody>  
            <tr v-for="item in korisnici" :key="item.Id">  
               <td>{{item.Id}}</td>  
                <td>{{item.korisnickoIme }}</td>  
                 <td>{{item.ime}}</td>  
                 <td>{{item.prezime}}</td>  
                 <td>{{item.datumRodjenja}}</td>
                 <td>{{item.pol}}</td>   
                 <td>{{item.uloga}}</td>
            </tr>  
        </tbody>  
    </table>  
    </div>  
</template>  
  
<script>  
import TestComponent from "../TestComponent";  
    export default {  
         name: 'Korisnici',  
             data() {  
       return {  
      korisnici: [],  
    };  
  },  
          created()  
        {  
             this.citajkorisnike();  
        },  
      
    methods: {  
        citajkorisnike() {  
      TestComponent.getAll().then(response => {  
      this.korisnici = response.data;  
          console.log(response.data);  
        })  
        .catch(e => {  
          console.log(e);  
        });  
    },  
  
}  
}  
</script>  
  
<style lang="scss" scoped>  
  
</style>   