package ru.malakhov.motoartbot;

import org.junit.jupiter.api.Assertions;
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

import static org.mockito.Mockito.*;

public class BikeServiceImpTest {
    private BikeServiceImp bikeService;

    @Mock
    private BikeRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        bikeService = new BikeServiceImp(repository);
    }

    @Test
    public void save_ShouldCallRepositorySave() {
        // Arrange
        Bike bike = new Bike();
        // Act
        bikeService.save(bike);
        // Assert
        verify(repository, times(1)).save(bike);
    }

    @Test
    public void findById_ShouldReturnBikeWhenBikeExists() {
        // Arrange
        long bikeId = 1L;
        Bike bike = new Bike();
        when(repository.findById(bikeId)).thenReturn(Optional.of(bike));
        // Act
        Optional<Bike> result = bikeService.findById(bikeId);
        // Assert
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(bike, result.get());
    }

    @Test
    public void findById_ShouldReturnEmptyWhenBikeDoesNotExist() {
        // Arrange
        long bikeId = 1L;
        when(repository.findById(bikeId)).thenReturn(Optional.empty());
        // Act
        Optional<Bike> result = bikeService.findById(bikeId);
        // Assert
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void findAll_ShouldReturnAllBikes() {
        // Arrange
        Bike bike1 = new Bike();
        Bike bike2 = new Bike();
        List<Bike> bikes = Arrays.asList(bike1, bike2);
        when(repository.findAll()).thenReturn(bikes);
        // Act
        List<Bike> result = bikeService.findAll();
        // Assert
        Assertions.assertEquals(bikes, result);
    }
}
