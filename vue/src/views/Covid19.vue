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
            <h3>🔍 {{$t('covidInfo.fact-check.title')}}</h3>
            <b-row style="margin-bottom: 10%;">
                <b-card no-body class="mb-1">
                    <b-card-header header-tag="header" class="p-1" role="tab">
                        <b-button block href="#" v-b-toggle.accordion-1 variant="Secondary">
                            {{$t('covidInfo.fact-check.sub1.title')}}
                        </b-button>
                    </b-card-header>
                    <b-collapse id="accordion-1" visible accordion="my-accordion" role="tabpanel">
                        <b-card-body>
                            <b-card-text style="font-weight: bold">{{$t('covidInfo.fact-check.sub1.content1')}}</b-card-text>
                            <b-card-text>
                                {{$t('covidInfo.fact-check.sub1.content2')}}<br>
                                {{$t('covidInfo.fact-check.sub1.content3')}}<br>
                                {{$t('covidInfo.fact-check.sub1.content4')}}
                            </b-card-text>
                        </b-card-body>
                    </b-collapse>
                </b-card>

                <b-card no-body class="mb-1">
                    <b-card-header header-tag="header" class="p-1" role="tab">
                        <b-button block href="#" v-b-toggle.accordion-2 variant="Secondary">
                            {{$t('covidInfo.fact-check.sub2.title')}}
                        </b-button>
                    </b-card-header>
                    <b-collapse id="accordion-2" accordion="my-accordion" role="tabpanel">
                        <b-card-body>
                            <b-card-text style="font-weight: bold">{{$t('covidInfo.fact-check.sub2.content1')}}</b-card-text>
                            <b-card-text>
                                {{$t('covidInfo.fact-check.sub2.content2')}}<br>
                                {{$t('covidInfo.fact-check.sub2.content3')}}<br>
                                {{$t('covidInfo.fact-check.sub2.content4')}}<br>
                                {{$t('covidInfo.fact-check.sub2.content5')}}<br>
                                {{$t('covidInfo.fact-check.sub2.content6')}}
                            </b-card-text>
                        </b-card-body>
                    </b-collapse>
                </b-card>

                <b-card no-body class="mb-1">
                    <b-card-header header-tag="header" class="p-1" role="tab">
                        <b-button block href="#" v-b-toggle.accordion-3 variant="Secondary">
                            {{$t('covidInfo.fact-check.sub3.title')}}
                        </b-button>
                    </b-card-header>
                    <b-collapse id="accordion-3" accordion="my-accordion" role="tabpanel">
                        <b-card-body>
                            <b-card-text style="font-weight: bold">{{$t('covidInfo.fact-check.sub3.content1')}}</b-card-text>
                            <b-card-text>
                                {{$t('covidInfo.fact-check.sub3.content2')}}<br>
                                {{$t('covidInfo.fact-check.sub3.content3')}}<br>
                                {{$t('covidInfo.fact-check.sub3.content4')}}<br>
                                {{$t('covidInfo.fact-check.sub3.content5')}}
                            </b-card-text>
                        </b-card-body>
                    </b-collapse>
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
        text-align: left;
    }
    .card{
        margin: 3%;
        width: 100%;
        line-height:1.8em;
    }
    #highlight{
        font-weight: bold;
    }
</style>