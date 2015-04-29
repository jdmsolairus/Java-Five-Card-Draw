import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Handler;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CORBA.portable.ValueBase;

public class application{
	public static void main(String[] args) {
	gui gui = new gui();
	gui.setVisible(true);
	gui.setSize(585, 550);
	gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}