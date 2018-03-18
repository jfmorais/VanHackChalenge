package com.skipthedishes.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class IDGenerator {

	private AtomicInteger nextId = new AtomicInteger(1);
	
	public int getNextId() {
		return nextId.getAndIncrement();
	}
}