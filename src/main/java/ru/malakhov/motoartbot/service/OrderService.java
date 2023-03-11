package ru.malakhov.motoartbot.service;

import ru.malakhov.motoartbot.entity.Bike;
import ru.malakhov.motoartbot.entity.Client;
import ru.malakhov.motoartbot.entity.Order;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    void save(Order order);
    Optional<Order> findById(long id);
    List<Order> findAll();
    List<Order> findByClient(Client client);
    List<Order> findByBike(Bike bike);
    List<Order> findByBikeAndTimeStart(Bike bike, LocalTime timeStart);
}
