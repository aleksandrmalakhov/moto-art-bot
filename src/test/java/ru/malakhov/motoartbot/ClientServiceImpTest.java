package ru.malakhov.motoartbot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.malakhov.motoartbot.entity.Client;
import ru.malakhov.motoartbot.repository.ClientRepository;
import ru.malakhov.motoartbot.service.imp.ClientServiceImp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ClientServiceImpTest {
    private ClientServiceImp service;
    @Mock
    private ClientRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new ClientServiceImp(repository);
    }

    @Test
    public void save_ShouldCallRepositorySave() {
        Client client = new Client();

        service.save(client);

        verify(repository, times(1)).save(client);
    }

    @Test
    public void findById_ShouldReturnClient_WhenClientExists() {
        long clientId = 1L;
        Client client = new Client();
        when(repository.findById(clientId)).thenReturn(Optional.of(client));

        Optional<Client> result = service.findById(clientId);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(client, result.get());
    }

    @Test
    public void findById_ShouldReturnEmpty_WhenClientDoesNotExist() {
        long clientId = 1L;
        when(repository.findById(clientId)).thenReturn(Optional.empty());

        Optional<Client> result = service.findById(clientId);

        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void findAll_ShouldReturnAllClients() {
        Client client1 = new Client();
        Client client2 = new Client();
        List<Client> clients = Arrays.asList(client1, client2);
        when(repository.findAll()).thenReturn(clients);

        List<Client> result = service.findAll();

        Assertions.assertEquals(clients, result);
    }
}
