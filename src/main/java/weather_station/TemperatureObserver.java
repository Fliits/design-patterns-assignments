package weather_station;

public class TemperatureObserver implements Observer {
    private double temperature;

    @Override
    public void update(Observable observable) {
        if (observable instanceof WeatherStation weatherStation) {
            this.temperature = weatherStation.getTemperature();
            display();
        }
    }

    public void display() {
        System.out.println("Current temperature: " + temperature + "°C");
    }

}
