<template>
    <div id="Content">
        <b-container id="infectionContent">
            {{statusItems}}
        </b-container>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: 'status',
        data: () => {
            return {
                statusItems: []
            }
        },
        created () {
            axios.get('http://happycastle.club/status')
                .then(response => {
                    this.statusItems = response.data
                })
                .catch(e => {
                    console.log('error : ', e)
                })
        }
    }
</script>

<style lang="css">
    #Content{
        margin-top: 5%;
    }
    #Content #infectionContent{
        margin-left: 10%;
        text-align: left;
    }
</style>