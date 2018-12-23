package ExecutionManager;

public class Main {
    public static void main(String[] args) {
        Runnable callback = () -> System.out.println("callback!");

        Runnable[] tasks = new Runnable[50];
        for (Integer i=0; i < 50; i++) {
            Integer finalI = i+1;
            tasks[i] = () -> {
                System.out.println("task " + finalI);
            };
        }

        ExecutionManager executionManager = new ExecutionManagerImpl();
        Context context = executionManager.execute(callback, tasks);
        context.interrupt();


        System.out.println("CompletedTaskCount " + context.getCompletedTaskCount());
        System.out.println("FailedTaskCount " + context.getFailedTaskCount());
        System.out.println("InterruptedTaskCount " + context.getInterruptedTaskCount());
    }
}
