package ru.netology.radio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    // проверяем переключение номера станции вперед с обычными и граничными вариантами
    @CsvSource(value = {
            "'normalMode',3 , 4",
            "'maxValue', 9 , 0",
            "'minValue', 0 , 1"})
    void next(String name, int radioStationNumber, int expectedRadioStationNumber) {
        Radio rad = new Radio();
        rad.setCurrentRadioStation(radioStationNumber);
        rad.next();
        assertEquals(expectedRadioStationNumber, rad.getCurrentRadioStation());
    }

    @ParameterizedTest
    // проверяем переключение номера станции yfpfl с обычными и граничными вариантами
    @CsvSource(value = {
            "'normalMode',3 , 2",
            "'maxValue', 0 , 9",
            "'minValue', 9 , 8"})
    void prev(String name, int radioStationNumber, int expectedRadioStationNumber) {
        Radio rad = new Radio();
        rad.setCurrentRadioStation(radioStationNumber);
        rad.prev();
        assertEquals(expectedRadioStationNumber, rad.getCurrentRadioStation());
    }


    @ParameterizedTest
    // проверяем выбор конкретного номера станции и вылет за пределы слева и справа
    @CsvSource(value = {
            "'normalMode',2 , 2",
            "'outOfRangeFromLeft', -1 , 0",
            "'outOfRangeFromRight', 20 , 9"})
    void setCurrentRadioStation(String name, int numberForSet, int expectedNumber) {
        Radio rad = new Radio();
        rad.setCurrentRadioStation(numberForSet);
        assertEquals(expectedNumber, rad.getCurrentRadioStation());

    }


    @ParameterizedTest
    // проверяем увеличение громкости станции при различных состониях
    @CsvSource(value = {
            "'normalMode',5 , 6",
            "'outOfRangeFromLeft', 0, 1",
            "'outOfRangeFromRight', 10 , 10"})
    void increaseVolume(String name, int currentVolume, int expectedVolume) {
        Radio rad = new Radio();
        rad.setVolumeLevel(currentVolume);
        rad.increaseVolume();
        assertEquals(expectedVolume, rad.getVolumeLevel());
    }

    @ParameterizedTest
    // проверяем уменьшение громкости станции при различных состониях
    @CsvSource(value = {
            "'normalMode',5 , 4",
            "'outOfRangeFromLeft', 0, 0",
            "'outOfRangeFromRight', 10 , 9"})
    void decreaseVolume(String name, int currentVolume, int expectedVolume) {
        Radio rad = new Radio();
        rad.setVolumeLevel(currentVolume);
        rad.decreaseVolume();
        assertEquals(expectedVolume, rad.getVolumeLevel());
    }


}