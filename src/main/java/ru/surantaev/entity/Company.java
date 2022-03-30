package ru.surantaev.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "company_base", schema = "home_task_base", catalog = "postgres")
public class Company {

    @Id
    @SequenceGenerator(name = "company_id", sequenceName = "company_sequence", allocationSize = 1, schema = "home_task_base")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_id")
    private int id;

    @Column(name = "company_name")
    private String name;

    @Column(name = "located_country")
    private String locatedCountry;

    //Связь с таблицой Course
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> course;

    public Company(String name, String locatedCountry) {
        this.name = name;
        this.locatedCountry = locatedCountry;
    }
}
