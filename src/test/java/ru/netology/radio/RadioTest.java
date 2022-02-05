package ru.netology.radio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    // проверяем переключение номера станции вперед с обычными и граничными вариантами c указанным максимумом станций
    @CsvSource(value = {
            "'normalMode',3 , 4, 20",
            "'maxValue', 19 , 0, 20",
            "'minValue', 0 , 1, 20"})
    void next(String name, int radioStationNumber, int expectedRadioStationNumber, int maxRadioStation) {
        Radio rad = new Radio(maxRadioStation);
        rad.setCurrentRadioStation(radioStationNumber);
        rad.next();
        assertEquals(expectedRadioStationNumber, rad.getCurrentRadioStation());
    }

    @ParameterizedTest
    // проверяем переключение номера станции назад с обычными и граничными вариантами c указанным максимумом станций
    @CsvSource(value = {
            "'normalMode',3 , 2, 20",
            "'maxValue', 0 , 19, 20",
            "'minValue', 19 , 18, 20"})
    void prev(String name, int radioStationNumber, int expectedRadioStationNumber, int maxRadioStation) {
        Radio rad = new Radio(maxRadioStation);
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
    // проверяем увеличение громкости станции при различных состояниях
    @CsvSource(value = {
            "'normalMode',5 , 6",
            "'outOfRangeFromLeft', 0, 1",
            "'outOfRangeFromRight', 100 , 100"})
    void increaseVolume(String name, int currentVolume, int expectedVolume) {
        Radio rad = new Radio();
        rad.setVolumeLevel(currentVolume);
        rad.increaseVolume();
        assertEquals(expectedVolume, rad.getVolumeLevel());
    }

    @ParameterizedTest
    // проверяем уменьшение громкости станции при различных состояниях
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