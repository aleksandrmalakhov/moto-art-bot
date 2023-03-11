package ru.malakhov.motoartbot.service.imp;

import org.springframework.stereotype.Service;
import ru.malakhov.motoartbot.entity.Bike;
import ru.malakhov.motoartbot.entity.Client;
import ru.malakhov.motoartbot.entity.Order;
import ru.malakhov.motoartbot.repository.OrderRepository;
import ru.malakhov.motoartbot.service.OrderService;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService {
    private final OrderRepository repository;

    public OrderServiceImp(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Order order) {
        repository.save(order);
    }

    @Override
    public Optional<Order> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Order> findByClient(Client client) {
        return repository.findByClient(client);
    }

    @Override
    public List<Order> findByBike(Bike bike) {
        return repository.findByBike(bike);
    }

    @Override
    public List<Order> findByBikeAndTimeStart(Bike bike, LocalTime timeStart) {
        return repository.findByBikeAndTimeStart(bike, timeStart);
    }
}