package DW;
import robocode.*;
import java.awt.Color;
import java.util.Random;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * DanBot - a robot by (your name here)
 */
public class DanBot extends AdvancedRobot
{
	boolean lockedOn = false; //set to true when we have found a robot
	
	
	public void run() {
		setColors(Color.black,Color.black,Color.green); // body,gun,radar
		Random randomiser = new Random();
		int strafeDirection; // will be set randomly, 0 for left 1 for right 
		int strafeAmount; //also random, how much we will move from side to side
		//main loop
		while(true) {
			//we will move ahead, while randomly moving side to side until we spot a robot
			ahead(1000);
			strafeDirection = randomiser.nextInt(2);
			strafeAmount = randomiser.nextInt(5);
			if(strafeDirection == 0)
			{
				setTurnLeft(strafeAmount);
			}
			else
			{
				setTurnRight(strafeAmount);	
			}
		if(!lockedOn)
		{
			turnGunRight(40);
			turnGunLeft(60);
		}
		execute();
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
		lockedOn = true;
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		
		setTurnRight(100);
		ahead(100);
	}	
}
