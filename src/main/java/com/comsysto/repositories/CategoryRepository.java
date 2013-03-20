package com.comsysto.repositories;

import com.comsysto.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author sekibomazic
 */
public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category>{

    @Query("SELECT c FROM Category c WHERE LOWER(c.name) = LOWER(:name)")
    public List<Category> findByName(@Param("name") String name);

}