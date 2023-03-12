package ru.malakhov.motoartbot.service.imp;

import org.springframework.stereotype.Service;
import ru.malakhov.motoartbot.entity.BotUser;
import ru.malakhov.motoartbot.repository.BotUserRepository;
import ru.malakhov.motoartbot.service.BotUserService;

import java.util.List;
import java.util.Optional;

@Service
public class BotUserServiceImp implements BotUserService {
    private final BotUserRepository repository;

    public BotUserServiceImp(BotUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(BotUser botUser) {
        repository.save(botUser);
    }

    @Override
    public Optional<BotUser> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<BotUser> findAll() {
        return repository.findAll();
    }
}