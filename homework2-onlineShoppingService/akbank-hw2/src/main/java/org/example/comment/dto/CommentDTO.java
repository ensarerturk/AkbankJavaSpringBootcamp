package org.example.comment.dto;

/*
 * Defines a data transfer object named CommentDTO.
 * This object contains certain fields of the Comment entity and is used to get and set these fields.
 * */

public record CommentDTO(Long id,
                         Long productId,
                         Long customerId,
                         String comment,
                         String title) {
}