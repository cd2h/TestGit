package org.lrf.old_driver.entity;

import java.util.List;

public class Page<T> {
	private int currentNumber;
	private int totalNumbers;
	private int totalElements;
	private final static int PAGE_SIZE = 20;
	private boolean isFirstPage;
	private boolean isLastPage;
	private List<T> contents;
	public int getCurrentNumber() {
		return currentNumber;
	}
	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}
	public int getTotalNumbers() {
		return totalNumbers;
	}
	public void setTotalNumbers(int totalNumbers) {
		this.totalNumbers = totalNumbers;
	}
	public int getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}
	public boolean isFirstPage() {
		return isFirstPage;
	}
	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}
	public boolean isLastPage() {
		return isLastPage;
	}
	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
	public List<T> getContents() {
		return contents;
	}
	public void setContents(List<T> contents) {
		this.contents = contents;
	}
	public static int getPageSize() {
		return PAGE_SIZE;
	}
}
