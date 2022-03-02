package brokenrobotgame.model;

import brokenrobotgame.model.characteristics.AbstractCharacteristic;
import brokenrobotgame.model.characteristics.CellCharacteristic;
import brokenrobotgame.model.navigation.MiddlePosition;
import brokenrobotgame.model.navigation.CellPosition;
import java.util.ArrayList;



public class GameField {

    
	
    public GameField ()
    {
        setSize(10, 10);
    }
        
    public final void setSize(int width, int height)
    {
        CellPosition.setHorizontalRange(1, width);
        CellPosition.setVerticalRange(1, height);
    }

    public int width() {
        return CellPosition.horizontalRange().length();
    }

    public int height() {
        return CellPosition.verticalRange().length();
    }
	


 
    Robot _robot;

    
    public void setRobot(Robot robot)
    {
        if(robot!=null && _robot!=robot) {
            if (_robot != null) {
                removeRobot();
            }

            _robot = robot;
            _robot.setField(this);
        }
    }

    public boolean removeRobot()
    {
        if(_robot==null)
            return false;

        Robot r = _robot;
        _robot=null;
        r.removeField();

        return true;
    }

	


    private ArrayList<WallPiece> _wallPool = new ArrayList();  

    public boolean isWall(MiddlePosition pos)
    {
        for (WallPiece obj : _wallPool)
        {
            if(obj.position().equals(pos))  return true;
        }
        
        return false;
    }
    
    public boolean addWall(MiddlePosition pos, WallPiece obj)
    {
        boolean success = obj.setPosition(pos);
        
        if(success) _wallPool.add(obj);
        
        return success;
    }

   

    private ArrayList<Door> _doorPool = new ArrayList();    

    public Door door(MiddlePosition pos)
    {
        for (Door obj : _doorPool)
        {
            if(obj.position().equals(pos))  return obj;
        }
        
        return null;
    }
    
    public boolean addDoor(MiddlePosition pos, Door obj)
    {
        boolean success = obj.setPosition(pos);
        
        if(success) _doorPool.add(obj);
        
        return success;
    }

    private ArrayList<CellCharacteristic> _characteristics = new ArrayList(); 

    public CellCharacteristic characteristic (CellPosition pos)
    {
        for (CellCharacteristic obj : _characteristics)
        {
            if(obj.position().equals(pos))  return obj;
        }

        return null;
    }

    public boolean addCharacteristic(CellPosition pos, CellCharacteristic obj)
    {
        boolean success = obj.setPosition(pos);

        if(success) _characteristics.add(obj);

        return success;
    }

    public boolean removeCharacteristic(CellCharacteristic obj)
    {
        boolean success = _characteristics.remove(obj);

        if(success) obj.setPosition(null);

        return success;
    }

 
    
    private ArrayList<AbstractBattery> _batteryPool = new ArrayList();  

    public AbstractBattery battery(CellPosition pos)
    {
        for (AbstractBattery obj : _batteryPool)
        {
            if(obj.position().equals(pos))  return obj;
        }
        
        return null;
    }
	
    public boolean addBattery(CellPosition pos, AbstractBattery obj)
    {
        boolean success = obj.setPosition(pos);
        
        if(success) _batteryPool.add(obj);
        
        return success;
    }
    
    public boolean removeBattery(AbstractBattery obj)
    {
        boolean success = _batteryPool.remove(obj);
        
        if(success) obj.setPosition(null);
        
        return success;
    }
    
    
    
    public void clear()
    {
        
        removeRobot();

        _wallPool.clear();
        _batteryPool.clear();
    }
}