package ru.netology.radio;

public class Radio {
    private int currentRadioStation;
    private int volumeLevel;
    private int maxStationCount;
    private int maxVolumeLevel;
    private int minVolumeLevel;

    public Radio() {
        maxStationCount = 10;
        volumeLevel = 5;
        currentRadioStation = 5;
        maxVolumeLevel = 100;
        minVolumeLevel = 0;
    }


    public Radio(int maxStationCount) {
        this.volumeLevel = 5;
        this.currentRadioStation = 0;
        this.maxVolumeLevel = 100;
        this.minVolumeLevel = 0;
        this.maxStationCount = maxStationCount;

    }


    public int getCurrentRadioStation() {
        return currentRadioStation;
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

    public int getVolumeLevel() {
        return volumeLevel;
    }

    public void setVolumeLevel(int volumeLevel) {
        // Служебный метод для тестов. Проверок нет, потому,что подразумевается,что значения задаются руками и всегда в допуске
        this.volumeLevel = volumeLevel;
    }
}
