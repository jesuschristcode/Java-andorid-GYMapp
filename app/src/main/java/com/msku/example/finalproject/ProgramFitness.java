package com.msku.example.finalproject;

import java.util.Map;

public class ProgramFitness {
    private String Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday;
    public ProgramFitness() {
        // Firestore'dan veri çekildiğinde kullanılacak parametresiz constructor
    }

    public ProgramFitness(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) {
        Monday = monday;
        Tuesday = tuesday;
        Wednesday = wednesday;
        Thursday = thursday;
        Friday = friday;
        Saturday = saturday;
        Sunday = sunday;
    }

    public String getMonday() {
        return Monday;
    }

    public void setMonday(String monday) {
        Monday = monday;
    }

    public String getTuesday() {
        return Tuesday;
    }

    public void setTuesday(String tuesday) {
        Tuesday = tuesday;
    }

    public String getWednesday() {
        return Wednesday;
    }

    public void setWednesday(String wednesday) {
        Wednesday = wednesday;
    }

    public String getThursday() {
        return Thursday;
    }

    public void setThursday(String thursday) {
        Thursday = thursday;
    }

    public String getFriday() {
        return Friday;
    }

    public void setFriday(String friday) {
        Friday = friday;
    }

    public String getSaturday() {
        return Saturday;
    }

    public void setSaturday(String saturday) {
        Saturday = saturday;
    }

    public String getSunday() {
        return Sunday;
    }

    public void setSunday(String sunday) {
        Sunday = sunday;
    }
    @Override
    public String toString() {
        return "ProgramFitness{" +
                "Monday='" + Monday + '\'' +
                ", Tuesday='" + Tuesday + '\'' +
                ", Wednesday='" + Wednesday + '\'' +
                ", Thursday='" + Thursday + '\'' +
                ", Friday='" + Friday + '\'' +
                ", Saturday='" + Saturday + '\'' +
                ", Sunday='" + Sunday + '\'' +
                '}';
    }
}
