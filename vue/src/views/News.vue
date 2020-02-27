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
            <router-view :lang="$route.fullPath"></router-view>
        </b-container>
    </div>
</template>

<script>
    export default {
        name: 'news',
        data() {
            return {
                locale: this.$i18n.locale
            }
        },
        watch: {
            locale: function (val) {
                this.$i18n.locale = val;
                this.$router.push({name: 'news', params: { lang: val}});
            }
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