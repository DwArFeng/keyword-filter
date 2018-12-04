package com.dwarfeng.kwf.core.model.enumeration;

import com.dwarfeng.dutil.develop.setting.SettingEnumItem;
import com.dwarfeng.dutil.develop.setting.SettingInfo;
import com.dwarfeng.dutil.develop.setting.info.LocaleSettingInfo;

/**
 * 核心配置入口。
 * 
 * @author DwArFeng
 * @since 0.0.0.a-alpha
 */
public enum CoreSettingItem implements SettingEnumItem {

	/** 记录器的国际化配置。 */
	LOCALE_I18N("locale.i18n", new LocaleSettingInfo("zh_CN")),

	;

	private final String name;
	private final SettingInfo settingInfo;

	private CoreSettingItem(String name, SettingInfo settingInfo) {
		this.name = name;
		this.settingInfo = settingInfo;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SettingInfo getSettingInfo() {
		return settingInfo;
	}

}
