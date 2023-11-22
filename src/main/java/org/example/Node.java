package org.example;

/**
 * a very generic Node for a directed graph
 */
public class Node {
    int src;
    int dest;
    int w;

    public Node(int src, int dest, int w) {
        this.src = src;
        this.dest = dest;
        this.w = w;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }
}
