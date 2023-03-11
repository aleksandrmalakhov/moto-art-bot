package ru.malakhov.motoartbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.malakhov.motoartbot.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}