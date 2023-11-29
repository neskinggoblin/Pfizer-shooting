package com.game.src.main;

public class Position {
	
	public static int PROXIMITY_RANGE = 5;
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public static Position copyOf(Position position) {
        return new Position(position.getX(), position.getY());
    }
    
    public int intX() {
        return (int) Math.round(x);
    }

    public int intY() {
        return (int) Math.round(y);
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
