<template>
    <div id="Content">
        <b-container id="preventionContent">
            <b-card id="videoCard" no-body>
                <b-tabs card>
                    <b-tab title="🚨 코로나바이러스감염증-19 예방수칙" active>
                        <b-row class="preventionVideo">
                            <h5>💡 예방수칙 준수만으로도 코로나 감염확률을 충분히 줄일 수 있습니다.</h5>
                            <b-embed
                                    type="iframe"
                                    aspect="16by9"
                                    src="https://www.youtube.com/embed/tDJF0cdJWHo"
                                    allowfullscreen/>
                        </b-row>
                    </b-tab>
                </b-tabs>
            </b-card>
        </b-container>
    </div>
</template>
<style lang="css">
    #Content{
        margin-top: 5%;
    }
    #Content #preventionContent{
        margin-left: 3%;
        text-align: left;
    }
    #videoCard{
        color: black;
    }
    .preventionVideo{
        padding: 3%;
    }
</style>