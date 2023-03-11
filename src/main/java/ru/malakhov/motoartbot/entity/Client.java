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
