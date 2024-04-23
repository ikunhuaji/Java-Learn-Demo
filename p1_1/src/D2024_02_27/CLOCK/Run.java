package D2024_02_27.CLOCK;

import D2024_02_27.CLOCK.Clock;

public class Run {
    public static void main(String[] args) {
        Clock clock=new Clock();
        new Thread(clock).start();
    }
}
