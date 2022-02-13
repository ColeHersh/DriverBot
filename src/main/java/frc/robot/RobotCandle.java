package frc.robot;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.ColorFlowAnimation;
import com.ctre.phoenix.led.FireAnimation;
import com.ctre.phoenix.led.RainbowAnimation;
import com.ctre.phoenix.led.RgbFadeAnimation;
import com.ctre.phoenix.led.StrobeAnimation;

public class RobotCandle {

    private final CANdle candle = new CANdle(0);
    private final RainbowAnimation r = new RainbowAnimation(1, 1, 6);
    private final FireAnimation f = new FireAnimation(1, 1, 8, .2, .4);
    private final RgbFadeAnimation fa = new RgbFadeAnimation(1, .7, 8);
    private final StrobeAnimation s = new StrobeAnimation(100, 200, 8, 255, 1, 8);
    private final ColorFlowAnimation c = new ColorFlowAnimation(100, 200, 8, 255, 1, 8,
            ColorFlowAnimation.Direction.Backward);

    public void setLEDs(int r, int g, int b) {
        candle.setLEDs(r, g, b);
    }

    public void update() {
        /*candle.setLEDs (255,0,0);
         if(m_timer.get() < 15){
          candle.setLEDs (0,255,0);
         }
         else if(m_timer.get() < 30){
          candle.setLEDs (0,0,255);
         }
         else{
         // candle.setLEDs (0,255,255);*/
         candle.animate(c);
    }

}
