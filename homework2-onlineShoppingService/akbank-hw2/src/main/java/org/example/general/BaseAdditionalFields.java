package org.example.general;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/*This class is used to store the creation and update information of a record kept in the database.*/

@Embeddable
@Getter
@Setter
public class BaseAdditionalFields {

    @Column(name = "ID_CUSTOMER_CREATED_BY")
    private Long createdBy;

    @Column(name = "ID_CUSTOMER_UPDATE_BY")
    private Long updatedBy;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;
}