package com.example.blog_application.repository;

import com.example.blog_application.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {


//    @Query(value = "select '*' from Blog b where b.blogName like concat('%' , :blogName , '%') or b.writer like concat('%', :writer , '%') ")
//    Page<Blog> findByBlogNameContainingOAndWriterOrOrderByBlogName(@Param("blogName") String blogName, @Param("writer") String writer, Pageable pageable);
}
