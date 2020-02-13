package com.spring.sharding.test;

import com.spring.sharding.jdbc.ShardingJdbcApplication;
import com.spring.sharding.jdbc.mapper.DictMapper;
import com.spring.sharding.jdbc.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShardingJdbcApplication.class})
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private DictMapper dictMapper;

    @Test
    public void testInsert() {
        for(int i = 0; i < 20; i++) {
            orderMapper.insert(new BigDecimal(i), Long.valueOf(i), "yes");
        }
    }

    @Test
    public void testSelect() {
        List<Long> orderIds = new ArrayList<>();
        orderIds.add(393345721874513920l);
        orderIds.add(393345722830815232l);
        orderIds.add(393345721346031617l);
        Map<String, ?> orders = orderMapper.selectOrderById(393345721874513920l);

        for (Map.Entry<String, ?> entry : orders.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    @Test
    public void testInsertDict() {
        dictMapper.insertDict(393345721874513920L, "1", "10", "test");
    }

}