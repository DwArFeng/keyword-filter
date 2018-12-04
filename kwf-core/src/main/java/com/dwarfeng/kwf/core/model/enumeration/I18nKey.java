package com.dwarfeng.kwf.core.model.enumeration;

import com.dwarfeng.dutil.basic.str.DefaultName;
import com.dwarfeng.dutil.basic.str.Name;

/**
 * 记录器文本键。
 * 
 * @author DwArFeng
 * @since 0.0.0.a-alpha
 */
public enum I18nKey implements Name {

	ACTION_CONTROL_0(new DefaultName("action.control.0")), //
	ACTION_CONTROL_1(new DefaultName("action.control.1")), //

	;

	private Name name;

	private I18nKey(Name name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.str.Name#getName()
	 */
	@Override
	public String getName() {
		return name.getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return name.getName();
	}

}
