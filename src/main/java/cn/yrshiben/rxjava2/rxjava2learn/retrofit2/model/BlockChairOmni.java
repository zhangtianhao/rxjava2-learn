package cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/18 10:48 AM
 */
@Data
@NoArgsConstructor
public class BlockChairOmni {
    private Integer property_id;
    private String property_name;
    private Integer type_id;
    private String type;
    private String sender;
    private String recipient;
    private Boolean valid;
    private BigDecimal amount;
    private Integer balance;
    private Integer reserved_balance;
    private Integer frozen_balance;
}
