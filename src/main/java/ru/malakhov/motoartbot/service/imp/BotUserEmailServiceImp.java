package ru.malakhov.motoartbot.service.imp;

import org.springframework.stereotype.Service;
import ru.malakhov.motoartbot.entity.BotUser;
import ru.malakhov.motoartbot.entity.BotUserEmail;
import ru.malakhov.motoartbot.entity.Client;
import ru.malakhov.motoartbot.entity.Contact;
import ru.malakhov.motoartbot.repository.BotUserEmailRepository;
import ru.malakhov.motoartbot.repository.ClientRepository;
import ru.malakhov.motoartbot.service.BotUserEmailService;

import java.util.Optional;

@Service
public class BotUserEmailServiceImp implements BotUserEmailService {
    private final BotUserEmailRepository emailRepository;
    private final ClientRepository clientRepository;

    public BotUserEmailServiceImp(BotUserEmailRepository emailRepository
            , ClientRepository clientRepository) {
        this.emailRepository = emailRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Contact> findContactByEmail(String email) {
        var emailOptional = emailRepository.findByEmail(email);
        return emailOptional.map(BotUserEmail::getContact);
    }

    @Override
    public Optional<Client> findClientByEmail(String email) {
        var contact = this.findContactByEmail(email);

        if (contact.isPresent()) {
            var client = clientRepository.findById(contact.get().getId());

            if (client.isPresent()) {
                return client;
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<BotUser> findBotUserByEmail(String email) {
        var contact = this.findContactByEmail(email);
        return contact.map(Contact::getBotUser);
    }
}