/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class MonthData {

    private String label;
    private int data=0;
    private float floatData;

    public MonthData(int month) {
        this.label = this.getMonthLabel(month);
        this.data = 0;
        this.floatData = 0f;
    }

    public MonthData(int month, int data) {
        this.label = this.getMonthLabel(month);
        this.data = data;
    }
    public MonthData(int month, float data) {
        this.label = this.getMonthLabel(month);
        this.floatData = data;
    }

    public String getMonth() {
        return label;
    }

    public void setMonth(String month) {
        this.label = month;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public float getFloatData() {
        return floatData;
    }

    public void setFloatData(float floatData) {
        this.floatData = floatData;
    }

    private String getMonthLabel(int n) {
        switch (n) {
            case 1:
                return "Jan";
            case 2:
                return "Feb";
            case 3:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "May";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Aug";
            case 9:
                return "Sep";
            case 10:
                return "Oct";
            case 11:
                return "Nov";
            case 12:
                return "Dec";
            default:
                throw new IllegalArgumentException("Invalid month number: " + n);
        }
    }
}
