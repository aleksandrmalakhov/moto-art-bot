package ru.malakhov.motoartbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.malakhov.motoartbot.entity.BotUserPhone;

import java.util.Optional;

@Repository
public interface BotUserPhoneRepository extends JpaRepository<BotUserPhone, Long> {
    Optional<BotUserPhone> findByPhone(String phone);
}
