package com.alinazim.account.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class AccountCustomerDto {
    private String id;
    private String name;
    private String surname;
}
