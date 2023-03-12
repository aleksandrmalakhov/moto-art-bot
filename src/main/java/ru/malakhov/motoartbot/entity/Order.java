package ru.malakhov.motoartbot.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@EqualsAndHashCode(exclude = "id")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bike_id", nullable = false)
    private Bike bike;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    private LocalDate date;
    private LocalTime timeStart;
    private LocalTime timeStop;
    private long cost;
}