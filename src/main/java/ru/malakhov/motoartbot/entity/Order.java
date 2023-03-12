package ru.malakhov.motoartbot.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Builder
@Table(name = "orders")
@EqualsAndHashCode(exclude = "id")
public class Order {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_bike", nullable = false)
    private Bike bike;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    private LocalDate date;
    private LocalTime timeStart;
    private LocalTime timeStop;
    private long cost;

    public Order() {
    }
}