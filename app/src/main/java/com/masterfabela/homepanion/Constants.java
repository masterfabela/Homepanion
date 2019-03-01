package com.masterfabela.homepanion;

public final class Constants {
    public static final int PRO_ID = 1;
    public static final int PRE_ID = 0;
    private static int entornoActivo = PRE_ID;
    public static String URL_BASE = getUrlBase();
    private static final String URL_BASE_PRE = "https://google.com";
    private static final String URL_BASE_PRO = "https://yahoo.com";

    private Constants(){}

    private static String getUrlBase(){
        if (entornoActivo == PRO_ID){
            return URL_BASE_PRO;
        } else {
            return URL_BASE_PRE;
        }
    }

}
