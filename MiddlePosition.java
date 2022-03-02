package brokenrobotgame.model.navigation;

public class MiddlePosition
{
    
    private CellPosition _cellPosition; 
    private Direction _direction;  			
    

    public Direction direction(){
        return _direction;
    }
    
    public CellPosition cellPosition(){
        return _cellPosition;
    }
    

    public MiddlePosition(CellPosition cellPos, Direction direct)
    {
        if(!cellPos.isValid())
        {
            
            throw new RuntimeException("ERROR: cell position is not valid");
        }    
        
        _cellPosition = cellPos;
        _direction = direct;
                
        normalize();
}

    private void normalize()
    {
       
        if(_direction.equals(Direction.south()) && _cellPosition.hasNext(_direction))
        {
            _cellPosition = _cellPosition.next(_direction);
            _direction = Direction.north();
        }
        
       
        if(_direction.equals(Direction.east()) && _cellPosition.hasNext(_direction))
        {
            _cellPosition = _cellPosition.next(_direction);
            _direction = Direction.west();
        }
    }

    @Override
    public MiddlePosition clone(){ 
        return new MiddlePosition(_cellPosition, _direction); 
    }

    
    public MiddlePosition next(Direction direct)
    {
        
        if(_cellPosition.hasNext(direct))
        {
            return new MiddlePosition(_cellPosition.next(direct), _direction);
        }

      
        if(_direction.isOpposite(direct))
        {
            return  new MiddlePosition(_cellPosition, _direction.opposite());
        }

     
        throw new RuntimeException();
        //return null;
    }

    public boolean hasNext(Direction direct){
	return _cellPosition.hasNext(direct) || _direction.isOpposite(direct);
    }
	


	
    public CellPosition cellPosition(Direction direct)
    {
       
        if(_direction.isOpposite(direct))
        {
            return _cellPosition.clone();
        }

        if(_direction.equals(direct) && _cellPosition.hasNext(direct))
        {
            return _cellPosition.next(direct);
        }

     
        throw new RuntimeException();
        //return null;
    }

	public boolean hasCellPosition(Direction direct)
    {
        return _direction.isOpposite(direct) || _cellPosition.hasNext(direct);
	}
        

    
    public boolean equals(Object other)
    {
        if(other instanceof MiddlePosition)
        {
           
            MiddlePosition otherPosition = (MiddlePosition)other;
            
         
            return _cellPosition.equals(otherPosition._cellPosition) && _direction.equals(otherPosition._direction);
        }
        
        return false;
    }
	
//    @Override
//    public int hashCode(){
//       
//        return _direction.hashCode()*_cellPosition.hashCode();
//    }
}