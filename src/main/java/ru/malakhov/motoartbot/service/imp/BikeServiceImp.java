package ru.malakhov.motoartbot.service.imp;

import org.springframework.stereotype.Service;
import ru.malakhov.motoartbot.entity.Bike;
import ru.malakhov.motoartbot.repository.BikeRepository;
import ru.malakhov.motoartbot.service.BikeService;

import java.util.List;
import java.util.Optional;

@Service
public class BikeServiceImp implements BikeService {
    private final BikeRepository repository;

    public BikeServiceImp(BikeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Bike save(Bike bike) {
        return repository.save(bike);
    }

    @Override
    public Optional<Bike> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Bike> findAll() {
        return repository.findAll();
    }
}