package org.example.comment.dto;

// This object contains the fields required to create a new Comment entity.

public record CommentSaveDTO(Long productId,
                             Long customerId,
                             String comment,
                             String title) {
}