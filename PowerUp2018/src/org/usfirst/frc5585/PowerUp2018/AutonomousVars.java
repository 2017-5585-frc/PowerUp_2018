package org.usfirst.frc5585.PowerUp2018;

import edu.wpi.first.wpilibj.Timer;

/**
 * This class contains variables for use in autonomous commands. It should be fairly reusable between years.
 * commands import the instance of the class CONTAINED IN THE ROBOT CLASS. This avoids creating multiple instances of the same variables without
 * creating static classes.
 * @author Ian Bolin
 */
public class AutonomousVars {
	private int loopsRun;
	
	private double startTime;
	private double timeElapsed;
	
	private boolean gearPlaced;
	private boolean turned;
	
	private double range;
	private double distanceTraveled;
	
	public final double turnConst = -0.02; // constant to add to auto turn values to adjust for drift.
	
	/**
	 * inits class, goes in roboinit or autoinit.
	 */
	public void init() {
		loopsRun = 0;
		distanceTraveled = 0;
		timeElapsed = 0;
		startTime = 0;
		gearPlaced = false;
	}
	/**
	 * gets the number of loops recorded since last init. record loops with incrementLoopCount()
	 * @return int number of loops recorded
	 * @see #incrementLoopCount()
	 */
	public int getLoopsRun() {
		return loopsRun;
	}
	
	/**
	 * call to increment recorded loop count.
	 * @see #getLoopsRun()
	 */
	public void incrementLoopCount() {
		loopsRun += 1;
	}
	
	//distance vars
	
	/**
	 * returns distance traveled since last reset.
	 * @return double distance traveled since last reset.
	 * @see #setDistanceTraveled(double)
	 * @see #calculateDistanceTraveled(double, double)
	 * @see #resetDistanceTraveled() 
	 */
	public double getDistanceTraveled() {
		return distanceTraveled;
	}
	
	/**
	 * adds distance to distance traveled.
	 * @param distance - the distance to add to the current distance
	 */
	public void setDistanceTraveled(double distance) {
		distanceTraveled += distance;
	}
	
	/**
	 * calculates distance based on AVERAGE velocity and time. Can use getTimeElapsed()
	 * @param time - time that the robot spent traveling at SPEED
	 * @param speed - average velocity of the robot during TIME
	 */
	public void calculateDistanceTraveled(double time, double speed) {
		distanceTraveled += time * speed;
	}
	
	/**
	 * resets the distance traveled
	 */
	public void resetDistanceTraveled() {
		distanceTraveled = 0;
	}
	
	// time vars
	/**
	 * sets the start time from which all other time vars are calculated.
	 */
	public void setStartTime() {
		startTime = Timer.getFPGATimestamp(); //in seconds
	}
	
	/**
	 * gets the time since setStartTime() was called last.
	 * if {@link #setStartTime()} was not called yet, returns 0
	 * @return time in seconds since setStartTime() was called.
	 */
	public double getElapsedTime() {
		double currentTime = Timer.getFPGATimestamp();
		if (startTime != 0) {
			timeElapsed = currentTime - startTime;
			return timeElapsed;
		}
		else {
			return 0.0;
		}
	}
	
	/**
	 * returns the time left till a set amount of time has elapsed.
	 * @param endTime - duration of time period.
	 * @return time in seconds remaining
	 */
	public double getTimeRemaining(double endTime) {
		return endTime - getElapsedTime();
	}
	
	//top level vars
	/**
	 * sets whether the robot has turned to face the gear peg
	 * @param isTurned - true if gear is turned, false if gear is not turned.
	 */
	public void setTurned(boolean isTurned) {
		turned = isTurned;
	}
	
	/**
	 * @return if robot is turned
	 */
	public boolean getIsTurned() {
		return turned;
	}
	
	/**
	 * sets whether gear is placed
	 * @param placed - true if gear is placed
	 */
	public void setGearPlaced(boolean placed) {
		gearPlaced = placed;
	}
	
	/**
	 * 
	 * @return if gear is placed
	 */
	public boolean isGearPlaced() {
		return gearPlaced;
	}
	
	/**
	 * Gets the range from the ultrasonic range finder mounted to the left of the gear holder.
	 * @return the distance in inches between the rangefinder and the nearest surface.
	 */
	public double getRange() {
		//range = RobotMap.driveTrainRangeFinder.getAverageVoltage() * 89.17;
		return range;
	}
}
