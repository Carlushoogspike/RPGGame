package net.bytes.projects.rpg.config.thread;

import java.util.concurrent.*;

/**
 * This class provides a custom {@link ExecutorService} with configurable thread pool settings.
 * It serves as a centralized provider for handling concurrent tasks using a thread pool.
 * The pool uses a core size of 10 threads, can scale up to 100 threads, and has a keep-alive time of 60 seconds.
 * It also provides a shutdown mechanism when the service is destroyed to ensure proper cleanup of threads.
 */
public class ThreadExecutorProvider {

    /**
     * The core number of threads in the pool.
     */
    private static final int CORE_POOL_SIZE = 10;

    /**
     * The maximum number of threads in the pool.
     */
    private static final int MAX_POOL_SIZE = 100;

    /**
     * The time, in seconds, that idle threads will wait before being terminated.
     */
    private static final int KEEP_ALIVE_TIME = 60;

    /**
     * The time unit for the keep-alive time.
     */
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    /**
     * The blocking queue that holds tasks before they are executed.
     */
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>(1000);

    /**
     * The {@link ExecutorService} instance used for managing tasks in the pool. 
     * It is a {@link ThreadPoolExecutor} that is configured with core and max pool sizes, keep-alive time, 
     * a custom thread factory, and a caller-run policy for handling task rejections.
     */
    private static final ExecutorService executorService = new ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAX_POOL_SIZE,
            KEEP_ALIVE_TIME,
            KEEP_ALIVE_TIME_UNIT,
            WORK_QUEUE,
            r -> {
                // Custom thread factory for creating threads with a specific naming pattern
                Thread thread = new Thread(r);
                thread.setName("CustomExecutorService-" + thread.getId());
                thread.setDaemon(true);  // Make the thread a daemon thread to ensure it doesn't block JVM shutdown
                return thread;
            },
            new ThreadPoolExecutor.CallerRunsPolicy()  // Policy for handling rejected tasks (run the task in the caller's thread)
    );

    /**
     * Shuts down the {@link ExecutorService} gracefully by attempting a normal shutdown.
     * If the service does not terminate within 60 seconds, it forces a shutdown.
     */
    public void shutdownExecutor() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    /**
     * Submits a task to the executor service for execution.
     *
     * @param task the task to be executed by the executor service.
     */
    public static void submitTask(Runnable task) {
        executorService.submit(task);
    }

    /**
     * Checks if the executor service has been shut down.
     *
     * @return true if the executor service has been shut down, false otherwise.
     */
    public static boolean isShutdown() {
        return executorService.isShutdown();
    }

    /*
    * Normal getters!
    * */

    public static BlockingQueue<Runnable> getWorkQueue() {
        return WORK_QUEUE;
    }

    public static ExecutorService getExecutorService() {
        return executorService;
    }

    public static int getCorePoolSize() {
        return CORE_POOL_SIZE;
    }

    public static int getKeepAliveTime() {
        return KEEP_ALIVE_TIME;
    }

    public static int getMaxPoolSize() {
        return MAX_POOL_SIZE;
    }

    public static TimeUnit getKeepAliveTimeUnit() {
        return KEEP_ALIVE_TIME_UNIT;
    }
}
