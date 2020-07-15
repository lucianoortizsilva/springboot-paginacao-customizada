package com.lucianoortizsilva.paginacao.util;

import java.util.ArrayList;
import java.util.List;

public class Util {

	public static <T> List<T> getListByPage(final List<T> list, final int page, final int size) {
		int rowsByPage = size;
		int rowsToIgnore = page * size;
		final List<T> newList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (i >= rowsToIgnore) {
				if (rowsByPage > 0) {
					newList.add(list.get(i));
					rowsByPage--;
				} else {
					break;
				}
			}
		}
		return newList;
	}

}