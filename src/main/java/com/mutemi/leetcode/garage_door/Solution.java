package com.mutemi.leetcode.garage_door;

public class Solution {
    public static String consumeDoorEvents(String events) {
        char[] eventsCharArray = events.toCharArray();
        int currentState = 0;
        String currentMotion = "static";
        boolean isPaused = false;
        String[] output = new String[eventsCharArray.length];
        for (int i = 0; i < eventsCharArray.length; i++) {
            var event = eventsCharArray[i];
            int result = 0;
            switch (event) {
                case '.':
                    result = proceedWithState(currentState, currentMotion, isPaused);
                    currentState = result;
                    if(result == 5 || result == 0) {
                        currentMotion = "static";
                    }
                    break;
                case 'O':
                    if (currentMotion.equalsIgnoreCase("closing")) {
                        currentMotion = "opening";
                    } else if (currentMotion.equalsIgnoreCase("opening")) {
                        currentMotion = "closing";
                    } else {
                        currentMotion = "static";
                    }
                    result = reverse(currentState);
                    currentState = result;
                    break;
                case 'P':
                    if (currentMotion.equalsIgnoreCase("static")) {
                        if (currentState == 5) {
                            currentMotion = "closing";
                            currentState=-1;
                            result = currentState;
                        } else {
                            currentMotion = "opening";
                            currentState=+1;
                            result = currentState;
                        }
                    } else if (currentMotion.equalsIgnoreCase("closing") || currentMotion.equalsIgnoreCase("opening")) {
                        isPaused = !isPaused;
                        if(isPaused) {
                            result = currentState;
                        } else {
                            result = proceedWithState(currentState, currentMotion, isPaused);
                        }
                    }
                    break;
                }
            output[i] = String.valueOf(result);
        }
        return String.join("", output);
    }

    static int proceedWithState(int currentState, String currentMotion, boolean isPaused) {
        if (currentMotion.equalsIgnoreCase("static")) {
            return 0;
        } else if (currentMotion.equalsIgnoreCase("opening")) {
            if (isPaused) {
                return currentState;
            }
            if (currentState >= 5) {
                return 5;
            }
            return currentState + 1;
        } else if (currentMotion.equalsIgnoreCase("closing")) {
            if (currentState <= 1) {
                return 0;
            }
            return currentState - 1;
        }
        return currentState;
    }

    // duplication test for sonar
    static int proceedWithStater(int currentState, String currentMotion, boolean isPaused) {
        if (currentMotion.equalsIgnoreCase("static")) {
            return 0;
        } else if (currentMotion.equalsIgnoreCase("opening")) {
            if (isPaused) {
                return currentState;
            }
            if (currentState >= 5) {
                return 5;
            }
            return currentState + 1;
        } else if (currentMotion.equalsIgnoreCase("closing")) {
            if (currentState <= 1) {
                return 0;
            }
            return currentState - 1;
        }
        return currentState;
    }

    static int proceedWithState3(int currentState, String currentMotion, boolean isPaused) {
        if (currentMotion.equalsIgnoreCase("static")) {
            return 0;
        } else if (currentMotion.equalsIgnoreCase("opening")) {
            if (isPaused) {
                return currentState;
            }
            if (currentState >= 5) {
                return 5;
            }
            return currentState + 1;
        } else if (currentMotion.equalsIgnoreCase("closing")) {
            if (currentState <= 1) {
                return 0;
            }
            return currentState - 1;
        }
        return currentState;
    }

    static int reverse(int currentState) {
        if (currentState < 5 && currentState > 0) {
            return currentState - 1;
        } else {
            return 0;
        }
    }
}
