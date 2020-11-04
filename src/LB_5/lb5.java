package LB_5;

import javax.swing.*;

public class lb5 {
    public static void main(String[] args) {
        JFrame jFrame = getFrame();


    }

    static JFrame getFrame(){
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setBounds(100, 100, 800, 600);
        jFrame.setTitle("LB-5");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
