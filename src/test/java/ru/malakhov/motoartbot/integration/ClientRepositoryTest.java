package ru.malakhov.motoartbot.integration;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.malakhov.motoartbot.entity.Client;
import ru.malakhov.motoartbot.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;

    private static Client[] clients;

    @BeforeAll
    public static void beforeAll(){
        clients = new Client[2];

//        clients[0] = Client.builder().firstName("John").lastName("Doe").phone("+1-555-555-5555").email("johndoe@example.com").build();
//        clients[1] = Client.builder().firstName("Jane").lastName("Doe").phone("+1-555-555-5556").email("janedoe@example.com").build();
    }

    @Before
    public void setUp() {
        clientRepository.deleteAll();
    }

    @Test
    public void testSaveClient() {
        Client client = clients[0];

        clientRepository.save(client);

        assertThat(client.getId()).isNotNull();
        assertThat(clientRepository.findById(client.getId())).isNotEmpty().hasValue(client);
    }

    @Test
    public void testFindAllClients() {
        Client client1 = clients[0];
        clientRepository.save(client1);

        Client client2 = clients[1];
        clientRepository.save(client2);

        List<Client> clients = clientRepository.findAll();

        assertThat(clients).hasSize(2);
        assertThat(clients).contains(client1, client2);
    }

    @Test
    public void testFindClientById() {
        Client client = clients[0];
        clientRepository.save(client);

        Optional<Client> foundClient = clientRepository.findById(client.getId());

        assertThat(foundClient).isNotEmpty().hasValue(client);
    }
}