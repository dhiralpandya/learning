package com.omt.learn.errortrack;

import io.sentry.Sentry;
import io.sentry.SentryClient;
import io.sentry.SentryClientFactory;
import io.sentry.context.Context;
import io.sentry.event.BreadcrumbBuilder;
import io.sentry.event.UserBuilder;

public class SentryExample {

	public static SentryClient sentry = SentryClientFactory.sentryClient();

	public static void main(String args[]) {

		Sentry.init();

		// logWithStaticAPI();
		logWithInstanceAPI();
		// logWithCustomErrorAPI();
	}

	/**
	 * Examples using the (recommended) static API.
	 */
	static void logWithStaticAPI() {
		// Note that all fields set on the context are optional. Context data is copied
		// onto
		// all future events in the current context (until the context is cleared).

		// Record a breadcrumb in the current context. By default the last 100
		// breadcrumbs are kept.
		Sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder().setMessage("User made an action").build());

		// Set the user in the current context.
		Sentry.getContext().setUser(new UserBuilder().setEmail("hello@sentry.io").build());

		// Add extra data to future events in this context.
		Sentry.getContext().addExtra("extra", "thing");

		// Add an additional tag to future events in this context.
		Sentry.getContext().addTag("tagName", "tagValue");

		/*
		 * This sends a simple event to Sentry using the statically stored instance that
		 * was created in the ``main`` method.
		 */
		Sentry.capture("This is a test");

		try {
			unsafeMethod();
		} catch (Exception e) {
			// This sends an exception event to Sentry using the statically stored instance
			// that was created in the ``main`` method.
			Sentry.capture(e);
		}
	}

	/**
	 * An example method that throws an exception.
	 */
	static void unsafeMethod() {
		throw new UnsupportedOperationException("You shouldn't call this!");
	}

	/**
	 * Examples that use the SentryClient instance directly.
	 */
	static void logWithInstanceAPI() {
		// Retrieve the current context.
		Context context = sentry.getContext();

		// Record a breadcrumb in the current context. By default the last 100
		// breadcrumbs are kept.
		context.recordBreadcrumb(new BreadcrumbBuilder().setMessage("Dhiral Pandya").build());

		// Set the user in the current context.
		context.setUser(new UserBuilder().setEmail("dhp@sentry.io").build());

		// This sends a simple event to Sentry.
		sentry.sendMessage("This is custom msg");

		try {
			unsafeMethod();
		} catch (Exception e) {
			// This sends an exception event to Sentry.
			sentry.sendException(e);
		}
	}

	/**
	 * Examples that use the SentryClient instance directly.
	 */
	static void logWithCustomErrorAPI() {
		// Retrieve the current context.
		Context context = sentry.getContext();

		// Record a breadcrumb in the current context. By default the last 100
		// breadcrumbs are kept.
		context.recordBreadcrumb(new BreadcrumbBuilder().setMessage("User made an action").build());

		// Set the user in the current context.
		context.setUser(new UserBuilder().setEmail("hello@sentry.io").build());

		// This sends a simple event to Sentry.
		sentry.sendMessage("This is a test");

		try {
			unsafeMethod();
		} catch (Exception e) {
			// This sends an exception event to Sentry.
			sentry.sendException(e);
		}
	}

}
