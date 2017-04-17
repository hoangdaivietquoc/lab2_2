package com.polytech.repository;

import com.polytech.business.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by daivietquochoang on 16/04/2017.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
