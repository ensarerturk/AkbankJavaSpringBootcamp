package org.example.comment.controller.contract;

import org.example.comment.dto.CommentDTO;
import org.example.comment.dto.CommentSaveDTO;

import java.util.List;

/*
 * Contains methods that must be implemented by the CommentController class and define operations related to comments.
 * */

public interface CommentControllerContract {

    CommentDTO save(CommentSaveDTO commentSaveDTO);

    List<CommentDTO> findAll();

    void delete(Long id);

    List<CommentDTO> findAllByProductId(Long id);

    List<CommentDTO> findAllByCustomerId(Long id);
}
