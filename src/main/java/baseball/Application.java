package baseball;

import nextstep.utils.Randoms;
import nextstep.utils.Console;

public class Application {

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현

        // 게임 상태 관리 변수
        boolean isClosed = false;

        while (!isClosed) {
            // 게임 타이틀
            System.out.println("⚾⚾⚾⚾⚾⚾");
            System.out.println(
                "\uD83D\uDC9B\uD83D\uDC9B\uD83D\uDC9B\uD83D\uDC9B\uD83D\uDC9B\uD83D\uDC9B");
            System.out.println("⚾⚾⚾⚾⚾⚾");
            System.out.println();

            // 1 이상 9 이하의 임의의 수 생성
            int computerNumber = Randoms.pickNumberInRange(123, 987);
            while (!checkInvalidate(computerNumber, 123, 987)) {
                computerNumber = Randoms.pickNumberInRange(123, 987);
            }

            boolean isCorrect = false;
            while (!isCorrect) {
                // 사용자 수 입력
                String userInput = "ERROR";

                while (userInput.equals("ERROR")) {
                    System.out.printf("숫자를 입력해 주세요⚾️ : ");
                    userInput = inputUser();
                }
                int input = Integer.parseInt(userInput);
                System.out.println(computerNumber + " / " + input);

                // 비교
                isCorrect = checkNumber(computerNumber, input);
            }


            // 게임 진행 여부 물어보기
            int gameNumber = askGameRestart();
            if (gameNumber == 2) {
                isClosed = true;
            }
        }
        System.out.println("게임 끝");
    }

    private static int askGameRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        while (true) {
            try {
                int gameInput = Integer.parseInt(Console.readLine());
                if(checkInvalidate(gameInput, 1, 2))
                    return gameInput;
                printError();
            } catch (NumberFormatException e) {
                printError();
            }
        }
    }

    // 숫자 야구 진행 (스트라이크, 볼, 낫씽 여부 판단)
    private static boolean checkNumber(int computerNumber, int input) {
        if (computerNumber == input) return true;
        else return false;
    }

    // 시작 범위 이상 끝 범위 이하 & 서로 다른 세 수인지 & 0 포함 여부 확인
    private static boolean checkInvalidate(int input, int start, int end) {
        if (start > input || input > end) {
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
            if (!checkInvalidate(inputNum, 123, 987)) {
                printError();
                return "ERROR";
            }
        } catch (NumberFormatException e) {
            printError();
            return "ERROR";
        }

        return input;
    }

    // 사용자 입력이 잘못 됐을 경우 출력하는 함수
    private static void printError() {
        System.out.println("ERROR");
    }

}
