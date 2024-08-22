package com.ssn.design.patterns.service.template;

/**
 * @Author linchengdong
 * @Date 2024-08-22 18:25
 * @PackageName:com.ssn.design.patterns.service.template
 * @ClassName: FileMetaDecode
 * @Description: TODO
 * @Version 1.0
 */
public interface FileMetaDecode {


    void decode(String filePath);


    String type();
}
