package ru.malakhov.motoartbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.malakhov.motoartbot.entity.BotUserEmail;

import java.util.Optional;

@Repository
public interface BotUserEmailRepository extends JpaRepository<BotUserEmail, Long> {
    Optional<BotUserEmail> findByEmail(String email);
}
