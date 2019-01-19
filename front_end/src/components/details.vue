<template>
  <div>
    <div class="container">
      <div class="row">
        <div class="card card-bg mx-auto">
          <div class="row">
            <aside class="col-sm-5 border-right">
              <article class="gallery-wrap">
                <div class="img-big-wrap">
                  <div>
                      <img :src="require('@/assets/img'+carInfo.car_image)">
                  </div>
                </div>
              </article>
            </aside>
            <aside class="col-sm-7">
              <article class="card-body p-5">
                <h3 class="title mb-3">{{carInfo.brand}} - {{carInfo.model}}</h3>

                <p class="price-detail-wrap">
                  <span class="price h3 text-warning">
                    <span class="currency">TL ₺</span>
                    <span class="num">{{carInfo.price * diffDays * quantity}}</span>
                  </span>
                  <span>/for {{diffDays}} day(s)</span>
                </p>

                <dl class="item-property">
                  <dt>Features</dt>
                  <dd>
                    <div class="row">
                      <div class="col-6 col-md-6">
                        <li v-if="carInfo.ac">Air Conditioner: Yes</li>
                        <li v-else>Air Conditioner: No</li>
                        <li>Car Class: {{carInfo.carClass}}</li>
                        <li>Number of Doors: {{carInfo.doorsNumber}}</li>
                      </div>
                      <div class="col-6 col-md-6">
                        <li>Fuel: {{carInfo.fuelType}}</li>
                        <li>Gear: {{carInfo.gearType}}</li>
                        <li>Number of Seats: {{carInfo.seatsNumber}}</li>
                      </div>
                    </div>
                  </dd>
                </dl>

                <hr>
                <div class="row">
                  <div class="col-8 col-md-8 mx-auto">
                    <div class="input-group">
                      <div class="input-group-prepend">
                        <button class="btn btn-outline-dark" @click="decrement()" type="button">-</button>
                      </div>
                      <input
                        type="number"
                        class="form-control form-control-lg shadow-lg"
                        min="1"
                        v-bind:max="carInfo.carsNumber"
                        :placeholder="quantity"
                      >
                      <div class="input-group-append">
                        <button class="btn btn-outline-dark" @click="increment()" type="button">+</button>
                      </div>
                    </div>
                  </div>
                </div>

                <hr>
                <div class="row">
                  <button
                    data-toggle="collapse"
                    href="#collapseExample"
                    aria-expanded="false"
                    aria-controls="collapseExample"
                    class="btn btn-dark btn-lg col-12 col-md-12 mx-auto"
                  >Rent Now</button>
                </div>
              </article>
            </aside>
          </div>
          <hr>
          <!-- collapse -->
          <div class="collapse" id="collapseExample">
            <div class="container">
              <div class="row">
                <div class="container py-3">
                  <div class="row">
                    <div class="mx-auto col-9 col-md-9">
                      <!-- form user info -->
                      <div class="card">
                        <div class="card-header">
                          <h4 class="mb-0">User Information</h4>
                        </div>
                        <div class="card-body">
                          <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Name</label>
                            <div class="col-lg-9">
                              <input class="form-control shadow-lg" type="text" v-model="name">
</div>
                          </div>
                          <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Surname</label>
                            <div class="col-lg-9">
                              <input class="form-control shadow-lg" type="text" v-model="surname">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Email</label>
                            <div class="col-lg-9">
                              <input class="form-control shadow-lg" type="email" v-model="email">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">TC Number</label>
                            <div class="col-lg-9">
                              <input
                                class="form-control shadow-lg"
                                type="number"
                                minlength="11"
                                maxlength="11"
                                v-model="tcNumber"
                              >
                            </div>
                          </div>
                          <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Phone Number</label>
                            <div class="col-lg-9">
                              <input
                                class="form-control shadow-lg"
                                type="number"
                                minlength="11"
                                maxlength="11"
                                v-model="phoneNumber"
                              >
                            </div>
                          </div>
                          <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Address</label>
                            <div class="col-lg-9">
                              <textarea
                                class="form-control shadow-lg"
                                type="text"
                                v-model="address"
                              ></textarea>
                            </div>
                          </div>
                          <div class="form-group row">
                            <label
                              class="col-lg-3 col-form-label form-control-label"
                            >Delivey Address</label>
                            <div class="col-lg-9">
                              <textarea
                                class="form-control shadow-lg"
                                type="text"
                                v-model="deliveryAddress"
                              ></textarea>
                            </div>
                          </div>
                          <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Title</label>
                            <div class="col-lg-9">
                              <input class="form-control shadow-lg" type="text" v-model="title">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Company Name</label>
                            <div class="col-lg-9">
                              <input
                                class="form-control shadow-lg"
                                type="text"
                                v-model="companyName"
                              >
                            </div>
                          </div>
                          <div class="form-group row">
                            <label class="col-lg-3 co
l-form-label form-control-label"></label>
                            <div class="col-lg-9">
                              <button
                                @click="confirm()"
                                class="btn btn-dark"
                                data-toggle="collapse"
                                href="#collapseExample1"
                                role="button"
                                aria-expanded="false"
                                aria-controls="collapseExample1"
                              >Confirm</button>
                            </div>
                          </div>
                        </div>
                      </div>
                      <!-- /form user info -->
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- collapse1 -->
          <div class="collapse" id="collapseExample1">
            <div class="container">
              <div class="row">
                <div class="container py-3">
                  <div class="row">
                    <div class="mx-auto col-9 col-md-9">
                      <!-- form user info -->
                      <div class="card">
                        <div class="card-header">
                          <h4 class="mb-0">Payment</h4>
                        </div>
                        <div class="card-body">
                          <div class="form-group row">
                            <label
                              class="col-lg-3 col-form-label form-control-label"
                            >Full Name on the Card</label>
                            <div class="col-lg-9">
                              <input class="form-control shadow-lg" type="text">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Card Number</label>
                            <div class="col-lg-9">
                              <input
                                class="form-control shadow-lg"
                                type="number"
                                minlength="16"
                                maxlength="16"
                              >
                            </div>
                          </div>
                          <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Expiration</label>
                            <div class="col-lg-9">
                              <div class="input-group shadow-lg">
                                <input
                                  type="number"
                                  class="form-control"
                                  placeholder="MM"
                                  minlength="2"
                                  maxlength="2"
                                >
                                <input
                                  type="number"
                                  class="form-control"
                                  placeholder="YY"
                                  minlength="4"
                                  maxlength="4"
                                >
                              </div>
                            </div>
                          </div>
                          <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">CVV</label>
                            <div class="col-lg-9">
                              <input
                                class="form-control shadow-lg"
                                type="number"
                                minlength="3"
                                maxlength="3"
                              >
                            </div>
                          </div>
                          <div class="form-group row">
                            <label class="col-lg-3 col-form-
label form-control-label"></label>
                            <div class="col-lg-9">
                              <button class="btn btn-dark" @click="pay()">Pay and Rent</button>
                            </div>
                          </div>
                        </div>
                      </div>
                      <!-- /form user info -->
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div></div>
        </div>
      </div>

      <br>
      <br>
      <br>
    </div>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  data() {
    return {
    carID: this.$route.params.carID,
    fromDate: this.$route.params.fromDate,
    fromTime: this.$route.params.fromTime,
    toDate: this.$route.params.toDate,
    toTime: this.$route.params.toTime,
    diffDays: this.$route.params.diffDate,
    carInfo: [],
    quantity: 1,
    name: "",
    surname: "",
    email: "",
    tcNumber: "",
    address: "",
    deliveryAddress: "",
    companyName: "",
    customerID: ""
    }
  },
  mounted() {
    console.log("DATE:" + this.fromDate.substring(0,10) + this.fromTime.substring(10,19))
    console.log("car id "+this.carID)
    axios
      .get("http://localhost:8080/api/car/" + this.carID)
      .then((response) => {this.carInfo = response.data})
      .catch(error => console.log("error = "+error))
  },
  methods: {
    increment() {
      if (this.quantity < this.carInfo.available_car_number) {
        this.quantity++;
      }
    },
    decrement() {
      if (this.quantity > 1) {
        this.quantity--;
      }
    },
    confirm() {
      axios.post("http://localhost:8080/api/customer/save",
      {
        name: this.name,
        surname: this.surname,
        email: this.email,
        tc_number: this.tcNumber,
        address: this.address,
        delivery_address: this.deliveryAddress,
        title: this.title,
        company_name: this.companyName,
        from_date: this.fromDate.substring(0,10) + this.fromTime.substring(10,19),
        to_date: this.toDate.substring(0,10) + this.toTime.substring(10,19),
        numberof_rented_cars: this.quantity
      }
      ).then((result) => {console.log(result)}).catch((err) => {console.log(err.body.message)});

      axios.get("http://localhost:8080/api/customer/last").then((response) => {
        console.log("customer id "+response.data);
        this.customerID = response.data.id;
        console.log(this.customerID);
      }).catch((err) => {
        console.log(err.data.message);
      });
    },
  }
}
</script>

<style>
.html,
body {
  background-color: #34495e !important;
}
.card-bg {
  background-color: #ecf0f1;
  margin-top: 5%;
  padding: 3%;
}
.gallery-wrap .img-big-wrap img {
  height: 50%;
  width: 100%;
  display: inline-block;
}

.gallery-wrap .img-small-wrap {
  text-align: center;
}
.gallery-wrap .img-small-wrap img {
  max-width: 100%;
  max-height: 100%;
  object-fit: cover;
  border-radius: 4px;
  cursor: zoom-in;
}
</style>
