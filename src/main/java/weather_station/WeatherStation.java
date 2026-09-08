package weather_station;

public class WeatherStation extends Observable {
    //Initial temperature is random
    public double temperature = Math.random() * 80 - 40; // Random temperature between -40 and 40

    public static double maxTemperature = 50.0;
    public static double minTemperature = -50.0;

    public double getTemperature() {
        return temperature;
    }

    public void updateTemperature(double newTemperature) {
        if (newTemperature > maxTemperature) {
            maxTemperature = newTemperature;
        }
        if (newTemperature < minTemperature) {
            minTemperature = newTemperature;
        }
        temperature = newTemperature;
        notifyObservers();
    }

    //temperature updates between 1 and 5 seconds but cannot go over maxTemperature or under minTemperature
    public void start() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep((long) (Math.random() * 4000 + 1000));
                    double newTemperature = temperature + (Math.random() * 10 - 5); // Random change between -5 and 5
                    if (newTemperature > maxTemperature) {
                        newTemperature = maxTemperature;
                    }
                    if (newTemperature < minTemperature) {
                        newTemperature = minTemperature;
                    }
                    updateTemperature(newTemperature);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();
    }
}
