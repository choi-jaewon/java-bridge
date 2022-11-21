package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static bridge.view.InputView.*;
import static bridge.view.OutputView.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgeMaker bridgeMaker;
    private Bridge bridge;

    /**
     * 게임을 시작할 때 및 전체적인 게임을 진행하는 메서드
     */
    public void start() {
        printStart();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = Bridge.make(readBridgeSize());
        System.out.println(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Result move() {
        List<String> user = new ArrayList<>();
        while (bridge.isProceeding(user)) {
            printMoveOptionInput();
            user.add(readMoving());
            printMap(bridge, user);
            if (bridge.compare(user).equals(Result.FAIL)) {
                return Result.FAIL;
            }
        }
        return Result.SUCCESS;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
