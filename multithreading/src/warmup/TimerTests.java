package warmup;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import task.factory.TimerTaskFactory;
import utils.thread.ThreadUtils;

/**
 * Simple timer jobs, for warm-up. Sole motive is to understand how multiple
 * tasks behave when scheduled under the same timer..
 * 
 * @author anjaneya
 *
 */
public class TimerTests {

	public static void testSimpleTimerTask() {
		TimerTask task = (TimerTask) TimerTaskFactory.getInstance().makeAction();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 2000, 2000);
		ThreadUtils.sleepQuietly(10000);
		Logger.getAnonymousLogger().log(Level.SEVERE, "Cancelling timer.");
		timer.cancel();
	}
}
