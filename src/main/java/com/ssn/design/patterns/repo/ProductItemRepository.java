package com.ssn.design.patterns.repo;

import com.ssn.design.patterns.pojo.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem,Integer> {

    @Modifying
    @Query(value = "insert into product_item(name, pid) values (?1, ?2)", nativeQuery = true)
    public void addItem(String name, int pid);
    @Modifying
    @Query(value = "delete from product_item where" + "id=?1 or pid=?1",nativeQuery = true)
    public void delItem(int id);

    public ProductItem findByNameAndPid(String name,int pid);
}
