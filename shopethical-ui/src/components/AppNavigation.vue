<template>
    <span>
    <v-navigation-drawer
            v-model="drawer"
            app
    >
        <v-list dense>

            <template v-for="(item, index) in items">
                <v-list-item :key="index" link>
                    <v-list-item-action>
                        <v-icon>{{item.icon}}</v-icon>
                    </v-list-item-action>
                    <v-list-item-content>
                        <v-list-item-title>{{item.title}}</v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </template>

        </v-list>

    </v-navigation-drawer>

    <v-app-bar
            app
            color="indigo"
            dark
    >
        <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
        <v-toolbar-title>{{
            appTitle
            }}
        </v-toolbar-title>
    </v-app-bar>
        </span>
</template>

<script>
    export default {
        name: 'AppNavigation',
        data() {
            return {
                appTitle: 'Shop Ethical',
                drawer: false,
                items: [
                    {icon: 'mdi-home', title: 'Home', url: '/'},
                    {icon: 'mdi-magnify', title: 'Search', url: '/search'}
                ]
            };
        },
        computed: {

        },
        methods: {

        }
    };
</script>