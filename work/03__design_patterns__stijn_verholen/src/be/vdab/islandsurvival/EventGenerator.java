package be.vdab.islandsurvival;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class EventGenerator {

	private static final long DEFAULT_DELAY = 0L;
	private static final long DEFAULT_PERIOD = 1500L;
	
	private final long delay;
	private final long period;
	
	public EventGenerator() {
		this(DEFAULT_DELAY, DEFAULT_PERIOD);
	}
	
	public EventGenerator(final long delay, final long period) {
		this.delay = delay;
		this.period = period;
	}

	public final void startGenerating(final Island island) {
		// Execute this task every 1,5 seconds, but only if a randomly
		// generated integer is even.
		final TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (new Random().nextInt(1337) % 2 == 0) {
					island.erupt(island.getRandomVolcano());
				}
			}
		};
		
		final Timer timer = new Timer("ISLAND EVENTSs");
		
		timer.scheduleAtFixedRate(task, delay, period);
	}
	public final void stopGenerating() {
		
	}
}