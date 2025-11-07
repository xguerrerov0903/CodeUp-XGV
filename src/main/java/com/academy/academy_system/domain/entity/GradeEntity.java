package com.academy.academy_system.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Grades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradeEntity extends  BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grade")
    private Long id;

    private Double score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_task")
    private TaskEntity task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UserEntity user;


    @Override
    public String toString() {
        return "GradeEntity{" +
                "id=" + id +
                ", score=" + score +
                ", task=" + task +
                ", user=" + user +
                '}';
    }
}
