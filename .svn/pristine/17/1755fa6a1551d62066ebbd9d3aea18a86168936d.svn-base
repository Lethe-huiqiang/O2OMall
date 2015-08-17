package com.jixie.utils;

import java.util.List;

public class HTMLUtils {
	/**
	 * 当前缺省值，在查询条件输出之后需要立即取出，否则在下次合成查询界面时改变
	 * 有时填充下列表时，没有查询条件，默认第一项为查询的值。此时可能需要取到当前列表的缺省值是什么。
	 */
	private static String currentValue = "";

	/**
	 * 由IListItem列表生成Radio列表
	 * 
	 * @param list
	 *            IListItem列表
	 * @param defaultValue
	 *            当前选中的值
	 * @param buttonName
	 *            按钮名称
	 * @param ext
	 *            扩展字符串，如onclick='' or class="button"
	 * @param radio
	 *            true=单选 false复选
	 * @return HTML代码
	 */
	@SuppressWarnings("unchecked")
	public static String getButtonsByList(List list, String defaultValue,
			String buttonName, String ext, boolean radio) {
		if (list == null)
			return "";
		if (defaultValue == null)
			defaultValue = "";
		StringBuffer buf = new StringBuffer("");
		String tmp;
		currentValue = defaultValue;
		for (int i = 0; i < list.size(); i++) {
			IListItem item = (IListItem) list.get(i);
			tmp = " value='" + item.getCode() + "'";
			if (i == 0)
				currentValue = item.getCode();
			if (defaultValue.equals(item.getCode())) {
				tmp = tmp + " checked ";
				currentValue = item.getCode();
			}

			if (radio)
				buf.append("<input type=radio name='" + buttonName + "'" + tmp
						+ ext + ">" + item.getTitle() + "\n");
			else
				buf.append("<input type=checkbox name='" + buttonName + "'"
						+ tmp + ext + ">" + item.getTitle() + "\n");

		}
		return buf.toString();
	}

	/**
	 * 通过标题返回编码
	 * 
	 * @param list
	 *            IListItem列表
	 * @param code
	 *            编码
	 * @return 名称或标题
	 */
	@SuppressWarnings("unchecked")
	public static String getCodeByTitle(List list, String title) {
		if (list == null)
			return null;
		if (title == null) {
			title = "";
			return null;
		} else
			title = title.trim();
		if (list != null)
			for (int i = 0; i < list.size(); i++) {
				IListItem item = (IListItem) list.get(i);
				if (title.equals(item.getTitle().trim()))
					return item.getCode();
			}
		return null;
	}

	/**
	 * 当前缺省值，在查询条件输出之后需要立即取出，否则在下次合成查询界面时改变
	 * 有时填充下列表时，没有查询条件，默认第一项为查询的值。此时可能需要取到当前列表的缺省值是什么。
	 * 
	 * @return
	 */
	public static String getCurrentValue() {
		return currentValue;
	}

	/**
	 * 根据编码取相应对象
	 * 
	 * @param list
	 *            IListItem对象列表
	 * @param code
	 *            对象ID
	 * @return IListItem
	 */
	@SuppressWarnings("unchecked")
	public static IListItem getItemById(List list, int code) {
		return getItemById(list, String.valueOf(code));
	}

	/**
	 * 根据标题取相应对象
	 * 
	 * @param list
	 *            IListItem对象列表
	 * @param title
	 *            标题
	 * @return IListItem
	 */
	@SuppressWarnings("unchecked")
	public static IListItem getItemByTitle(List list, String Title) {
		if (list == null)
			return null;
		if (Title == null) {
			Title = "";
			return null;
		} else
			Title = Title.trim();

		if (list != null)
			for (int i = 0; i < list.size(); i++) {
				IListItem item = (IListItem) list.get(i);
				if (Title.equals(item.getTitle()))
					return item;
			}
		return null;
	}

	/**
	 * 根据编码取相应对象
	 * 
	 * @param list
	 *            IListItem对象列表
	 * @param code
	 *            对象ID
	 * @return IListItem
	 */
	@SuppressWarnings("unchecked")
	public static IListItem getItemById(List list, String code) {
		if (list == null)
			return null;
		if (code == null) {
			code = "";
			return null;
		} else
			code = code.trim();

		if (list != null)
			for (int i = 0; i < list.size(); i++) {
				IListItem item = (IListItem) list.get(i);
				if (code.equals(item.getCode()))
					return item;
			}
		return null;
	}

	/**
	 * 返回下拉列表选项。
	 * 
	 * @param list
	 *            IListItem列表
	 * @param defaultValue
	 *            当前选中的值，可以为空。
	 * @return HTML代码
	 */
	@SuppressWarnings("unchecked")
	public static String getOptionsByList(List list, int defaultValue) {
		return getOptionsByList(list, String.valueOf(defaultValue));
	}
	
	/**
	 * 返回下拉列表选项。
	 * 
	 * @param list
	 *            IListItem列表
	 * @param defaultValue
	 *            当前选中的值，可以为空。
	 * @return HTML代码
	 */
	@SuppressWarnings("unchecked")
	public static String getOptionsByListStr(List list, String defaultValue) {
		return getOptionsByList(list, defaultValue);
	}

	/**
	 * 
	 * @param name
	 *            The name of Checkbox Control
	 * @param list
	 *            The key-value list of checkbos
	 * @param checkeds
	 *            The values that checked;
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getCheckBoxGroupByList(String name, List list,
			String[] checkeds) {
		StringBuffer ret = new StringBuffer("");
		if (list != null)
			for (int i = 0; i < list.size(); i++) {
				String checked = "";
				IListItem item = (IListItem) list.get(i);
				if (checkeds != null)
					for (int j = 0; j < checkeds.length; j++)
						if (item.getCode().equals(checkeds[j])) {
							checked = " checked";
						}
				ret.append(String.format(
						"<input type='checkbox' name='%s' value='%s'%s/>%s",
						new Object[] { name, item.getCode(), checked,
								item.getTitle() }));
			}

		return ret.toString();
	}

	/**
	 * 返回下拉列表选项。
	 * 
	 * @param list
	 *            IListItem列表
	 * @param defaultValue
	 *            当前选中的值，可以为空。
	 * @return HTML代码
	 */
	@SuppressWarnings("unchecked")
	public static String getOptionsByList(List list, String defaultValue) {
		if (list == null)
			return "";
		StringBuffer buf = new StringBuffer("");
		if (defaultValue == null)
			defaultValue = "";
		else
			defaultValue = defaultValue.trim();
		String tmp;
		currentValue = defaultValue;
		for (int i = 0; i < list.size(); i++) {
			IListItem item = (IListItem) list.get(i);
			tmp = " value='" + item.getCode() + "'";
			if (i == 0)
				currentValue = item.getCode();
			if (defaultValue.equals(item.getCode())) {
				tmp = tmp + " selected";
				currentValue = item.getCode();
			}

			buf.append("<option" + tmp + ">" + item.getTitle() + "</option>\n");
		}
		return buf.toString();
	}

	/**
	 * 通过编码返回名称或标题
	 * 
	 * @param list
	 *            IListItem列表
	 * @param code
	 *            编码
	 * @return 名称或标题
	 */
	@SuppressWarnings("unchecked")
	public static String getTitleByList(List list, int code) {
		return getTitleByList(list, String.valueOf(code));
	}

	/**
	 * 通过编码返回名称或标题
	 * 
	 * @param list
	 *            IListItem列表
	 * @param code
	 *            编码
	 * @return 名称或标题
	 */
	@SuppressWarnings("unchecked")
	public static String getTitleByList(List list, String code) {
		IListItem item = getItemById(list, code);
		if (item == null)
			return code == null ? "" : code;
		else
			return item.getTitle();
	}
	
	/**
	 * 通过编码返回Tip
	 * 
	 * @param list
	 *            IListItem列表
	 * @param code
	 *            编码
	 * @return 名称或标题
	 */
	@SuppressWarnings("unchecked")
	public static String getTipByList(List list, int code) {
		IListItem item = getItemById(list, code);
		if (item == null)
			return code == 0 ? "" : String.valueOf(code);
		else
			return item.getTip();
	}

	/**
	 * 通过编码返回Tip
	 * 
	 * @param list
	 *            IListItem列表
	 * @param code
	 *            编码
	 * @return 名称或标题
	 */
	@SuppressWarnings("unchecked")
	public static String getTipByList(List list, String code) {
		IListItem item = getItemById(list, code);
		if (item == null)
			return code == null ? "" : code;
		else
			return item.getTip();
	}


}
