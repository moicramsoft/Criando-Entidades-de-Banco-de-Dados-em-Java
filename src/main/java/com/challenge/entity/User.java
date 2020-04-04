package com.challenge.entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    @NotNull
    @Size(max = 100)
    private String fullName;

    @Column()
    @Size(max = 100)
    @NotNull
    @Email
    private String email;

    @Column()
    @NotNull
    @Size(max = 50)
    private String nickname;

    @Column()
    @NotNull
    @Size(max = 255)
    private String password;

    @CreatedDate
    @NotNull
    @Column()
    private LocalTime createdAt;

    @OneToMany(mappedBy = "id.user")
    private Set<Submission> submissions;

    @OneToMany(mappedBy = "id.user")
    private Set<Candidate> candidates;


}