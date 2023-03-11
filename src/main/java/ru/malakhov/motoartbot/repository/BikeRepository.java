package ru.malakhov.motoartbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.malakhov.motoartbot.entity.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {
}
