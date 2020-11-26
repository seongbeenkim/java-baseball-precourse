package baseball;

public class BallCountData {
    private static final int MIN = 0;
    private static final int MAX = 3;
    private static final String UNVALID_COUNT = "볼 또는 스트라이크의 수가 올바르지 않습니다.";
    private int ball;
    private int strike;

    public BallCountData() {
        this(MIN, MIN);
    }

    public BallCountData(int ball, int strike) {
        if (ball < MIN || ball > MAX || strike < MIN || strike > MAX) {
            throw new IllegalArgumentException(UNVALID_COUNT);
        }
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }
}
