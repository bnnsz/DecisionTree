/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

import static decisiontree.Type.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ObinnaAsuzu
 */
public class DecisionTree {

    Scanner input = new Scanner(System.in);
    public final String ANSI_RESET = "\u001B[0m";
    public final String ANSI_BLACK = "\u001B[30m";
    public final String ANSI_RED = "\u001B[31m";
    public final String ANSI_GREEN = "\u001B[32m";
    public final String ANSI_YELLOW = "\u001B[33m";
    public final String ANSI_BLUE = "\u001B[34m";
    public final String ANSI_PURPLE = "\u001B[35m";
    public final String ANSI_CYAN = "\u001B[36m";
    public final String ANSI_WHITE = "\u001B[37m";

    List<Edge> createBranches(int n, Node parent) {
        if (n == 0) {
            return null;
        }
        List<Edge> branches = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println();
            switch (parent.getType()) {
                case DECISION: {
                    Edge edge = new Edge();
                    Node node = new Node();
                    if (parent.getParent() != null) {
                        System.out.print("DESCRIBE " + ordinal(i + 1).toUpperCase() + " CHOICE IF " + ANSI_BLUE + parent.getParent().getName().toUpperCase() + ANSI_RESET + " OCCURS: ");
                    } else {
                        System.out.print("DESCRIBE " + ordinal(i + 1).toUpperCase() + " CHOICE: ");
                    }
                    input.nextLine();

                    edge.setName(input.nextLine());
                    
                    System.out.print("VALUE FOR CHOICE: ");
                    edge.setValue(input.nextDouble());
                    System.out.println();
                    System.out.println();
                    edge.setType(CHOICE);
                    edge.setDecision(parent);
                    node.setType(OUTCOME);
                    node.setParentNode(edge);
                    System.out.print("NO OF OUTCOMES IF CHOICE IS " + ANSI_BLUE + edge.getName().toUpperCase() + ANSI_RESET + ": ");
                    node.setChildren(createBranches(input.nextInt(), node));
                    edge.setOutcome(node);
                    branches.add(edge);
                    break;
                }
                case OUTCOME: {

                    Edge edge = new Edge();
                    Node node = new Node();
                    System.out.print("DESCRIBE " + ordinal(i + 1).toUpperCase() + " OUTCOME FOR THE CHOICE " + ANSI_BLUE + parent.getParent().getName().toUpperCase() + ANSI_RESET + ": ");
                    input.nextLine();
                    edge.setName(input.nextLine());
                    System.out.print("PROBABILITY OF A "+ANSI_BLUE + edge.getName().toUpperCase() + ANSI_RESET+": ");
                    edge.setValue(input.nextDouble());
                    System.out.println();
                    edge.setType(OUTCOME);
                    edge.setOutcome(parent);
                    node.setType(DECISION);
                    node.setParentNode(edge);
                    System.out.print("ENTER NO OF CHOICES FOR NEW DECISION [D" + (i + 1) + "] IF " + ANSI_BLUE + parent.getParent().getName().toUpperCase() + ANSI_RESET + " YIELDS "
                    + ANSI_BLUE + edge.getName().toUpperCase() + ANSI_RESET + ": ");
                    node.setChildren(createBranches(input.nextInt(), node));
                    edge.setDecision(node);
                    branches.add(edge);
                    break;
                }
                default:
                    throw new AssertionError(parent.getType().name());
            }
        }
        return branches;
    }

    public void buildTree() {
        Node node = new Node();
        node.setType(DECISION);
        System.out.print("\nENTER NO OF CHOICES FOR NEW DECISION [D0]: ");
        node.setChildren(createBranches(input.nextInt(), node));
    }

    public String ordinal(int i) {
        String[] sufixes = new String[]{"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};
        switch (i % 100) {
            case 11:
            case 12:
            case 13:
                return i + "th";
            default:
                return i + sufixes[i % 10];

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new DecisionTree().buildTree();
    }

}
