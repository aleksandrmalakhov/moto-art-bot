package ru.malakhov.motoartbot.integration;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.malakhov.motoartbot.entity.Bike;
import ru.malakhov.motoartbot.entity.Client;
import ru.malakhov.motoartbot.entity.Order;
import ru.malakhov.motoartbot.repository.BikeRepository;
import ru.malakhov.motoartbot.repository.ClientRepository;
import ru.malakhov.motoartbot.repository.OrderRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BikeRepository bikeRepository;
    @Autowired
    private ClientRepository clientRepository;

    private static Client[] clients;
    private static Bike[] bikes;

    @BeforeAll
    public static void beforeAll(){
        clients = new Client[2];
        bikes = new Bike[2];

//        clients[0] = Client.builder().firstName("John").lastName("Doe").phone("+1-555-555-5555").email("johndoe@example.com").build();
//        clients[1] = Client.builder().firstName("Jane").lastName("Doe").phone("+1-555-555-5556").email("janedoe@example.com").build();

        bikes[0] = Bike.builder().name("Harley-Davidson").model("Sportster").build();
        bikes[1] = Bike.builder().name("Honda").model("CBR").build();
    }

    @Before
    public void setUp() {
        orderRepository.deleteAll();
        bikeRepository.deleteAll();
        clientRepository.deleteAll();
    }

    @Test
    public void testSaveOrder() {
        Bike bike = bikes[0];
        bikeRepository.save(bike);

        Client client = clients[0];
        clientRepository.save(client);

        Order order = Order.builder()
                .bike(bike)
                .client(client)
                .date(LocalDate.now())
                .timeStart(LocalTime.of(10, 0))
                .timeStop(LocalTime.of(14, 0))
                .cost(100).build();
        orderRepository.save(order);

        assertThat(order.getId()).isNotNull();
        assertThat(orderRepository.findById(order.getId())).isNotEmpty().hasValue(order);
    }

    @Test
    public void testFindAllOrders() {
        Bike bike = bikes[0];
        bikeRepository.save(bike);

        Client client = clients[0];
        clientRepository.save(client);

        Order order1 = Order.builder()
                .bike(bike)
                .client(client)
                .date(LocalDate.now())
                .timeStart(LocalTime.of(10, 0))
                .timeStop(LocalTime.of(14, 0))
                .cost(100).build();
        orderRepository.save(order1);

        Order order2 = Order.builder()
                .bike(bike)
                .client(client)
                .date(LocalDate.now())
                .timeStart(LocalTime.of(14, 0))
                .timeStop(LocalTime.of(18, 0))
                .cost(100).build();
        orderRepository.save(order2);

        List<Order> orders = orderRepository.findAll();

        assertThat(orders).hasSize(2);
        assertThat(orders).contains(order1, order2);
    }

    @Test
    public void testDeleteOrder() {
        Bike bike = bikes[0];
        bikeRepository.save(bike);

        Client client = clients[0];
        clientRepository.save(client);

        Order order = Order.builder()
                .bike(bike)
                .client(client)
                .date(LocalDate.now())
                .timeStart(LocalTime.of(10, 0))
                .timeStop(LocalTime.of(14, 0))
                .cost(100).build();

        orderRepository.save(order);
        assertThat(orderRepository.findById(order.getId())).isPresent();

        orderRepository.delete(order);
        assertThat(orderRepository.findById(order.getId())).isEmpty();
    }

    @Test
    public void testFindByClient() {
        Bike bike = bikes[0];
        bikeRepository.save(bike);

        Client client = clients[0];
        clientRepository.save(client);

        Order order1 = Order.builder()
                .bike(bike)
                .client(client)
                .date(LocalDate.now())
                .timeStart(LocalTime.of(10, 0))
                .timeStop(LocalTime.of(14, 0))
                .cost(100).build();
        orderRepository.save(order1);

        Order order2 = Order.builder()
                .bike(bike)
                .client(client)
                .date(LocalDate.now())
                .timeStart(LocalTime.of(14, 0))
                .timeStop(LocalTime.of(18, 0))
                .cost(100).build();
        orderRepository.save(order2);

        List<Order> orders = orderRepository.findByClient(client);

        assertThat(orders).hasSize(2);
        assertThat(orders).contains(order1, order2);
    }

    @Test
    public void testFindByBike() {
        Bike bike1 = bikes[0];
        bikeRepository.save(bike1);

        Bike bike2 = bikes[1];
        bikeRepository.save(bike2);

        Client client1 = clients[0];
        clientRepository.save(client1);

        Client client2 = clients[1];
        clientRepository.save(client2);

        Order order1 = Order.builder()
                .bike(bike1)
                .client(client1)
                .date(LocalDate.now())
                .timeStart(LocalTime.of(14, 0))
                .timeStop(LocalTime.of(18, 0))
                .cost(100).build();
        orderRepository.save(order1);

        Order order2 = Order.builder()
                .bike(bike1)
                .client(client2)
                .date(LocalDate.now())
                .timeStart(LocalTime.of(14, 0))
                .timeStop(LocalTime.of(18, 0))
                .cost(100).build();
        orderRepository.save(order2);

        Order order3 = Order.builder()
                .bike(bike2)
                .client(client1)
                .date(LocalDate.now())
                .timeStart(LocalTime.of(14, 0))
                .timeStop(LocalTime.of(18, 0))
                .cost(100).build();
        orderRepository.save(order3);

        List<Order> orders = orderRepository.findByBike(bike1);

        assertThat(orders).hasSize(2);
        assertThat(orders).contains(order1, order2);
    }

    @Test
    public void testFindByBikeAndTimeStart() {
        Bike bike = bikes[0];
        bikeRepository.save(bike);

        Client client = clients[0];
        clientRepository.save(client);

        Order order1 = Order.builder()
                .bike(bike)
                .client(client)
                .date(LocalDate.now())
                .timeStart(LocalTime.of(10, 0))
                .timeStop(LocalTime.of(14, 0))
                .cost(100).build();
        orderRepository.save(order1);

        Order order2 = Order.builder()
                .bike(bike)
                .client(client)
                .date(LocalDate.now())
                .timeStart(LocalTime.of(14, 0))
                .timeStop(LocalTime.of(18, 0))
                .cost(100).build();
        orderRepository.save(order2);

        List<Order> orders = orderRepository.findByBikeAndTimeStart(bike, LocalTime.of(10, 0));

        assertThat(orders).hasSize(1);
        assertThat(orders).contains(order1);
    }
}
