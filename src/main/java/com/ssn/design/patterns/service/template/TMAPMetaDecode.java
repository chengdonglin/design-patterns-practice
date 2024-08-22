package com.ssn.design.patterns.service.template;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author linchengdong
 * @Date 2024-08-22 19:12
 * @PackageName:com.ssn.design.patterns.service.template
 * @ClassName: TMAPMetaDecode
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
@Component
public class TMAPMetaDecode extends AbstractMetaDecode{
    @Override
    public FileMeta parse(String filePath) {
       log.info("TMAP格式元数据解析");
        return new FileMeta(20000,2000,40);
    }

    @Override
    public String type() {
        return "TMAP";
    }
}
