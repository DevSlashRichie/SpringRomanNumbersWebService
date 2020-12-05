package io.github.ricardormdev.springwebservice.Controllers;

import io.github.ricardormdev.springwebservice.Entities.IntegerNumberEntityModel;
import io.github.ricardormdev.springwebservice.Entities.RomanNumberEntityModel;
import io.github.ricardormdev.springwebservice.Utils.RomanNumber;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin
@RestController
public class EntityController {

    private final AtomicLong requestId = new AtomicLong();

    @GetMapping("/toroman")
    public RomanNumberEntityModel model(@RequestParam(value = "number", defaultValue = "0") int number) {
        return new RomanNumberEntityModel(requestId.incrementAndGet(), RomanNumber.toRoman(number));
    }

    @GetMapping("/toint")
    public IntegerNumberEntityModel model(@RequestParam(value = "number", defaultValue = "") String romanNumber) {
        return new IntegerNumberEntityModel(requestId.incrementAndGet(),
                RomanNumber.toInt(romanNumber.toUpperCase()));
    }

}
