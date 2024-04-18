package model;

import java.util.*;

/**
 * Represents a directed acyclic graph (DAG) of courses where nodes are course units and edges represent prerequisites.
 */
public class CourseDAG {
    // A map to hold all CourseNodes, keyed by course ID.
    private Map<String, CourseNode> nodes;

    /**
     * Constructor that initializes the DAG with an empty map.
     */
    public CourseDAG() {
        this.nodes = new HashMap<>();
    }

    /**
     * Retrieves a CourseNode based on its course ID.
     * @param courseID The ID of the course to retrieve.
     * @return The CourseNode associated with the given course ID.
     */
    public CourseNode getCourseNode(String courseID) {
        return nodes.get(courseID);
    }

    /**
     * Adds a new CourseNode to the DAG.
     * @param course The course to add as a node.
     */
    public void addNode(Course course) {
        nodes.put(course.getCourseID(), new CourseNode(course));
    }

    /**
     * Establishes a child relationship between two courses.
     * @param parentNode The parent course node.
     * @param childNode The child course node.
     */
    public void addParent(Course parentNode, Course childNode) {
        this.getCourseNode(parentNode.getCourseID()).addChild(this.getCourseNode(childNode.getCourseID()));
    }

    /**
     * Establishes a descendant relationship between two courses.
     * @param parentNode The parent course node.
     * @param childNode The child course node.
     */
    public void addChild(Course parentNode, Course childNode) {
        this.getCourseNode(childNode.getCourseID()).addAncestor(this.getCourseNode(parentNode.getCourseID()));
    }

    /**
     * Adds an ancestor relationship between two courses.
     * @param parentNode The course to be the ancestor.
     * @param childNode The course to be the descendant.
     */
    public void addAncestor(Course parentNode, Course childNode) {
        CourseNode parentNodeCourseNode = this.getCourseNode(parentNode.getCourseID());
        CourseNode childNodeCourseNode = this.getCourseNode(childNode.getCourseID());

        if (parentNodeCourseNode == null || childNodeCourseNode == null) {
            System.err.println("Parent or Child node not found in the Course DAG.");
            return; // Exit the method if either node is not found
        }

        childNodeCourseNode.addAncestor(parentNodeCourseNode);
    }

    /**
     * Calculates the maximum depth from a given node to its furthest ancestor.
     * @param node The node to start from.
     * @param visited A set to track visited nodes and prevent infinite loops.
     * @return The maximum depth to the furthest ancestor.
     */
    private int calculateMaxAncestorDepth(CourseNode node, Set<CourseNode> visited) {
        visited.add(node);
        int maxDepth = 0;
        for (CourseNode ancestor : node.getAncestors()) {
            if (!visited.contains(ancestor)) {
                int depth = calculateMaxAncestorDepth(ancestor, visited) + 1;
                maxDepth = Math.max(maxDepth, depth);
            }
        }
        visited.remove(node);
        return maxDepth;
    }

    /**
     * Calculates the maximum depth from a given node to its furthest descendant.
     * @param node The node to start from.
     * @param visited A set to track visited nodes and prevent infinite loops.
     * @return The maximum depth to the furthest descendant.
     */
    private int calculateMaxDescendantDepth(CourseNode node, Set<CourseNode> visited) {
        visited.add(node);
        int maxDepth = 0;
        for (CourseNode child : node.getChildren()) {
            if (!visited.contains(child)) {
                int depth = calculateMaxDescendantDepth(child, visited) + 1;
                maxDepth = Math.max(maxDepth, depth);
            }
        }
        visited.remove(node);
        return maxDepth;
    }

    /**
     * Updates all nodes with their maximum ancestor and descendant depths.
     */
    private void updateMaxDepths() {
        for (CourseNode node : nodes.values()) {
            Set<CourseNode> visited = new HashSet<>();
            int maxAncestorDepth = calculateMaxAncestorDepth(node, visited);
            int maxDescendantDepth = calculateMaxDescendantDepth(node, visited);

            node.setMaxAncestors(maxAncestorDepth);
            node.setMaxChildren(maxDescendantDepth);
        }
    }

    /**
     * Sorts courses in the DAG based on the number of children and ancestors.
     * @return A sorted list of lists of courses.
     */
    public List<List<Course>> sortByChildrenAndAncestors() {
        final int maxCoursesPerList = 6;
        this.updateMaxDepths();
        List<CourseNode> originalNodes = new ArrayList<>(nodes.values());

        Collections.sort(originalNodes, (a, b) -> {
            int comparisonResult = Integer.compare(b.getMaxChildren(), a.getMaxChildren());
            if (comparisonResult == 0) {
                comparisonResult = Integer.compare(b.getMaxAncestors(), a.getMaxAncestors());
            }
            return comparisonResult;
        });

        List<CourseNode> workingList = new ArrayList<>(originalNodes);
        List<List<Course>> sortedCourseLists = new ArrayList<>();
        List<Course> currentList = new ArrayList<>();

        while (!workingList.isEmpty()) {
            Iterator<CourseNode> iterator = originalNodes.iterator();
            while (iterator.hasNext()) {
                CourseNode node = iterator.next();
                int index = sortedCourseLists.size();

                if (workingList.contains(node) && node.getMaxAncestors() <= index) {
                    if (currentList.size() < maxCoursesPerList) {
                        currentList.add(node.getCourse());
                        workingList.remove(node);
                    } else {
                        sortedCourseLists.add(new ArrayList<>(currentList));
                        currentList.clear();
                        currentList.add(node.getCourse());
                        workingList.remove(node);
                    }
                }
            }

            if (!currentList.isEmpty()) {
                sortedCourseLists.add(new ArrayList<>(currentList));
                currentList.clear();
            }
        }
        return sortedCourseLists;
    }

    /**
     * Provides a string representation of the DAG structure.
     * @return A string representation of the Course DAG.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (CourseNode node : nodes.values()) {
            sb.append("\n---\n");
            sb.append(node.toString());
        }
        return sb.toString();
    }
}
