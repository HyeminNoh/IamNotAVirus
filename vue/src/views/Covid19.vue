<template>
    <div id="Content">
        <b-container id="coronaContent">
            <h3>🔍 {{$t('header.covid19')}}</h3>
            <b-row>
                <b-card class="card">
                    <b-card-text>
                        {{$t('covidInfo.card1.content1')}}<br>
                        {{$t('covidInfo.card1.content2')}}<br>
                        {{$t('covidInfo.card1.content3')}}<br>
                        {{$t('covidInfo.card1.content4')}}<br>
                    </b-card-text>
                    <b-card-text>
                        {{$t('covidInfo.card1.content5')}}<br>
                        {{$t('covidInfo.card1.content6')}}
                    </b-card-text>
                </b-card>
            </b-row>
            <h3>🔍 {{$t('covidInfo.infectious-route')}}</h3>
            <b-row>
                <b-card class="card">
                    <b-card-text>
                        {{$t('covidInfo.card2.content1')}}<br>
                        {{$t('covidInfo.card2.content2')}}<br>
                        {{$t('covidInfo.card2.content3')}}<br>
                        {{$t('covidInfo.card2.content4')}}<br>
                    </b-card-text>
                    <b-card-text id="highlight">
                        {{$t('covidInfo.card2.content5')}}
                    </b-card-text>
                </b-card>
            </b-row>
        </b-container>
    </div>
</template>
<style lang="css">
    #Content{
        margin-top: 5%;
    }
    #Content #coronaContent{
        margin-left: 5%;
        text-align: left;
    }
    .card{
        margin: 3%;
        width: 100%;
        text-align: center;
        line-height:1.8em;
    }
    #highlight{
        font-weight: bold;
    }
</style>