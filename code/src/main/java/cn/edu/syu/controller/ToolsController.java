package cn.edu.syu.controller;

import cn.edu.syu.po.User;
import cn.edu.syu.service.UserService;
import com.sun.beans.editors.ColorEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
public class ToolsController {
    private static final int WIDTH = 60;
    private static final int HEIGHT=20;
    @Autowired
    private UserService userService;
    @RequestMapping("/findUser")
    public String findUserById(Integer id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user";
    }
    @RequestMapping("checkServlet")
    public String checkServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        response.setContentType("image/jpeg");
        ServletOutputStream sos=response.getOutputStream();
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
        BufferedImage image=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_BGR);
        Graphics g=image.getGraphics();
        char[] rands=generateCHeckCode();
        drawBackground(g);
        drawBands(g,rands);
        g.dispose();
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ImageIO.write(image,"JPEG",bos);
        byte[] buf=bos.toByteArray();
        response.setContentLength(buf.length);
        sos.write(buf);
        bos.close();
        sos.close();
        session.setAttribute("check_code",new String(rands));
        return "check_code";
    }

    private void drawBands(Graphics g,char[] rands) {
        g.setColor(Color.BLACK);
        g.setFont(new Font(null,Font.ITALIC|Font.BOLD,18));
        g.drawString(""+rands[0],1,17);
        g.drawString(""+rands[1],16,15);
        g.drawString(""+rands[2],31,18);
        g.drawString(""+rands[3],46,16);
        System.out.print("验证码：");
        System.out.println(rands);
    }

    private void drawBackground(Graphics g) {
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0,0,WIDTH,HEIGHT);
        for (int i = 0; i < 120; i++) {
            int x= (int) (Math.random()*WIDTH);
            int y= (int) (Math.random()*HEIGHT);
            int red= (int) (Math.random()*255);
            int green= (int) (Math.random()*255);
            int blue= (int) (Math.random()*255);
            g.setColor(new Color(red,green,blue));
            g.drawOval(x,y,1,0);
        }
    }

    private char[] generateCHeckCode() {
        String chars="0123456789abcdefghijklmnopqrstuvwxyz";
        char[] rands=new char[4];
        for (int i = 0; i < 4; i++) {
            int rand= (int) (Math.random()*36);
            rands[i]=chars.charAt(rand);
        }
        return rands;
    }
}
