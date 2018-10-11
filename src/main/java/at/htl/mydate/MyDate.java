package at.htl.mydate;

import javax.print.DocFlavor;

/**
 * Informationen zu Enums: http://tutorials.jenkov.com/java/enums.html
 *               zu split: https://stackoverflow.com/a/3481842/9818338
 *   zur Ermittlung des Wochentages: https://de.wikipedia.org/wiki/Wochentagsberechnung#Programmierung
 */
public class MyDate {

    private int day;
    private  int month;
    private int year;



    /**
     *
     * @param input zB. "05.10.2018"
     */

    public MyDate(String input){
        String[] datum = input.split("\\.");
        for (int i = 0; i < 4; i++) {
            if (i == 0){
                setDay(Integer.parseInt(datum[i]));
            }else if(i == 1){
                setMonth(Integer.parseInt(datum[i]));
            }else if(i == 2){
                setYear(Integer.parseInt(datum[i]));
            }
        }


    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {

        this.month = month;
    }

    /**
     * Formatierung des Datums
     *
     * @return String, zB Samstag, 29. September 2018
     */
    public String formatDate(String input) {
            String formatedDate = "";
            String weekday = "";
            String monthstring = getMonthString();


            if (getWeekday().equals(Weekday.MONDAY)){
                weekday = "Montag";
            }else if (getWeekday().equals(Weekday.TUESDAY)){
                weekday = "Dienstag";
            }else if (getWeekday().equals(Weekday.WEDNESDAY)){
                weekday = "Mittwoch";
            }else if (getWeekday().equals(Weekday.THURSDAY)){
                weekday = "Donnerstag";
            }else if (getWeekday().equals(Weekday.FRIDAY)){
                weekday = "Freitag";
            }else if (getWeekday().equals(Weekday.SATURDAY)){
                weekday = "Samstag";
            }else if (getWeekday().equals(Weekday.SUNDAY)){
                weekday = "Sonntag";
            }
            formatedDate = weekday+", " + day+". "+ monthstring+" "+ year;
        return formatedDate;

    }

    private String getMonthString() {
        String monthS = "";
        if (month == 1){
            monthS = "Jänner";
        }else if(month == 2){
            monthS = "Februar";
        }else if(month == 3){
            monthS = "März";
        }else if(month == 4){
            monthS = "April";
        }else if(month == 5){
            monthS = "Mai";
        }else if(month == 6){
            monthS = "Juni";
        }else if(month == 7){
            monthS = "Juli";
        }else if(month == 8){
            monthS = "August";
        }else if(month == 9){
            monthS = "September";
        }else if(month == 10){
            monthS = "Oktober";
        }else if(month == 11){
            monthS = "November";
        }else if(month == 12){
            monthS = "Dezember";
        }
        return monthS;
    }

    private Weekday getWeekday() {
        int weekday;
        Weekday weekdayWeekday = Weekday.MONDAY;
        if (month ==1 || month ==2) {
             weekday = ((day + (int) (2.6 * ((month + 9) % 12 + 1) - 0.2)
                    + (year - 1) % 100 + (int) ((year - 1) % 100 / 4) + (int) ((year - 1) / 400)
                    - 2 * (int) ((year - 1) / 100) - 1) % 7 + 7) % 7 + 1;
        }else {
             weekday = ((day + (int) (2.6 * ((month + 9) % 12 + 1) - 0.2)
                        + year % 100 + (int) (year % 100 / 4) + (int) (year / 400)
                        - 2 * (int) (year / 100) - 1) % 7 + 7) % 7 + 1;


        }
        if (weekday == 1 ){
            weekdayWeekday = Weekday.MONDAY;
        }else if (weekday == 2){
            weekdayWeekday = Weekday.TUESDAY;
        }else if (weekday == 3){
            weekdayWeekday = Weekday.WEDNESDAY;
        }else if (weekday == 4){
            weekdayWeekday = Weekday.THURSDAY;
        }else if (weekday == 5){
            weekdayWeekday = Weekday.FRIDAY;
        }else if (weekday == 6){
            weekdayWeekday = Weekday.SATURDAY;
        }else if (weekday == 7){
            weekdayWeekday = Weekday.SUNDAY;
        }
        return weekdayWeekday;
    }

    /**
     *  Überprüfen, ob ein übergebenes Datum (other) jünger oder älter ist
     *
     * @param other
     * @return true, wenn this-Datum jünger als other-Datum ist
     *         false, wenn this-Datum jünger oder gleich other-Datum ist
     */
    public boolean isYoungerThan(MyDate other) {
        boolean isYounger = false;
            if(other.year < year){
                isYounger = true;
            }else if (other.year == year && other.month < month) {
                isYounger = true;
            } else if (other.year == year && other.month == month && other.day < day) {
                isYounger = true;
            }
        return isYounger;

    }
}
