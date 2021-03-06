package ru.netology.radio;

public class Radio {
    private int currentRadioStation;
    private int volumeLevel;

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int currentRadioStation) {
        // Проверяем попадание в заданные пределы по колличеству станций, если да то устанавливаем номер  станции и выходим
        if ((currentRadioStation >= 0) && (currentRadioStation <= 9)) {
            this.currentRadioStation = currentRadioStation;
            return;
        }
        //Если дошли сюда,значит currentRadioStation точно не в допуске. Проверяем и соответственно ставим либо 0 либо 9
        if (currentRadioStation < 0) {
            this.currentRadioStation = 0;
        } else {
            this.currentRadioStation = 9;
        }
    }

    public void next() {
        // Т.к. единственное место, откуда может появиться некорректное значение обеспечено методом setCurrentRadioStation,
        // то просто обойдемся отработкой граничного значения или инкрементом currentRadioStation
        if (currentRadioStation == 9) {
            currentRadioStation = 0;
        } else {
            currentRadioStation++;
        }
    }

    public void prev() {
        // Т.к. единственное место, откуда может появиться некорректное значение обеспечено методом setCurrentRadioStation,
        // то просто обойдемся отработкой граничного значения или декрементом currentRadioStation
        if (currentRadioStation == 0) {
            currentRadioStation = 9;
        } else {
            currentRadioStation--;
        }

    }


    public void increaseVolume() {
        if (volumeLevel < 10) {
            volumeLevel++;
        } else {
            volumeLevel = 10;
        }
    }

    public void decreaseVolume() {
        if (volumeLevel > 0) {
            volumeLevel--;
        } else {
            volumeLevel = 0;
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
