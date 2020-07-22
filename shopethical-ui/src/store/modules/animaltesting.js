import axios from 'axios';


const state = {
	results: [],
	policy: '',
};

const getters = {
	results: state => { return state.results },
	policy: state => { return state.policy },
};

const mutations = {
	saveResults(state, results) {
		state.results = results;
	},
	savePolicy(state, policy) {
		state.policy = policy;
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
		axios.get(`http://localhost:8092/animaltesting/company/${search.company}`,
			config)
			.then(({data}) => {
				commit('saveResults', data);
			})
	},
	getPolicy({ commit, rootGetters}, companyID) {
		const config = {
			headers: {
				'Authorization': `Bearer ${ rootGetters['user/token'] }`,
				'Access-Control-Allow-Origin': 'http://localhost:8080'
			}
		}
		axios.get(`http://localhost:8092/animaltesting/policy/${companyID}`,
			config)
			.then(({data}) => {
				commit('savePolicy', data.policy);
			})
	}
};

export default {
	namespaced: true,
	state,
	getters,
	mutations,
	actions,
};