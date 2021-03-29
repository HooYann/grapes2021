package org.yann.node;

public class NodeType {

    public static class Node<E> {
        E item;
        Node<E> next;
    }

    public static class DeNode<E> {
        E item;
        DeNode<E> prev;
        DeNode<E> next;
        DeNode(DeNode<E> prev, E element, DeNode<E> next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public static class TreeNode<E> {
        E data;
        TreeNode<E> parent;
        TreeNode<E>[] children;
        TreeNode<E> left;
        TreeNode<E> right;
    }

}
