package conpanySpecific;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Node{
    String data;

    Node(String data){
        this.data = data;
    }
}

class Pair{
    Node start;
    Node end;

    Pair(Node start, Node end){
        this.start = start;
        this.end = end;
    }
}
public class TreeBuilder 
{
    public static Node returnRoot(List<Pair> input)
    {
          if(input == null || input.size() == 0){
              throw new IllegalArgumentException("Input is null or doesn't contain any elements");
          }

          // Create a list of roots, in case there are multiple roots present
          List<Node> roots = new ArrayList<>();

          // This boolean checks if there are edges pointing to a particular node
          boolean isPresent = false;
          HashMap<Node, HashSet<Node>> adjList = buildList(input);

          // iterate over each key of the hash map (which is the tree) and check if there are any edges pointing to it
          for(Node keyItr: adjList.keySet()) {
              for (HashSet<Node> setItr : adjList.values()) {
                  if (setItr.contains(keyItr)) {
                      isPresent = true;
                      break;
                  }
              }

              // if there were no edges pointing to this node, add it as a root
              if (!isPresent) {
                  roots.add(keyItr);
                  // Ideally we would return the keyItr here as the root
                  // but we continue to check if there are multiple roots in the input data
              }
              isPresent = false;
          }

          // only one root is found
          if(roots.size() == 1){
              // check if there are cycles within the children of this tree and return the root
              checkChildCycles(adjList);
              return roots.get(0);
          }

          // there is a cycle with the root
          else if(roots.size() == 0) {
              throw new IllegalArgumentException("Input pairs contain a cycle with the root");
          }

          // there are multiple roots
          else{
              throw new IllegalArgumentException("Input pairs contains multiple ("+ roots.size() + ") roots");
          }
      }

      public static HashMap<Node, HashSet<Node>> buildList(List<Pair> input){
        HashSet<Node> childSet;
        HashMap<Node, HashSet<Node>> adjList = new HashMap<>();
        for(Pair i: input){
            // if this subtree exists, add the child to that
            if(adjList.containsKey(i.start)){
                childSet = adjList.get(i.start);
                childSet.add(i.end);
                adjList.put(i.start, childSet);
            }
            // create a new subtree
            else{
                HashSet<Node> newSet = new HashSet<>();
                newSet.add(i.end);
                adjList.put(i.start, newSet);
            }
        }
        return adjList;
    }

    public static void checkChildCycles(HashMap<Node, HashSet<Node>> tree){
        int childOccurance = 0;
        // for each set
        for(HashSet<Node> setItr: tree.values()){
            // for each node in set
            for(Node x : setItr){
                // check against each value set to find occurrences
                for(HashSet<Node> checkSets: tree.values()){
                    if(checkSets.contains(x)){
                        childOccurance++;
                        if(childOccurance > 1){
                            throw new IllegalArgumentException("Input pairs contain cycle with child nodes");
                        }
                    }
                }
                childOccurance = 0;
            }
        }
    }

    public static void main(String[] args){
        List<Pair> input = new ArrayList<>();
        Node r1 = new Node("r1");
        Node c11 = new Node("c11");
        Node c12 = new Node("c12");
        Node c13 = new Node("c13");
        Node c111 = new Node("c111");
        Node c112 = new Node("c112");
        Node c121 = new Node("c121");
        // add these nodes to pairs of the tree as edges
        Pair p1 = new Pair(r1,c11);
        Pair p2 = new Pair(r1,c12);
        Pair p3 = new Pair(r1,c13);
        Pair p4 = new Pair(c11,c111);
        Pair p5 = new Pair(c11,c112);
        Pair p6 = new Pair(c12, c121);
        // add these pairs to our input list of edges
        input.add(p4); input.add(p5); input.add(p6);
        input.add(p1); input.add(p2); input.add(p3);

        // to test edge cases

        // pair that makes cycle with root
        // Pair p7 = new Pair (c121, r1);
        // input.add(p7);

        // pair that makes cycle with children
        // Pair p8 = new Pair(c121, c112);
        // input.add(p8);

        // 2 nodes to create 2 trees
        //Node d1 = new Node("d1");
        //Node d2 = new Node("d2");
        // pair that makes 2 trees / 2 roots
        //Pair p9 = new Pair (d1, d2);
        //input.add(p9);


        // execute the function
        try{
            System.out.println(returnRoot(input).data);
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
