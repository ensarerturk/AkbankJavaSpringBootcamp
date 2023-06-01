package org.example.general;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/*It is an abstract class that can be extended by other classes and provides some basic properties.
 * The BaseEntity class supports serialization and cloning of objects by implementing the "Serializable" and "Cloneable" interfaces.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable, Cloneable, BaseEntityModel {

    @Embedded
    private BaseAdditionalFields baseAdditionalFields;

}