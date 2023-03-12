package ru.malakhov.motoartbot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.malakhov.motoartbot.entity.BotUser;
import ru.malakhov.motoartbot.repository.BotUserRepository;
import ru.malakhov.motoartbot.service.imp.BotUserServiceImp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BotUserServiceTest {
    private BotUserServiceImp service;
    @Mock
    private BotUserRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new BotUserServiceImp(repository);
    }

    @Test
    public void save_ShouldCallRepositorySave() {
        BotUser botUser = new BotUser();

        repository.save(botUser);

        verify(repository, times(1)).save(botUser);
    }


    @Test
    public void findById_ShouldReturnBotUserWhenBotUserExists() {
        long botUserId = 1L;
        BotUser botUser = new BotUser();

        when(repository.findById(botUserId)).thenReturn(Optional.of(botUser));

        Optional<BotUser> result = service.findById(botUserId);

        assertTrue(result.isPresent());
        assertEquals(botUser, result.get());
    }

    @Test
    public void findById_ShouldReturnEmptyWhenBotUsersDoesNotExist() {
        long botUserId = 1L;
        when(repository.findById(botUserId)).thenReturn(Optional.empty());

        Optional<BotUser> result = service.findById(botUserId);

        assertTrue(result.isEmpty());
    }

    @Test
    public void findAll_ShouldReturnAllBotUsers() {
        BotUser botUser1 = new BotUser();
        BotUser botUser2 = new BotUser();

        List<BotUser> botUsers = Arrays.asList(botUser1, botUser2);
        when(repository.findAll()).thenReturn(botUsers);

        List<BotUser> result = service.findAll();
        assertEquals(botUsers, result);
    }
}