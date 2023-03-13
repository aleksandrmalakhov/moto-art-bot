package ru.malakhov.motoartbot.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "contacts")
@EqualsAndHashCode(exclude = "id")
public class Contact {
    @Id
    private Long id;

    @MapsId
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private BotUser botUser;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BotUserPhone> phones;
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BotUserEmail> emails;

    public Contact() {
        this.phones = new ArrayList<>();
        this.emails = new ArrayList<>();
    }

    public void addPhone(BotUserPhone phone) {
        if (phones == null) {
            phones = new ArrayList<>();
        }

        if (!phones.contains(phone)) {
            phone.setContact(this);
            phones.add(phone);
        }
    }

    public void removePhone(BotUserPhone phone) {
        if (phones.contains(phone)) {
            phones.remove(phone);
            phone.setPhone(null);
        }
    }

    public void addEmail(BotUserEmail email) {
        if (emails == null) {
            emails = new ArrayList<>();
        }

        if (!emails.contains(email)) {
            email.setContact(this);
            emails.add(email);
        }
    }

    public void removeEmail(BotUserEmail email) {
        if (emails.contains(email)) {
            emails.remove(email);
            email.setEmail(null);
        }
    }
}