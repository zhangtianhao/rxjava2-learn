package cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhangbin
 * @Description: BlockChair 响应地址数据
 * @date create at 2019/10/17 11:33 AM
 */
@Data
@NoArgsConstructor
public class BlockChairAddress {

    /**
     * 地址信息
     */
    private BlockChairAddressInfo address;
    /**
     * 交易 hash 列表
     */
    private List<String> transactions;
    /**
     * utxo 列表
     */
    private List<BlockChairUtxo> utxo;
    /**
     * ETH 独有
     */
    private List<BlockChairCall> calls;
}
