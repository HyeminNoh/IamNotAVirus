const BundleAnalyzerPlugin = require('webpack-bundle-analyzer')
    .BundleAnalyzerPlugin;

module.exports = {
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
    chainWebpack: config => {
        const svgRule = config.module.rule("svg");
        svgRule.uses.clear();
        svgRule.use("vue-svg-loader").loader("vue-svg-loader");
    },
    configureWebpack: {
        plugins: [new BundleAnalyzerPlugin()]
    }
};