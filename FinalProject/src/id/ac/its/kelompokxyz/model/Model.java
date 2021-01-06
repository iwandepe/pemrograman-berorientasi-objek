package id.ac.its.kelompokxyz.model;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;
import id.ac.its.kelompokxyz.model.Ball;
import id.ac.its.kelompokxyz.util.Commons;
import id.ac.its.kelompokxyz.view.View;

public class Model {
	
	Random ran = new Random();
    private List<Ball> balls;
    private List<Brick> bricks;
    private Paddle paddle;
	private View view;
	private int difficulty;
	private int[] numsToGenerate = new int[]
    		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,11,12};
    int timeStart = (int)(System.currentTimeMillis() /1000);
    public int time;
	
	public Model() {
		modelInit();
	}
	
    private void modelInit() {

        bricks = new ArrayList<Brick>();
        paddle = new Paddle(difficulty);
        balls = new ArrayList<Ball>();
        balls.add(new Ball(100, difficulty, 1));
        
		view = new View(balls, bricks, paddle);
        initBrick();
    }
    
    private void initBrick() {
    	for (int i = 0; i < Commons.ROW; i++) {
            for (int j = 0; j < 10; j++) {
            	if (i % 2 == 0) {
            		bricks.add(new Brick(j * 70 + 50, i * 18 + 75, 100, ran.nextInt(2)+1));
            	}
            	else {
            		bricks.add(new Brick(j * 70 + 50, i * 18 + 75, 300, i%3+1));
            	}
            }
        }
    }
    
    public void showGameMenu() {
    	view.showGameMenu();
    }
    
    public void showDifficulty() {
    	view.showDifficulty();
    }
    
    public void showCredit() {
    	view.showCredit();
    }
    
    public static int getRandom(int[] array) {
        int random = new Random().nextInt(array.length);
        return array[random];
    }
    
    public void movePaddle(int dx) {
    	paddle.setDx(dx);
    }
	
	public void checkCollision() {
    	
    	for (ListIterator<Ball> iter = balls.listIterator(); iter.hasNext(); ) {
    		Ball ball = iter.next();
    		
    		if (ball.getRect().getMaxY() > Commons.BOTTOM_EDGE) {
    			iter.remove();
    		}
        }
        
        for (Ball ball: balls) {
        	
	        if ((ball.getRect()).intersects(paddle.getRect())) {
	
	            int paddleLPos = (int) paddle.getRect().getMinX();
	            int ballLPos = (int) ball.getRect().getMinX();
	
	            int first = paddleLPos + 8;
	            int second = paddleLPos + 16;
	            int third = paddleLPos + 24;
	            int fourth = paddleLPos + 32;
	
	            if (ballLPos < first) {
	
	                ball.setXDir(-1);
	                ball.setYDir(-1);
	            }
	
	            if (ballLPos >= first && ballLPos < second) {
	
	                ball.setXDir(-1);
	                ball.setYDir(-1 * ball.getYDir());
	            }
	
	            if (ballLPos >= second && ballLPos < third) {
	
	                ball.setXDir(0);
	                ball.setYDir(-1);
	            }
	
	            if (ballLPos >= third && ballLPos < fourth) {
	
	                ball.setXDir(1);
	                ball.setYDir(-1 * ball.getYDir());
	            }
	
	            if (ballLPos > fourth) {
	
	                ball.setXDir(1);
	                ball.setYDir(-1);
	            }
	        }
        }
        
        for (ListIterator<Brick> iter = bricks.listIterator(); iter.hasNext(); ) {
        	Brick brick = iter.next();
        	
        	for (Ball ball: balls) {
	            if ((ball.getRect()).intersects(brick.getRect())) {
	
					int ballLeft = (int) ball.getRect().getMinX();
	                int ballHeight = (int) ball.getRect().getHeight();
	                int ballWidth = (int) ball.getRect().getWidth();
	                int ballTop = (int) ball.getRect().getMinY();
	
	                var pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
	                var pointLeft = new Point(ballLeft - 1, ballTop);
	                var pointTop = new Point(ballLeft, ballTop - 1);
	                var pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

	
                    if (brick.getRect().contains(pointRight)) {

                        ball.setXDir(-1);
                    } 
                    else if (brick.getRect().contains(pointLeft)) {

                        ball.setXDir(1);
                    }

                    if (brick.getRect().contains(pointTop)) {

                        ball.setYDir(1);
                    } 
                    else if (brick.getRect().contains(pointBottom)) {

                        ball.setYDir(-1);
                    }
                    
                    brick.decreaseWeight(ball.getWeight());
                    
                    if (brick.getWeight() <= 0) {
                    	iter.remove();
                		// clone the ball
                		if ( brick.getBrickType() == 11) {
                			balls.add(new Ball(ball.getX()+5, ball.getY(), 
                					ball.getWeight(), difficulty, ball.getBallType()));
                    		balls.add(new Ball(ball.getX()-5, ball.getY(), 
                    				ball.getWeight(), difficulty, ball.getBallType()));
                    		break;
                		}
                		else if (brick.getBrickType() == 12){
                			ball.setBallType(11);
                			ball.setWeight(300);
                			ball.loadImage();
                			break;
                		}
                    	
                    	int random = getRandom(numsToGenerate);
                    	
                    	if (random > 0) {
                    		iter.add(new Brick(brick.getX()+26, brick.getY(), 1, random));
                    	}
                    	
                    	break;
                    }
	            }
        	}
        }
    }

	public List<Ball> getBalls() {
		return balls;
	}

	public Paddle getPaddle() {
		return paddle;
	}
}