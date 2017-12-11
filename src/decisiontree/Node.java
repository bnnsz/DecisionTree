/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

import static decisiontree.Constant.SPAN;
import java.util.List;

/**
 *
 * @author ObinnaAsuzu
 */
public class Node {

    private Edge parent;
    private List<Edge> children;
    private Type type;

    private double value;

    public Node() {

    }

    public Node(Edge parent, List<Edge> children, Type type) {
        this.parent = parent;
        this.children = children;
        this.type = type;
    }

    /**
     * @return the parentNode
     */
    public Edge getParent() {
        return parent;
    }

    /**
     * @param parent
     */
    public void setParentNode(Edge parent) {
        this.parent = parent;
    }

    /**
     * @return the branches
     */
    public List<Edge> getChildren() {
        return children;
    }

    /**
     * @param children
     */
    public void setChildren(List<Edge> children) {
        this.children = children;
        switch (type) {
            case DECISION: {
                if (getParent() == null) {
                    double[] ds = new double[children.size()];
                    double max = 0.0;
                    String choice = "";
                    for (int i = 0; i < ds.length; i++) {

                        ds[i] = children.get(i).getOutcome().getValue() - children.get(i).getValue();
                        System.out.printf("\nFOR CHOICE : %s RESULT: [%.1f]",children.get(i).getName().toUpperCase(),ds[i]);
                        choice = ds[i] > max ? children.get(i).getName().toUpperCase() + " [" + children.get(i).getValue() + "] " : choice;
                        max = ds[i] > max ? ds[i] : max;

                    }
                    System.out.println("THE BEST CHOICE IS " + choice);

                }
            }
            case OUTCOME: {
                if (children != null) {
                    for (Edge e : children) {
                        for (Edge e1 : e.getDecision().getChildren()) {
                            value += (e.getValue() * e1.getValue() * SPAN);
                        }
                    }
                }
            }
        }
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

}
