package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Candidate {

    @EmbeddedId
    ChavesPKFK id;

    @Column(nullable = false)
    @NotNull
    private Integer status;

    @CreatedDate
    @Column()
    @NotNull
    private LocalTime createdAt;


}