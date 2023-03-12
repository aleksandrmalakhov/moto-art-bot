package ru.malakhov.motoartbot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.malakhov.motoartbot.entity.Bike;
import ru.malakhov.motoartbot.repository.BikeRepository;
import ru.malakhov.motoartbot.service.imp.BikeServiceImp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BikeServiceImpTest {
    private BikeServiceImp service;
    @Mock
    private BikeRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new BikeServiceImp(repository);
    }

    @Test
    public void save_ShouldCallRepositorySave() {
        Bike bike = new Bike();

        service.save(bike);

        verify(repository, times(1)).save(bike);
    }

    @Test
    public void findById_ShouldReturnBikeWhenBikeExists() {
        long bikeId = 1L;
        Bike bike = new Bike();
        when(repository.findById(bikeId)).thenReturn(Optional.of(bike));

        Optional<Bike> result = service.findById(bikeId);

        assertTrue(result.isPresent());
        assertEquals(bike, result.get());
    }

    @Test
    public void findById_ShouldReturnEmptyWhenBikeDoesNotExist() {
        long bikeId = 1L;
        when(repository.findById(bikeId)).thenReturn(Optional.empty());

        Optional<Bike> result = service.findById(bikeId);

        assertTrue(result.isEmpty());
    }

    @Test
    public void findAll_ShouldReturnAllBikes() {
        Bike bike1 = new Bike();
        Bike bike2 = new Bike();
        List<Bike> bikes = Arrays.asList(bike1, bike2);

        when(repository.findAll()).thenReturn(bikes);

        List<Bike> result = service.findAll();

        assertEquals(bikes, result);
    }
}