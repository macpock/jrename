package com.googlecode.jrename.gui.option.regexp;


import java.util.EventListener;

import javax.swing.JLabel;
import javax.swing.event.CaretListener;

import com.googlecode.jrename.gui.Resources;
import com.googlecode.jrename.gui.option.OptionPane;
import com.googlecode.jrename.ui.RenameMediator;

import net.miginfocom.swing.MigLayout;

public class RegexpPane extends OptionPane {

	private static final long serialVersionUID = 1L;

	public RegexpPane(EventListener el, RenameMediator m) {
		super(new MigLayout("fillx", "0[][]0", "[]"), "title.regexp");
		JLabel groupLabel = new JLabel();
		groupLabel.setFont(Resources.BOLD);
		m.registerGroupLabel(groupLabel);
		// --- Layout
		add(new RegexpString((CaretListener) el, m), 							"growx");
		add(groupLabel, 														"");
	}
	
}
