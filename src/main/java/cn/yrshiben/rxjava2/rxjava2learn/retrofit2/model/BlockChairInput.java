package cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


/**
 * @author zhangbin
 * @Description: 交易输入信息
 * @date create at 2019/10/17 2:04 PM
 */
@Data
@NoArgsConstructor
public class BlockChairInput {

    private Long block_id;
    private Long transaction_id;
    private Long index;
    private String transaction_hash;
    private String date;
    private String time;
    private Long value;
    private BigDecimal value_usd;
    private String recipient;
    private String type;
    private String script_hex;
    private Boolean is_from_coinbase;
    private Boolean is_spendable;
    private Boolean is_spent;
    private Long spending_block_id;
    private Long spending_transaction_id;
    private Integer spending_index;
    private String spending_transaction_hash;
    private String spending_date;
    private String spending_time;
    private BigDecimal spending_value_usd;
    private Long spending_sequence;
    private String spending_signature_hex;
    private String spending_witness;
    private Long lifespan;
    private Integer cdd;
}
