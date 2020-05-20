import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/ResponseImageServlet")
public class ResponseImageServlet extends HttpServlet {


    private static class Imagination {
        private static BufferedImage drawGraphics() {
            BufferedImage imgBuff = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = imgBuff.createGraphics();
            GeneralPath path = new GeneralPath(GeneralPath.WIND_NON_ZERO);
            path.moveTo(0.0f,0.0f);
            path.lineTo(0.0f,125.0f);
            path.quadTo(100.0f,100.0f,225.0f,125.0f);
            path.curveTo(260.0f,100.0f,130.0f,50.0f,225.0f,0.0f);
            path.closePath();
            AffineTransform at = new AffineTransform();
            at.setToRotation(-Math.PI/8.0);
            g2.transform(at);
            at.setToTranslation(0.0f,150.0f);
            g2.transform(at);
            g2.setColor(Color.green);
            g2.fill(path);
            Font exFont = new Font("TimesRoman",Font.PLAIN,40);
            g2.setFont(exFont);
            g2.setColor(Color.RED);
            g2.drawString("JavaWorld",0.0f,0.0f);
            return imgBuff;
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("image/jpeg");
        try(ServletOutputStream out = response.getOutputStream()) {
            ImageIO.write(Imagination.drawGraphics(), "jpeg", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }
}

