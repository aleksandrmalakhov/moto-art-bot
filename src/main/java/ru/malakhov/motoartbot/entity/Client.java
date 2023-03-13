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
@Table(name = "clients")
@EqualsAndHashCode(exclude = "id")
public class Client {
    @Id
    private Long id;
    private String firstName;
    private String lastName;

    @DateTimeFormat
    private LocalDateTime dateCreate;

    @MapsId
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private BotUser botUser;
}