package ExecutionManager;

public class CallBack extends Thread{
    private Runnable callback;
    private ContextImpl context;

    public CallBack(Runnable callback, ContextImpl context) {
        this.callback = callback;
        this.context = context;
    }

    @Override
    public void run() {
        for(Thread taskThread : context.getThreads()) {
            try {
                taskThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(context.isFinished()) {
            try {
                callback.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
