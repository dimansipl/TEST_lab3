package brokenrobotgame.model.navigation;

import java.util.HashMap;

public class CellPosition
{
   
    private static CellRange _horizontalRange = new CellRange(0, 0);
    private static CellRange _verticalRange = new CellRange(0, 0);

    public static void setHorizontalRange(int min, int max)
    {
        if(CellRange.isValidRange(min, max))
            _horizontalRange = new CellRange(min, max);
    }
    
    public static CellRange horizontalRange() {return _horizontalRange;}

    public static void setVerticalRange(int min, int max)
    {
        if(CellRange.isValidRange(min, max))
            _verticalRange = new CellRange(min, max);
    }
    
    public static CellRange verticalRange() {return _verticalRange;}
    

    private int _row;// = _verticalRange.min();
    private int _column;// = _horizontalRange.min();
    
    public CellPosition(int row, int col)
    {
        if(!isValid(row, col))
        {
            
            throw new RuntimeException("ERROR: row and column are not valid");
        }

        _row = row;
        _column = col;
    }
    
    public int row()
    {
        if(!isValid())
        {
            
            throw new RuntimeException("ERROR: row and column are not valid");
        }

        return _row;
    }

    public int column()
    {
        if(!isValid())
        {
           
            throw new RuntimeException("ERROR: row and column are not valid");
        }

        return _column;
    }
    
    
    public boolean isValid() {return isValid(_row, _column);}
    
    public static boolean isValid(int row, int col)
    {
        return _horizontalRange.contains(col) && _verticalRange.contains(row);
    }
    
    @Override
    public CellPosition clone() {return new CellPosition(_row, _column);}
    
   
    
    public CellPosition next(Direction direct)
    {
        int[] newPos = calcNewPosition(_row, _column, direct);
        return new CellPosition(newPos[0], newPos[1]);
    }

    public boolean hasNext(Direction direct)
    {
        int[] newPos = calcNewPosition(_row, _column, direct);
        return isValid(newPos[0], newPos[1]);
    }
    
    
    private int[] calcNewPosition(int row, int col, Direction direct)
    {
        
        HashMap<Direction, int [] > offset=  new  HashMap<Direction, int [] >();
        
        offset.put(Direction.north(),   new int []{ 0, -1} );
        offset.put(Direction.south(),   new int []{ 0,  1} );
        offset.put(Direction.east(),    new int []{ 1,  0} );
        offset.put(Direction.west(),    new int []{-1,  0} );
        
        int[] newPos = new int[2];
        
        newPos[0] = _row + offset.get(direct)[1];
        newPos[1] = _column + offset.get(direct)[0];
        
        return newPos;
    }
    

    
    @Override
    public boolean equals(Object other)
    {
        if(!isValid())
        {
            
            throw new RuntimeException("ERROR: row and column are not valid");
        }

        if(other instanceof CellPosition)
        {
            
            CellPosition otherPosition = (CellPosition)other;
           
            return _row == otherPosition._row && _column == otherPosition._column;
        }
        
        return false;
    }
}
