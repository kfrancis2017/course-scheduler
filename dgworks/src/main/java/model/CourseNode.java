package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a node in a course directed acyclic graph, where each node
 * contains information about a course, its direct children, and its ancestors.
 */
public class CourseNode {
    private Course course; // The course associated with this node
    private List<CourseNode> children; // List of direct child nodes
    private List<CourseNode> ancestors; // List of ancestor nodes
    private boolean isAddingChild = false; // Flag to prevent recursive additions in addChild
    private boolean isAddingAncestor = false; // Flag to prevent recursive additions in addAncestor
    private int maxChildren = 0; // Maximum number of direct children (0 implies no limit)
    private int maxAncestors = 0; // Maximum number of direct ancestors (0 implies no limit)

    /**
     * Constructor for creating a CourseNode instance.
     * @param course The course associated with this node.
     */
    public CourseNode(Course course) {
        this.course = course;
        this.children = new ArrayList<>();
        this.ancestors = new ArrayList<>();
    }

    /**
     * Returns the course associated with this node.
     * @return The course object.
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Returns the course ID of the associated course.
     * @return The course ID as a string.
     */
    public String getCourseID() {
        return course.getCourseID();
    }

    /**
     * Returns the list of direct child nodes.
     * @return A list of CourseNode objects representing children.
     */
    public List<CourseNode> getChildren() {
        return children;
    }

    /**
     * Adds a child node to this node. Ensures that the child is not already present,
     * and manages reciprocal addition of this node as an ancestor to the child.
     * @param courseNode The child node to add.
     */
    public void addChild(CourseNode courseNode) {
        if (!children.contains(courseNode)) {
            children.add(courseNode);
            // Prevent recursive addition when adding this node as an ancestor to the child
            if (!courseNode.isAddingAncestor) {
                isAddingChild = true;
                courseNode.addAncestor(this);
                isAddingChild = false;
            }
        }
    }

    /**
     * Returns the list of ancestor nodes.
     * @return A list of CourseNode objects representing ancestors.
     */
    public List<CourseNode> getAncestors() {
        return ancestors;
    }

    /**
     * Adds an ancestor node to this node. Ensures that the ancestor is not already present,
     * and manages reciprocal addition of this node as a child to the ancestor.
     * @param ancestorNode The ancestor node to add.
     */
    public void addAncestor(CourseNode ancestorNode) {
        if (!ancestors.contains(ancestorNode)) {
            ancestors.add(ancestorNode);
            // Prevent recursive addition when adding this node as a child to the ancestor
            if (!ancestorNode.isAddingChild) {
                isAddingAncestor = true;
                ancestorNode.addChild(this);
                isAddingAncestor = false;
            }
        }
    }

    /**
     * Sets the maximum number of direct children this node can have.
     * @param max The maximum number of children.
     */
    public void setMaxChildren(int max) {
        this.maxChildren = max;
    }

    /**
     * Gets the maximum number of direct children this node can have.
     * @return The maximum number of children.
     */
    public int getMaxChildren() {
        return this.maxChildren;
    }

    /**
     * Sets the maximum number of direct ancestors this node can have.
     * @param max The maximum number of ancestors.
     */
    public void setMaxAncestors(int max) {
        this.maxAncestors = max;
    }

    /**
     * Gets the maximum number of direct ancestors this node can have.
     * @return The maximum number of ancestors.
     */
    public int getMaxAncestors() {
        return this.maxAncestors;
    }

    /**
     * Provides a string representation of this node including its course ID,
     * its children, its ancestors, and the maximum depths for children and ancestors.
     * @return A string representation of this CourseNode.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getCourseID());
        sb.append("\nChildren: ");
        if (children.isEmpty()) {
            sb.append("None");
        } else {
            children.forEach(child -> sb.append(child.getCourseID()).append(", "));
        }
        sb.append("\nAncestors: ");
        if (ancestors.isEmpty()) {
            sb.append("None");
        } else {
            ancestors.forEach(ancestor -> sb.append(ancestor.getCourseID()).append(", "));
        }
        sb.append("\nMaximum Depths - Children: ").append(this.getMaxChildren())
          .append(", Ancestors: ").append(this.getMaxAncestors());
        return sb.toString().replaceAll(", $", "");  // Cleanly remove the last comma if present
    }
}
