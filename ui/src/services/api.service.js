import Vue from "vue";
import axios from "axios";
import VueAxios from "vue-axios"

import JwtService from "./jwt.service";
import { API_URL } from "./config";
import applyConverters  from "axios-case-converter";


const ApiService  = {
  initialize() {
    console.log(`[MyKoiPond] initialize axios instance`)
    Vue.use(VueAxios, axios);
    Vue.axios.defaults.timeout = 1000;
    Vue.axios.defaults.headers.common = {
      // 'Access-Control-Allow-Origin': '*',
      // 'Access-Control-Allow-Methods': 'GET, POST, OPTIONS, PUT, PATCH, DELETE',
      // 'Access-Control-Allow-Headers': 'Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,X-Access-Token,XKey,Authorization',
    }
  },

  setHeader() {
    const authToken = JwtService.getToken('authToken');
    const authUser = JwtService.getToken('authUser');

    // if(authUser && authToken){
    //   Vue.axios.defaults.headers.common["Authorization"] = `Bearer ${JSON.parse(authToken)}`;
    //   Vue.axios.defaults.headers.common["AuthUser"] = `${JSON.parse(authUser)}`;
    // }
  },

  query(resource, params) {
    const request = applyConverters(Vue.axios)
      .get(`${resource}`, params)
      .catch(error => {
        throw `[MyKoiPond] ApiService ${resource} \n ${error.response.data.message}`;
      });
    return request;
  },

  getByParam(resource, param = "") {
    console.log(`[MyKoiPond] getByParam ${resource} with param ${param}`)
    const request = applyConverters(Vue.axios)
      .get(`${resource}${param}`)
      .catch(error => {
        throw `[MyKoiPond] ApiService ${resource} \n ${error.response.data.message}`;
      });
    return request;
  },
  get(resource, slug = "") {
    console.log(`[MyKoiPond] get ${resource} with slug ${slug}`)
    const request = applyConverters(Vue.axios)
      .get(`${resource}/${slug}`)
      .catch(error => {
        throw `[MyKoiPond] ApiService ${resource} \n ${error.response.data.message}`;
      });
    return request;
  },

  post(resource, params) {

    console.log(`[MyKoiPond] post ${resource} with params ${JSON.stringify(params)}`)

    const request = Vue.axios
      .post(`${resource}`, params, { headers: { 'content-type': 'application/json'}})
      .catch((error) => {
        throw `[MyKoiPond] ApiService ${resource} \n ${error}`;
      });
    return request;
  },

  update(resource, slug, params) {
    console.log(`[MyKoiPond] update ${resource} with slug ${slug} and params ${params}`)
    const request = applyConverters(Vue.axios)
      .put(`${resource}/${slug}`, params)
      .catch(error => {
        throw `[MyKoiPond] ApiService ${resource}/${slug} \n ${error.response.data.message}`;
      });
    return request;
  },

  put(resource, params) {
    console.log(`[MyKoiPond] update ${resource} with params ${params}`)
    const request = applyConverters(Vue.axios)
      .put(`${resource}`, params)
      .catch(error => {
        throw `[MyKoiPond] ApiService ${resource} \n ${error.response.data.message}`;
      });
    return request
  },

  delete(resource, slug) {
    console.log(`[MyKoiPond] update ${resource} with slug ${slug}`)
    const request = applyConverters(Vue.axios)
      .delete(`${resource}/${slug}`)
      .catch(error => {
        throw `[MyKoiPond] ApiService ${resource}/${slug} \n ${error.response.data.message}`;
      });
    return request
  }
};

export default ApiService;
