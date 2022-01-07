package baseball;

import nextstep.utils.Randoms;
import nextstep.utils.Console;

public class Application {

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현

        // 게임 상태 관리 변수
        boolean isRunned = true;

        while (isRunned) {
            System.out.println("⚾⚾⚾⚾⚾⚾");
            System.out.println("\uD83D\uDC9B\uD83D\uDC9B\uD83D\uDC9B\uD83D\uDC9B\uD83D\uDC9B\uD83D\uDC9B");
            System.out.println("⚾⚾⚾⚾⚾⚾");
            System.out.println();

            // 1 이상 9 이하의 임의의 수 생성
            int computerNumber = Randoms.pickNumberInRange(1,9);

            // 사용자 수 입력
            System.out.printf("숫자를 입력해 주세요⚾️ : ");
            String userInput = Console.readLine();

            // 게임 시
        }

    }
}
