<template>
    <div>
        <b-container id="Header">
            <b-navbar variant="light">
                <b-navbar-brand style="font-size: 25px" to="/">#IamNotAVirus</b-navbar-brand>
                <b-navbar-nav style="font-size: 18px">
                    <b-nav-item><b-link to="/News" class="items">인종차별 관련 기사</b-link></b-nav-item>
                    <b-nav-item><b-link to="/covid19" class="items">코로나19란?</b-link></b-nav-item>
                    <b-nav-item><b-link to="/prevention" class="items">예방법</b-link></b-nav-item>
                    <b-nav-item><b-link to="/infection" class="items">전세계 감염 분포</b-link></b-nav-item>
                </b-navbar-nav>
                <!-- Right aligned nav items -->
                <b-navbar-nav class="ml-auto">
                    <b-button v-b-modal.support-modal variant="outline-primary" style="margin-right: 10px">응원해요✨</b-button>
                    <b-nav-item-dropdown text="언어" right>
                        <b-dropdown-item href="#">한국어</b-dropdown-item>
                        <b-dropdown-item href="#">영어</b-dropdown-item>
                    </b-nav-item-dropdown>
                </b-navbar-nav>
            </b-navbar>
        </b-container>
        <!-- The modal -->
        <b-modal id="support-modal" ok-only title="👍 #IAmNotAVirus를 응원해주세요" >
            <b-container style="margin: 5px">
                <p>이 운동에 대해 지지한다면, <br>
                    링크를 공유해 이 사이트를 다른 사람에게 공유해주세요😇</p>
                <p id="url-txt" style="color: lightslategray; text-align: center">URL: {{url}}</p>
                <div id="sns-btn" class="col text-center">
                    <b-button  v-clipboard:copy="url"
                               v-clipboard:success="urlCopy"
                               v-clipboard:error="onError">url<br>복사</b-button>
                    <b-button variant="info">트위터<br>공유하기</b-button>
                    <b-button variant="primary">페이스북<br>공유하기</b-button>
                    <b-button variant="warning" v-on:click="postKakao">카카오톡<br>공유하기</b-button>
                </div>
            </b-container>
        </b-modal>
    </div>
</template>
<script>
    import axios from 'axios'

    export default {
        name: 'snsSharing',
        data: () => {
            return {
                url: document.URL
            }
        },
        methods:{
            urlCopy: function (e) {
                this.url = e.text;
                alert('복사 성공')
            },
            onError: function () {
                console.log('복사 실패')
            },
            postKakao: ()=>{
                axios.post('/post/sns/kakao',{'url':document.URL})
                    .then(res => { console.log(res.data) })
            }
        }
    }
</script>
<style lang="css">
    #Header .items {
        color: black;
        text-decoration: none;
    }
    #Header .items:hover {
        outline: none;
        color: #2c7bdc;
    }
    #Header .items:focus {
        outline: none;
        font-weight: bold;
        color: #2c7bdc;
    }
    #sns-btn >button{
        margin: 5px;
    }
</style>