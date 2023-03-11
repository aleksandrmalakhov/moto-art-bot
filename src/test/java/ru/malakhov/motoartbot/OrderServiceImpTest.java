package ru.malakhov.motoartbot;

import org.junit.jupiter.api.Assertions;
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

import static org.mockito.Mockito.*;

public class OrderServiceImpTest {
    private OrderServiceImp orderService;

    @Mock
    private OrderRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderServiceImp(repository);
    }

    @Test
    public void save_ShouldCallRepositorySave() {
        // Arrange
        Order order = new Order();
        // Act
        orderService.save(order);
        // Assert
        verify(repository, times(1)).save(order);
    }

    @Test
    public void findById_ShouldReturnOrder_WhenOrderExists() {
        // Arrange
        long orderId = 1L;
        Order order = new Order();
        when(repository.findById(orderId)).thenReturn(Optional.of(order));
        // Act
        Optional<Order> result = orderService.findById(orderId);
        // Assert
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(order, result.get());
    }

    @Test
    public void findById_ShouldReturnEmpty_WhenOrderDoesNotExist() {
        // Arrange
        long orderId = 1L;
        when(repository.findById(orderId)).thenReturn(Optional.empty());
        // Act
        Optional<Order> result = orderService.findById(orderId);
        // Assert
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void findAll_ShouldReturnAllOrders() {
        // Arrange
        Order order1 = new Order();
        Order order2 = new Order();
        List<Order> orders = Arrays.asList(order1, order2);
        when(repository.findAll()).thenReturn(orders);
        // Act
        List<Order> result = orderService.findAll();
        // Assert
        Assertions.assertEquals(orders, result);
    }

    @Test
    public void findByClient_ShouldReturnOrdersForClient() {
        // Arrange
        Client client = new Client();
        Order order1 = new Order();
        Order order2 = new Order();
        List<Order> orders = Arrays.asList(order1, order2);
        when(repository.findByClient(client)).thenReturn(orders);
        // Act
        List<Order> result = orderService.findByClient(client);
        // Assert
        Assertions.assertEquals(orders, result);
    }

    @Test
    public void findByBike_ShouldReturnOrdersForBike() {
        // Arrange
        Bike bike = new Bike();
        Order order1 = new Order();
        Order order2 = new Order();
        List<Order> orders = Arrays.asList(order1, order2);
        when(repository.findByBike(bike)).thenReturn(orders);
        // Act
        List<Order> result = orderService.findByBike(bike);
        // Assert
        Assertions.assertEquals(orders, result);
    }

    @Test
    public void findByBikeAndTimeStart_ShouldReturnOrdersForBikeAndTimeStart() {
        // Arrange
        Bike bike = new Bike();
        LocalTime timeStart = LocalTime.of(9, 0);
        Order order1 = new Order();
        Order order2 = new Order();
        List<Order> orders = Arrays.asList(order1, order2);
        when(repository.findByBikeAndTimeStart(bike, timeStart)).thenReturn(orders);
        // Act
        List<Order> result = orderService.findByBikeAndTimeStart(bike, timeStart);
        // Assert
        Assertions.assertEquals(orders, result);
    }
}
