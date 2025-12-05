package org.example.DTO;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.entity.Category;
import org.example.entity.Transactions;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public record CategoryDTO(String nome, List<Transactions> transactions) {

    public static CategoryDTO fromEntity(Category c) {
        return new CategoryDTO(c.getName());
}
