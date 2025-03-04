package org.learn.orderservice.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Builder(toBuilder = true)
public class PaymentDTO {

    private String id;
    private LocalDate date;
    private Double amount;
    private String orderNumber;
    private String customerNumber;

}
