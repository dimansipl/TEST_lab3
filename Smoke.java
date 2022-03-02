package brokenrobotgame.model.characteristics;

import brokenrobotgame.model.GameField;
import brokenrobotgame.model.events.RobotActionEvent;
import brokenrobotgame.model.events.RobotActionListener;
import brokenrobotgame.model.navigation.CellPosition;

import java.awt.*;
import java.util.EventObject;

public class Smoke extends AbstractCharacteristic
{
    public Smoke (GameField field, int value)   {
        super(field, value);
    }

    @Override
    public Color drawColor() {
        return new Color(176,176,176,80);
    }

    @Override
    public String drawName() {
        return value();
    }

    @Override
    public void update(EventObject event)
    {
        if(value()>0)
            setValue(value()-2);
    }

    public class SmokeDecreases implements RobotActionListener
    {
        @Override
        public void robotMadeMove(RobotActionEvent e)
        {

                update(e);
        }
    }
}
