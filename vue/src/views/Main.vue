<template>
    <div id="Content">
        <b-container id="mainContent">
            <b-row>
                <b-col>
                    <b-embed
                            type="iframe"
                            aspect="16by9"
                            src="https://www.youtube.com/embed/Bkltok5THro"
                            allowfullscreen>
                    </b-embed>
                </b-col>
                <b-col>
                    <div class="text-left">
                        <h5 style="font-weight: bold;">#IamNotAVirus 운동에 대해 아시나요?</h5>
                        <p class=mainDetail>
                            코로나19가 전세계에 퍼져나가면서 많은 사람들이 두려움을 느끼고 있습니다.
                            일부에서는 모든 동양인을 보균자 취급하며 차별하는 현상이 일어나고 있습니다.
                            이런 현상들은 인종차별적인 행동입니다.
                        </p>
                        <p class=mainDetail style="font-weight: bold">
                            코로나19를 인종차별을 위한 요소로 사용하지말아주세요.<br>
                            코로나19에 대해 올바르게 인식하고 차별을 멈춰주세요.
                        </p>
                    </div>
                    <div class="text-right" style="margin-top: 50px;">
                        <b-button variant="danger" class="MoreBtn" to="/News">인종차별 관련 뉴스</b-button>
                        <b-button variant="primary" class="MoreBtn" to="/covid19">코로나19 알아보기</b-button>
                        <b-button variant="success" class="MoreBtn" to="/infection">전세계 현황</b-button>
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
    #Content #mainContent{
        margin-left: 6%;
    }
    .MoreBtn{
        margin: 5px;
    }
    .mainDetail{
        line-height: 1.8em;
        margin-top: 3%;
    }
</style>