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

            // 1 이상 9 이하의 임의의 수 3번 생성
            int[] arrComputer = new int[3];
            int indexComputer = 0;
            while (indexComputer != 3) {
                arrComputer[indexComputer] = Randoms.pickNumberInRange(1, 9);
                if (checkInvalidate(arrComputer, indexComputer)) {
                    indexComputer += 1;
                }
            }

            for(int i = 0; i<3; i++) {
                System.out.println(arrComputer[i]);
            }
//            boolean isCorrect = false;
//            while (!isCorrect) {
//                // 사용자 수 입력
//                String userInput = "ERROR";
//
//                while (userInput.equals("ERROR")) {
//                    System.out.printf("숫자를 입력해 주세요 : ");
//                    userInput = inputUser();
//                }
//                int input = Integer.parseInt(userInput);
//
//                // 비교
//                isCorrect = checkNumber(computerNumber, input);
//            }
//
//            // 게임 진행 여부 물어보기
//            int gameNumber = askGameRestart();
//            if (gameNumber == 2) {
//                isClosed = true;
//            }
        }
        System.out.println("게임 끝");
    }

    private static boolean checkInvalidate(int[] arr, int index) {
        int curNum = arr[index];
        for (int i = 0; i < index; i++) {
            if (curNum == arr[i]) {
                return false;
            }
        }
        return true;
    }

//    private static int askGameRestart() {
//        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//
//        while (true) {
//            try {
//                int gameInput = Integer.parseInt(Console.readLine());
//                if (checkInvalidate(gameInput, 1, 2)) {
//                    return gameInput;
//                }
//                printError();
//            } catch (NumberFormatException e) {
//                printError();
//            }
//        }
//    }

    // 숫자 야구 진행 (스트라이크, 볼, 낫씽 여부 판단)
    private static boolean checkNumber(int computerNumber, int input) {

        if (computerNumber == input) {
            System.out.println("3스트라이크");
            return true;
        }

        int sameCount = 0;
        int strikeCount = 0;

        int[] arrComputer = new int[3];
        int[] numComputer = new int[10];
        int[] arrUser = new int[3];
        int[] numUser = new int[10];

        int index = 2;
        while (computerNumber != 0) {
            arrComputer[index] = computerNumber % 10;
            arrUser[index] = input % 10;
            numComputer[arrComputer[index]] = 1;
            numUser[arrUser[index]] = 1;
            computerNumber /= 10;
            input /= 10;
            index -= 1;
        }

        // 같은 수 몇 개인지 확인
        for (int i = 1; i < 10; i++) {
            if (numComputer[i] != 0 && numComputer[i] == numUser[i]) {
                sameCount += 1;
            }
        }

        // 같은 자리 & 같은 수 몇 개인지 확인
        for (int i = 0; i < 3; i++) {
            if (arrComputer[i] == arrUser[i]) {
                strikeCount += 1;
            }
        }

        if (sameCount == 0) {
            System.out.println("낫싱");
            return false;
        } else if (strikeCount == 0) {
            System.out.println(sameCount + "볼");
            return false;
        } else if (sameCount - strikeCount == 0) {
            System.out.println(strikeCount + "스트라이크");
            return false;
        } else if (sameCount - strikeCount > 0) {
            System.out.println((sameCount - strikeCount) + "볼 " + strikeCount + "스트라이크");
            return false;
        }

        return false;
    }

    // 시작 범위 이상 끝 범위 이하 & 서로 다른 세 수인지 & 0 포함 여부 확인


    // 사용자가 범위 내의 수를 입력했는지 확인
//    private static String inputUser() {
//        String input = Console.readLine();
//        try {
//            int inputNum = Integer.parseInt(input);
//            if (!checkInvalidate(inputNum, 123, 987)) {
//                printError();
//                return "ERROR";
//            }
//        } catch (NumberFormatException e) {
//            printError();
//            return "ERROR";
//        }
//
//        return input;
//    }

    // 사용자 입력이 잘못 됐을 경우 출력하는 함수
    private static void printError() {
        System.out.println("ERROR");
    }

}
