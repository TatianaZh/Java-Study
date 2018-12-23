package ExecutionManager;

public class ExecutionManagerImpl implements ExecutionManager {
    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        ContextImpl context = new ContextImpl();
        for (Runnable task : tasks) {
            context.addThread(runTask(task, context));
        }
        runCallBack(callback, context);
        return context;
    }

    private Thread runCallBack(Runnable callback, ContextImpl context) {
        Thread callbackThread = new CallBack(callback, context);
        try {
            callbackThread.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return callbackThread;
    }

    private Thread runTask(Runnable task, ContextImpl context) {
        Thread taskThread = new Task(task, context);
        try {
            taskThread.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taskThread;
    }
}
