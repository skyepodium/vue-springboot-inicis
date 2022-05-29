const path = require('path')

module.exports = {
    configureWebpack: {
        resolve: {
            alias: {
                '@': path.join(__dirname, 'src/'),
                '@comp': path.join(__dirname, 'src/components'),
                '@views': path.join(__dirname, 'src/views')
            }
        },
        // 개발 서버 설정
        devServer: {
            port: 3000
        }        
    }
}