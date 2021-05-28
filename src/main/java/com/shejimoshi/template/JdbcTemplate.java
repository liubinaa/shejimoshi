package com.shejimoshi.template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 模板模式：用户自己实现的东西，参与整个流程
 * 整个流程模拟模板模式，processResult 作为用户自己写的，来参于整个流程
 * <p>
 * 策略模式与模板模式对比
 * 策略模式：只有选择权
 * 模板模式：侧重的点不一样，你没得选择，你必须这么做 你可以参与某一部分内容自定义   经典：compare比较
 *
 * @author liubin
 */
public abstract class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, Object[] values) {
        List<Object> objectList = new ArrayList<>();
        //1、获取连接
        try {
            Connection connection = dataSource.getConnection();
            //2、创建语句集
            PreparedStatement ps = connection.prepareStatement(sql);
            //3、执行语句集，并且获得结果集
            ResultSet resultSet = ps.executeQuery();
            //4、解析语句集
            int rowNum = 1;
            while (resultSet.next()) {
                Object objects = processResult(resultSet, rowNum++);
                objectList.add(objects);
            }
            //5、关闭结果集
            resultSet.close();
            //6、关闭语句集
            ps.close();
            //7、关闭连接
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objectList;
    }

    /**
     * 处理结果
     *
     * @param rs     rs
     * @param rowNum 行号
     * @return 结果
     */
    public abstract Object processResult(ResultSet rs, int rowNum);
}
