package com.ecoproj.ecommerce.dao;

import com.ecoproj.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {
    // query method
    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

    // also query method behind the scene with logic: {select * from product p where p.name like concat('%', : name, '%')}
    Page<Product> findByNameContaining(@Param("name") String name, Pageable page);


}
