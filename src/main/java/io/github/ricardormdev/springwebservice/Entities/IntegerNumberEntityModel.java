package io.github.ricardormdev.springwebservice.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class IntegerNumberEntityModel {

    private final long id;
    private final int result;

}
