package com.ssn.design.patterns.service.template;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.transaction.NotSupportedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author linchengdong
 * @Date 2024-08-22 19:22
 * @PackageName:com.ssn.design.patterns.service.template
 * @ClassName: MetaDecodeFactory
 * @Description: TODO
 * @Version 1.0
 */
@Component
public class MetaDecodeFactory {

    private Map<String,FileMetaDecode> META_DECODE_MAP ;

    public MetaDecodeFactory(List<FileMetaDecode> decodes) {
        META_DECODE_MAP = new HashMap<>(decodes.size());
        decodes.forEach(fileMetaDecode -> {
            META_DECODE_MAP.putIfAbsent(fileMetaDecode.type(),fileMetaDecode);
        });
    }

    @SneakyThrows
    public FileMetaDecode getMetaDecode(String fileType) {
        FileMetaDecode decode = META_DECODE_MAP.get(fileType);
        if (decode == null) {
            throw new NotSupportedException("不支持的文件格式");
        }
        return decode;
    }

}
