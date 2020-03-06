<template>
    <div id="Content">
        <b-container id="mainContent">
            <b-row>
                <b-col>
                    <b-embed
                            type="iframe"
                            aspect="16by9"
                            :src="this.$t('main.src')"
                            allowfullscreen>
                    </b-embed>
                </b-col>
                <b-col>
                    <div class="text-left">
                        <h5 style="font-weight: bold;">{{$t('main.content-title')}}</h5>
                        <p class=mainDetail>
                            {{$t('main.content1')}}
                        </p>
                        <p class=mainDetail style="font-weight: bold">
                            {{$t('main.content2')}}<br>
                            {{$t('main.content3')}}
                        </p>
                    </div>
                    <div class="text-right" style="margin-top: 50px;">
                        <b-button variant="danger" class="MoreBtn" :to="{ name: 'news', params: { lang: this.$i18n.locale }}">{{$t('header.news')}}</b-button>
                        <b-button variant="primary" class="MoreBtn" to="/covid19">{{$t('header.covid19')}}</b-button>
                        <b-button variant="success" class="MoreBtn" :to="{ name: 'infection', params: { lang: this.$i18n.locale }}">{{$t('header.infection')}}</b-button>
                    </div>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>
<style lang="css">
    #Content{
        margin-top: 5%;
    }
    .MoreBtn{
        margin: 5px;
    }
    .mainDetail{
        line-height: 1.8em;
        margin-top: 3%;
    }
</style>