<template>
    <div id="Content">
        <b-container id="infectionContent">
            <div id="map">
                <l-map
                        :center="[30, 50]"
                        :zoom="1.5"
                        style="height: 400px; width: 95%"
                        :options="mapOptions">
                    <l-choropleth-layer
                            :data="statusItems"
                            titleKey="country"
                            idKey="country"
                            :value="value"
                            :extraValues="extraValues"
                            geojsonIdKey="id"
                            :geojson="countries"
                            :colorScale="colorScale">
                    </l-choropleth-layer>
                </l-map>
            </div>
            <div id="infectionTable">
                <b-table striped hover :items="statusItems"></b-table>
            </div>
        </b-container>
    </div>
</template>

<script>
    import axios from 'axios'
    import {LMap} from 'vue2-leaflet'
    import { ChoroplethLayer } from 'vue-choropleth'
    import countries from '../data/countries.geo.json'

    export default {
        name: 'status',
        components: {
            LMap,
            'l-choropleth-layer': ChoroplethLayer
        },
        data: () => {
            return {
                countries,
                colorScale: ["e7d090", "e9ae7b", "de7062"],
                value: {
                    key: "infected",
                    metric: "% 감염"
                },
                extraValues: [{
                    key: "die",
                    metric: "% 사망"
                }],
                mapOptions: {
                    attributionControl: false
                },
                currentStrokeColor: '3d3213',
                statusItems: []
            }
        },
        mounted () {
            axios.get('/infection',
                {headers:{'Access-Control-Allow-Origin': '*', 'Content-Type':'application/json'}})
                .then(response => {
                    this.statusItems = response.data;
                })
                .catch(e => {
                    console.log('error : ', e)
                })
        }
    }
</script>

<style lang="css">
    @import "~leaflet/dist/leaflet.css";
    #Content{
        margin-top: 5%;
    }
    #Content #infectionContent{
        margin-left: 10%;
        text-align: center;
    }
    #map{
        margin-bottom: 30px;
    }
    #infectionTable{
        width: 95%;
    }
</style>