<template>
    <div id="Content">
        <b-container id="preventionContent">
            <h3>🚨 {{$t('prevention.title')}}</h3>
            <b-card id="videoCard" header-tag="header">
                <template v-slot:header>
                    <h5 class="mb-0">💡 {{$t('prevention.sub-title')}}</h5>
                </template>
                <b-row class="preventionVideo">
                    <b-embed
                            type="iframe"
                            aspect="16by9"
                            :src="this.$t('prevention.src')"
                            allowfullscreen/>
                </b-row>
            </b-card>
        </b-container>
    </div>
</template>
<style lang="css">
    #Content{
        margin-top: 5%;
    }
    #Content #preventionContent{
        margin-left: 5%;
        text-align: left;
    }
    #videoCard{
        margin-left: 1%;
        color: black;
    }
    .preventionVideo{
        padding: 3%;
    }
</style>