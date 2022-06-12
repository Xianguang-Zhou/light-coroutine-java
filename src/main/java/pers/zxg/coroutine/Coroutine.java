/*
 * Copyright (c) 2022, Xianguang Zhou <xianguang.zhou@outlook.com>. All rights reserved.
 */
package pers.zxg.coroutine;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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

	public Coroutine(Runnable runnable) {
		throw new Weaver.NotWeaved();
	}

	public static Coroutine create(Runnable runnable) {
		throw new Weaver.NotWeaved();
	}

	public static Coroutine launch(Runnable runnable) {
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
