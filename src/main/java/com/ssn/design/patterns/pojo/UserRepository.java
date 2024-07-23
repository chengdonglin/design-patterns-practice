package com.ssn.design.patterns.pojo;

import com.ssn.design.patterns.repo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo,Integer> {

    UserInfo findByUsername(String username);

    UserInfo findByUsernameAndUserPassword(String account,String password);
}
