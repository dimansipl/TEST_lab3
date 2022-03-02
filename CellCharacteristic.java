package brokenrobotgame.model.characteristics;

import brokenrobotgame.model.navigation.CellPosition;

import java.awt.*;
import java.util.EventObject;

public interface CellCharacteristic
{
    public CellPosition position();
    public int value();
    public Color drawColor();
    public String drawName();
    public void update(EventObject event);
    public boolean setPosition(CellPosition pos);
}
