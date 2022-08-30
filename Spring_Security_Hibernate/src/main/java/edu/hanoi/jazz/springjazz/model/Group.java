package edu.hanoi.jazz.springjazz.model;

import javax.persistence.*;

@Entity
@Table(name = "hn_group",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id")
        })
public class Group {


    private Integer id;

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
