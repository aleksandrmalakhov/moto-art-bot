package ru.malakhov.motoartbot.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@Table(name = "clients")
@EqualsAndHashCode(exclude = "id")
public class Client {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public Client() {
    }
}
