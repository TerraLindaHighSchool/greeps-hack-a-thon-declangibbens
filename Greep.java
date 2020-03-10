    import greenfoot.*;
    
    /**
     * A Greep is an alien creature that likes to collect tomatoes.
     * 
     * @author (your name here)
     * @version 0.2
     */
    public class Greep extends Creature
    {
        // Remember: you cannot extend the Greep's memory. So:
        // no additional fields (other than final fields) allowed in this class!
        public int count;
        public int x = 0;
        public int y = 0;
        /**
         * Default constructor for testing purposes.
         */
        public Greep()
        {
            this(null);
        }
        
        /**
         * Create a Greep with its home space ship.
         */
        public Greep(Ship ship)
        {
            super(ship);
        }
        
    
        /**
         * Do what a greep's gotta do.
         */
        public void act()
        {
            super.act();   // do not delete! leave as first statement in act().
            
            if (carryingTomato()) {
                if (atShip()) {
                    dropTomato();
                    count++;
                }
                else {
                    if (atWater())
                    {
                        turn(50);
                        move();
                    }
                    else
                    {
                        turnHome();
                        move();
                        spit("red");
                        
                    }
                }
            }
            else {
                if (count > 0 & carryingTomato() !=true )
                {
                    
                    if (atWater())
                    {
                        turn(40);
                        move();
                    }
                    else
                    {
                        turnTowards(x ,y);
                        move();
                    }
                    if (isAtEdge())
                    {
                        turn(10);
                    }
                }
                
                else
                {
                    move();
                    checkFood();
                    if (atWater())
                    {
                        turn(10);
                    }
                    if (isAtEdge())
                    {
                        turn(10);
                    }
            }
        }
       
    }
    
    public void avoidObstacle()
    {
        turn(10);
        move();
    }
    
    /**
     * Is there any food here where we are? If so, try to load some!
     */
    public void checkFood()
    {
        // check whether there's a tomato pile here
        TomatoPile tomatoes = (TomatoPile) getOneIntersectingObject(TomatoPile.class);
        if (tomatoes != null) {
            loadTomato();
            // Note: this attempts to load a tomato onto *another* Greep. It won't
            // do anything if we are alone here.
            x = getX();
            y = getY();
        }
    }
    

    /**
     * This method specifies the name of the author (for display on the result board).
     */
    public static String getAuthorName()
    {
        return "Declan Gibbens";  // write your name here!
    }

    /**
     * This method specifies the image we want displayed at any time. (No need 
     * to change this for the competition.)
     */
    public String getCurrentImage()
    {
        if (carryingTomato()) {
            return "greep-with-food.png";
        }
        else {
            return "greep.png";
        }
    }
}