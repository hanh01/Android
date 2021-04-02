package com.example.android_weather.model;

public class Item {
   private int WeatherIcon;
   private String IconPhrase;
   private String DateTime;
   private Temperature Temperature;


    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public com.example.android_weather.model.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.example.android_weather.model.Temperature temperature) {
        Temperature = temperature;
    }
}
