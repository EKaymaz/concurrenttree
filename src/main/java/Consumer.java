/**
 * Consumer object is an object that can be run as a thread.It consumes BST periodically
 */
public class Consumer extends BaseWorker implements Runnable {

    /**
     * @param tree      data structure to be consumed
     * @param sleepTime specifies the period
     */
    public Consumer(BinarySearchTree tree, Integer sleepTime) {
        super(tree, sleepTime);
    }

    /**
     * Runs periodically and writes the number of nodes of the BST
     */
    public void run() {
        while (true) {
            try {
                Thread.sleep(sleepTime);
                System.out.println(Thread.currentThread().getName() + " calculated number of Nodes :" + tree.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}