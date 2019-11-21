package cn.yrshiben.rxjava2.rxjava2learn.retrofit2.config;

import cn.yrshiben.rxjava2.rxjava2learn.retrofit2.BlockChairExplorerApi;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author zhangbin
 * @Description: 区块链浏览器接口配置
 * @date create at 2019/10/17 11:18 AM
 */
@Configuration
public class BlockChairExplorerConfig {

    private final static String BTC_API_URL = "https://api.blockchair.com";

    @Autowired
    private OkHttpClient okHttpClient;

    @Bean
    public BlockChairExplorerApi createBlockChainExplorerApi() {
        return new Retrofit.Builder()
                .baseUrl(BTC_API_URL)
                .client(okHttpClient)
                // 指定使用 RxJava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(BlockChairExplorerApi.class);
    }
}
