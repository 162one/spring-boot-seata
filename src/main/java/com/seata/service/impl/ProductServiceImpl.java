package com.seata.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.seata.entity.Product;
import com.seata.mapper.ProductMapper;
import com.seata.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 
 *
 * @author wz
 * @date 2023-10-13 15:34:55
 */
@Service
@Slf4j
@DS("storage")
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    @Override
    public Product info(Long id) {

        log.info("ProductFacadeImpl.info:入参：id:{}", id);
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    @Override
    public Product getById(Long id) {

        log.info("ProductFacadeImpl.getById:入参：id:{}", id);
        return productMapper.selectByPrimaryKey(id);
    }

    /**
     * 保存信息
     *
     * @param product
     * @return 结果
     */
    @Override
    public void insert(Product product) {

        log.info("ProductFacadeImpl.insert:入参：product:{}", JSON.toJSON(product));
        productMapper.insertSelective(product);
    }

    /**
     * 修改信息
     *
     * @param product
     * @return 结果
     */
    @Override
    public void update(Product product) {
        log.info("ProductFacadeImpl.update:入参：product:{}", JSON.toJSON(product));
        productMapper.updateByPrimaryKeySelective(product);
    }

    /**
     * 修改信息
     *
     * @param product
     * @return 结果
     */
    @Override
    public void updateById(Product product) {
        log.info("ProductFacadeImpl.updateById:入参：product:{}", JSON.toJSON(product));
        productMapper.updateByPrimaryKeySelective(product);
    }

    /**
     * 删除信息
     *
     * @param id 需要删除的ID
     * @return 结果
     */
    @Override
    public void deleteById(Long id) {

        log.info("ProductFacadeImpl.deleteById:入参：id:{}", id);
        productMapper.deleteByPrimaryKey(id);
    }

}
