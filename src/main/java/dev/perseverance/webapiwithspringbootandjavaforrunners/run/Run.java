package dev.perseverance.webapiwithspringbootandjavaforrunners.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location
) {

    public Run {
        if(!completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("The Completed On date must be after the Started Date");
        }
    }
}
