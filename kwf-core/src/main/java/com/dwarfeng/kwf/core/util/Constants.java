package com.dwarfeng.kwf.core.util;

/**
 * 常量包。
 * 
 * @author DwArFeng
 * @since 0.0.0.a-alpha
 */
public final class Constants {

	/** 默认的丢失文本字段。 */
	public final static String MISSING_LABEL = "！文本丢失";

	/** Jar包内配置列表的文件路径。 */
	public final static String JPATH_CONFIG_LIST = "config-list.xml";
	/** Jar包内组件列表文件路径。 */
	public final static String JPATH_MODULE_LIST = "module-list.xml";
	/** Jar包内默认的国际化属性文件路径。 */
	public final static String JPATH_DEFAULT_I18N_PROP_FILE = "/com/dwarfeng/projwiz/resources/core/config/i18n/logger.properties";

	/** 主程序的核心配置的资源仓库类别。 */
	public final static String CONFIG_CLASSIFY_CORE = "com.dwarfeng.projwiz.core";
	/** 主程序的国际化配置的资源仓库类别。 */
	public final static String CONFIG_CLASSIFY_I18N = "com.dwarfeng.projwiz.i18n";

	/** 代表配置列表路径的命令行参数。 */
	public static final String CLI_OPT_UPATH_CONFIG_LIST = "c";
	/** 代表强制重置配置文件的命令行参数。 */
	public static final String CLI_OPT_FLAG_CONFIG_FORCE_RESET = "r";
	/** 代表测试模式的命令行参数。 */
	public static final String CLI_OPT_FLAG_TEST_CASE = "t";

	// 禁止外部实例化
	private Constants() {
	}
}
