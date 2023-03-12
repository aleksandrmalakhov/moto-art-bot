package ru.malakhov.motoartbot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.malakhov.motoartbot.entity.Contact;
import ru.malakhov.motoartbot.repository.ContactRepository;
import ru.malakhov.motoartbot.service.imp.ContactServiceImp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ContactServiceImpTest {
    private ContactServiceImp service;

    @Mock
    private ContactRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new ContactServiceImp(repository);
    }

    @Test
    public void save_ShouldCallRepositorySave() {
        Contact contact = new Contact();

        service.save(contact);
        verify(repository, times(1)).save(contact);
    }

    @Test
    public void findById_ShouldReturnContactWhenContactExists() {
        long contactId = 1L;
        Contact contact = new Contact();

        when(repository.findById(contactId)).thenReturn(Optional.of(contact));

        Optional<Contact> result = service.findById(contactId);

        assertTrue(result.isPresent());
        assertEquals(contact, result.get());
    }

    @Test
    public void findByEmail_ShouldReturnContactWhenContactExists() {
        String email = "johndoe@example.com";
        Contact contact = new Contact();

        when(repository.findByEmail(anyString())).thenReturn(Optional.of(contact));

        Optional<Contact> result = service.findByEmail(email);

        assertTrue(result.isPresent());
        assertEquals(contact, result.get());
    }

    @Test
    public void findByPhone_ShouldReturnContactWhenContactExists() {
        String phone = "1234567890";
        Contact contact = new Contact();

        when(repository.findByPhone(anyString())).thenReturn(Optional.of(contact));
        Optional<Contact> result = service.findByPhone(phone);

        assertTrue(result.isPresent());
        assertEquals(contact, result.get());
    }

    @Test
    public void findById_ShouldReturnEmptyWhenContactDoesNotExist() {
        long contactId = 1L;
        when(repository.findById(contactId)).thenReturn(Optional.empty());

        Optional<Contact> result = service.findById(contactId);

        assertTrue(result.isEmpty());
    }

    @Test
    public void findAll_ShouldReturnAllContacts() {
        Contact contact1 = new Contact();
        Contact contact2 = new Contact();

        List<Contact> contacts = Arrays.asList(contact1, contact2);
        when(repository.findAll()).thenReturn(contacts);

        List<Contact> result = service.findAll();
        assertEquals(contacts, result);
    }
}