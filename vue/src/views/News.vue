<template>
    <div id="Content">
        <b-container id="newsContent">
            <b-row>
                <b-col>
                    <h3 style="text-align: left">📰 인종차별 관련 기사</h3>
                </b-col>
                <b-col style="text-align: right; margin-right: 2%">
                    <b-button variant="outline-success" target="_blank" href="https://search.naver.com/search.naver?query=%EC%BD%94%EB%A1%9C%EB%82%98+%EC%9D%B8%EC%A2%85%EC%B0%A8%EB%B3%84&where=news&ie=utf8&sm=nws_hty">뉴스 더보기</b-button>
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
                            <h6>출처: {{item.source}}</h6>
                        </b-card-text>
                </b-card>
            </b-row>
        </b-container>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: 'news',
        data: () => {
            return {
                newsList: []
            }
        },
        mounted () {
            axios.get('/crawling/news/kr',
                {headers:{'Access-Control-Allow-Origin': '*', 'Content-Type':'application/json; charset = utf-8'}})
                .then(response => {
                    this.newsList = response.data;
                    console.log(response.data);
                })
                .catch(e => {
                    console.log('error : ', e)
                })
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