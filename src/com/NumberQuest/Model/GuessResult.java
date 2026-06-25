package com.NumberQuest.Model;

public enum GuessResult {
 
    // User's guess is greater than the target number 
    TOO_HIGH,
 
    // User's guess is less than the target number 
    TOO_LOW,
 
    // User's guess exactly matches the target number 
    CORRECT,
 
    // User entered something out of valid range (e.g. 0 or 101) 
    OUT_OF_RANGE,
 
    // User entered non-numeric input — handled at controller level 
    INVALID_INPUT
}
