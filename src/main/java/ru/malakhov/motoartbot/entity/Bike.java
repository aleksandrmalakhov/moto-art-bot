package ru.malakhov.motoartbot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "bikes")
@EqualsAndHashCode(exclude = "id")
public class Bike {
    @Id
    private Long id;
    private String name;
    private String model;
}