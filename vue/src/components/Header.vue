<template>
    <div>
        <b-container id="Header">
            <b-navbar variant="light">
                <b-navbar-brand style="font-size: 25px" to="/">{{$t("header.brand")}}</b-navbar-brand>
                <b-navbar-nav style="font-size: 18px">
                    <b-nav-item><b-link to="/News" class="items">{{$t("header.news")}}</b-link></b-nav-item>
                    <b-nav-item><b-link to="/covid19" class="items">{{$t("header.covid19")}}</b-link></b-nav-item>
                    <b-nav-item><b-link to="/prevention" class="items">{{$t("header.prevention")}}</b-link></b-nav-item>
                    <b-nav-item><b-link to="/infection" class="items">{{$t("header.infection")}}</b-link></b-nav-item>
                </b-navbar-nav>
                <!-- Right aligned nav items -->
                <b-navbar-nav class="ml-auto">
                    <b-button v-b-modal.support-modal variant="outline-primary" style="margin-right: 10px">{{$t("header.support")}}</b-button>
                    <b-nav-item-dropdown :text="$t('header.language')" right>
                        <b-dropdown-item @click="$i18n.locale='ko'">{{$t("header.korean")}}</b-dropdown-item>
                        <b-dropdown-item @click="$i18n.locale='en'"> {{$t('header.english')}}</b-dropdown-item>
                    </b-nav-item-dropdown>
                </b-navbar-nav>
            </b-navbar>
        </b-container>
        <!-- The modal -->
        <b-modal ref="support-modal" id="support-modal" hide-footer :title="$t('header.modal.title')" >
            <b-container style="margin: 5px">
                <p>{{$t('header.modal.content1')}}<br>{{$t('header.modal.content2')}}</p>
                <p id="url-txt" style="color: lightslategray; text-align: center">URL: {{url}}</p>
                <div id="sns-btn" class="col text-center">
                    <b-button block v-clipboard:copy="url"
                               v-clipboard:success="urlCopy"
                               v-clipboard:error="onError">{{$t('header.modal.copy')}}</b-button>
                </div>
            </b-container>
        </b-modal>
    </div>
</template>
<script>
    export default {
        name: 'urlSharing',
        data: () => {
            return {
                url: document.URL
            }
        },
        methods:{
            urlCopy: function (e) {
                this.url = e.text;
                this.$refs['support-modal'].hide();
            },
            onError: function () {
                alert('복사 실패')
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
</style>