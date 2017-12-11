/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decisiontree;

/**
 *
 * @author ObinnaAsuzu
 */
public class Edge {
    private String name;
    private double value;
    private Node decision;
    private Node outcome;
    private Type type;

    public Edge() {
        
    }

    public Edge(String name, double value, Node decision, Node outcome, Type type) {
        this.name = name;
        this.value = value;
        this.decision = decision;
        this.outcome = outcome;
        this.type = type;
    }

    

    
    
    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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

    /**
     * @return the decision
     */
    public Node getDecision() {
        return decision;
    }

    /**
     * @param decision the decision to set
     */
    public void setDecision(Node decision) {
        this.decision = decision;
    }

    /**
     * @return the outcome
     */
    public Node getOutcome() {
        return outcome;
    }

    /**
     * @param outcome the outcome to set
     */
    public void setOutcome(Node outcome) {
        this.outcome = outcome;
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

    

}
