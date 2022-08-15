
public class gameobject {

	private int type;
	private double x;
	private double y;
	private double w;
	private double h;
	
	gameobject(int type, double x, double y, double w,double h){
		this.type = type;
		this.x = x;
		this.y= y;
		this.w=w;
		this.h=h;
	}
	public void draw() {
		if(type==1) {
			StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledRectangle(x+(w/2), y, w/2, h/2);
		
		}else if(type==2) {
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.filledRectangle(x+(w/2), y, w/2, h/2);
			
		}
	}
	public Boolean isInside(double ball_x, double ball_y) {
		if((ball_x<this.x) && (ball_x>this.x) && (ball_y<this.y) && (ball_y>this.y)) {
			return true;
		}
		return false;
		
	}
}
