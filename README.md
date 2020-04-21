# concurrenttree MAVEN - DRONE - JAVA8 - AUTOMATION

Binary Search Tree(BST) is used as tree data structure

There are two type of threads according to their purpose in the application.
One type is producer thread that is responsible for expanding the BST.
Another type is consumer thread that is responsible for traversing the BST to calculate the number of nodes.

It is assumed that BST can only be expanded.Deletion operation is not supported.

ThreadPool is used to organize the threads.

Locking mechanism is used on BST node level.

Periodic thread count can be increased.
The application has one producer thread for expanding and six consumer thread for dumping the current number of nodes.
