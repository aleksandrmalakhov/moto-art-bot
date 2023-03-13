package ru.malakhov.motoartbot.service;

import ru.malakhov.motoartbot.entity.BotUser;
import ru.malakhov.motoartbot.entity.Client;
import ru.malakhov.motoartbot.entity.Contact;

import java.util.Optional;

public interface BotUserEmailService {
    Optional<Contact> findContactByEmail(String email);
    Optional<Client> findClientByEmail(String email);

    Optional<BotUser> findBotUserByEmail(String email);
}