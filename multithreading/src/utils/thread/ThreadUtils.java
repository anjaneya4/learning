package utils.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Thread operations: has utility methods
 * 
 * @author anjaneya
 *
 */
public final class ThreadUtils {

	/**
	 * If some one interrupts the current thread sleep attempt..
	 * then that exception will be ignored. However, the thread will probably wake up.
	 * 
	 * @param timeout
	 */
	public static void sleepQuietly(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "The thread was interrupted: ", e);
		}
	}
}
