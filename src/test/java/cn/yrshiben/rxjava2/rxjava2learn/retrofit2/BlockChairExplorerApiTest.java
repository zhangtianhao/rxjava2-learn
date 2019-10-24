package cn.yrshiben.rxjava2.rxjava2learn.retrofit2;

import cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model.BlockChairAddress;
import cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model.BlockChairOmni;
import cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model.BlockChairResponse;
import cn.yrshiben.rxjava2.rxjava2learn.retrofit2.model.BlockChairTransaction;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author zhangbin
 * @Description:
 * @date create at 2019/10/18 9:29 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlockChairExplorerApiTest {

    @Autowired
    private BlockChairExplorerApi blockChairExplorerApi;

    @Test
    public void testGetAddress() {
        BlockChairResponse<BlockChairAddress, BlockChairOmni> single = blockChairExplorerApi.getAddress("bitcoin", "39k4xmqiCznfFxLU1qEhBozSshTVCSevoC")
                .map(response -> {
                    Map<String, Object> data = response.getData();
                    Gson gson = new Gson();
                    Type addressType = new TypeToken<BlockChairAddress>() {
                    }.getType();
                    BlockChairAddress blockChairAddress = gson.fromJson(gson.toJson(data.get("39k4xmqiCznfFxLU1qEhBozSshTVCSevoC")), addressType);
                    response.setT(blockChairAddress);

                    Type listType = new TypeToken<List<BlockChairOmni>>() {
                    }.getType();
                    List<BlockChairOmni> omniList = gson.fromJson(gson.toJson(data.get("_omni")), listType);
                    response.setMList(omniList);
                    return response;
                })
                .blockingSingle();
        System.out.println(single);
    }

    @Test
    public void testGetTransaction() {
        BlockChairResponse<BlockChairTransaction, Object> single = blockChairExplorerApi.getTransaction("ethereum", "0xfcb0e2dd0705fa0965373b01846ccdbced693c35cad8543b35845c20e8c95330")
                .map(response -> {
                    Map<String, Object> data = response.getData();
                    Gson gson = new Gson();
                    Type addressType = new TypeToken<BlockChairTransaction>() {
                    }.getType();
                    BlockChairTransaction blockChairTransaction = gson.fromJson(gson.toJson(data.get("0xfcb0e2dd0705fa0965373b01846ccdbced693c35cad8543b35845c20e8c95330")), addressType);
                    response.setT(blockChairTransaction);

                    return response;
                })
                .blockingSingle();
        System.out.println(single);
    }
}
