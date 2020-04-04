package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Acceleration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    @NotNull
    @Size(max = 100)
    private String name;

    @Column()
    @NotNull
    @Size(max = 50)
    private String slug;

    @ManyToOne
    private Challenge challenge;

    @CreatedDate
    @Column()
    @NotNull
        private LocalTime createdAt;

    @OneToMany(mappedBy = "id.acceleration")
    private Set<Candidate> candidates;


}