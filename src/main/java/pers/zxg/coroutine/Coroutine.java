/*
 * Copyright (c) 2022, Xianguang Zhou <xianguang.zhou@outlook.com>. All rights reserved.
 */
package pers.zxg.coroutine;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author <a href="mailto:xianguang.zhou@outlook.com">Xianguang Zhou</a>
 */
public class Coroutine {

	public static enum State {
		NEW, RUNNING, SUSPENDED, WAITING, TERMINATED
	}

	public static final class Weaver {

		@Target({ ElementType.METHOD, ElementType.TYPE })
		@Retention(RetentionPolicy.CLASS)
		public static @interface Ignore {
		}

		public final static boolean used = used();

		private static boolean used() {
			return false;
		}

		public static class NotWeaved extends UnsupportedOperationException {
		}
	}

	public static final class Suspend extends Throwable {
		private Suspend() {
			throw new Weaver.NotWeaved();
		}
	}

	public static interface Runnable {
		public void run() throws Suspend;
	}

	public static interface Callable<T> {
		public T call() throws Suspend;
	}

	public static class OutsideCall extends SchedulableCoroutine.OutsideCall {
	}

	public static class NotSameThread extends RuntimeException {
	}

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

	public Coroutine(Runnable runnable) {
		throw new Weaver.NotWeaved();
	}

	public static Coroutine create(Runnable runnable) {
		throw new Weaver.NotWeaved();
	}

	public static Coroutine launch(Runnable runnable) {
		throw new Weaver.NotWeaved();
	}

	public static java.util.concurrent.Future<Void> run(Runnable runnable, Executor executor) {
		throw new Weaver.NotWeaved();
	}

	public static <T> java.util.concurrent.Future<T> run(Callable<T> callable, Executor executor) {
		throw new Weaver.NotWeaved();
	}

	public static <T> T suspend() throws Suspend, OutsideCall {
		throw new Weaver.NotWeaved();
	}

	public static void exit() throws Suspend, OutsideCall {
		throw new Weaver.NotWeaved();
	}

	public boolean resume() throws NotSameThread {
		throw new Weaver.NotWeaved();
	}

	public boolean resume(Object message) throws NotSameThread {
		throw new Weaver.NotWeaved();
	}

	public boolean stop() throws NotSameThread {
		throw new Weaver.NotWeaved();
	}

	public State state() {
		throw new Weaver.NotWeaved();
	}

	public Thread thread() {
		throw new Weaver.NotWeaved();
	}

	public static Coroutine current() {
		throw new Weaver.NotWeaved();
	}
}
