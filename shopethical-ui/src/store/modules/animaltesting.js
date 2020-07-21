import axios from 'axios';


const state = {
	results: [],
};

const getters = {
	results: state => { return state.results },
};

const mutations = {
	saveResults(state, results) {
		state.results = results;
	},
};

const actions = {
	getResults({ commit, rootGetters}, search) {
		const config = {
			headers: {
				'Authorization': `Bearer ${ rootGetters['user/token'] }`,
				'Access-Control-Allow-Origin': 'http://localhost:8080'
			}
		}
		axios.get(`http://localhost:8092/animaltesting/company/${ search.company}`,
			config)
			.then(({data}) => {
				commit('saveResults', data);
			})
	},
};

export default {
	namespaced: true,
	state,
	getters,
	mutations,
	actions,
};