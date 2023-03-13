package ru.malakhov.motoartbot.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_emails")
@EqualsAndHashCode(exclude = "id")
public class BotUserEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    private Contact contact;
}