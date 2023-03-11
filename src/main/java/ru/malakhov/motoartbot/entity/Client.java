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
@Table(name = "clients")
@EqualsAndHashCode(exclude = "id")
public class Client {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}
