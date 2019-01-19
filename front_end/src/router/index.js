import Vue from 'vue'
import Router from 'vue-router'
import home from '@/components/home'
import carList from '@/components/carList'
import details from '@/components/details'
import carDetails from '@/components/carDetails'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: home
    },
    {
      path: '/list/:branchID/:fromDate/:fromTime/:toDate/:toTime/',
      name: 'list cars',
      component: carList
    },
    {
      path: '/details/:carID/:fromDate/:fromTime/:toDate/:toTime/:diffDate',
      name: 'car details',
      component: carDetails
    },
    {
      path: '/detailss/:carID/:fromDate/:fromTime/:toDate/:toTime/:diffDate',
      name: 'details',
      component: details
    }
  ]
})
