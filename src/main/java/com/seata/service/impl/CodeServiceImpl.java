package com.seata.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.seata.entity.Code;
import com.seata.mapper.CodeMapper;
import com.seata.service.CodeService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 *
 * @author wz
 * @date 2023-09-28 15:12:29
 */
@Service
@Slf4j
@DS("test")
@Transactional
public class CodeServiceImpl implements CodeService {

    @Resource
    private CodeMapper codeMapper;
    @Resource
    private RedissonClient redisson;

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    @Override
    public Code info(Long id) {

        log.info("CodeServiceImpl.info:入参：id:{}", id);
        Code account = codeMapper.selectByPrimaryKey(id);
        return account;
    }

    /**
     * 详细信息
     *
     * @param id ID
     * @return 结果
     */
    @Override
    public Code getById(Long id) {

        log.info("CodeServiceImpl.getById:入参：id:{}", id);
        return codeMapper.selectByPrimaryKey(id);
    }

    /**
     * 保存信息
     *
     * @param code
     * @return 结果
     */
    @Override
    public void insert(Code code) {

        log.info("CodeServiceImpl.insert:入参：code:{}", JSON.toJSON(code));

        Code code1 = new Code();
        List<Code> codes = new ArrayList<>();
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMddHHmmssS");
        code1.setType(1);
        code1.setCode(dateFormat1.format(new Date()));
        codes.add(code1);

        Code code2 = new Code();
        code2.setType(2);
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmm");
        String date = dateFormat2.format(new Date());
        DecimalFormat decimalFormat = new DecimalFormat("00000");
        String numFormat = decimalFormat.format(incr("key", ChronoUnit.SECONDS.getDuration()));
        StringBuilder sb = new StringBuilder();
        sb.append(date);
        sb.append(numFormat);
        code2.setCode(sb.toString());
        codes.add(code2);
        codeMapper.batchInsert(codes);
    }

    /**
     * 修改信息
     *
     * @param code
     * @return 结果
     */
    @Override
    public void update(Code code) {
        log.info("CodeServiceImpl.update:入参：code:{}", JSON.toJSON(code));
        codeMapper.updateByPrimaryKeySelective(code);
    }

    /**
     * 修改信息
     *
     * @param code
     * @return 结果
     */
    @Override
    public void updateById(Code code) {
        log.info("CodeServiceImpl.updateById:入参：code:{}", JSON.toJSON(code));
        codeMapper.updateByPrimaryKeySelective(code);
    }

    /**
     * 删除信息
     *
     * @param id 需要删除的ID
     * @return 结果
     */
    @Override
    public void deleteById(Long id) {

        log.info("CodeServiceImpl.deleteById:入参：id:{}", id);
        codeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 自增
     *
     * @param key
     * @return
     */
    public long incr(String key, Duration duration) {
        RAtomicLong atomicVar = redisson.getAtomicLong(key);
        if (!atomicVar.isExists()) {
            atomicVar.set(0);
        }
        long value = atomicVar.incrementAndGet();
        atomicVar.expire(duration);
        return value;
    }
}
