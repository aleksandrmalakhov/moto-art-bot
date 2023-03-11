package ru.malakhov.motoartbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.malakhov.motoartbot.entity.Bike;
import ru.malakhov.motoartbot.entity.Client;
import ru.malakhov.motoartbot.entity.Order;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByClient(Client client);
    List<Order> findByBike(Bike bike);
    List<Order> findByBikeAndTimeStart(Bike bike, LocalTime timeStart);
}
