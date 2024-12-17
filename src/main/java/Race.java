import java.util.ArrayList;

public class Race {
    ArrayList<Car> carsList;
    String leaderName;

    public Race(ArrayList<Car> carsList) {
        this.carsList = carsList;
    }

    //создаем метод по определению лидера гонки
    public void defendLeader() {
        //проверяем не пустой ли список
        if (carsList == null || carsList.isEmpty()) {
            leaderName = "Error";
            return;
        }
        // если список не пустой определяем машину - лидер как первую в списке
        Car topCar = carsList.get(0);
        leaderName = topCar.name;
        // вычисляем пройденную дистанцию
        if (carsList.size() > 1) {
            for (int i = 1; i < carsList.size(); i++) {
                int topCarSpeed = calculateDistance(topCar.speed, 24);
                int currentCarSpeed = calculateDistance(carsList.get(i).speed, 24);
                // определяем лидера и сохраняем имя машины
                if (currentCarSpeed > topCarSpeed) {
                    topCar = carsList.get(i);
                    leaderName = topCar.name;
                }
            }
        }
    }

    public int calculateDistance(int speed, int time) {
        return speed * time;
    }

    public String getLeaderName() {
        return leaderName;
    }
}
