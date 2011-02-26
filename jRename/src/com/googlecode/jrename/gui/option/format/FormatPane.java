package com.googlecode.jrename.gui.option.format;


import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import com.googlecode.jrename.bean.Option;
import com.googlecode.jrename.gui.option.OptionPane;
import com.googlecode.jrename.gui.option.generic.OptionCheckBox;
import com.googlecode.jrename.gui.option.generic.OptionRadioButton;
import com.googlecode.jrename.ui.RenameMediator;

import net.miginfocom.swing.MigLayout;

public class FormatPane extends OptionPane implements Option {

	private static final long serialVersionUID = 1L;
	private static final JRadioButton defaultRadioCase = new JRadioButton();
	private ButtonGroup group;

	public FormatPane(EventListener el, RenameMediator m) {
		super(new MigLayout("", "[]10[]10[]", "[]0[]0[]0[]0[]"), "title.format");
		
		// --- Doit s'enregistrer avant les RadioButton
		m.registerOption(this);
		
		group = new ButtonGroup();
		AbstractButton lowercase = new OptionRadioButton((ActionListener) el, m, "option.format.lowercase", "Lowercase", false);
		AbstractButton uppercase = new OptionRadioButton((ActionListener) el, m, "option.format.uppercase", "Uppercase", false);
		AbstractButton swapcase = new OptionRadioButton((ActionListener) el, m, "option.format.swapcase", "SwapCase", false);
		AbstractButton capitalize = new OptionRadioButton((ActionListener) el, m, "option.format.capitalize", "Capitalize", false);
		AbstractButton uncapitalize = new OptionRadioButton((ActionListener) el, m, "option.format.uncapitalize", "Uncapitalize", false);
		group.add(lowercase);
		group.add(uppercase);
		group.add(swapcase);
		group.add(capitalize);
		group.add(uncapitalize);
		group.add(defaultRadioCase);
		setOpaque(false);
		
		// --- Layout
		add(lowercase, "cell 0 0");
		add(uppercase, "cell 0 1");
		add(swapcase, "cell 0 2");
		add(capitalize, "cell 0 3");
		add(uncapitalize, "cell 0 4");
		add(new OptionCheckBox((ActionListener) el, m, "option.format.trim", "Trim", true), "cell 1 0");
		add(new OptionCheckBox((ActionListener) el, m, "option.format.remove.blank", "SpacesAllowed", true), "cell 1 1");
		add(new OptionCheckBox((ActionListener) el, m, "option.format.remove.double.spaces", "DoubleSpaces", true), "cell 1 2");
		add(new OptionCheckBox((ActionListener) el, m, "option.format.parenthesis", "Parenthesis", false), "cell 2 0");
		add(new OptionCheckBox((ActionListener) el, m, "option.format.extra.periods", "Periods", false), "cell 2 1");
		
	}

	public void restoreDefault() {
		group.setSelected(defaultRadioCase.getModel(), true);
	}
	
}
