package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

//@Data
@Getter
@Setter
@Entity
@Table(name = "class")
public class SchoolClass extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int classId;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;

    @OneToMany(mappedBy = "schoolClass")
    // fetch = FetchType.EAGER,
    //            cascade = CascadeType.PERSIST, targetEntity = Person.class fetch = FetchType.EAGER,
    //            cascade = CascadeType.PERSIST, targetEntity = Person.class
    @JsonIgnore
    private Set<Person> persons;

    public Set<Person> getPersons() {
        return persons;
    }

//    //public void setPersons(Set<Person> persons) {
//        this.persons = persons;
//    }

}
