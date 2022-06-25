package lesson8;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Введите название города: ");
            String city = scanner.nextLine();

            System.out.println("Введите 1 для получения погоды на сегодня" + " 5 для получения погоды на 5 дней: " + "0 - для выхода." + " 2 для получения погоды из базы данных");

            String command = scanner.nextLine();


            if("0".equals(command)) break;
            if ("5".equals(command) || "1".equals(command)) try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                System.out.println("При получении погоды произошла ошибка.Введите 1 для получения погоды на один день , или 5 - для получения погоды на 5 дней.");
            }
        }
    }

}
