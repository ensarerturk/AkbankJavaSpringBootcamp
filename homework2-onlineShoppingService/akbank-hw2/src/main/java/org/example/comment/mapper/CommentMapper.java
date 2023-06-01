package org.example.comment.mapper;

import org.example.comment.Comment;
import org.example.comment.dto.CommentDTO;
import org.example.comment.dto.CommentSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/*
 * Defines a data transformation interface called CommentMapper.
 * It enables conversions between Comment and CommentDTO with the MapStruct library.
 * */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment toEntity(CommentSaveDTO commentSaveDTODTO);

    CommentDTO toDTO(Comment comment);

    List<CommentDTO> toDTOList(List<Comment> commentList);
}