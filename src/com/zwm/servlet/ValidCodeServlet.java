package com.zwm.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

@WebServlet("/validcode")
public class ValidCodeServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建一张图片
        BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);

        //透明的玻璃
        //向画板上画内容之前必须先设置画笔
        Graphics2D gra = image.createGraphics();

        gra.setColor(Color.WHITE);
        //从哪个坐标开启填充，矩形区域
        gra.fillRect(0,0,200,100);

        ArrayList<Integer> randList = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            randList.add(random.nextInt(10));
        }
        gra.setColor(Color.BLACK);
        //设置字体
        gra.setFont(new Font("宋体", Font.BOLD|Font.ITALIC, 30));
        Color[] colors = new Color[]{Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.PINK, Color.GRAY};
        for (int i = 0; i < randList.size(); i++) {
            gra.setColor(colors[random.nextInt(colors.length-1)]);
            gra.drawString(randList.get(i)+"", i *40, 50 + (random.nextInt(21) - 10));
        }

        gra.setColor(colors[random.nextInt(colors.length- 1)]);
        //画横线
        for (int i = 0; i < 2; i++) {
            gra.drawLine(0, random.nextInt(101), 200, random.nextInt(101));
            gra.drawString("",0 , 50);
        }

        ServletOutputStream outputStream = resp.getOutputStream();
        //工具类
        ImageIO.write(image, "jpg", outputStream);
    }
}
