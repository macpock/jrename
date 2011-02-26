package com.googlecode.jrename.gui.option.generic;



import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import com.googlecode.jrename.bean.Option;
import com.googlecode.jrename.gui.Resources;
import com.googlecode.jrename.ui.Command;
import com.googlecode.jrename.ui.RenameMediator;



public class OptionCheckBox extends JCheckBox implements Command, Option {

	private static final long serialVersionUID = 1L;
	private RenameMediator med;
	private String option;
	private boolean defaultValue;

	public OptionCheckBox(ActionListener al, RenameMediator m, String title, String opt, boolean selected) {
		super(Resources.get(title));
		setOpaque(false);
		option = opt;
		defaultValue=selected;
		setSelected(selected);
		addActionListener(al);
        med = m;
        med.registerOption(this);
        // --- Enregistrement de l'option par defaut
        execute();
	}
	
	public void execute() {
		med.setOption(this.isSelected(), option, boolean.class);
	}

	public void restoreDefault() {
		setSelected(defaultValue);
		execute();
	}

}
