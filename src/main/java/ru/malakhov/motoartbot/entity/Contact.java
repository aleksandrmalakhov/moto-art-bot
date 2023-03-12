package ru.malakhov.motoartbot.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contacts")
@EqualsAndHashCode(exclude = "id")
public class Contact {
    @Id
    private Long id;

    @Email
    private String email;

    @Pattern(regexp="^((\\+7|7|8)+([0-9]){10})$")
    private String phone;

    @OneToOne
    @MapsId
    @JoinColumn(name = "client_id")
    private Client client;
}
