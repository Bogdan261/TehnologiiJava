/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.seminar2;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bogdan
 */
 // Am generat o imagine care pune un numar undeva alatoriu in partea stanga, o operatie aleatoriu in mijloc si un alt numar aleatoriu in partea dreapta
//  cercurile sunt pentur a incurca cumva utilizatorii "neumani"
@WebServlet(name = "CaptchaGenerator", urlPatterns = {"/CaptchaGenerator"})
public class CaptchaGenerator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      int d = 450;
      BufferedImage bufferedImage = new BufferedImage(d, d,BufferedImage.TYPE_INT_RGB);  
      Graphics2D g = bufferedImage.createGraphics();
      Random rand = new Random();
      int randInt1 = rand.nextInt(1000); 
      int randInt2 = rand.nextInt(10);
      int randPos1x = rand.nextInt(1000) % 100 + 30;
      int randPos1y = rand.nextInt(1000) % 100 + 30;
      int randPos2x = rand.nextInt(1000) % 150 + 100;
      int randPos2y = rand.nextInt(1000) % 150 + 100;
      int randPos3x = rand.nextInt(1000) % 200 + 200;
      int randPos3y = rand.nextInt(1000) % 200 + 200;
      String[] op = new String[2];
      op[0] = "+";
      op[1] = "-";
      int rand_op = rand.nextInt(2);
      int answer = 0;
      if(rand_op == 0) 
          answer = randInt1 + randInt2;
      else 
          answer = randInt1 - randInt2;
      
      HttpSession session = request.getSession();
      session.setAttribute("answer", answer);
      g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
      g.drawString(String.valueOf(randInt1), randPos1x, randPos1y);
      g.drawString(op[rand_op], randPos2x, randPos2y);
      g.drawString(String.valueOf(randInt2), randPos3x, randPos3y);
      for (int i = 0; i<= 10; i++)
          g.drawOval(rand.nextInt(1000) % 300 + 50 , rand.nextInt(1000) % 300 + 50, rand.nextInt(1000) % 100 + 50,rand.nextInt(1000) % 100 + 50);
      
      response.setContentType("image/png");
      OutputStream os = response.getOutputStream();
      ImageIO.write(bufferedImage, "png", os);
      os.close();
    }

   
    
}
