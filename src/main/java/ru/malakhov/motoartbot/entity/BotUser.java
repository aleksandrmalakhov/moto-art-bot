package ru.malakhov.motoartbot.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bot_users")
@EqualsAndHashCode(exclude = "id")
public class BotUser {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;

    @DateTimeFormat
    private LocalDateTime dateCreate;

    @PrimaryKeyJoinColumn
    @OneToOne(mappedBy = "botUser", cascade = CascadeType.ALL)
    private Client client;
}