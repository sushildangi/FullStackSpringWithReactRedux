package org.pyarts.projectmanagementtool.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
@Setter
@Getter
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDate createdAt;
    private LocalDate updatedAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDate.now();
    }

    @PreUpdate
    protected  void onUpdate(){
        this.updatedAt = LocalDate.now();
    }
}
