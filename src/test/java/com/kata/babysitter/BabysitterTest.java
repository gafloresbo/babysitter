package com.kata.babysitter;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BabysitterTest {

    @Test
    public void whenBabysitterStartTimeIsEarlierThan1700ThrowsException() {
        LocalDateTime starTime = LocalDateTime.of(2019, 8, 18, 15, 0);
        LocalDateTime endTime = LocalDateTime.of(2019, 8, 18, 19, 0);
        Babysitter babysitter = new Babysitter();

        assertThrows(InvalidTimeException.class, () -> babysitter.pay(starTime, endTime, "A"));
    }
}