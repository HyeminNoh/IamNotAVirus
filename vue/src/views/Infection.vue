<template>
    <div id="Content">
        <b-container id="infectionContent">
            <h3 style="text-align: left; margin-bottom: 4%">🗺️ {{$t('infection.title')}}</h3>
            <div id="map">
                <l-map
                        :center="[35, 0]"
                        :zoom="1.3"
                        style="height: 400px;">
                    <l-choropleth-layer
                            ref="my-choropleth-layer"
                            :data="statusItems"
                            :titleKey="titleKey"
                            idKey="ISO_A3"
                            :value="value"
                            :extraValues="extraValues"
                            geojsonIdKey="ISO_A3"
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
    import custom from '../data/countries.geo.json'

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
                titleKey: "",
                colorScale: ["e7d090", "e9ae7b", "de7062"],
                value: {},
                extraValues: [],
                mapOptions: {
                    attributionControl: false
                },
                currentStrokeColor: '3d3213',
                statusItems: [],
                fields: [],
                isHidden: false,
                sortBy: 'no',
                sortDesc: false

            }
        },
        methods:{
            rowClass(item, type) {
                if (!item || type !== 'row') return;
                if (item.no === '1' || item.no === '2' || item.no === '3') return 'table-warning';
                if (item.no === '0') return 'table-danger';
            },
            getData(){
                axios.get('/status/data',
                    {
                        headers:{
                            'Access-Control-Allow-Origin': '*',
                            'Content-Type':'application/json; charset = utf-8'
                        }
                    })
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
                    this.titleKey = "country";
                    this.value = {
                        key: "infected",
                        metric: this.$t('infection.infect-info')
                    };
                    this.extraValues = [
                        {
                            key: "die",
                            metric: this.$t('infection.die-info')
                        }
                    ];
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
                        }
                    ]
                }
                if(this.$i18n.locale==="en"){
                    this.titleKey = "engCountry";
                    this.value = {
                        key: "infected",
                        metric: this.$t('infection.infect-info')
                    };
                    this.extraValues = [
                        {
                            key: "die",
                            metric: this.$t('infection.die-info')
                        }
                    ];
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
        text-align: center;
    }
    #map{
        margin-bottom: 30px;
    }
    #infectionTable{
        width: 100%;
    }
    #tableBtn{
        width: 100%;
        margin-bottom: 5%;
    }
</style>