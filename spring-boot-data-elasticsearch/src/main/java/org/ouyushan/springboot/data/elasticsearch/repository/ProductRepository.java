package org.ouyushan.springboot.data.elasticsearch.repository;

import org.ouyushan.springboot.data.elasticsearch.dataobject.ESProductDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<ESProductDO, Integer> {

}
