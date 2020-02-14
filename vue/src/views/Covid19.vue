<template>
    <div id="Content">
        <b-container id="coronaContent">
            <h3>🔍 코로나19란?</h3>
            <b-row>
                <b-card class="card">
                    <b-card-text>
                        코로나 바이이러스(CoV) 중에서도 사람감염을 일으키는 코로나 바이러스 종으로<br>
                        2019년 12월 중국 우한에서 처음 발생한 뒤 전 세계로 확산된 호흡기 감염질환이다.<br>
                        2003년 유행한 사스(SARS, 중증급성호흡기증후군)와 비슷한 특징을 갖고있으며<br>
                        증상으로는 발열, 호흡기 증상(기침, 호흡곤란), 중증 폐렴을 유발한다.<br>
                    </b-card-text>
                    <b-card-text>
                        발생 초기에 '우한폐렴', '신종코로나바이러스'라고 불렸지만<br>
                        현재는 '코로나바이러스감염증-19'(약칭 코로나19)라는 공식 명칭이 명명되었다.
                    </b-card-text>
                </b-card>
            </b-row>
            <h3>🔍 전염 경로</h3>
            <b-row>
                <b-card class="card">
                    <b-card-text>
                        감염자의 비말(침방울)이 호흡기나 눈·코·입의 점막으로 침투될 때 전염된다.<br>
                        비말감염은 감염자가 기침·재채기를 할 때 침 등의 작은 물방울(비말)에 바이러스·세균이 섞여 나와 <br>
                        타인에게 감염되는 것으로 통상 이동거리는 2m로 알려져 있다.<br>
                        눈의 경우 환자의 침 등이 눈에 직접 들어가거나, 바이러스에 오염된 손으로 눈을 비비면 눈을 통해 전염될 수 있다.<br>
                    </b-card-text>
                    <b-card-text id="highlight">
                        공기 중 전파 가능성에 대해서는 아직 확인된 바 없다.
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
        margin-left: 10%;
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