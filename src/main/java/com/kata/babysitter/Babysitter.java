package com.kata.babysitter;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Babysitter {
    private final LocalTime MINIMUM_START_TIME_ALLOWED = LocalTime.of(17,0);
    private final LocalTime MAXIMUM_END_TIME_ALLOWED = LocalTime.of(4,0);

    public int pay(LocalDateTime starTime, LocalDateTime endTime, String a) {
        if (starTime.toLocalTime().isBefore(MINIMUM_START_TIME_ALLOWED)) {
            throw new InvalidTimeException("Please ensure startTime is after "+MINIMUM_START_TIME_ALLOWED.toString());
        }
        return 0;
    }
}