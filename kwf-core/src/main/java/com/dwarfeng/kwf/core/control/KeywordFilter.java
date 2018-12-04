package com.dwarfeng.kwf.core.control;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;

import com.dwarfeng.dutil.basic.prog.DefaultVersion;
import com.dwarfeng.dutil.basic.prog.Version;
import com.dwarfeng.dutil.basic.prog.VersionType;
import com.dwarfeng.dutil.develop.backgr.Background;
import com.dwarfeng.dutil.develop.backgr.ExecutorServiceBackground;
import com.dwarfeng.dutil.develop.i18n.DelegateI18nHandler;
import com.dwarfeng.dutil.develop.i18n.I18nUtil;
import com.dwarfeng.dutil.develop.i18n.SyncI18nHandler;
import com.dwarfeng.dutil.develop.logger.DelegateLoggerHandler;
import com.dwarfeng.dutil.develop.logger.LoggerUtil;
import com.dwarfeng.dutil.develop.logger.SyncLoggerHandler;
import com.dwarfeng.dutil.develop.resource.DelegateResourceHandler;
import com.dwarfeng.dutil.develop.resource.ResourceUtil;
import com.dwarfeng.dutil.develop.resource.SyncResourceHandler;
import com.dwarfeng.dutil.develop.setting.DefaultSettingHandler;
import com.dwarfeng.dutil.develop.setting.SettingUtil;
import com.dwarfeng.dutil.develop.setting.SyncSettingHandler;

/**
 * 程序主框架。
 * 
 * @author DwArFeng
 * @since 0.0.0.a-alpha
 */
public class KeywordFilter {

	/** 程序的版本。 */
	public static final Version VERSION = new DefaultVersion.Builder().setType(VersionType.ALPHA)
			.setFirstVersion((byte) 0).setSecondVersion((byte) 0).setThirdVersion((byte) 0).setBuildVersion('A')
			.build();

	/** 程序的实例列表，用于持有引用 */
	private static final Set<KeywordFilter> INSTANCES = Collections.synchronizedSet(new HashSet<>());

	// --------------------------------------------管理器--------------------------------------------
	/** 模型管理器。 */
	private final ModelManager modelManager = new KWFModelManager(this);
	/** 动作管理器。 */
	private final ActionManager actionManger = new KWFActionManager(this);

	// --------------------------------------------模型--------------------------------------------
	/** 后台。 */
	private final Background background = new ExecutorServiceBackground(
			Executors.newFixedThreadPool(4, ExecutorServiceBackground.THREAD_FACTORY),
			Collections.newSetFromMap(new WeakHashMap<>()));
	/** 核心配置模型。 */
	private final SyncSettingHandler settingHandler = SettingUtil.syncSettingHandler(new DefaultSettingHandler());
	/** 命令行配置模型。 */
	private final SyncSettingHandler cliSettingHandler = SettingUtil.syncSettingHandler(new DefaultSettingHandler());
	/** 记录器接口。 */
	private final SyncLoggerHandler loggerHandler = LoggerUtil.syncLoggerHandler(new DelegateLoggerHandler());
	/** 国际化处理器。 */
	private final SyncI18nHandler i18nHandler = I18nUtil.syncI18nHandler(new DelegateI18nHandler());
	/** 配置处理器。 */
	private final SyncResourceHandler configHandler = ResourceUtil.syncResourceHandler(new DelegateResourceHandler());

	/**
	 * 新实例。
	 */
	public KeywordFilter() {
		// 为自己保留引用。
		INSTANCES.add(this);
	}

	/**
	 * @return the actionManger
	 */
	ActionManager getActionManger() {
		return actionManger;
	}

	/**
	 * @return the background
	 */
	Background getBackground() {
		return background;
	}

	/**
	 * @return the cliSettingHandler
	 */
	SyncSettingHandler getCliSettingHandler() {
		return cliSettingHandler;
	}

	/**
	 * @return the configHandler
	 */
	SyncResourceHandler getConfigHandler() {
		return configHandler;
	}

	/**
	 * @return the i18nHandler
	 */
	SyncI18nHandler getI18nHandler() {
		return i18nHandler;
	}

	/**
	 * @return the loggerHandler
	 */
	SyncLoggerHandler getLoggerHandler() {
		return loggerHandler;
	}

	/**
	 * @return the modelManager
	 */
	ModelManager getModelManager() {
		return modelManager;
	}

	/**
	 * @return the settingHandler
	 */
	SyncSettingHandler getSettingHandler() {
		return settingHandler;
	}

}
