package cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author zhangbin
 * @Description: BlockChair 响应状态码信息的封装
 * @date create at 2019/10/17 11:31 AM
 */
@Data
@NoArgsConstructor
public class BlockChairContext {

    /**
     * 状态码，200 为成功。
     */
    private Integer code;
    private String source;
    private BigDecimal time;
    private String limit;
    private String offset;
    private Integer results;
    private Long state;
    private Long state_layer_2;
    private BlockChairCache cache;
    private BlockChairApi api;

    /**
     * 请求是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        return Objects.equals(200, code);
    }

    @Data
    @NoArgsConstructor
    public static class BlockChairCache {
        private Boolean live;
        private Integer duration;
        private String since;
        private String until;
        private String time;
    }

    @Data
    @NoArgsConstructor
    public static class BlockChairApi {
        private String version;
        private String last_major_update;
        private String next_major_update;
        private String tested_features;
        private String documentation;
        private String notice;
    }
}
