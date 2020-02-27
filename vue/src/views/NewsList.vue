<template>
    <div>
        <b-row id="news-list" v-for="(item, index) in newsList"
               :key="index" >
            <b-card :img-src=item.img :to=item.link target="_blank" img- img-alt="News image" img-height="120px" img-width="120px" img-left class="mb-3">
                <b-card-text id="news-text">
                    <a :href=item.link target="_blank">
                        <h4 id="news-title">{{item.title}}</h4>
                    </a>
                    <br>
                    <h6>{{item.source}}</h6>
                </b-card-text>
            </b-card>
        </b-row>
    </div>
</template>
<script>
    import axios from 'axios'

    export default {
        name: 'newsList',
        data() {
            return {
                locale: this.$i18n.locale,
                newsList: []
            }
        },
        methods:{
            getData(){
                axios.get('/crawling/news/' + this.$i18n.locale,
                    {
                        headers: {
                            'Access-Control-Allow-Origin': '*',
                            'Content-Type': 'application/json; charset = utf-8'
                        }
                    })
                    .then(response => {
                        this.newsList = response.data;
                        //console.log(response.data);
                    })
                    .catch(e => {
                        console.log('error : ', e)
                    })
            }
        },
        watch: {
            locale: function (val) {
                this.$i18n.locale = val;
            }
        },
        mounted() {
            this.getData();
        }
    }
</script>