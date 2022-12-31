import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;
public class Task2 extends JFrame
{
    static int GuessedNo = 0;
    int Attempt = 10;
    int Score = 100;
    JLabel l1,l2,l3,l4;
    JTextField t1,t2;
    JButton b1,b2;
    public Task2(String s)
    {
        super(s);
    }
    public void setComponents()
    {
        l1= new JLabel("Attempt Left : 10");
        l2= new JLabel("Score : 0");
        l3 = new JLabel("Guess The Number");
        l4 = new JLabel("Play Game");
        t1 = new JTextField();
        b1 = new JButton("Guess");
        b2 = new JButton("Reset");
        setLayout(null);
        l1.setBounds(20,40,100,20);
        l2.setBounds(180,40,100,20);
        l3.setBounds(20,80,150,20);
        t1.setBounds(180,80,50,20);
        b1.setBounds(50,120,70,20);
        b2.setBounds(180,120,70,20);
        l4.setBounds(20,160,200,20);
        b1.addActionListener(new Handler());
        b2.addActionListener(new HandlerReset());
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(t1);
        add(b1);
        add(b2);
    }
    class Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int a = Integer.parseInt(t1.getText());
            l1.setText("Attempt Left : "+(--Attempt));
            if(a==GuessedNo)
            {
                l2.setText("Score : "+Score);
                JOptionPane.showMessageDialog(new Task2(""),"your guess is right, You Win!!!","Hurrah",JOptionPane.INFORMATION_MESSAGE);
                GuessedNo = (int)(Math.random()*(100-1+1)+1);
                Score=100;
                Attempt=10;
                l1.setText("Attempt Left : "+Attempt);
                l2.setText("Score : 0");
                l4.setText("Play Game");
            }
            else if(a<GuessedNo)
            {
                Score = Score-10;
                l2.setText("Score : "+Score);
                l4.setText("Guess a higher number");
            }
            else
            {
                Score = Score-10;
                l2.setText("Score : "+Score);
                l4.setText("Guess a lower number");
            }
            if(Attempt==0)
            {
                JOptionPane.showMessageDialog(new Task2(""),"You Loose, Play Again!!!","Loose",JOptionPane.INFORMATION_MESSAGE);
                GuessedNo = (int)(Math.random()*(100-1+1)+1);
                Score=100;
                Attempt=10;
                l1.setText("Attempt Left : "+Attempt);
                l4.setText("Play Game");
            }
        }
    }
    class HandlerReset implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            GuessedNo = (int)(Math.random()*(100-1+1)+1);
            Score=100;
            Attempt=10;
            l1.setText("Attempt Left : 10");
            l2.setText("Score : 0");
            l4.setText("Play Game");
        }
    }
    public static void main(String args[])
    {
        Task2 obj= new Task2("Guess the number");
        GuessedNo = (int)(Math.random()*(100-1+1)+1);
        obj.setComponents();
        obj.setBounds(500,180,300,300);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}