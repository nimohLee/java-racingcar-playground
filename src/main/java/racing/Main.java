package racing;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static RandomUtil randomUtil = new RandomUtil();
    private static Scanner scanner = new Scanner(System.in);
    private static Referee referee = new Referee();

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputCarList = scanner.nextLine();
        CarGenerator carGenerator = new CarGenerator();
        List<Car> carList = carGenerator.generate(inputCarList);

        System.out.println("시도할 회수는 몇 회인가요?");
        int inputCount = scanner.nextInt();

        System.out.println("실행 결과");
        printRoundResult(carList);
        for (int i = 0; i < inputCount; i++) {
            playRound(carList);
            printRoundResult(carList);
        }
        List<Car> winners = referee.rank(carList);

        System.out.println(winners.toString() + "가 최종 우승했습니다.");
    }

    private static void printRoundResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.getPositionDash());
        }
        System.out.println();
    }

    private static void playRound(List<Car> carList) {
        for (Car car : carList) {
            car.play(randomUtil.makeNumberZeroToNine());
        }
    }
}
