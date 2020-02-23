<template>
    <div id="Content">
        <b-container id="infectionContent">
            <h3 style="text-align: left; margin-bottom: 4%">🗺️ 전세계 감염 정보</h3>
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
                                    title="국가별 정보"
                                    placeholder="지도 위에 커서를 올려주세요"/>
                        </template>
                    </l-choropleth-layer>
                </l-map>
            </div>
            <b-row>
                <div id="tableBtn">
                    <b-button block variant="outline-secondary" v-if="!isHidden" v-on:click="isHidden = !isHidden">표 숨기기</b-button>
                    <b-button block variant="outline-danger" v-if="isHidden" v-on:click="isHidden = !isHidden">전세계 감염 정보</b-button>
                </div>
                <div v-if="!isHidden" id="infectionTable">
                    <b-table bordered outlined hover :items="statusItems" :fields="fields" head-variant="light" :tbody-tr-class="rowClass"></b-table>
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
        data: () => {
            return {
                custom,
                colorScale: ["e7d090", "de7062"],
                value: {
                    key: "infected",
                    metric: "명 감염"
                },
                extraValues: [{
                    key: "die",
                    metric: "명 사망"
                }],
                mapOptions: {
                    attributionControl: false
                },
                currentStrokeColor: '3d3213',
                statusItems: [],
                fields: [
                    {
                    key: 'country',
                    label: '국가'
                    },
                    {
                        key: 'infected',
                        label: '확진'
                    },
                    {
                        key: 'die',
                        label: '사망'
                    },
                    {
                        key: 'restore',
                        label: '완치'
                    },
                    {
                        key: 'sus',
                        label: '의심'
                    },
                ]
                ,
                isHidden: false
            }
        },
        methods:{
            rowClass(item, type) {
                if (!item || type !== 'row') return
                //수정해야됨, 첫줄이랑 둘쨰줄에 색 적용되게
                if (item.country === '대한민국') return 'table-warning'
                if (item.country === '중국') return 'table-danger'
            }
        },
        mounted () {
            axios.get('/infection/data',
                {headers:{'Access-Control-Allow-Origin': '*', 'Content-Type':'application/json; charset = utf-8'}})
                .then(response => {
                    this.statusItems = response.data;
                    console.log(response.data);
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