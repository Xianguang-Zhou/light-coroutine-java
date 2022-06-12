/*
 * Copyright (c) 2022, Xianguang Zhou <xianguang.zhou@outlook.com>. All rights reserved.
 */
package pers.zxg.coroutine;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import pers.zxg.coroutine.Coroutine.Callable;
import pers.zxg.coroutine.Coroutine.NotSameThread;
import pers.zxg.coroutine.Coroutine.OutsideCall;
import pers.zxg.coroutine.Coroutine.Runnable;
import pers.zxg.coroutine.Coroutine.Suspend;
import pers.zxg.coroutine.Coroutine.Weaver;

/**
 * @author <a href="mailto:xianguang.zhou@outlook.com">Xianguang Zhou</a>
 */
public class CoroutineUtil {

	public static interface Future<T> {
		public boolean isDone();

		public T get() throws Suspend, ExecutionException, OutsideCall;

		public T get(long timeout, TimeUnit unit)
				throws Suspend, TimeoutException, ExecutionException, SchedulableCoroutine.OutsideCall;
	}

	public static class Promise<T> implements Future<T> {

		@Override
		public boolean isDone() {
			throw new Weaver.NotWeaved();
		}

		@Override
		public T get() throws Suspend, ExecutionException, OutsideCall {
			throw new Weaver.NotWeaved();
		}

		@Override
		public T get(long timeout, TimeUnit unit)
				throws Suspend, TimeoutException, ExecutionException, SchedulableCoroutine.OutsideCall {
			throw new Weaver.NotWeaved();
		}

		public boolean complete(T result) throws NotSameThread {
			throw new Weaver.NotWeaved();
		}

		public boolean fail(Throwable cause) throws NotSameThread {
			throw new Weaver.NotWeaved();
		}

		public static Promise<Void> allOf(Promise<?>... ps) {
			throw new Weaver.NotWeaved();
		}

		public static Promise<Object> anyOf(Promise<?>... ps) {
			throw new Weaver.NotWeaved();
		}
	}

	public static java.util.concurrent.Future<Void> run(Runnable runnable, Executor executor) {
		throw new Weaver.NotWeaved();
	}

	public static <T> java.util.concurrent.Future<T> run(Callable<T> callable, Executor executor) {
		throw new Weaver.NotWeaved();
	}
}
