package ru.malakhov.motoartbot.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@Table(name = "bikes")
@EqualsAndHashCode(exclude = "id")
public class Bike {
    @Id
    private Long id;
    private String name;
    private String model;
    private Integer costPerHour;

    public Bike() {
    }
}