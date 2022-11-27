package com.alinazim.account.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class CreateAccountRequest {
    @NotBlank
    private String customerId;
    @Min(0)
    private BigDecimal initialCredit;
}
