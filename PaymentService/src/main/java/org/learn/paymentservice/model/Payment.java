package org.learn.paymentservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Setter
@Getter
@EqualsAndHashCode
@Builder(toBuilder = false)
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class Payment {

    @Id
    private String id;
    private LocalDate date;
    private Double amount;
    private String orderNumber;
    private String customerNumber;

}
