package com.dwarfeng.kwf.core.control;

import java.io.IOException;
import java.util.Objects;

import org.apache.commons.cli.ParseException;

import com.dwarfeng.kwf.core.model.enumeration.I18nKey;
import com.dwarfeng.kwf.core.util.Constants;

class KWFActionManager implements ActionManager {

	private final KeywordFilter keywordFilter;

	public KWFActionManager(KeywordFilter keywordFilter) {
		this.keywordFilter = keywordFilter;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(String[] args) throws IllegalStateException, NullPointerException, ParseException, IOException {
		// TODO Auto-generated method stub

	}

	// --------------------------------------------日志输出--------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void trace(String message) throws NullPointerException {
		Objects.requireNonNull(message, "入口参数 message 不能为 null。");
		keywordFilter.getLoggerHandler().trace(message);
	}

	private void trace(I18nKey key) throws NullPointerException {
		trace(keywordFilter.getI18nHandler().getStringOrDefault(key, Constants.MISSING_LABEL));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void debug(String message) throws NullPointerException {
		Objects.requireNonNull(message, "入口参数 message 不能为 null。");
		keywordFilter.getLoggerHandler().debug(message);
	}

	private void debug(I18nKey key) throws NullPointerException {
		debug(keywordFilter.getI18nHandler().getStringOrDefault(key, Constants.MISSING_LABEL));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void info(String message) throws NullPointerException {
		Objects.requireNonNull(message, "入口参数 message 不能为 null。");
		keywordFilter.getLoggerHandler().info(message);
	}

	private void info(I18nKey key) throws NullPointerException {
		info(keywordFilter.getI18nHandler().getStringOrDefault(key, Constants.MISSING_LABEL));
	}

	private void formatInfo(I18nKey key, Object... args) {
		info(String.format(keywordFilter.getI18nHandler().getStringOrDefault(key, Constants.MISSING_LABEL), args));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void warn(String message) throws NullPointerException {
		Objects.requireNonNull(message, "入口参数 message 不能为 null。");
		keywordFilter.getLoggerHandler().warn(message);
	}

	private void warn(I18nKey key) throws NullPointerException {
		warn(keywordFilter.getI18nHandler().getStringOrDefault(key, Constants.MISSING_LABEL));
	}

	private void formatWarn(I18nKey key, Object... args) {
		warn(String.format(keywordFilter.getI18nHandler().getStringOrDefault(key, Constants.MISSING_LABEL), args));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void warn(String message, Throwable t) throws NullPointerException {
		Objects.requireNonNull(message, "入口参数 message 不能为 null。");
		Objects.requireNonNull(t, "入口参数 t 不能为 null。");
		keywordFilter.getLoggerHandler().warn(message, t);
	}

	private void warn(I18nKey key, Throwable t) throws NullPointerException {
		warn(keywordFilter.getI18nHandler().getStringOrDefault(key, Constants.MISSING_LABEL), t);
	}

	private void formatWarn(I18nKey key, Throwable t, Object... args) {
		warn(String.format(keywordFilter.getI18nHandler().getStringOrDefault(key, Constants.MISSING_LABEL), args), t);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void error(String message, Throwable t) throws NullPointerException {
		Objects.requireNonNull(message, "入口参数 message 不能为 null。");
		Objects.requireNonNull(t, "入口参数 t 不能为 null。");
		keywordFilter.getLoggerHandler().error(message, t);
	}

	private void error(I18nKey key, Throwable t) throws NullPointerException {
		error(keywordFilter.getI18nHandler().getStringOrDefault(key, Constants.MISSING_LABEL), t);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fatal(String message, Throwable t) throws NullPointerException {
		Objects.requireNonNull(message, "入口参数 message 不能为 null。");
		Objects.requireNonNull(t, "入口参数 t 不能为 null。");
		keywordFilter.getLoggerHandler().fatal(message, t);
	}

	private void fatal(I18nKey key, Throwable t) throws NullPointerException {
		fatal(keywordFilter.getI18nHandler().getStringOrDefault(key, Constants.MISSING_LABEL), t);
	}

	private String i18nString(I18nKey key) {
		return keywordFilter.getI18nHandler().getStringOrDefault(key, Constants.MISSING_LABEL);
	}

	private String formatI18nString(I18nKey key, Object... args) {
		return String.format(keywordFilter.getI18nHandler().getStringOrDefault(key, Constants.MISSING_LABEL), args);
	}

}
