module.exports ={
    outputDir: "../src/main/resources/static",
    indexPath: "../static/index.html",

    devServer: {
        proxy: {
            '/': {
                "target": 'http://localhost:8080/',
                "pathRewrite": { '^/': '' },
                "changeOrigin": true,
                "secure": false
            }
        }
    },
    pluginOptions: {
      i18n: {
        locale: 'en',
        fallbackLocale: 'en',
        localeDir: 'locales',
        enableInSFC: false
      }
    },
    chainWebpack: config => {
        config.module
            .rule("i18n")
            .resourceQuery(/blockType=i18n/)
            .type('javascript/auto')
            .use("i18n")
            .loader("@kazupon/vue-i18n-loader")
            .end();
    }
};
