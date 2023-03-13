package ru.malakhov.motoartbot.service;

import ru.malakhov.motoartbot.entity.BotUser;
import ru.malakhov.motoartbot.entity.Client;
import ru.malakhov.motoartbot.entity.Contact;

import java.util.Optional;

public interface BotUserPhoneService {
    Optional<Contact> findContactByPhone(String phone);
    Optional<Client> findClientByPhone(String phone);

    Optional<BotUser> findBotUserByPhone(String phone);
}