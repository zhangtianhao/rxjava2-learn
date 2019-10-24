package cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/17 11:42 AM
 */
@Data
@NoArgsConstructor
public class BlockChairAddressInfo {

    private String type;
    private String script_hex;
    private String balance;
    private BigDecimal balance_usd;
    private Long received;
    private BigDecimal received_usd;
    private Long spent;
    private BigDecimal spent_usd;
    private Long output_count;
    private Long unspent_output_count;
    private String first_seen_receiving;
    private String last_seen_receiving;
    private String first_seen_spending;
    private String last_seen_spending;
    private Integer transaction_count;
    private String contract_code_hex;
    private Boolean contract_created;
    private Boolean contract_destroyed;
    private String received_approximate;
    private String spent_approximate;
    private String fees_approximate;
    private BigDecimal fees_usd;
    private Long receiving_call_count;
    private Long spending_call_count;
    private Long call_count;
}
