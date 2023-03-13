package ru.malakhov.motoartbot.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_phones")
@EqualsAndHashCode(exclude = "id")
public class BotUserPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp="^((\\+7|7|8)+([0-9]){10})$")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    private Contact contact;
}
