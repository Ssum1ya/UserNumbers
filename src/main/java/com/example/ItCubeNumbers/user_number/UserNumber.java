package com.example.ItCubeNumbers.user_number;

import com.example.ItCubeNumbers.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    @NotBlank(message = "имя должно быть не пустое")
    private String name;
    @Column(name = "number")
    @Pattern(regexp = "^\\+7\\d{10}$", message = "Введе номер с помощью +7")
    @NotBlank(message = "номер должен быть не пустым")
    private String number;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public UserNumber() {
    }

    public UserNumber(String number, String name, User user) {
        this.number = number;
        this.name = name;
        this.user = user;
    }
}
