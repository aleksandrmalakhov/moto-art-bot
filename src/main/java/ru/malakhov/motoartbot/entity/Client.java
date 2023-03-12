package ru.malakhov.motoartbot.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
@EqualsAndHashCode(exclude = "id")
public class Client {
    @Id
    private Long id;
    private String firstName;
    private String lastName;

    @Valid
    @PrimaryKeyJoinColumn
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Contact contacts;

    @DateTimeFormat
    private LocalDateTime dateCreate;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private BotUser botUser;
}