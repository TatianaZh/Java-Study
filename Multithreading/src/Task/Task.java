package Task;
/*Ваша задача реализовать метод get()
который возвращает результат работы Callable.
Выполнение callable должен начинать тот поток, который первый вызвал метод get().
 */

import java.util.concurrent.Callable; ///Callable похож на Runnable, но результатом его работы является объект (а не void).

public class Task<T> {
    private final Callable<? extends T> callable;
    private T result = null;
    private GetException exception;
    private boolean first;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
        this.first = true;
    }

    public T get() throws GetException {
        //*Если при вызове get() результат уже просчитан, то он должен вернуться сразу,
        //(даже без задержек на вход в синхронизированную область).
        if (first) {
             try {
                result = checkCall();
            } catch (GetException e) {
                exception = e;
            }
        }
        if (exception != null) {
            throw exception;
        }
        return result;
    }

    // *Если несколько потоков одновременно вызывают этот метод,
    //    то выполнение должно начаться только в одном потоке,
    //    а остальные должны ожидать конца выполнения (не нагружая процессор).
    private synchronized T checkCall() throws GetException {
        if (first) {
            try {
                T result = callable.call();
                first = false;
                return result;
            } catch (Exception e) {
                //*Если при просчете результата произошел Exception, то всем потокам при вызове get(),
                //  надо кидать этот Exception, обернутый в ваш RuntimeException
                throw new GetException("Exception!");
            }
        } else {
            return result;
        }
    }
}


