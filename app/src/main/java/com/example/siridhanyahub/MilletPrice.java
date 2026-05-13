package com.example.siridhanyahub;
public class MilletPrice {
    private String milletName;   // e.g. "Navane"
    private String city;          // e.g. "Davangere"
    private double currentPrice;  // e.g. 45.50
    private double weekHigh;
    private double weekLow;
    private String trend;         // "UP" or "DOWN"
    // Constructor
    public MilletPrice(String milletName, String city,
                       double currentPrice, double weekHigh,
                       double weekLow, String trend) {
        this.milletName = milletName;
        this.city = city;
        this.currentPrice = currentPrice;
        this.weekHigh = weekHigh;
        this.weekLow = weekLow;
        this.trend = trend;
    }
    // Getters
    public String getMilLetName() { return milletName; }
    public String getCity() { return city; }
    public double getCurrentPrice() { return currentPrice; }
    public double getWeekHigh() { return weekHigh; }
    public double getWeekLow() { return weekLow; }
    public String getTrend() { return trend; }
}