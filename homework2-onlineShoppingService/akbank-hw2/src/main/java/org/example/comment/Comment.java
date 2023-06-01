package org.example.comment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.general.BaseEntity;

/*
 * It is an entity class named Comment.
 * Each comment has an id (productId), customer id (customerId), comment text, and title fields.
 * This class is used to represent and manage comment data.
 * */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Comment", sequenceName = "COMMENT_ID_SEQ")
    private Long id;

    @Column(name = "PRODUCT_ID", length = 200, nullable = false)
    private Long productId;

    @Column(name = "CUSTOMER_ID", length = 200, nullable = false)
    private Long customerId;

    @Column(name = "COMMENT", length = 300)
    private String comment;

    @Column(name = "TITLE", length = 100)
    private String title;

}
