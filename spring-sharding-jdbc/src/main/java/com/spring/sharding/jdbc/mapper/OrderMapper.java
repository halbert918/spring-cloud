package com.spring.sharding.jdbc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;

@Repository
public interface OrderMapper {

    /**
     * 插入訂單
     * @param price 價格
     * @param userId 用戶id
     * @param status 狀態
     */
    @Insert("insert into t_order(price, user_id, status) values (#{price}, #{userId}, #{status})")
    void insert(@Param("price") BigDecimal price, @Param("userId") Long userId, @Param("status") String status);

    /**
     * 根据orderId查询
     * @param orderId id
     * @return
     */
    @Select("SELECT * FROM t_order_1 WHERE order_id=#{orderId}")
    Map<String, ?> selectOrderById(@Param("orderId") Long orderId);

}