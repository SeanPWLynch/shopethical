<template>
    <v-container fluid>
        <v-row>
            <v-col cols="6" class="mx-auto">
                <v-card>
                    <v-card-title>Search Company Database</v-card-title>
                    <v-card-text>
                        <div class="align-center">
                            <v-text-field v-model="searchCompany"
                                          label="Company Name"></v-text-field>
                            <v-btn color="primary"
                                   :disabled="searchCompany === ''"
                                   class="ml-5"
                                   @click="searchCompanies">
                                search
                            </v-btn>
                        </div>

                        <v-row justify="center">
                            <v-expansion-panels v-if="results.length > 0" inset>
                                <v-expansion-panel v-for="result in results" :key="result.id">
                                    <v-expansion-panel-header @click="searchPolicy(result.id)">{{ result.name }}
                                    </v-expansion-panel-header>
                                    <v-expansion-panel-content>
                                        <v-progress-circular v-show="gettingPolicy"
                                                             indeterminate
                                                             color="primary"
                                        ></v-progress-circular>
                                        <div v-show="!gettingPolicy">
                                            <span>{{ result.name }} - {{policy.policy}}</span>
                                        </div>
                                    </v-expansion-panel-content>
                                </v-expansion-panel>
                            </v-expansion-panels>
                        </v-row>

                        <div v-if="noResults">
                            <span class="text--secondary">No results found</span>
                        </div>
                    </v-card-text>
                </v-card>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
    import {mapActions, mapGetters} from 'vuex';

    export default {
        name: "AnimalTesting",
        data() {
            return {
                searchCompany: '',
                noResults: false,
                gettingPolicy: false,
                companyPolicy: ''
            }
        },
        computed: {
            ...mapGetters({
                results: 'animalTesting/results',
                policy: 'animalTesting/policy'
            })
        },
        methods: {
            ...mapActions({
                getResults: 'animalTesting/getResults',
                getPolicy: 'animalTesting/getPolicy',
            }),
            searchCompanies() {
                let search = {
                    company: this.searchCompany
                }
                this.getResults(search)
            },
            searchPolicy(id) {
                this.gettingPolicy = true
                this.getPolicy(id)
            }
        },
        watch: {
            results(results) {
                this.noResults = results.length <= 0;
            },
            policy() {
                this.gettingPolicy=false;
            }
        }
    }
</script>
