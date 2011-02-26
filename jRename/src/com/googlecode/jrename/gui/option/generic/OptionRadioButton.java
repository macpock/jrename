package com.googlecode.jrename.gui.option.generic;



import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import com.googlecode.jrename.gui.Resources;
import com.googlecode.jrename.ui.Command;
import com.googlecode.jrename.ui.RenameMediator;



public class OptionRadioButton extends JRadioButton implements Command {

	private static final long serialVersionUID = 1L;
	private RenameMediator med;
	private String option;

	public OptionRadioButton(ActionListener al, RenameMediator m, String title, String opt, boolean selected) {
		super(Resources.get(title));
		setOpaque(false);
		option = opt;
		setSelected(selected);
		addActionListener(al);
        med = m;
        // --- Enregistrement de l'option par defaut
        execute();
	}
	
	public void execute() {
		med.setOption(this.isSelected(), option, boolean.class);
	}

}
