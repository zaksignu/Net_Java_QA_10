package ru.netology.radio;


import lombok.*;

@AllArgsConstructor
public class Radio {

    @Getter private  int currentRadioStation = 10;
    @Getter @Setter private int volumeLevel =10;
    @Getter @Setter private int maxStationCount = 10;
    private int maxVolumeLevel =10;
    private int minVolumeLevel =10;


    public Radio() {
        maxStationCount = 10;
        volumeLevel = 5;
        currentRadioStation = 5;
        maxVolumeLevel = 100;
        minVolumeLevel = 0;
    }

    public void setCurrentRadioStation(int currentRadioStation) {
        // Проверяем попадание в заданные пределы по колличеству станций, если да то устанавливаем номер  станции и выходим
        if ((currentRadioStation >= 0) && (currentRadioStation <= (maxStationCount - 1))) {
            this.currentRadioStation = currentRadioStation;
            return;
        }
        //Если дошли сюда,значит currentRadioStation точно не в допуске. Проверяем и соответственно ставим либо 0 либо 9
        if (currentRadioStation < 0) {
            this.currentRadioStation = 0;
        } else {
            this.currentRadioStation = maxStationCount - 1;
        }
    }

    public void next() {
        // Т.к. единственное место, откуда может появиться некорректное значение обеспечено методом setCurrentRadioStation,
        // то просто обойдемся отработкой граничного значения или инкрементом currentRadioStation
        if (currentRadioStation == (maxStationCount - 1)) {
            currentRadioStation = 0;
        } else {
            currentRadioStation++;
        }
    }

    public void prev() {
        // Т.к. единственное место, откуда может появиться некорректное значение обеспечено методом setCurrentRadioStation,
        // то просто обойдемся отработкой граничного значения или декрементом currentRadioStation
        if (currentRadioStation == 0) {
            currentRadioStation = (maxStationCount - 1);
        } else {
            currentRadioStation--;
        }

    }


    public void increaseVolume() {
        if (volumeLevel < maxVolumeLevel) {
            volumeLevel++;
        } else {
            volumeLevel = maxVolumeLevel;
        }
    }

    public void decreaseVolume() {
        if (volumeLevel > minVolumeLevel) {
            volumeLevel--;
        } else {
            volumeLevel = minVolumeLevel;
        }
    }

}
