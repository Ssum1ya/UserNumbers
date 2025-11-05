package com.example.ItCubeNumbers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class UserNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "имя должно быть не пустое")
    private String name;
    @Pattern(regexp = "^\\+7\\d{10}$", message = "Введе номер с помощью +7")
    @NotBlank(message = "номер должен быть не пустым")
    private String number;

    public UserNumber() {
    }

    public UserNumber(String name, String number) {
        this.name = name;
        this.number = number;
    }
}
