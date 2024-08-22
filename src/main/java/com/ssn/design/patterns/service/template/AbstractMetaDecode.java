package com.ssn.design.patterns.service.template;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author linchengdong
 * @Date 2024-08-22 18:26
 * @PackageName:com.ssn.design.patterns.service.template
 * @ClassName: AbstractMetaDecode
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
public abstract class AbstractMetaDecode implements FileMetaDecode{
    @Override
    public void decode(String filePath) {
        before();
        checkFileExist(filePath);
        FileMeta fileMeta = parse(filePath);
        saveMeta(fileMeta);
        after();
    }

    public abstract void before();

    public abstract void after();

    public void checkFileExist(String filePath) {
        log.info("检查文件是否存在");
    }

    public abstract FileMeta parse(String filePath);

    public void saveMeta(FileMeta meta) {
        log.info("保存数据库 {}",meta);
    }
}
