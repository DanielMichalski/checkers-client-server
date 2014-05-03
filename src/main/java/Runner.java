import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.game.BoardFrame;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context_base.xml");

        BoardFrame boardFrame = context.getBean("boardFrame", BoardFrame.class);
        boardFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        boardFrame.setVisible(true);
    }
}
