package ru.malakhov.motoartbot.service;

import ru.malakhov.motoartbot.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client save(Client client);

    Optional<Client> findById(long id);

    List<Client> findAll();
}