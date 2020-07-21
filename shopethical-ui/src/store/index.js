import Vue from "vue";
import Vuex from "vuex";
import animalTesting from './modules/animaltesting';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {},
  mutations: {},
  actions: {},
  modules: {animalTesting,
  }
});
