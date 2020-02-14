<template>
    <div>
        <b-container id="Header">
            <b-navbar>
                <b-navbar-brand to="/">#IamNotAVirus</b-navbar-brand>
                <b-navbar-nav>
                    <b-nav-item><b-link to="/covid19" class="items">코로나-19란?</b-link></b-nav-item>
                    <b-nav-item><b-link to="/prevention" class="items">예방법</b-link></b-nav-item>
                    <b-nav-item><b-link to="/infection" class="items">전세계 감염 분포</b-link></b-nav-item>
                </b-navbar-nav>
                <!-- Right aligned nav items -->
                <b-navbar-nav class="ml-auto">
                    <b-nav-item active>응원해요✨</b-nav-item>
                    <b-nav-item-dropdown text="Lang" right>
                        <b-dropdown-item href="#">KR</b-dropdown-item>
                        <b-dropdown-item href="#">EN</b-dropdown-item>
                    </b-nav-item-dropdown>
                </b-navbar-nav>
            </b-navbar>
        </b-container>
    </div>
</template>