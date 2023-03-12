package ru.malakhov.motoartbot.service;

import ru.malakhov.motoartbot.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    void save(Contact contact);

    Optional<Contact> findById(long id);

    Optional<Contact> findByEmail(String email);

    Optional<Contact> findByPhone(String phone);

    List<Contact> findAll();
}