package com.academy.academy_system.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Table(name = "Enrolls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enroll")
    private Long id;


    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course")
    private CourseEntity course;

    // Getters and Setters


    @Override
    public String toString() {
        return "EnrollEntity{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", user=" + user +
                ", course=" + course +
                '}';
    }
}
