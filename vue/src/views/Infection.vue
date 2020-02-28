<template>
    <div id="Content">
        <b-container id="infectionContent">
            <h3 style="text-align: left; margin-bottom: 4%">🗺️ {{$t('infection.title')}}</h3>
            <div id="map">
                <l-map
                        :center="[39, 127]"
                        :zoom="4.5"
                        style="height: 400px; width: 95%"
                        :options="{zoomControl: false}">
                    <l-choropleth-layer
                            :data="statusItems"
                            titleKey="country"
                            idKey="postal"
                            :value="value"
                            :extraValues="extraValues"
                            geojsonIdKey="postal"
                            :geojson="custom"
                            :colorScale="colorScale">
                        <template slot-scope="props">
                            <l-info-control
                                    :item="props.currentItem"
                                    :unit="props.unit"
                                    :title="$t('infection.countryInfo')"
                                    :placeholder="$t('infection.placeholder')"/>
                        </template>
                    </l-choropleth-layer>
                </l-map>
            </div>
            <b-row>
                <div id="tableBtn">
                    <b-button block variant="outline-secondary" v-if="!isHidden" v-on:click="isHidden = !isHidden">{{$t('infection.hidden-table')}}</b-button>
                    <b-button block variant="outline-danger" v-if="isHidden" v-on:click="isHidden = !isHidden">{{$t('infection.show-table')}}</b-button>
                </div>
                <div v-if="!isHidden" id="infectionTable" >
                    <b-table bordered outlined hover
                             :items="statusItems"
                             :fields="fields"
                             head-variant="light"
                             :tbody-tr-class="rowClass"
                             :sort-by.sync="sortBy"
                             :sort-desc.sync="sortDesc"></b-table>
                </div>
            </b-row>
        </b-container>
    </div>
</template>

<script>
    import axios from 'axios'
    import {LMap} from 'vue2-leaflet'
    import { InfoControl, ChoroplethLayer } from 'vue-choropleth'
    import custom from '../data/custom.geo.json'

    export default {
        name: 'status',
        components: {
            LMap,
            'l-choropleth-layer': ChoroplethLayer,
            'l-info-control': InfoControl
        },
        data () {
            return {
                locale: this.$i18n.locale,
                custom,
                colorScale: ["e7d090", "de7062"],
                value: {
                    key: "infected",
                    metric: this.$t('infection.infect-info')
                },
                extraValues: [{
                    key: "die",
                    metric: this.$t('infection.die-info')
                }],
                mapOptions: {
                    attributionControl: false
                },
                currentStrokeColor: '3d3213',
                statusItems: [],
                fields: [],
                isHidden: false,
                sortBy: 'infected',
                sortDesc: true

            }
        },
        methods:{
            rowClass(item, type) {
                if (!item || type !== 'row') return;
                if (item.country === '대한민국') return 'table-warning';
                if (item.country === '중국') return 'table-danger';
            },
            getData(){
                axios.get('/infection/data',
                    {headers:{'Access-Control-Allow-Origin': '*', 'Content-Type':'application/json; charset = utf-8'}})
                    .then(response => {
                        this.statusItems = response.data;
                        //console.log(response.data);
                    })
                    .catch(e => {
                        console.log('error : ', e)
                    })
            },
            setFields(){
                if(this.$i18n.locale==="ko"){
                    this.fields = [{
                        key: 'country',
                        label: this.$t('infection.country-label')
                    },
                        {
                            key: 'infected',
                            label: this.$t('infection.infected-label')
                        },
                        {
                            key: 'die',
                            label: this.$t('infection.die-label')
                        },
                        {
                            key: 'restore',
                            label: this.$t('infection.restore-label')
                        },
                        {
                            key: 'sus',
                            label: this.$t('infection.sus-label')
                        }
                    ]
                }
                if(this.$i18n.locale==="en"){
                    this.fields = [{
                        key: 'engCountry',
                        label: this.$t('infection.country-label')
                    },
                        {
                            key: 'infected',
                            label: this.$t('infection.infected-label')
                        },
                        {
                            key: 'die',
                            label: this.$t('infection.die-label')
                        },
                        {
                            key: 'restore',
                            label: this.$t('infection.restore-label')
                        },
                        {
                            key: 'sus',
                            label: this.$t('infection.sus-label')
                        }
                    ]
                }
            }
        },
        created () {
            this.getData();
            this.setFields();

        },
        watch: {
            '$i18n.locale': function () {
                this.$router.replace({ name: 'infection', params: { lang: this.$i18n.locale}});
            },
            '$route' (to, from) {
                if(to!==from){
                    this.setFields();
                }
            }
        }
    }
</script>

<style lang="css">
    @import "~leaflet/dist/leaflet.css";
    #Content{
        margin-top: 5%;
    }
    #Content #infectionContent{
        margin-left: 6%;
        text-align: center;
    }
    #map{
        margin-bottom: 30px;
    }
    #infectionTable{
        width: 95%;
    }
    #tableBtn{
        width: 95%;
        margin-bottom: 5%;
    }
</style>