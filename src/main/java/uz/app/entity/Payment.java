package uz.app.entity;

import jakarta.persistence.*;
import lombok.Data;
import uz.app.entity.enums.Method;
import uz.app.entity.enums.PendingStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "Payments")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payment_id;

    private Double amount;
    @Enumerated(EnumType.STRING)
    private Method method;
    @Enumerated(EnumType.STRING)
    private PendingStatus status;
    private LocalDateTime created_at;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
