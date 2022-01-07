package baseball;

import nextstep.utils.Randoms;
import nextstep.utils.Console;

public class Application {

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현

        // 게임 상태 관리 변수
        boolean isRunned = true;

        while (isRunned) {
            // 게임 타이틀
            System.out.println("⚾⚾⚾⚾⚾⚾");
            System.out.println(
                "\uD83D\uDC9B\uD83D\uDC9B\uD83D\uDC9B\uD83D\uDC9B\uD83D\uDC9B\uD83D\uDC9B");
            System.out.println("⚾⚾⚾⚾⚾⚾");
            System.out.println();

            // 1 이상 9 이하의 임의의 수 생성
            int computerNumber = Randoms.pickNumberInRange(123, 987);
            while (!checkInvalidate(computerNumber)) {
                computerNumber = Randoms.pickNumberInRange(123, 987);
            }

            // 사용자 수 입력
            String userInput = "ERROR";

            while (userInput.equals("ERROR")) {
                System.out.printf("숫자를 입력해 주세요⚾️ : ");
                userInput = inputUser();
            }
            int input = Integer.parseInt(userInput);
            System.out.println(computerNumber + " / " + input);
            // 비교
            // String info = checkNumber(computerNumber, userInput);

            // 게임 시
        }

    }

    // 123 이상 987 이하 & 서로 다른 세 수인지 & 0 포함 여부 확인
    private static boolean checkInvalidate(int input) {
        if (123 > input || input > 987) {
            return false;
        }
        int[] arrayNum = new int[10];
        while (input != 0) {
            int num = input % 10;
            if (arrayNum[num] != 0 || num == 0) {
                return false;
            }
            arrayNum[num] = 1;
            input = input / 10;
        }
        return true;
    }

    // 사용자가 범위 내의 수를 입력했는지 확인
    private static String inputUser() {
        String input = Console.readLine();
        try {
            int inputNum = Integer.parseInt(input);
            if (123 > inputNum || inputNum > 987) {
                printError();
                return "ERROR";
            }
            if (!checkInvalidate(inputNum)) {
                printError();
                return "ERROR";
            }
        } catch (NumberFormatException e) {
            printError();
            return "ERROR";
        }

        return input;
    }

    // 사용자 입력이 잘 못 됐을 경우 출력하는 함수
    private static void printError() {
        System.out.println("ERROR");
    }

}
