package org.example.comment.service;

import org.example.comment.Comment;
import org.example.comment.repository.CommentRepository;
import org.example.general.exception.CommentNotFoundException;
import org.example.general.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* It contains a service class named CommentEntityService.
* This class performs the business logic associated with the Comment entity and
* manages database operations through the CommentRepository.
* If no comments are found for the specified product or customer, it will throw a CommentNotFoundException.
* */

@Service
public class CommentEntityService extends BaseEntityService<Comment, CommentRepository> {
    public CommentEntityService(CommentRepository repository) {
        super(repository);
    }

    // Provides the necessary methods to find reviews based on a specific product ID.
    public List<Comment> findAllByProductId(Long id){
        List<Comment> allByProductId = getRepository().findAllByProductId(id);
        if (allByProductId.isEmpty()){
            throw new CommentNotFoundException(id + "  ürüne henüz bir yorum yazılmamıştır");
        }
        return allByProductId;
    }

    // provides the necessary methods to find reviews by customer ID.
    public List<Comment> findAllByCustomerId(Long id){
        List<Comment> allByCustomerId = getRepository().findAllByCustomerId(id);
        if (allByCustomerId.isEmpty()){
            throw new CommentNotFoundException(id + " kullanıcı henüz bir yorum yazmamıştır”");
        }
        return allByCustomerId;
    }
}