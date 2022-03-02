package brokenrobotgame.model;

import brokenrobotgame.model.navigation.Direction;
import brokenrobotgame.model.navigation.MiddlePosition;

public class Door {
   
    private GameField _field;

    public Door(GameField field) {
        _field = field;
    }

  

    private MiddlePosition _position;
    
    public MiddlePosition position(){
        return _position;
    }

    boolean setPosition(MiddlePosition pos)
    {
        if(!_field.isWall(pos) && _field.door(pos)== null)      
        {
            _position = pos;
            return true;
        }
        
        return false;
    }
    
 
    
    public  static final int VERTICAL = 1; 
    public  static final int HORIZONTAL = 2; 
    
    public int orientation()
    {
        Direction direct = position().direction();

        if(direct.equals(Direction.south()) || direct.equals(Direction.north()))   return VERTICAL;
        if(direct.equals(Direction.west()) || direct.equals(Direction.east()))     return HORIZONTAL;

     
        throw new RuntimeException("ERROR: door has no orientation");
        //return -1;
    }  
    
    
    
    private boolean _isOpen = false;
    
    public void open(){
        _isOpen = true;
    }
    
    public void close(){
        _isOpen = false;
    }
    
    public boolean isOpen(){
        return _isOpen;
    }
}
