import java.util.Scanner;

class DoublyLinkedList {
    // Node class for doubly linked list
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Head of the doubly linked list
    private Node head = null;

    // Method to create a new node and add it to the doubly linked list
    public void createNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // If list is empty, newNode becomes the head
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next; // Traverse to the last node
            }
            temp.next = newNode; // Link newNode to the last node
            newNode.prev = temp; // Set previous of newNode
        }
        System.out.println("Node added: " + data);
    }

    // Method to delete a node from the doubly linked list
    public void deleteNode(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data == data) {
            head = head.next; // If head node is to be deleted
            if (head != null) {
                head.prev = null; // Set the new head's previous to null
            }
            System.out.println("Node deleted: " + data);
            return;
        }

        Node temp = head;
        while (temp != null && temp.data != data) {
            temp = temp.next; // Traverse to find the node to delete
        }
        if (temp == null) {
            System.out.println("Node not found: " + data);
        } else {
            if (temp.next != null) {
                temp.next.prev = temp.prev; // Update the next node's prev pointer
            }
            if (temp.prev != null) {
                temp.prev.next = temp.next; // Update the previous node's next pointer
            }
            System.out.println("Node deleted: " + data);
        }
    }

    // Method to display nodes from head to tail
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.print("Doubly Linked List (Forward): ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Method to display nodes from tail to head
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        // Traverse to the last node
        while (temp.next != null) {
            temp = temp.next;
        }
        System.out.print("Doubly Linked List (Backward): ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
}

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice, data;

        while (true) {
            System.out.println("\n1. Create Node\n2. Delete Node\n3. Display Nodes Forward\n4. Display Nodes Backward\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data for new node: ");
                    data = sc.nextInt();
                    list.createNode(data);
                    break;
                case 2:
                    System.out.print("Enter data to delete: ");
                    data = sc.nextInt();
                    list.deleteNode(data);
                    break;
                case 3:
                    list.displayForward();
                    break;
                case 4:
                    list.displayBackward();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
