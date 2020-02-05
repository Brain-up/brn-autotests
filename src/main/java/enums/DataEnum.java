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
    ДУБ ("дуб", "%D0%B4%D1%83%D0%B1.mp3", "%D0%B4%D1%83%D0%B1.jpg")
    ;

    public String value, audio, pic;

    DataEnum(String value, String audio, String pic) {
        this.value = value;
        this.audio = audio;
    }

    public static String getNoNoise(DataEnum  option) {
        return InitTest.baseUri + NO_NOISE.value + option.audio;
    }

    public static String getPic(DataEnum option) {
        return InitTest.baseUri + PIC.value + option.pic;
    }
}
