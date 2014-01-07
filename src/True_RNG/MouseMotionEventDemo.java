package True_RNG;

//import items.BlankArea;
//import items.MouseMotionEventDemo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MouseMotionEventDemo extends JPanel
implements MouseMotionListener {
BlankArea blankArea;
JTextArea textArea;
static final String NEWLINE = System.getProperty("line.separator");

File outputFile = new File("newfile.txt");
FileWriter fileWriter = null;

public void runmouse() {

try {
	
  UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
} catch (UnsupportedLookAndFeelException ex) {
    ex.printStackTrace();
} catch (IllegalAccessException ex) {
    ex.printStackTrace();
} catch (InstantiationException ex) {

    ex.printStackTrace();
} catch (ClassNotFoundException ex) {
    ex.printStackTrace();
}

UIManager.put("swing.boldMetal", Boolean.FALSE);
javax.swing.SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        createAndShowGUI();
    }
});
}


private static void createAndShowGUI() {
//Create and set up the window.
JFrame frame = new JFrame("MouseMotionEventDemo");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//Create and set up the content pane.
JComponent newContentPane = new MouseMotionEventDemo();
newContentPane.setOpaque(true); //content panes must be opaque
frame.setContentPane(newContentPane);

//Display the window.
frame.pack();
frame.setVisible(true);
}

public MouseMotionEventDemo() {
super(new GridLayout(0,1));

try {
	fileWriter = new FileWriter(outputFile, true);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

blankArea = new BlankArea(Color.WHITE);
add(blankArea);

textArea = new JTextArea();
textArea.setEditable(false);
JScrollPane scrollPane = new JScrollPane(textArea,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scrollPane.setPreferredSize(new Dimension(200, 75));

add(scrollPane);

//Register for mouse events on blankArea and panel.
blankArea.addMouseMotionListener(this);
addMouseMotionListener(this);

setPreferredSize(new Dimension(1200, 2000));
setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
}

void eventOutput(String eventDescription, MouseEvent e) {

String outMessage = eventDescription
        + " (" + e.getX() + "," + e.getY() + ")"
        + " detected on "
        + e.getComponent().getClass().getName()
        + NEWLINE;
int a=e.getX();
int b=e.getY();
String s =Integer.toBinaryString(a);
String y=Integer.toBinaryString(b);
try {
	fileWriter.flush();
	fileWriter.write(s+y);   //File writing is done here
	fileWriter.flush();
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

textArea.append(outMessage);
textArea.setCaretPosition(textArea.getDocument().getLength());
}

public void mouseMoved(MouseEvent e) {
eventOutput("Mouse moved", e);
}

public void mouseDragged(MouseEvent e) {
eventOutput("Mouse dragged", e);
}
}


