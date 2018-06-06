/**
 * Base worker object is an object that provides abstraction for worker threads
 */
public abstract class BaseWorker {

    protected BinarySearchTree tree;
    protected Integer sleepTime;

    public BaseWorker() {
    }

    /**
     * @param tree      data structure to be consumed
     * @param sleepTime specifies the period
     */
    public BaseWorker(BinarySearchTree tree, Integer sleepTime) {
        this.tree = tree;
        this.sleepTime = sleepTime;
    }
}