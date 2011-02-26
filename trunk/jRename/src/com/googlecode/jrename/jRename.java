package com.googlecode.jrename;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.googlecode.jrename.gui.MenuPane;
import com.googlecode.jrename.gui.Resources;
import com.googlecode.jrename.gui.list.RenamerFileList;
import com.googlecode.jrename.gui.option.format.FormatPane;
import com.googlecode.jrename.gui.option.increment.IncrementPane;
import com.googlecode.jrename.gui.option.output.OutputPane;
import com.googlecode.jrename.gui.option.regexp.RegexpPane;
import com.googlecode.jrename.gui.option.replace.ReplacePane;
import com.googlecode.jrename.ui.Command;
import com.googlecode.jrename.ui.RenameMediator;

import net.miginfocom.swing.MigLayout;

public class jRename extends JFrame implements ActionListener, CaretListener, ChangeListener {

	private static final long serialVersionUID = 1L;
	
	private RenameMediator mediator;

	public static void main(String[] args) {
		
		// --- Select the System look & feel

		// lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
		// lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		// lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
		// lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
		// lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();

		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();

		try {

			UIManager.setLookAndFeel(lookAndFeel);

		} catch (ClassNotFoundException e) {
		} catch (UnsupportedLookAndFeelException e) {
		} catch (Exception e) {}

		// --- Mac OS About Box
		if (System.getProperty("mrj.version") != null) {   
			            
	    } 
		
		new jRename();
	}
	
	public jRename() {
		
		// --- Construction de la fenetre principale
		super(Resources.get("application.name"));
		this.getContentPane().setLayout(new MigLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new MigLayout("fillx"));
		
		mediator = new RenameMediator(this);
		
		/********************
		 * CONSTRUCTION IHM *
		 ********************/

		// --- Menu
		MenuPane menu = new MenuPane(this, mediator);
		
		// --- File list
		RenamerFileList list = new RenamerFileList(this, mediator);

		// --- Options
		FormatPane format = new FormatPane(this, mediator);
		RegexpPane regex = new RegexpPane(this, mediator);
		IncrementPane increment = new IncrementPane(this, mediator);
		ReplacePane replace = new ReplacePane(this, mediator);
		OutputPane output = new OutputPane(this, mediator);
		
		// --- Layout
		JPanel center = new JPanel(new MigLayout("", "[]", "10[]0[]0[][]5"));
		this.getContentPane().add(menu, 	"west");
		this.getContentPane().add(center, 	"");
		center.add(format, 		"growx, wrap");
		center.add(increment, 	"growx, split");
		center.add(replace, 	"growx, aligny top, wrap");
		center.add(output, 		"growx, split, sg 1");
		center.add(regex, 		"growx, wrap, sg 1");
		center.add(list, 		"growx, wrap");
		
		// --- Affichage de la fenetre
		setResizable(false);
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		launchCommand((Command) ae.getSource());
    }

	public void caretUpdate(CaretEvent ce) {
		launchCommand((Command) ce.getSource());
	}

	public void stateChanged(ChangeEvent ce) {
		launchCommand((Command) ce.getSource());
	}
	
	private void launchCommand(Command c) {
		c.execute();
	}

}
