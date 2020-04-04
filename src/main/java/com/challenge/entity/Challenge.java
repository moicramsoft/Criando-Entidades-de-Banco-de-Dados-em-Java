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
public class Challenge {

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

    @CreatedDate
    @NotNull
    @Column()
    private LocalTime createdAt;

    @OneToMany(mappedBy = "challenge")
    private Set<Acceleration> accelerations;

    @OneToMany(mappedBy = "id.challenge")
    private Set<Submission> submissions;

}