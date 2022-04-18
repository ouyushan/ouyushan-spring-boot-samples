package org.ouyushan.springboot.data.elasticsearch;


import org.junit.jupiter.api.Test;
import org.ouyushan.springboot.data.elasticsearch.dataobject.ESProductDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

@SpringBootTest(classes = SpringBootDataElasticsearchApplication.class)
public class ProductRepositoryTest {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Test // 插入一条记录
    public void testInsert() {
        ESProductDO product = new ESProductDO();
        product.setId(1); // 一般 ES 的 ID 编号，使用 DB 数据对应的编号。这里，先写死
        product.setName("芋道源码");
        product.setSellPoint("愿半生编码，如一生老友");
        product.setDescription("我只是一个描述");
        product.setCid(2);
        product.setCategoryName("技术");
        elasticsearchOperations.save(product);
    }

    // 这里要注意，如果使用 save 方法来更新的话，必须是全量字段，否则其它字段会被覆盖。
    // 所以，这里仅仅是作为一个示例。
    @Test // 更新一条记录
    public void testUpdate() {
        ESProductDO product = new ESProductDO();
        product.setId(1);
        product.setCid(2);
        product.setCategoryName("技术-Java");
        elasticsearchOperations.save(product);
    }

    @Test // 根据 ID 编号，删除一条记录
    public void testDelete() {
        elasticsearchOperations.delete("1",ESProductDO.class);
    }

    @Test // 根据 ID 编号，查询一条记录
    public void testSelectById() {
        ESProductDO userDO = elasticsearchOperations.get("1",ESProductDO.class);
    }

}
