<template>
    <v-container fluid>
        <v-row>
            <v-col cols="6" class="mx-auto">
                <v-card>
                    <v-card-title>Search Company Database</v-card-title>
                    <v-card-text>
                        <div class="d-flex align-center">
                            <v-text-field v-model="searchCompany"
                                          label="Company Name"></v-text-field>
                            <v-btn color="primary"
                                   :disabled="searchCompany === ''"
                                   class="ml-5"
                                   @click="searchCompanies">
                                search
                            </v-btn>
                        </div>

                        <v-simple-table v-if="results.length > 0">
                            <thead>
                            <tr>
                                <th class="text-left">ID</th>
                                <th class="text-left">Name</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr v-for="result in results" :key="result.id">
                                <td>{{ result.id }}</td>
                                <td>{{ result.name }}</td>
                            </tr>
                            </tbody>
                        </v-simple-table>
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
    import { mapActions, mapGetters } from 'vuex';

    export default {
        name: "AnimalTesting",
        data() {
            return {
                searchCompany: '',
                noResults: false,
            }
        },
        computed: {
            ...mapGetters({
                results: 'animalTesting/results'
            })
        },
        methods: {
            ...mapActions({
                getResults: 'animalTesting/getResults',
            }),
            searchCompanies() {
                let search = {
                    company: this.searchCompany
                }
                this.getResults(search)
            }
        },
        watch: {
            results(results) {
                this.noResults = results.length <= 0;
            }
        }
    }
</script>
