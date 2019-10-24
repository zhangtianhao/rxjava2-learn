package cn.yrshiben.rxjava2.rxjava2learn.retrofit2;

import cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model.BlockChairAddress;
import cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model.BlockChairAddressInfo;
import cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model.BlockChairOmni;
import cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model.BlockChairResponse;
import cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model.BlockChairTransaction;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author zhangbin
 * @Description: 区块链浏览器接口
 * bitcoin、bitcoin-cash、bitcoin-sv、litecoin、dogecoin、dash、ethereum、groestlcoin
 * @date create at 2019/10/17 11:19 AM
 */
public interface BlockChairExplorerApi {

    /**
     * 获取地址信息
     *
     * @param chain   链
     * @param address 地址
     * @return
     */
    @GET("/{chain}/dashboards/address/{address}")
    Observable<BlockChairResponse<BlockChairAddress, BlockChairOmni>> getAddress(@Path("chain") String chain, @Path("address") String address);

    /**
     * 获取交易信息
     *
     * @param chain  链
     * @param txHash
     * @return
     */
    @GET("/{chain}/dashboards/transaction/{txHash}")
    Observable<BlockChairResponse<BlockChairTransaction, Object>> getTransaction(@Path("chain") String chain, @Path("txHash") String txHash);
}
