package cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author zhangbin
 * @Description: BlockChair 响应结果
 * @date create at 2019/10/17 11:29 AM
 */
@Data
@NoArgsConstructor
public class BlockChairResponse<T, M> {

    private Map<String, Object> data;
    private T t;
    private List<M> mList;

    /**
     * 响应的状态码、请求执行时间等信息
     */
    private BlockChairContext context;

}
