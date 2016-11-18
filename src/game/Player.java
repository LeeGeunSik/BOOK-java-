package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Movable {

   BufferedImage player;
   BufferedImage playerleft;
   BufferedImage playerright;
   BufferedImage playerback;
   public Player() {
      // TODO Auto-generated constructor stub
      setX(100);
      setY(100);
      setHeight(45);
      setWidth(45);
      try{
         player = ImageIO.read(new File("front.png"));//�÷��̾� �̹��� �ҷ�����
         playerleft = ImageIO.read(new File("left.png"));
         playerright = ImageIO.read(new File("right.png"));
         playerback = ImageIO.read(new File("back.png"));
      } 
      catch(IOException e){
         System.out.println("�÷��̾� �̹��� �ҷ����� ����");
      }
      setSpeed(2);//�÷��̾� �ӵ�
   }
   @Override
   public void drawObj(Graphics g) {
      // TODO Auto-generated method stub
      super.drawObj(g);
      if(getXspeed() > 0)
         g.drawImage(playerright, (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);//�ڽ��� �׸��� �޼ҵ� TimerŬ�������� �� �޼ҵ带 ȣ���Ѵ�.
      else if(getXspeed() < 0)
         g.drawImage(playerleft, (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
      else if(getYspeed() < 0)
         g.drawImage(playerback, (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
      else
         g.drawImage(player, (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
   }
   @Override
   public String toString() {
      // TODO Auto-generated method stub
      return "player";
   }
}