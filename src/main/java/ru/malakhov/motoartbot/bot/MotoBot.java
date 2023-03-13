package ru.malakhov.motoartbot.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.malakhov.motoartbot.entity.BotUser;
import ru.malakhov.motoartbot.service.BotUserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MotoBot extends TelegramLongPollingBot {
    private final BotConfig botConfig;
    private final BotUserService botUserService;

    public MotoBot(BotConfig botConfig, BotUserService botUserService) {
        this.botConfig = botConfig;
        this.botUserService = botUserService;
    }

    @Override
    public void onUpdateReceived(Update update) {

        System.out.println(update);

        if (update.hasMessage() && update.getMessage().hasText()) {
            try {
                var delete = botUserService.deleteAll();
                var user = update.getMessage().getFrom();
                var boUser = botUserService.save(BotUser.builder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .userName(user.getUserName())
                        .dateCreate(LocalDateTime.now())
                        .build());

                execute(SendMessage.builder()
                        .chatId(update.getMessage().getChatId())
                        .text(delete + "\n" + boUser.getFirstName() + "\n" + boUser.getDateCreate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                        .build());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getBotToken();
    }
}