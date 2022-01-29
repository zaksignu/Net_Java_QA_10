package ru.netology.radio;

public class Radio {
    private int currentRadioStation;
    private int volumeLevel;

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int currentRadioStation) {

        if ((currentRadioStation >= 0) && (currentRadioStation <= 9)) {        // Проверяем попадание в заданные пределы по колличеству станций, если да то устанавливаем номер  станции и выходим
            this.currentRadioStation = currentRadioStation;
            return;
        }
        if (currentRadioStation < 0) {         //Если дошли сюда,значит уже точно не норма. Проверяем номер и соответственно ставим либо станцию 0 либо 9
            this.currentRadioStation = 0;
            return;
        } else {
            this.currentRadioStation = 9;
        }
    }

    public void next() {
        if (currentRadioStation == 9) {
            currentRadioStation = 0;
            return;
        } else {
            currentRadioStation++;
        }
    }

    public void prev() {
        if (currentRadioStation == 0) {
            currentRadioStation = 9;
            return;
        } else {
            currentRadioStation--;
        }

    }


    public void increaseVolume() {
        if (volumeLevel < 10) {
            volumeLevel++;
            return;
        } else {
            volumeLevel = 10;
        }
    }

    public void decreaseVolume() {
        if (volumeLevel > 0) {
            volumeLevel--;
            return;
        } else {
            volumeLevel = 0;
        }
    }

    public int getVolumeLevel() {
        return volumeLevel;
    }

    public void setVolumeLevel(int volumeLevel) {
        this.volumeLevel = volumeLevel;
    }
}
