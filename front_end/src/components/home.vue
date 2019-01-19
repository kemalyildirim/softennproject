<template>
  <div class="container">
    <div class="row">
      <div class="card col-8 col-md-8 rounded mx-auto card-space card-bg shadow-lg">
        <form>
          <div class="form-group">
            <label for="branch-select">Pick up location</label>
            <select v-model="selectedBranch" id="branch-selext" class="form-control shadow-lg rounded">
              <option v-for="item in branches" v-bind:value="item.id">{{item.city.city_name + " - " + item.branch_name}}</option>
            </select>
          </div>

          <div class="row">
            <div class="col-6 col-md-6 form-group">
              <label >From Date</label>
              <datetime auto v-model="selectedFromDate" :min-datetime="now" type="date" placeholder="click to select date"></datetime>
            </div>

            <div class="col-6 col-md-6 form-group">
              <label >From Time</label>
              <datetime auto v-model="selectedFromTime" type="time" placeholder="click of select time"></datetime>
            </div>

          </div>
          <div class="row">
            <div class="col-6 col-md-6 form-group">
              <label>To Date</label>
              <datetime auto v-model="selectedToDate" :min-datetime ="now" type="date" placeholder="click to select date"></datetime>
            </div>

            <div class="col-6 col-md-6 form-group">
              <label>To Time</label>
              <datetime auto v-model="selectedToTime" type="time" placeholder="click of select time"></datetime>
            </div>
          </div>

          <div class="form-group">
            <router-link
              tag="button"
              class="btn btn-outline-dark btn-lg btn col-12 col-md-12 shadow-lg"
              v-bind:to="'/list/'+selectedBranch+'/'+selectedFromDate+'/'+selectedFromTime+'/'+selectedToDate+'/'+selectedToTime"
            >Find Cars</router-link>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
//import moment from 'moment' ;del vue-moment
export default {
  data() {
    return {
      branches: [],
      selectedBranch: "",
      selectedFromDate: "",
      selectedFromTime: "",
      selectedToDate: "",
      selectedToTime: "",
      now: ""
    };
  },
  mounted(){
    const api = "http://localhost:8080/api/branch"
    axios
      .get(api).then((response) => {this.branches = response.data ;console.log(response.data)})
/*
    var now = moment()
    this.now = now.format('YYYY-MM-DD')
    console.log("now  "+ now.day())*/
    var day = new Date().getDate() + 1;
    var month = new Date().getMonth() + 1;
    var year = new Date().getFullYear();
    if (day < 10) {
      day = "0" + day;
    }
    if (month < 10) {
      month = "0" + month;
    }
    this.now = year + "-" + month + "-" + day;
    console.log(this.now);
  }
}
</script>

<style>
.html,
body {
  background-color: #34495e !important;
}
.card-space {
  margin-top: 5%;
  padding: 3%;
}
.card-bg {
  background-color: #ecf0f1;
}
</style>
