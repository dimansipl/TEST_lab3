package brokenrobotgame.model.characteristics;

import brokenrobotgame.model.GameField;
import brokenrobotgame.model.characteristics.AbstractCharacteristic;
import brokenrobotgame.model.events.RobotActionEvent;
import brokenrobotgame.model.events.RobotActionListener;
import brokenrobotgame.model.navigation.CellPosition;

import java.awt.*;
import java.util.EventObject;

public class Radiation extends AbstractCharacteristic
{
    public Radiation(GameField field, int val)
    {
        super(field, val);
    }

    @Override
    public Color drawColor()
    {
        return new Color(255, 255, 0, 60);
    }

    @Override
    public String drawName() {
        return value();
    }

    @Override
    public void update(EventObject event)
    {
        if(value()>0)
        setValue(value()-1);
    }

    public class RadiationDecreases implements RobotActionListener
    {
        @Override
        public void robotMadeMove(RobotActionEvent e)
        {

                update(e);
        }
    }
}
