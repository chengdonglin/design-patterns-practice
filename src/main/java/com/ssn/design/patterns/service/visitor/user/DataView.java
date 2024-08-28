package com.ssn.design.patterns.service.visitor.user;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author linchengdong
 * @Date 2024-08-23 15:21
 * @PackageName:com.ssn.design.patterns.service.visitor.user
 * @ClassName: DataView
 * @Description: TODO
 * @Version 1.0
 */
public class DataView {

    List<User> userList = new ArrayList<>();

    public DataView() {
        userList.add(new Student("A","普通班","高一1班"));
        userList.add(new Student("B","重点班","高一2班"));
        userList.add(new Student("C","重点班","高一3班"));
        userList.add(new Teacher("D","普通班","高一1班"));
        userList.add(new Teacher("E","重点班","高一2班"));
        userList.add(new Teacher("F","艺术班","高一3班"));
    }

    public void show(UserVisitor visitor) {
        for (User user : userList) {
            user.accept(visitor);
        }
    }
}
