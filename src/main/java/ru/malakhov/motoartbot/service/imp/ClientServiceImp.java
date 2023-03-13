package ru.malakhov.motoartbot.service.imp;

import org.springframework.stereotype.Service;
import ru.malakhov.motoartbot.entity.Client;
import ru.malakhov.motoartbot.repository.ClientRepository;
import ru.malakhov.motoartbot.service.ClientService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService {
    private final ClientRepository repository;

    public ClientServiceImp(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client save(Client client) {
        return repository.save(client);
    }

    @Override
    public Optional<Client> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }
}