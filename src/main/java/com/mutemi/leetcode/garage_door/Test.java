package com.mutemi.leetcode.garage_door;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("consumeDoorEvents")
public class Test {
    @Nested
    @DisplayName("sample tests")
    class SampleTests {

        @org.junit.jupiter.api.Test()
        @DisplayName("should work when there are no events")
        public void shouldWorkWhenThereAreNoEvents() {
            assertEquals("0000000000", Solution.consumeDoorEvents(".........."));
        }

        @org.junit.jupiter.api.Test
        @DisplayName("should work when there is a single event")
        public void shouldWorkWhenThereIsASingleEvent() {
            assertEquals("12345", Solution.consumeDoorEvents("P...."));
        }

        @org.junit.jupiter.api.Test
        @DisplayName("should work when operation was paused")
        public void shouldWorkWhenOperationWasPaused() {
            assertEquals("12222", Solution.consumeDoorEvents("P.P.."));
        }

        @org.junit.jupiter.api.Test
        @DisplayName("should work when there is an obstacle")
        public void shouldWorkWhenThereIsAnObstacle() {
            assertEquals("0012343210", Solution.consumeDoorEvents("..P...O..."));
        }
    }
}
