package com.example.clinic.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pets")
public class Pet<Visit> extends BaseEntity{

    @Column(name = "name")
    private String name;

    @ManyToMany
    @Column(name = "type_id")
    private String petType;

    @ManyToMany
    @Column(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();


    @Builder
    public Pet(String name, String petType, Owner owner, LocalDate birthDate) {
        this.name = name;
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;

        if (visits == null || visits.size() > 0 ) {
            this.visits = visits;
        }
    }

    public String getName() {
        return getName();
    }
}
