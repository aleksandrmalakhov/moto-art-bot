package ru.malakhov.motoartbot.service;

import ru.malakhov.motoartbot.entity.BotUser;

import java.util.List;
import java.util.Optional;

public interface BotUserService {
    BotUser save(BotUser botUser);

    Optional<BotUser> findById(long id);

    List<BotUser> findAll();

    long deleteAll();
}
