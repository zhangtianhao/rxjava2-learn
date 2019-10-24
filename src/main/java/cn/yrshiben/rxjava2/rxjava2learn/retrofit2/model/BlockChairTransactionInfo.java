package cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zhangbin
 * @Description: 交易具体信息
 * @date create at 2019/10/17 2:02 PM
 */
@Data
@NoArgsConstructor
public class BlockChairTransactionInfo {

    /**
     * 交易对应区块的区块高度
     */
    private Long block_id;
    private Long id;
    private String hash;
    private String date;
    private String time;
    private Integer size;
    private Integer weight;
    private Integer version;
    private Integer lock_time;
    private Boolean is_coinbase;
    private Boolean bas_witness;
    private Integer input_count;
    private Integer output_count;
    private Long input_total;
    private BigDecimal input_total_usd;
    private Long output_total;
    private BigDecimal output_total_usd;
    /**
     * 交易手续费
     */
    private Long fee;
    private BigDecimal fee_usd;
    private BigDecimal fee_per_kb;
    private BigDecimal fee_per_kb_usd;
    private BigDecimal fee_per_kwu;
    private BigDecimal fee_per_kwu_usd;
    private BigDecimal cdd_total;
    private Long index;
    private Boolean failed;
    private String type;
    private String sender;
    private String recipient;
    private Long call_count;
    private Long value;
    private BigDecimal value_usd;
    private String internal_value;
    private BigDecimal internal_value_usd;
    private BigDecimal fee_usdX;
    private BigDecimal gas_used;
    private Long gas_limit;
    private Long gas_price;
    private String input_hex;
    private String nonce;
    private String v;
    private String r;
    private String s;
}
