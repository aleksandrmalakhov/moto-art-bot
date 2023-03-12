package ru.malakhov.motoartbot.service.imp;

import org.springframework.stereotype.Service;
import ru.malakhov.motoartbot.entity.Contact;
import ru.malakhov.motoartbot.repository.ContactRepository;
import ru.malakhov.motoartbot.service.ContactService;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImp implements ContactService {
    private final ContactRepository repository;

    public ContactServiceImp(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Contact contact) {
        repository.save(contact);
    }

    @Override
    public Optional<Contact> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Contact> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Optional<Contact> findByPhone(String phone) {
        return repository.findByPhone(phone);
    }

    @Override
    public List<Contact> findAll() {
        return repository.findAll();
    }
}