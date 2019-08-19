package com.kata.babysitter;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Babysitter {
    private final LocalTime MINIMUM_START_TIME_ALLOWED = LocalTime.of(17, 0);
    private final LocalTime MAXIMUM_END_TIME_ALLOWED = LocalTime.of(4, 0);

    public int pay(LocalDateTime starDateAndTime, LocalDateTime endDateAndTime, String family) {
        validateTimes(starDateAndTime, endDateAndTime);
        return 0;
    }

    private void validateTimes(LocalDateTime starDateAndTime, LocalDateTime endDateAndTime) {
        if (endDateAndTime.isBefore(starDateAndTime)) {
            throw new InvalidTimeException("Please ensure startTime is earlier than endTime");
        }

        LocalTime startTime = starDateAndTime.toLocalTime();
        LocalTime endTime = endDateAndTime.toLocalTime();

        if (startTime.isAfter(MAXIMUM_END_TIME_ALLOWED) && startTime.isBefore(MINIMUM_START_TIME_ALLOWED)) {
            throw new InvalidTimeException("Invalid StartTime. Please ensure startTime is after " + MINIMUM_START_TIME_ALLOWED.toString());
        }
        if (endTime.isAfter(MAXIMUM_END_TIME_ALLOWED) && endTime.isBefore(MINIMUM_START_TIME_ALLOWED)) {
            throw new InvalidTimeException("Invalid Endtime. Please ensure endTime is before " + MAXIMUM_END_TIME_ALLOWED.toString());
        }
    }
}