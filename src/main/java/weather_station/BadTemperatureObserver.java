package weather_station;

public class BadTemperatureObserver extends TemperatureObserver{

    @Override
    public void update(Observable observable) {
        if (observable instanceof WeatherStation weatherStation) {
            double temperature = weatherStation.getTemperature();
            temperature = temperature + (Math.random() * 10 - 5) ; // Add random deviation to the temperature

            if (temperature > 40) {
                temperature = 40; // Cap the temperature at 40°C
            } else if (temperature < -40) {
                temperature = -40; // Cap the temperature at -40°C
            }
            System.out.println("Current temperature (probably): " + temperature + "°C");
        }
    }
}
