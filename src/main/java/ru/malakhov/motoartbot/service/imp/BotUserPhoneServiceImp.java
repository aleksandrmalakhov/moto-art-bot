package ru.malakhov.motoartbot.service.imp;

import org.springframework.stereotype.Service;
import ru.malakhov.motoartbot.entity.BotUser;
import ru.malakhov.motoartbot.entity.BotUserPhone;
import ru.malakhov.motoartbot.entity.Client;
import ru.malakhov.motoartbot.entity.Contact;
import ru.malakhov.motoartbot.repository.BotUserPhoneRepository;
import ru.malakhov.motoartbot.repository.ClientRepository;
import ru.malakhov.motoartbot.service.BotUserPhoneService;

import java.util.Optional;

@Service
public class BotUserPhoneServiceImp implements BotUserPhoneService {
    private final BotUserPhoneRepository phoneRepository;
    private final ClientRepository clientRepository;

    public BotUserPhoneServiceImp(BotUserPhoneRepository phoneRepository,
                                  ClientRepository clientRepository) {
        this.phoneRepository = phoneRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Contact> findContactByPhone(String phone) {
        var phoneOptional = phoneRepository.findByPhone(phone);
        return phoneOptional.map(BotUserPhone::getContact);
    }

    @Override
    public Optional<Client> findClientByPhone(String phone) {
        var contact = this.findContactByPhone(phone);

        if (contact.isPresent()) {
            var client = clientRepository.findById(contact.get().getId());

            if (client.isPresent()) {
                return client;
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<BotUser> findBotUserByPhone(String phone) {
        var contact = this.findContactByPhone(phone);
        return contact.map(Contact::getBotUser);
    }
}