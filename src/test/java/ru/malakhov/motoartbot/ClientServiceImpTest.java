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
    private ClientServiceImp clientService;
    @Mock
    private ClientRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        clientService = new ClientServiceImp(repository);
    }

    @Test
    public void save_ShouldCallRepositorySave() {
        // Arrange
        Client client = new Client();
        // Act
        clientService.save(client);
        // Assert
        verify(repository, times(1)).save(client);
    }

    @Test
    public void findById_ShouldReturnClient_WhenClientExists() {
        // Arrange
        long clientId = 1L;
        Client client = new Client();
        when(repository.findById(clientId)).thenReturn(Optional.of(client));
        // Act
        Optional<Client> result = clientService.findById(clientId);
        // Assert
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(client, result.get());
    }

    @Test
    public void findById_ShouldReturnEmpty_WhenClientDoesNotExist() {
        // Arrange
        long clientId = 1L;
        when(repository.findById(clientId)).thenReturn(Optional.empty());
        // Act
        Optional<Client> result = clientService.findById(clientId);
        // Assert
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void findAll_ShouldReturnAllClients() {
        // Arrange
        Client client1 = new Client();
        Client client2 = new Client();
        List<Client> clients = Arrays.asList(client1, client2);
        when(repository.findAll()).thenReturn(clients);
        // Act
        List<Client> result = clientService.findAll();
        // Assert
        Assertions.assertEquals(clients, result);
    }
}
