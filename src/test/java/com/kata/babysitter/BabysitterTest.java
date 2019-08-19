package com.kata.babysitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BabysitterTest {

    private Babysitter babysitter;

    @BeforeEach
    public void setUp() {
        babysitter = new Babysitter();
    }

    @Test
    public void whenBabysitterStartTimeIsEarlierThan1700ThrowsException() {
        LocalDateTime starTime = LocalDateTime.of(2019, 8, 18, 15, 0);
        LocalDateTime endTime = LocalDateTime.of(2019, 8, 18, 19, 0);

        InvalidTimeException exception = assertThrows(InvalidTimeException.class, () -> babysitter.pay(starTime, endTime, "A"));
        assertEquals("Invalid StartTime. Please ensure startTime is after 17:00", exception.getMessage());
    }

    @Test
    public void whenBabysitterEndTimeIsAfter400ThrowsException() {
        LocalDateTime starTime = LocalDateTime.of(2019, 8, 18, 17, 0);
        LocalDateTime endTime = LocalDateTime.of(2019, 8, 19, 6, 0);

        InvalidTimeException exception = assertThrows(InvalidTimeException.class, () -> babysitter.pay(starTime, endTime, "A"));
        assertEquals("Invalid Endtime. Please ensure endTime is before 04:00", exception.getMessage());
    }

    @Test
    public void whenBabysitterEndTimeIsBeforeStartTimeThrowsException() {
        LocalDateTime starTime = LocalDateTime.of(2019, 8, 18, 22, 0);
        LocalDateTime endTime = LocalDateTime.of(2019, 8, 18, 18, 0);

        InvalidTimeException exception = assertThrows(InvalidTimeException.class, () -> babysitter.pay(starTime, endTime, "A"));
        assertEquals("Please ensure startTime is earlier than endTime", exception.getMessage());
    }
}