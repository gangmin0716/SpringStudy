package com.dgsw.quickstart.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ItemDTO {
    @NotBlank(message = "ID는 필수입니다.")
    private String id;
    @NotBlank(message = "이름은 필수입니다")
    private String name;

}
