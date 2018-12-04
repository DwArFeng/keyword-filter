package com.dwarfeng.kwf.core.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.dwarfeng.dutil.develop.resource.ResourceUtil;
import com.dwarfeng.dutil.develop.setting.AbstractSettingInfo;
import com.dwarfeng.dutil.develop.setting.SettingInfo;

/**
 * 与统一路径有关的工具类。
 * 
 * @author DwArFeng
 * @since 0.0.0.a-alpha
 */
public final class UpathUtil {

	private static final String MARK_FILE = "file::";
	private static final String MARK_JAR = "jar::";

	/**
	 * 检查一个字符串是否是一个统一路径。
	 * 
	 * @param string
	 *            指定的字符串。
	 * @return 指定的字符串是否是一个统一路径。
	 */
	public static boolean isValid(String string) {
		return Objects.isNull(string) ? false : isNonNullValid(string);
	}

	private static boolean isNonNullValid(String string) {
		if (string.startsWith(MARK_FILE) && string.length() > MARK_FILE.length()) {
			return true;
		} else if (string.startsWith(MARK_JAR) && string.length() > MARK_JAR.length()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 将一个字符串按照统一路径的格式转化成URL。
	 * 
	 * @param string
	 *            指定的字符串。
	 * @return 指定的字符串按照统一路径格式转化成的URL。
	 */
	public static URL parseString(String string) {
		if (!isValid(string)) {
			return null;
		}

		if (string.startsWith(MARK_FILE)) {
			try {
				return new File(string.substring(MARK_FILE.length())).toURI().toURL();
			} catch (MalformedURLException e) {
				return null;
			}
		} else if (string.startsWith(MARK_JAR)) {
			return ResourceUtil.class.getResource(string.substring(MARK_JAR.length()));
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param defaultValue
	 * @return
	 * @throws NullPointerException
	 *             指定的入口参数为 <code> null </code>。
	 * @throws IllegalArgumentException
	 */
	public static SettingInfo newUpathSettingInfo(String defaultValue)
			throws NullPointerException, IllegalArgumentException {
		return new UpathSettingInfo(defaultValue);
	}

	private static final class UpathSettingInfo extends AbstractSettingInfo {

		private String lastCheckedValue = null;
		private URL lastParsedValue = null;

		private final Lock lock = new ReentrantLock();

		public UpathSettingInfo(String defaultValue) throws NullPointerException, IllegalArgumentException {
			super(defaultValue);
			checkDefaultValue();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int hashCode() {
			return UpathSettingInfo.class.hashCode() * 61 + defaultValue.hashCode() * 17;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (Objects.isNull(obj))
				return false;
			if (!(obj.getClass() == UpathSettingInfo.class))
				return false;

			UpathSettingInfo that = (UpathSettingInfo) obj;
			return Objects.equals(this.defaultValue, that.defaultValue);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String toString() {
			return "UpathSettingInfo [defaultValue=" + defaultValue + "]";
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected boolean isNonNullValid(String value) {
			lock.lock();
			try {
				if (Objects.equals(value, lastCheckedValue))
					return Objects.nonNull(lastParsedValue);

				try {
					if (value.startsWith("file::") && value.length() > 6) {
						lastCheckedValue = value;
						lastParsedValue = new File(value.substring(6)).toURI().toURL();
						return true;
					} else if (value.startsWith("jar::") && value.length() > 5) {
						lastCheckedValue = value;
						lastParsedValue = ResourceUtil.class.getResource(value.substring(5));
						return Objects.nonNull(lastParsedValue);
					} else {
						return false;
					}
				} catch (Exception e) {
					lastParsedValue = null;
					return false;
				}
			} finally {
				lock.unlock();
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected Object parseValidValue(String value) {
			lock.lock();
			try {
				if (Objects.equals(value, lastCheckedValue))
					return lastParsedValue;

				try {
					lastCheckedValue = value;
					if (value.startsWith("file::")) {
						lastParsedValue = new File(value.substring(6)).toURI().toURL();
					} else if (value.startsWith("jar::")) {
						lastParsedValue = ResourceUtil.class.getResource(value.substring(5));
					}
					return lastParsedValue;
				} catch (Exception e) {
					lastCheckedValue = null;
					lastParsedValue = null;
					throw new IllegalStateException();
				}
			} finally {
				lock.unlock();
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected String parseNonNullObject(Object object) {
			lock.lock();
			try {
				if (!(object instanceof URL))
					return null;

				URL url = (URL) object;
				if (Objects.equals(url, lastParsedValue))
					return lastCheckedValue;

				String externalForm = ((URL) url).toExternalForm();
				if (!externalForm.startsWith("file:/"))
					return null;
				return new StringBuilder().append("file::").append(externalForm.substring(6)).toString();
			} finally {
				lock.unlock();
			}
		}

	}

	private UpathUtil() {
		// 禁止外部实例化。
	}

}
