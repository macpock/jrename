package com.googlecode.jrename.gui.option.increment;


import java.util.EventListener;

import javax.swing.JLabel;
import javax.swing.event.ChangeListener;

import com.googlecode.jrename.gui.Resources;
import com.googlecode.jrename.gui.option.OptionPane;
import com.googlecode.jrename.gui.option.generic.OptionSpinner;
import com.googlecode.jrename.ui.RenameMediator;


public class IncrementPane extends OptionPane {

	private static final long serialVersionUID = 1L;

	public IncrementPane(EventListener el, RenameMediator m) {
		super("title.increment");
		setOpaque(false);
		// --- Layout
		add(new JLabel(Resources.get("option.increment.start")+ " :"), 			"cell 0 0");
		add(new OptionSpinner((ChangeListener) el, m, 1, 0, "IncrStart"), 		"cell 1 0");
		add(new JLabel(Resources.get("option.increment.step")+ " :"), 			"cell 0 1");
		add(new OptionSpinner((ChangeListener) el, m, 1, 1, "IncrStep"), 		"cell 1 1");
		add(new JLabel(Resources.get("option.increment.digits")+ " :"), 		"cell 0 2");
		add(new OptionSpinner((ChangeListener) el, m, 4, 1, "IncrDigits"), 		"cell 1 2");
	}
}
