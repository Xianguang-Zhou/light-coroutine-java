/*
 * Copyright (c) 2022, Xianguang Zhou <xianguang.zhou@outlook.com>. All rights reserved.
 */
package pers.zxg.coroutine;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:xianguang.zhou@outlook.com">Xianguang Zhou</a>
 */
public class SchedulableCoroutine extends Coroutine {

	public static class OutsideCall extends RuntimeException {
	}

	public static class Scheduler {

		public Scheduler() {
			throw new Weaver.NotWeaved();
		}

		public Scheduler(ScheduledExecutorService executorService) {
			throw new Weaver.NotWeaved();
		}

		public boolean shutdown() {
			throw new Weaver.NotWeaved();
		}

		public SchedulableCoroutine launch(Runnable runnable) {
			throw new Weaver.NotWeaved();
		}

		public java.util.concurrent.Future<Void> run(Runnable runnable) {
			throw new Weaver.NotWeaved();
		}

		public <T> java.util.concurrent.Future<T> run(Callable<T> callable) {
			throw new Weaver.NotWeaved();
		}
	}

	public SchedulableCoroutine(Scheduler scheduler, Runnable runnable) {
		super(runnable);
		throw new Weaver.NotWeaved();
	}

	public static SchedulableCoroutine create(Scheduler scheduler, Runnable runnable) {
		throw new Weaver.NotWeaved();
	}

	public Scheduler scheduler() {
		throw new Weaver.NotWeaved();
	}

	public void start() {
		throw new Weaver.NotWeaved();
	}

	public static SchedulableCoroutine current() {
		throw new Weaver.NotWeaved();
	}

	public static void sleep(long delay, TimeUnit unit) throws Suspend, OutsideCall {
		throw new Weaver.NotWeaved();
	}

	public static long sleepRemaining(long delay, TimeUnit unit) throws Suspend, OutsideCall {
		throw new Weaver.NotWeaved();
	}
}
