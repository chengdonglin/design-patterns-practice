package com.ssn.design.patterns.service.template;

import lombok.Data;

/**
 * @Author linchengdong
 * @Date 2024-08-22 18:29
 * @PackageName:com.ssn.design.patterns.service.template
 * @ClassName: FileMeta
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class FileMeta {

    private Integer height;

    private Integer width;

    private Integer maxScale;

    public FileMeta(Integer height, Integer width, Integer maxScale) {
        this.height = height;
        this.width = width;
        this.maxScale = maxScale;
    }
}
