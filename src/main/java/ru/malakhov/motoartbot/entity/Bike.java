package ru.malakhov.motoartbot.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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