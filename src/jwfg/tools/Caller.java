package jwfg.tools;

import java.util.concurrent.Callable;

public class Caller<V> {
    private final Callable<V> callee;

    public Caller(Callable<V> callee) {
        this.callee = callee;
    }

    public Callable<V> getCallee() {
        return this.callee;
    }

    public void call() throws RuntimeException {
        if (this.callee == null) return;

        try { this.callee.call(); }
        catch (Exception ex) { throw new RuntimeException(ex); }
    }
}
