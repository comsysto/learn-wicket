package com.comsysto.repositories;

import com.comsysto.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author sekibomazic
 */
public interface PostRepository extends JpaRepository<Post, Long>,JpaSpecificationExecutor<Post>{

}