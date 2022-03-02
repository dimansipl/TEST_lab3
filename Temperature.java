package brokenrobotgame.model.characteristics;

import brokenrobotgame.model.GameField;
import brokenrobotgame.model.characteristics.AbstractCharacteristic;
import brokenrobotgame.model.events.RobotActionEvent;
import brokenrobotgame.model.events.RobotActionListener;
import brokenrobotgame.model.navigation.CellPosition;

import java.awt.*;
import java.util.EventObject;

public class Temperature extends AbstractCharacteristic
{
    public Temperature(GameField field, int value)
    {
        super(field, value);
    }

    @Override
    public Color drawColor() {
        return new Color(73,173,0,70);
    }

    @Override
    public String drawName() {
        return value();
    }

    @Override
    public void update(EventObject event)
    {
        if(value()<100)
            setValue(value()+2);
    }

    public class TemperatureIncreases implements RobotActionListener
    {
        @Override
        public void robotMadeMove(RobotActionEvent e)
        {
                update(e);
        }
    }
}
