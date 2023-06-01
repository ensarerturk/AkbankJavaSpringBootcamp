package org.example.comment.repository;

import org.example.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Defines a database access interface called CommentRepository.
 * It extends the JpaRepository class, providing the necessary methods to perform database operations on the Comment entity.
 * */

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // to fetch all products from specific product id
    List<Comment> findAllByProductId(Long id);

    // to fetch all customers from specific customer id
    List<Comment> findAllByCustomerId(Long id);
}