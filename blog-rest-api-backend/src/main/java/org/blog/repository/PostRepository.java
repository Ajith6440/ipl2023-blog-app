package org.blog.repository;

import org.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JPARepository
//CRUDRepository
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}

