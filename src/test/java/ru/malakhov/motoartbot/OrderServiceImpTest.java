package ru.malakhov.motoartbot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.malakhov.motoartbot.entity.Bike;
import ru.malakhov.motoartbot.entity.Client;
import ru.malakhov.motoartbot.entity.Order;
import ru.malakhov.motoartbot.repository.OrderRepository;
import ru.malakhov.motoartbot.service.imp.OrderServiceImp;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class OrderServiceImpTest {
    private OrderServiceImp service;

    @Mock
    private OrderRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new OrderServiceImp(repository);
    }

    @Test
    public void save_ShouldCallRepositorySave() {
        Order order = new Order();

        service.save(order);

        verify(repository, times(1)).save(order);
    }

    @Test
    public void findById_ShouldReturnOrder_WhenOrderExists() {
        long orderId = 1L;
        Order order = new Order();
        when(repository.findById(orderId)).thenReturn(Optional.of(order));

        Optional<Order> result = service.findById(orderId);

        assertTrue(result.isPresent());
        assertEquals(order, result.get());
    }

    @Test
    public void findById_ShouldReturnEmpty_WhenOrderDoesNotExist() {
        long orderId = 1L;
        when(repository.findById(orderId)).thenReturn(Optional.empty());

        Optional<Order> result = service.findById(orderId);

        assertTrue(result.isEmpty());
    }

    @Test
    public void findAll_ShouldReturnAllOrders() {
        Order order1 = new Order();
        Order order2 = new Order();
        List<Order> orders = Arrays.asList(order1, order2);

        when(repository.findAll()).thenReturn(orders);

        List<Order> result = service.findAll();

        assertEquals(orders, result);
    }

    @Test
    public void findByClient_ShouldReturnOrdersForClient() {
        Client client = new Client();
        Order order1 = new Order();
        Order order2 = new Order();
        List<Order> orders = Arrays.asList(order1, order2);

        when(repository.findByClient(client)).thenReturn(orders);

        List<Order> result = service.findByClient(client);

        assertEquals(orders, result);
    }

    @Test
    public void findByBike_ShouldReturnOrdersForBike() {
        Bike bike = new Bike();
        Order order1 = new Order();
        Order order2 = new Order();
        List<Order> orders = Arrays.asList(order1, order2);

        when(repository.findByBike(bike)).thenReturn(orders);

        List<Order> result = service.findByBike(bike);

        assertEquals(orders, result);
    }

    @Test
    public void findByBikeAndTimeStart_ShouldReturnOrdersForBikeAndTimeStart() {
        Bike bike = new Bike();
        LocalTime timeStart = LocalTime.of(9, 0);
        Order order1 = new Order();
        Order order2 = new Order();
        List<Order> orders = Arrays.asList(order1, order2);

        when(repository.findByBikeAndTimeStart(bike, timeStart)).thenReturn(orders);

        List<Order> result = service.findByBikeAndTimeStart(bike, timeStart);

        assertEquals(orders, result);
    }
}
