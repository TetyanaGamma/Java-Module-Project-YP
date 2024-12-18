import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //Создаем структуру данных для хранения машин
        ArrayList<Car> carsList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите название машины №" + (i + 1));
            String name = scanner.next();
           System.out.println("Введите скорость машины №" + (i + 1));
            int speed;

            while (true) {
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    if (speed <= 0 || speed > 250) {
                        System.out.println("Error. Please, try again");
                    } else {
                       break;
                    }
                } else {
                    System.out.println("Error. Please, try again");
                    scanner.next();
                }
            }

            //заполняем список
            Car car = new Car(name, speed);
            carsList.add(car);
        }
        //применяем метод по определению лидера гонки
        Race race = new Race(carsList);
        race.defendLeader();
        System.out.println("Самая быстрая машина: " + race.getLeaderName());
        scanner.close();
    }
}