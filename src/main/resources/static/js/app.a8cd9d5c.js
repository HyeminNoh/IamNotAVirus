(function(t){function e(e){for(var n,u,i=e[0],s=e[1],l=e[2],b=0,f=[];b<i.length;b++)u=i[b],Object.prototype.hasOwnProperty.call(a,u)&&a[u]&&f.push(a[u][0]),a[u]=0;for(n in s)Object.prototype.hasOwnProperty.call(s,n)&&(t[n]=s[n]);c&&c(e);while(f.length)f.shift()();return o.push.apply(o,l||[]),r()}function r(){for(var t,e=0;e<o.length;e++){for(var r=o[e],n=!0,i=1;i<r.length;i++){var s=r[i];0!==a[s]&&(n=!1)}n&&(o.splice(e--,1),t=u(u.s=r[0]))}return t}var n={},a={app:0},o=[];function u(e){if(n[e])return n[e].exports;var r=n[e]={i:e,l:!1,exports:{}};return t[e].call(r.exports,r,r.exports,u),r.l=!0,r.exports}u.m=t,u.c=n,u.d=function(t,e,r){u.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:r})},u.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},u.t=function(t,e){if(1&e&&(t=u(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var r=Object.create(null);if(u.r(r),Object.defineProperty(r,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var n in t)u.d(r,n,function(e){return t[e]}.bind(null,n));return r},u.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return u.d(e,"a",e),e},u.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},u.p="/";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],s=i.push.bind(i);i.push=e,i=i.slice();for(var l=0;l<i.length;l++)e(i[l]);var c=s;o.push([0,"chunk-vendors"]),r()})({0:function(t,e,r){t.exports=r("56d7")},"034f":function(t,e,r){"use strict";var n=r("85ec"),a=r.n(n);a.a},"56d7":function(t,e,r){"use strict";r.r(e);r("e260"),r("e6cf"),r("cca6"),r("a79d");var n=r("2b0e"),a=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{attrs:{id:"app"}},[r("Header"),r("router-view")],1)},o=[],u=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("b-container",{attrs:{id:"Header"}},[r("b-navbar",[r("b-navbar-brand",{attrs:{to:"/"}},[t._v("#IamNotAVirus")]),r("b-navbar-nav",[r("b-nav-item",[r("b-link",{staticClass:"items",attrs:{to:"/covid19"}},[t._v("코로나-19란?")])],1),r("b-nav-item",[r("b-link",{staticClass:"items",attrs:{to:"/prevention"}},[t._v("예방법")])],1),r("b-nav-item",[r("b-link",{staticClass:"items",attrs:{to:"/infection"}},[t._v("전세계 감염 분포")])],1)],1),r("b-navbar-nav",{staticClass:"ml-auto"},[r("b-nav-item",{attrs:{active:""}},[t._v("응원해요✨")]),r("b-nav-item-dropdown",{attrs:{text:"Lang",right:""}},[r("b-dropdown-item",{attrs:{href:"#"}},[t._v("KR")]),r("b-dropdown-item",{attrs:{href:"#"}},[t._v("EN")])],1)],1)],1)],1)],1)},i=[],s=r("2877"),l={},c=Object(s["a"])(l,u,i,!1,null,null,null),b=c.exports,f={name:"App",components:{Header:b}},p=f,v=(r("034f"),Object(s["a"])(p,a,o,!1,null,null,null)),d=v.exports,m=r("8c4f"),_=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("b-container",[r("b-row",[r("b-jumbotron",{scopedSlots:t._u([{key:"header",fn:function(){return[t._v("#IamNotAVirus")]},proxy:!0}])},[r("b-row",[r("b-col",{attrs:{cols:"10"}},[r("b-embed",{attrs:{type:"iframe",aspect:"16by9",src:"https://www.youtube.com/embed/BVtt-_0tBa0",allowfullscreen:""}})],1),r("b-col",[r("p",[t._v("#iamnotavirus운동에 대해 아시나요?"),r("br"),t._v(" 신종 코로나 바이러스가 전세계에 퍼져나가면서 많은 사람들이 두려움을 느끼고 있습니다."),r("br"),t._v(" 이런 두려움과 별개로 신종 코로나 바이러스가 인종 차별의 요소로 사용되고 있습니다."),r("br"),r("br"),t._v(" 모든 아시안들이 코로나를 보균했을거라는 생각은 인종 차별적인 생각입니다."),r("br"),t._v(" 신종 코로나에 대해 올바르게 인식하고 모든 아시아인들에 대한 차별을 멈춰주세요."),r("br")]),r("b-button",{attrs:{variant:"primary",href:"#"}},[t._v("코로나-19 알아보기")]),r("b-button",{attrs:{variant:"success",href:"#"}},[t._v("전세계 현황")])],1)],1)],1)],1)],1)],1)},h=[],y={},w=Object(s["a"])(y,_,h,!1,null,null,null),g=w.exports;n["default"].use(m["a"]);var O=[{path:"/",name:"main",component:g}],j=new m["a"]({mode:"history",base:"/",routes:O}),x=j,k=r("5f5b");r("ab8b"),r("2dd8");n["default"].use(m["a"]),n["default"].use(k["a"]),n["default"].config.productionTip=!1,new n["default"]({router:x,render:function(t){return t(d)}}).$mount("#app")},"85ec":function(t,e,r){}});
//# sourceMappingURL=app.a8cd9d5c.js.map