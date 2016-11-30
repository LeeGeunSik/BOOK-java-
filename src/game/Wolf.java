package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Random;

import javax.imageio.ImageIO;

public class Wolf extends Movable {
   BufferedImage wolf;
   BufferedImage wolfleft;
   BufferedImage wolfright;
   BufferedImage wolfback;
   Random r;

   public Wolf(int x, int y) {
      // TODO Auto-generated constructor stub
      setX(x);
      setY(y);
      setHeight(50);
      setWidth(50);
      r = new Random();//방향을 랜덤으로 바꿔주기 위한 랜덤객체
      try {
         wolf = ImageIO.read(new File("wolffront.png"));
         wolfleft = ImageIO.read(new File("wolfleft.png"));
         wolfright = ImageIO.read(new File("wolfright.png"));
         wolfback = ImageIO.read(new File("wolfback.png"));
      } catch (IOException e) {
         // TODO: handle exception
         System.out.println("늑대그림 불러오기 실패");
      }
      changeDirection();//처음 방향 설정
   }

   @Override
   public void drawObj(Graphics g) {
      // TODO Auto-generated method stub
      super.drawObj(g);
      if(xspeed > 0)
         g.drawImage(wolfright, (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
      else if(xspeed < 0)
         g.drawImage(wolfleft, (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
      else if(yspeed < 0)
         g.drawImage(wolfback, (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
      else
         g.drawImage(wolf, (int) getX(), (int) getY(), (int) getWidth(), (int) getHeight(), null);
   }
   @Override
   public void backX() {
      // TODO Auto-generated method stub
      if (bumped) {//부딪혔으면 다시 전위치로 돌아간다.
         setX(xpos);
         changeDirection();//그리고 방향을 바꿔준다.
         bumped = false;
      }
   }
   @Override
   public void backY() {
      // TODO Auto-generated method stub
      if (bumped) {//부딪혔으면 다시 전위치로 돌아간다.
         setY(ypos);
         changeDirection();//그리고 방향을 바꿔준다.
         bumped = false;
      }
      
   }
   public void turn(){
	   changeDirection();
   }
   private void changeDirection() {//늑대의 방향을 바꿔주는 메소드
      switch (r.nextInt(4)) {//0~3의 랜덤값을 생성
      case 0:
         xspeed = 2;
         yspeed = 0;
         break;
      case 1:
         xspeed = -2;
         yspeed = 0;
         break;
      case 2:
         xspeed = 0;
         yspeed = 2;
         break;

      default:
         xspeed = 0;
         yspeed = -2;
         break;
      }
   }
   

   @Override
   public String toString() {
      // TODO Auto-generated method stub
      return "wolf";
   }
}