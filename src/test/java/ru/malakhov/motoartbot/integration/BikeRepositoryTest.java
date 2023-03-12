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
import ru.malakhov.motoartbot.repository.BikeRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BikeRepositoryTest {
    @Autowired
    private BikeRepository bikeRepository;
    private static Bike[] bikes;

    @BeforeAll
    public static void beforeAll(){
        bikes = new Bike[2];

        bikes[0] = Bike.builder().name("Harley-Davidson").model("Sportster").build();
        bikes[1] = Bike.builder().name("Honda").model("CBR").build();
    }

    @Before
    public void setUp() {
        bikeRepository.deleteAll();
    }

    @Test
    public void testSaveBike() {
        Bike bike = bikes[0];
        bikeRepository.save(bike);

        assertThat(bike.getId()).isNotNull();
        assertThat(bikeRepository.findById(bike.getId())).isNotEmpty().hasValue(bike);
    }

    @Test
    public void testFindAllBikes() {
        Bike bike1 = bikes[0];
        bikeRepository.save(bike1);

        Bike bike2 = bikes[1];
        bikeRepository.save(bike2);

        List<Bike> bikes = bikeRepository.findAll();

        assertThat(bikes).hasSize(2);
        assertThat(bikes).contains(bike1, bike2);
    }

    @Test
    public void testFindBikeById() {
        Bike bike = bikes[0];
        bikeRepository.save(bike);

        Optional<Bike> foundBike = bikeRepository.findById(bike.getId());

        assertThat(foundBike).isNotEmpty().hasValue(bike);
    }
}