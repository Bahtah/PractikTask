package ru.surantaev.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.surantaev.enam.StudyFormat;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "student_base", schema = "home_task_base", catalog = "postgres")
public class Student {

    @Id
    @SequenceGenerator(name = "student_id", sequenceName = "student_sequence", allocationSize = 1, schema = "home_task_base")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id")
    private int id;

    @Column(name = "student_fName")
    private String firstName;

    @Column(name = "student_lName")
    private String lastName;

    @Column(name = "student_email")
    private String email;

    @Column(name = "study_format")
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;

    //Связь с таблицой Group

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;

    public Student(String firstName, String lastName, String email, StudyFormat studyFormat) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studyFormat = studyFormat;
    }
}
