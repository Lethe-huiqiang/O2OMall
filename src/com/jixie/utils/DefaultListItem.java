package com.jixie.utils;

public class DefaultListItem implements IListItem {
	private String code;

	private String title;

	private String tip;

	public DefaultListItem(String code, String title) {
		this.code = code;
		this.title = title;
	}

	public DefaultListItem(String code, String title, String tip) {
		this.code = code;
		this.title = title;
		this.tip = tip;
	}

	public String getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	public String getTip() {
		return tip;
	}
}