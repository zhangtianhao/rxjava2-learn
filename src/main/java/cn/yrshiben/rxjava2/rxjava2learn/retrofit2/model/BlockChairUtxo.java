package cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/17 11:47 AM
 */
@Data
@NoArgsConstructor
public class BlockChairUtxo {

    private Long block_id;
    private String transaction_hash;
    private Integer index;
    private Long value;
}
