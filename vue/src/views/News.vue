<template>
    <div id="Content">
        <b-container id="newsContent">
            <b-row>
                <b-col>
                    <h3 style="text-align: left">📰 {{$t('header.news')}}</h3>
                </b-col>
                <b-col style="text-align: right; margin-right: 2%">
                    <b-button variant="outline-success" target="_blank" :href="$t('news.more-data')">{{$t('news.more-info')}}</b-button>
                </b-col>
            </b-row>
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
        </b-container>
    </div>
</template>

<script>
    import axios from "axios";
    export default {
        name: 'news',
        data() {
            return {
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
            '$i18n.locale': function () {
                this.$router.replace({ name: 'news', params: { lang: this.$i18n.locale}});
            },
            '$route' (to, from) {
                if(to!==from){
                    this.getData();
                }
            }
        },
        created() {
            this.getData();
        }
    }
</script>
<style lang="css">
    #Content{
        margin-top: 5%;
    }
    #Content #newsContent{
        margin-left: 5%;
        text-align: center;
    }
    #news-text{
        text-align: left;
    }
    #news-text #news-title{
        color: black;
    }
    #news-text #news-title:hover{
        outline: none;
        color: #2c7bdc;
    }
</style>