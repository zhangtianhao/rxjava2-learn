package cn.yrshiben.rxjava2.rxjava2learn.retrofit2.config;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author zhangbin
 * @Description: http 客户端配置
 * @date create at 2019/10/16 5:00 PM
 */
@Configuration
public class OkHttpClientConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                // 指定拦截器
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool(50, 5, MINUTES))
                // 设置连接超时时间
                .connectTimeout(60, SECONDS)
                // 设置读取超时时间
                .readTimeout(60, SECONDS)
                // 设置写入超时时间
                .writeTimeout(60, SECONDS)
                .build();
    }
}
