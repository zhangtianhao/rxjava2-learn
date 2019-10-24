package cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/21 2:58 PM
 */
@Data
@NoArgsConstructor
public class BlockChairCall {

    private Long block_id;
    private Long transaction_id;
    private String transaction_hash;
    private Long index;
    private Integer depth;
    private String date;
    private String time;
    private Boolean failed;
    private String fail_reason;
    private String type;
    private String sender;
    private String recipient;
    private Long child_call_count;
    private String value;
    private BigDecimal value_usd;
    private Boolean transferred;
    private String input_hex;
    private String output_hex;

}
