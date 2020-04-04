package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ChavesPKFK implements Serializable {

    @ManyToOne
    private User user;

    @ManyToOne
    private Acceleration acceleration;

    @ManyToOne
    private Company company;

}