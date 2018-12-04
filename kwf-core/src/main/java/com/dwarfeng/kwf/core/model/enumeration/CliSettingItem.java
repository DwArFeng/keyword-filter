package com.dwarfeng.kwf.core.model.enumeration;

import com.dwarfeng.dutil.develop.setting.SettingEnumItem;
import com.dwarfeng.dutil.develop.setting.SettingInfo;
import com.dwarfeng.dutil.develop.setting.info.BooleanSettingInfo;
import com.dwarfeng.dutil.develop.setting.info.FileSettingInfo;
import com.dwarfeng.kwf.core.util.UpathUtil;

/**
 * 命令行设置条目。
 * 
 * @author DwArFeng
 * @since 0.0.0.a-alpha
 */
public enum CliSettingItem implements SettingEnumItem {

	/** 临时文件的路径。 */
	FPATH_TEMP_DIR("fpath.temp_dir", new FileSettingInfo("temp")),
	/** 配置仓库的路径。 */
	FPATH_CONFIG_REPO_DIR("fpath.config_repo_dir", new FileSettingInfo("configuration")),
	/** 组件的路径。 */
	FPATH_MODULES_DIR("fpath.modules_dir", new FileSettingInfo("modules")),
	/** 元数据的路径。 */
	FPATH_METADATA_DIR("fpath.metadata_dir", new FileSettingInfo("metadata")),

	/** 配置列表的路径。 */
	UPATH_CONFIG_LIST("uptah.config_list", UpathUtil.newUpathSettingInfo("/com/dwarfeng/projwiz/resources/core/config-list.xml")),

	/** 是否强制重置配置文件。 */
	FLAG_CONFIG_FORCE_RESET("flag.config_force_reset", new BooleanSettingInfo("false")),

	;

	private final String name;
	private final SettingInfo settingInfo;

	private CliSettingItem(String name, SettingInfo settingInfo) {
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
