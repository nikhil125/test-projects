package test.reactor;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class TestPublisher implements Publisher<Long> {
	private List<Subscriber> subscribers = new ArrayList<Subscriber>();


	public void subscribe(Subscriber<? super Long> s) {
		s.onSubscribe(new Subscription() {
			public void request(long n) {

			}

			public void cancel() {

			}
		});
	}

	private static class TestSubscription implements Subscription<Long>
}
