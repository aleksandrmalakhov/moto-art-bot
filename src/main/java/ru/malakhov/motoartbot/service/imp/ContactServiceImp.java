package ru.malakhov.motoartbot.service.imp;

import org.springframework.stereotype.Service;
import ru.malakhov.motoartbot.entity.Contact;
import ru.malakhov.motoartbot.repository.ContactRepository;
import ru.malakhov.motoartbot.service.BotUserEmailService;
import ru.malakhov.motoartbot.service.BotUserPhoneService;
import ru.malakhov.motoartbot.service.ContactService;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImp implements ContactService {
    private final ContactRepository repository;
    private final BotUserPhoneService phoneService;
    private final BotUserEmailService emailService;

    public ContactServiceImp(ContactRepository repository,
                             BotUserPhoneService phoneService,
                             BotUserEmailService emailService) {
        this.repository = repository;
        this.phoneService = phoneService;
        this.emailService = emailService;
    }

    @Override
    public Contact save(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public Optional<Contact> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Contact> findByEmail(String email) {
        return emailService.findContactByEmail(email);
    }

    @Override
    public Optional<Contact> findByPhone(String phone) {
        return phoneService.findContactByPhone(phone);
    }

    @Override
    public List<Contact> findAll() {
        return repository.findAll();
    }
}