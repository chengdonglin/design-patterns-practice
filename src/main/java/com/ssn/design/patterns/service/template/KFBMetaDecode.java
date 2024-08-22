package com.ssn.design.patterns.service.template;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author linchengdong
 * @Date 2024-08-22 18:31
 * @PackageName:com.ssn.design.patterns.service.template
 * @ClassName: JFMetaDecode
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
@Component
public class KFBMetaDecode extends AbstractMetaDecode{
    @Override
    public FileMeta parse(String filePath) {
        log.info("JF格式文件解析元数据");
        return new FileMeta(10000,10000,20);
    }

    @Override
    public String type() {
        return "KFB";
    }
}
