package cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhangbin
 * @Description: 交易数据
 * @date create at 2019/10/17 2:01 PM
 */
@Data
@NoArgsConstructor
public class BlockChairTransaction {

    /**
     * 交易信息
     */
    private BlockChairTransactionInfo transaction;
    /**
     * 交易输入
     */
    private List<BlockChairInput> inputs;
    /**
     * 交易输出
     */
    private List<BlockChairOutput> outputs;

    private BlockChairOmni _omni;

    /**
     * ETH 独有
     */
    private List<BlockChairCall> calls;
}
