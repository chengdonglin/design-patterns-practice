package com.ssn.design.patterns.service.visitor.simple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author linchengdong
 * @Date 2024-08-23 14:32
 * @PackageName:com.ssn.design.patterns.service.visitor.simple
 * @ClassName: ObjectStructure
 * @Description: 对象结构
 * @Version 1.0
 */
public class ObjectStructure {

    private List<Element> list = new ArrayList<>();

    public void accept(Visitor visitor) {
        for (Element next : list) {
            next.accept(visitor);
        }
    }

    public void add(Element element) {
        list.add(element);
    }

    public void remove(Element element) {
        list.remove(element);
    }

}
