<template>
    <div>
        <b-container id="Header">
            <b-navbar>
                <b-navbar-brand to="/">#IamNotAVirus</b-navbar-brand>
                <b-navbar-nav>
                    <b-nav-item><b-link to="/covid19" class="items">코로나19란?</b-link></b-nav-item>
                    <b-nav-item><b-link to="/prevention" class="items">예방법</b-link></b-nav-item>
                    <b-nav-item><b-link to="/infection" class="items">전세계 감염 분포</b-link></b-nav-item>
                </b-navbar-nav>
                <!-- Right aligned nav items -->
                <b-navbar-nav class="ml-auto">
                    <b-button variant="outline-primary" style="margin-right: 10px">응원해요✨</b-button>
                    <b-nav-item-dropdown text="Language" right>
                        <b-dropdown-item href="#">KR</b-dropdown-item>
                        <b-dropdown-item href="#">EN</b-dropdown-item>
                    </b-nav-item-dropdown>
                </b-navbar-nav>
            </b-navbar>
        </b-container>
    </div>
</template>

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