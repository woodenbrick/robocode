package DW;
import robocode.*;
import java.awt.Color;
import static robocode.util.Utils.normalRelativeAngleDegrees;
// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * DanScanBot - a robot by (your name here)
 */
public class DanScanBot extends AdvancedRobot
{
	boolean lockedOn = false;
	double gunTurnAmt;
	
	public void run() {
		setColors(Color.black,Color.black,Color.white); // body,gun,radar

		// Robot main loop
		while(true) {
			if(! lockedOn)
			{
				ahead(100);
				setTurnRadarLeft(360);
				execute();
			}
		}
	}


	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
			if(!lockedOn)
			{
				lockedOn = true;
				gunTurnAmt =normalRelativeAngleDegrees(e.getBearing() + (getHeading() - getRadarHeading()));
				setTurnGunRight(gunTurnAmt);
				//setTurnRight(e.getBearing());
			}			
			fire(1);
	}


	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		setTurnLeft(160);
	}	
}
