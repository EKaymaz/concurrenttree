import java.util.Random;

/**
 * Producer object is an object that can be run as a thread.Producer can both expand and shrink BST periodically
 */
public class Producer extends BaseWorker implements Runnable {

    private Random rnd = new Random();

    /**
     * @param tree   data structure to be used for expanding or shrinking
     * @param period specifies the period
     */
    public Producer(BinarySearchTree tree, Integer period) {
        super(tree, period);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(period);
                tree.insert(rnd.nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
}