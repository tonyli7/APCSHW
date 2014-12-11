import java.awt.event.*;
import javax.swing.*;
import java.awt.*; //needed for pane
public class CF extends JFrame implements ActionListener{
    private Container pane;
    private JButton convert,clear;
    private JLabel l;
    private JTextField input;
    private Container buttons;
    private Container textyStuff;
    private JCheckBox box;

    public CF() {
	this.setTitle("C->F,F->C");
	this.setSize(600,100);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
	pane = this.getContentPane();
	pane.setLayout(new GridLayout(2,1));

	l = new JLabel("Temp:",null,JLabel.CENTER);
	convert = new JButton("Convert");
	clear = new JButton("Clear");
	input = new JTextField(40);
	box = new JCheckBox("Celcius to Fahrenheit");

	// make the buttons call the actionListener
	convert.setActionCommand("execute");
	convert.addActionListener(this);
	clear.setActionCommand("delete");
	clear.addActionListener(this);

	buttons = new Container();
	buttons.setLayout(new FlowLayout());
	buttons.add(clear);
	buttons.add(convert);
	buttons.add(box);
 				
	textyStuff = new Container();
	textyStuff.setLayout(new FlowLayout());
	textyStuff.add(l);
	textyStuff.add(input);

	//add the 2 containers
	pane.add(textyStuff);
	pane.add(buttons);
				
    }
    //look at which command is being executed, and choose an action
    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	//System.out.println(action);
	if(action.equals("execute")){
	    double i = Integer.parseInt(input.getText());
	    if(box.isSelected()){
		i=1.8*i+32;
	    }else{
		i=(i-32)*(5.0/9);
	    }
	    input.setText(""+i);
	}
	if(action.equals("delete")){
	    input.setText("");
	}
    }

    public static void main(String[] args) {
	CF g = new CF();
	g.setVisible(true);
    }

}

