package ru.malakhov.motoartbot.service;

import ru.malakhov.motoartbot.entity.Bike;

import java.util.List;
import java.util.Optional;

public interface BikeService {
    Bike save(Bike bike);

    Optional<Bike> findById(long id);

    List<Bike> findAll();
}
