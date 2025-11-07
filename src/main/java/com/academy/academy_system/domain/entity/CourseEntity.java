package com.academy.academy_system.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity extends  BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Long id;

    @Column(unique = true, nullable = false, name = "name_course")
    private String name;

    @Column(nullable = false)
    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @OneToMany(mappedBy = "course",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<EnrollEntity> enrolls;


    @OneToMany(mappedBy = "course",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<TaskEntity> tasks;

    @Override
    public String toString() {
        return "CourseEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                '}';
    }
}
