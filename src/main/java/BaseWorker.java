/**
 * Base worker object is an object that provides abstraction for worker threads
 */
public abstract class BaseWorker {

    protected BinarySearchTree tree;
    protected Integer period;

    public BaseWorker() {
    }

    /**
     * @param tree   data structure to be consumed
     * @param period specifies the period
     */
    public BaseWorker(BinarySearchTree tree, Integer period) {
        this.tree = tree;
        this.period = period;
    }
}