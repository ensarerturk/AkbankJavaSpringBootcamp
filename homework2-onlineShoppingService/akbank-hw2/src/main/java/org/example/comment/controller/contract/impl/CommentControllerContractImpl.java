package org.example.comment.controller.contract.impl;

import lombok.RequiredArgsConstructor;
import org.example.comment.Comment;
import org.example.comment.controller.contract.CommentControllerContract;
import org.example.comment.dto.CommentDTO;
import org.example.comment.dto.CommentSaveDTO;
import org.example.comment.mapper.CommentMapper;
import org.example.comment.service.CommentEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Contains the Comment ControllerContractImpl class that implements the Comment Controller Contract interface.
 * This class implements methods that perform operations on comments.
 * */

@Service
@RequiredArgsConstructor
public class CommentControllerContractImpl implements CommentControllerContract {

    private final CommentEntityService entityService;

    @Override
    public CommentDTO save(CommentSaveDTO commentSaveDTO) {
        Comment entity = CommentMapper.INSTANCE.toEntity(commentSaveDTO);
        entity = entityService.save(entity);
        return CommentMapper.INSTANCE.toDTO(entity);
    }

    @Override
    public List<CommentDTO> findAll() {
        List<Comment> commentList = entityService.findAll();
        return CommentMapper.INSTANCE.toDTOList(commentList);
    }

    @Override
    public void delete(Long id) {
        entityService.delete(id);
    }

    @Override
    public List<CommentDTO> findAllByProductId(Long id) {
        List<Comment> allByProductId = entityService.findAllByProductId(id);
        return CommentMapper.INSTANCE.toDTOList(allByProductId);
    }

    @Override
    public List<CommentDTO> findAllByCustomerId(Long id) {
        List<Comment> allByCustomerId = entityService.findAllByCustomerId(id);
        return CommentMapper.INSTANCE.toDTOList(allByCustomerId);
    }
}