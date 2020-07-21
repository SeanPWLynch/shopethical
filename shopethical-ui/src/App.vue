<template>
  <v-app id="shopethical-ui">

    <app-navigation></app-navigation>

    <v-main>
      <v-container
              class="fill-height"
              fluid
      >
        <v-row
                align="center"
                justify="center"
        >
          <v-col class="text-center">
            <v-flex><animal-testing></animal-testing></v-flex>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
    <v-footer
            color="indigo"
            app
    >
      <span class="white--text">&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
  </v-app>
</template>

<script>
  import AppNavigation from "@/components/AppNavigation";
  import AnimalTesting from "@/components/AnimalTesting";

  export default {
    name: 'App',
    components: {AnimalTesting, AppNavigation},
    props: {
      source: String,
    },

    data: () => ({
      drawer: null,
    }),
  }
</script>