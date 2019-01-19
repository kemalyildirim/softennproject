<template>
  <div>
    <div class="container">
      <div class="row col-10 col-md-10 form-group search-box mx-auto">
        <input type="text" v-model="search" class="form-control form-control-lg" placeholder="Search by brand">
      </div>

      <div class="row">
        <h6 v-if="cars.length == 0" style="background-color: aqua" class="media media-custom mx-auto col-9 col-md-9 rounded shadow-lg">Nothing found.</h6>
        <div v-for="car in filteredList" class="media media-custom mx-auto col-9 col-md-9 rounded shadow-lg">
          <div class="media-body media-space">
            <div class="row">
              <div class="col-4 col-md-4">
                <img class="mr-3 mx-auto shadow-lg custom-img-size" :src="require('@/assets/img'+car.car_image)">
              </div>
              <div class="col-4 col-md-4">
                <h2 class="mx-auto">{{car.car_brand}} - {{car.car_model}}</h2>
              </div>
              <div class="col-4 col-md-4">
                <div class="row">
                  <h5 class="mx-auto" v-if="diffDays <= 1">Price for {{diffDays}} day</h5>
                  <h5 class="mx-auto"v-else >Price for {{diffDays}} days</h5>
                </div>
                <div class="row">
                  <h2 class="mx-auto">{{car.car_daily_price * diffDays}} ₺</h2>
                </div>
                <div class="row">
                  <button
                    v-model="selectedCar"
                    @click="onClick(car.id)"
                    class="btn btn-outline-dark btn-lg mx-auto shadow-lg"
                  >More Details</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import axios from 'axios'
export default {
  data() {
    return {
      branchID: this.$route.params.branchID,
      fromDate: this.$route.params.fromDate,
      fromTime: this.$route.params.fromTime,
      toDate: this.$route.params.toDate,
      toTime: this.$route.params.toTime,
      cars: [],
      diffDays: "",
      selectedCar: "",
      search: ""
    };
  },
  methods: {
    onClick(value) {
      console.log("car "+value);
      this.selectedCar = value;
      this.$router.replace('/details/'+this.selectedCar+'/'+this.fromDate+'/'+this.fromTime+'/'+this.toDate+'/'+this.toTime + '/'+ this.diffDays);
    }
  },

  computed: {
    filteredList(){
      return this.cars.filter(car => {
        return car.car_brand.toLowerCase().includes(this.search.toLowerCase())
      })
    }
  },

  mounted() {
    const api_car = "http://localhost:8080/api/car/bybranch/"
    axios
      .get(api_car + this.branchID).then((response) => {this.cars = response.data; console.log(response.data)})
    var date1 = new Date(this.fromDate);
    var date2 = new Date(this.toDate);
    var timeDiff = Math.abs(date2.getTime() - date1.getTime());
    this.diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
    if (this.diffDays <= 0) {
      this.diffDays = 1;
    }
    console.log("selected dates = " + this.diffDays);
  }
};
</script>

<style>
.html,
body {
  background-color: #34495e !important;
}
.media-custom {
  background-color: #ecf0f1;
  padding: 3%;
  margin-top: 3%;
  margin-bottom: 3%;
}
.custom-img-size {
  height: 100%;
  width: 100%;
}
.search-box {
  margin-top: 3%;
}
</style>
