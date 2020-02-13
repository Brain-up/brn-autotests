package enums;

import helpers.InitTest;

import static enums.UriEnum.*;

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
    РОЖЬ("рожь", "%D1%80%D0%BE%D0%B6%D1%8C.mp3", "%D1%80%D0%BE%D0%B6%D1%8C.jpg"),
    СЕТЬ ("сеть","%D1%81%D0%B5%D1%82%D1%8C.mp3", "%D1%81%D0%B5%D1%82%D1%8C.jpg"),
    ТОПЬ ("топь", "%D1%82%D0%BE%D0%BF%D1%8C.mp3", "%D1%82%D0%BE%D0%BF%D1%8C.jpg"),
    ХОД ("ход", "%D1%85%D0%BE%D0%B4.mp3", "%D1%85%D0%BE%D0%B4.jpg"),
    ШЕФ ("шеф", "%D1%88%D0%B5%D1%84.mp3", "%D1%88%D0%B5%D1%84.jpg"),
    МОР ("мор", "%D0%BC%D0%BE%D1%80.mp3", "%D0%BC%D0%BE%D1%80.jpg"),

    БАБУШКА ("бабушка", "%D0%B1%D0%B0%D0%B1%D1%83%D1%88%D0%BA%D0%B0.mp3", "%D0%B1%D0%B0%D0%B1%D1%83%D1%88%D0%BA%D0%B0.jpg"),
    ДЕВОЧКА ("девочка", "%D0%B4%D0%B5%D0%B2%D0%BE%D1%87%D0%BA%D0%B0.mp3", "%D0%B4%D0%B5%D0%B2%D0%BE%D1%87%D0%BA%D0%B0.jpg"),
    ДЕДУШКА ("дедушка", "%D0%B4%D0%B5%D0%B4%D1%83%D1%88%D0%BA%D0%B0.mp3", "%D0%B4%D0%B5%D0%B4%D1%83%D1%88%D0%BA%D0%B0.jpg"),
    БРОСАЕТ ("бросает", "%D0%B1%D1%80%D0%BE%D1%81%D0%B0%D0%B5%D1%82.mp3", "%D0%B1%D1%80%D0%BE%D1%81%D0%B0%D0%B5%D1%82.jpg"),
    ЧИТАЕТ ("читает", "%D1%87%D0%B8%D1%82%D0%B0%D0%B5%D1%82.mp3", "%D1%87%D0%B8%D1%82%D0%B0%D0%B5%D1%82.jpg"),
    РИСУЕТ ("рисует", "%D1%80%D0%B8%D1%81%D1%83%D0%B5%D1%82.mp3", "%D1%80%D0%B8%D1%81%D1%83%D0%B5%D1%82.jpg")
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

    public static String getNoise6db(DataEnum  option) {
        return InitTest.baseUri + NOISE_6DB.value + option.audio;
    }

    public static String getNoise9db(DataEnum  option) {

        return InitTest.baseUri + NOISE_9DB.value + option.audio;
    }

    public static String getAudioSeries2(DataEnum  option) {

        return InitTest.baseUri + SERIES_2.value + option.audio;
    }

    public static String getPicSeries2(DataEnum  option) {
        return InitTest.baseUri + WITH_WORD.value + option.pic;
    }

    public static String getPic(DataEnum option) {
        return InitTest.baseUri + PIC.value + option.pic;
    }
}
