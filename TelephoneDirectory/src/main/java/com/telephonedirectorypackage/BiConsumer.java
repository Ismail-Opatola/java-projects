package com.telephonedirectorypackage;

@FunctionalInterface
public interface BiConsumer<T, U> {
	void accept(T t, U u);
}