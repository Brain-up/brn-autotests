package enums;

import helpers.InitTest;

import static enums.UriEnum.NO_NOISE;
import static enums.UriEnum.PIC;

public enum DataEnum {

    БАЛ ("бал", "%D0%B1%D0%B0%D0%BB.mp3", "%D0%B1%D0%B0%D0%BB.jpg"),
    БУМ ("бум", "%D0%B1%D1%83%D0%BC.mp3", "%D0%B1%D1%83%D0%BC.jpg"),
    БЫЛь ("быль","%D0%B1%D1%8B%D0%BB%D1%8C.mp3", "%D0%B1%D1%8B%D0%BB%D1%8C.jpg"),
    ВИТЬ ("вить", "%D0%B2%D0%B8%D1%82%D1%8C.mp3", "%D0%B2%D0%B8%D1%82%D1%8C.jpg"),
    ГАД ("гад", "%D0%B3%D0%B0%D0%B4.mp3", "%D0%B3%D0%B0%D0%B4.jpg"),
    ДУБ ("дуб", "%D0%B4%D1%83%D0%B1.mp3", "%D0%B4%D1%83%D0%B1.jpg"),

    ЛИНЬ ("линь", "%D0%BB%D0%B8%D0%BD%D1%8C.mp3", "%D0%BB%D0%B8%D0%BD%D1%8C.jpg"),
    ЛИС ("лис", "%D0%BB%D0%B8%D1%81.mp3", "%D0%BB%D0%B8%D1%81.jpg"),
    МОЛЬ ("моль","%D0%BC%D0%BE%D0%BB%D1%8C.mp3", "%D0%BC%D0%BE%D0%BB%D1%8C.jpg"),
    ПАР ("пар", "%D0%BF%D0%B0%D1%80.mp3", "%D0%BF%D0%B0%D1%80.jpg"),
    ПЯТЬ ("пять", "%D0%BF%D1%8F%D1%82%D1%8C.mp3", "%D0%BF%D1%8F%D1%82%D1%8C.jpg"),
    РАБ ("раб", "%D1%80%D0%B0%D0%B1.mp3", "%D1%80%D0%B0%D0%B1.jpg"),


    РАК ("рак", "%D1%80%D0%B0%D0%BA.mp3", "%D1%80%D0%B0%D0%BA.jpg"),
    РОЖ ("рожь", "%D1%80%D0%B0%D0%BA.jpg", "%D1%80%D0%BE%D0%B6%D1%8C.jpg"),
    СЕТЬ ("сеть","%D1%81%D0%B5%D1%82%D1%8C.mp3", "%D1%81%D0%B5%D1%82%D1%8C.jpg"),
    ТОПЬ ("топь", "%D1%82%D0%BE%D0%BF%D1%8C.mp3", "%D1%82%D0%BE%D0%BF%D1%8C.jpg"),
    ХОД ("ход", "%D1%85%D0%BE%D0%B4.mp3", "%D1%85%D0%BE%D0%B4.jpg"),
    ШЕФ ("шеф", "%D1%88%D0%B5%D1%84.mp3", "%D1%88%D0%B5%D1%84.jpg"),
    МОР ("мор", "%D0%BC%D0%BE%D1%80.mp3", "%D0%BC%D0%BE%D1%80.jpg")
    ;

    public String value, audio, pic;

    DataEnum(String value, String audio, String pic) {
        this.value = value;
        this.audio = audio;
        this.pic = pic;
    }

    public static String getNoNoise(DataEnum  option) {
        return InitTest.baseUri + NO_NOISE.value + option.audio;
    }

    public static String getPic(DataEnum option) {
        return InitTest.baseUri + PIC.value + option.pic;
    }
}
