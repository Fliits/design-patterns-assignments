package weather_station;

public class Main {
    static void main() {
        WeatherStation weatherStation = new WeatherStation();
        //add 3 observers
        weatherStation.addObserver(new TemperatureObserver());
        weatherStation.addObserver(new TemperatureObserver());
        weatherStation.addObserver(new BadTemperatureObserver());
        weatherStation.start();

        //After 20 seconds, remove an observer, then continue
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Removing bad observer...");
        weatherStation.removeObserver(weatherStation.getObservers().getLast());
    }
}
