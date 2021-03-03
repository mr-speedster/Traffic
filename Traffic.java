import java.awt.*;
import java.awt.event.*;

class Traffic extends Frame implements ItemListener
{
    String Traffic = "";
    public Traffic() 
    {
	    Checkbox red,yellow,green;
	    CheckboxGroup group=new CheckboxGroup();
        red=new Checkbox("stop",true,group);
        red.addItemListener(this);

        yellow=new Checkbox("ready",true,group);
        yellow.addItemListener(this);

	    green=new Checkbox("start",true,group);
        green.addItemListener(this);

	    setSize(1650,1050);
	    setTitle("Traffic Signal"); 
	    setVisible(true);
        setLayout(null);
        red.setBackground(Color.red);
        red.setBounds(1000, 200, 100, 60);
        yellow.setBackground(Color.YELLOW);
        yellow.setBounds(1000, 300, 100, 60);
        green.setBackground(Color.GREEN);
        green.setBounds(1000, 400, 100, 60);

	    add(red);
	    add(yellow);
        add(green);
        
	    red.addItemListener(this);
	    yellow.addItemListener(this);
        green.addItemListener(this);
        
	    addWindowListener(new WindowAdapter()
	    {
		    public void windowClosing(WindowEvent e)
		    {
		   	 System.exit(0);
		    }
	    });
    }
    public static void main(String[] args)
    {
        new Traffic();
    }
    public void itemStateChanged(ItemEvent e)
    {
        Traffic = (e.getItem()).toString();
        repaint();
    }
    public void paint(Graphics g)
    {
        Color bgColor=Color.BLACK;
        //g.drawString("Traffic signals", 185, 250);
        g.setColor(bgColor);
        g.drawOval(200, 100, 50, 50);
        g.drawOval(200, 200, 50, 50);
        g.drawOval(200, 300, 50, 50);
        g.drawRoundRect(180, 80, 100, 300,30,30);
        g.fillRoundRect(180, 80, 100, 300,30,30);
        g.drawRect(215,380,30,300);
        g.fillRect(215,380,30,300);
        g.drawRect(180,680,100,30);
        g.fillRect(180,680,100,30);
        if (Traffic.equals("stop"))
        {
            g.setColor(Color.red);
            g.fillOval(200, 100, 50, 50);
        }
        if (Traffic.equals("ready"))
        {
            g.setColor(Color.yellow);
            g.fillOval(200, 200, 50, 50);
        }
        if (Traffic.equals("start"))
        {
            g.setColor(Color.green);
            g.fillOval(200, 300, 50, 50);
        }
    }
}
