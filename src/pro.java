import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class pro {
	public static void main(String[] args) {
		StdDraw.setCanvasSize(700, 500);
		StdDraw.setXscale(0, 1800);
		StdDraw.setYscale(0, 300);
		// TODO Auto-generated method stub
		String fileName = "data1.txt";// txt file data1
		File file = new File(fileName);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println(fileName + ": city file can not be found!\nExiting program...");
			System.exit(1);
		}
		ArrayList<gameobject> GameObjects = new ArrayList<>();
		while (scanner.hasNextLine()) {
			String[] parts = scanner.nextLine().split(";");
			int Type = Integer.parseInt(parts[0]);
			double xCoord = Double.parseDouble(parts[1]);// split file to x coordinate
			double yCoord = Double.parseDouble(parts[2]);// split file to y coordinate
			double w = Double.parseDouble(parts[3]);// split file to width
			double h = Double.parseDouble(parts[4]);// split file to height
			gameobject object = new gameobject(Type, xCoord, yCoord, w, h);
			GameObjects.add(object);
		}
		double X_ball = 100;
		double Y_ball = 40;
		double velocity = 100;
		double angle = 45;
		double theta = angle * Math.PI / 180.0;
		double vx = velocity * Math.cos(theta);
		double vy = velocity * Math.sin(theta);
		int keyboardPauseDuration = 1;
		// main animation loop
		for (int i = 0; i < GameObjects.size(); i++) {

			GameObjects.get(i).draw();
		}
		while (true) {

			if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
				// Move the rectangle to the left
				velocity -= 1;
				StdDraw.pause(keyboardPauseDuration);

			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
				// Move right
				velocity += 1;
				StdDraw.pause(keyboardPauseDuration);

			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
				// Move up
				angle += 1;
				StdDraw.pause(keyboardPauseDuration);

			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
				// Move down
				angle -= 1;
				StdDraw.pause(keyboardPauseDuration);
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_Q)) {

				System.exit(0);
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_P)) {

				Boolean x = true;
				if (x==true) {
					x=false;
				}
					
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
				Boolean crashk = true;

				double dt = 0;
				while ((Y_ball >= 0) || (crashk = false)) {
					X_ball = 100;
					Y_ball = 40;
					dt += 0.02;
					X_ball = X_ball + vx * dt;
					Y_ball = Y_ball + (vy * dt) - (9.81 * Math.pow(dt, 2));
					StdDraw.point(X_ball, Y_ball);
					for (int i = 0; i < GameObjects.size(); i++) {
						if (GameObjects.get(i).isInside(X_ball, Y_ball)) {
							crashk = true;
						}

					}
					

					StdDraw.pause(keyboardPauseDuration);

				}
				
				StdDraw.show();
				StdDraw.pause(20000);
			}
			// clear the screen, draw the rectangle, and show it on the screen
			StdDraw.setPenColor(StdDraw.PINK);
			StdDraw.filledRectangle(50, 20, 50, 20);
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.text(X_ball, Y_ball, "O");
			StdDraw.line(100, 40, 100 + vx, 40 + vy);
			StdDraw.arc(50, 20, 0.2, angle, 0);
			vx = velocity * Math.cos(angle * (Math.PI / 180.0));
			vy = velocity * Math.sin(angle * (Math.PI / 180.0));
			StdDraw.text(150, 220, "Velcotiy : " + velocity);
			StdDraw.text(150, 200, "Angle : " + angle);
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.text(1500, 290, "Press P to play again,Q to quit");
			StdDraw.text(1500, 280, "wait until the ball drops");
			
			
		}

	}
}
