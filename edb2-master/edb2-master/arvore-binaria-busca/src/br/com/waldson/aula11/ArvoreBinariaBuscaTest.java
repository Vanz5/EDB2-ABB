package br.com.waldson.aula11;

import org.junit.*;
import static org.junit.Assert.*;

public class ArvoreBinariaBuscaTest {
    private ArvoreBinariaBusca arvore;

    @Before
    public void setUp() throws Exception{
        arvore = new ArvoreBinariaBusca();
    }

    @org.junit.Test
    public void isEmpty() {
        assertTrue(arvore.isEmpty());
        arvore.insert(1);
        assertFalse(arvore.isEmpty());
    }

    @org.junit.Test
    public void getRoot() {
        Node root = new Node(1);
        arvore.insert(root);

        assertEquals(root,arvore.getRoot());
    }

    @org.junit.Test
    public void insert() {
        arvore.insert(10);

        assertFalse(arvore.isEmpty());
    }

    @org.junit.Test
    public void search() {
        Node node = new Node(15);
        arvore.insert(20);
        arvore.insert(25);
        arvore.insert(node);

        assertEquals(node,arvore.search(15));
    }

    @org.junit.Test
    public void removeLeaf(){
        arvore.insert(3);
        arvore.insert(5);
        arvore.insert(12);

        arvore.remove(12);

        assertNull(arvore.search(12));
    }

    @org.junit.Test
    public void removeOneChild(){
        arvore.insert(45);
        arvore.insert(35);
        arvore.insert(2);
        arvore.insert(5);

        arvore.remove(2);

        assertEquals(5, arvore.search(35).getLeft().getValue());
    }

    @org.junit.Test
    public void removeTwoChild(){
        arvore.insert(15);
        arvore.insert(12);
        arvore.insert(4);

        arvore.remove(15);

        assertEquals(4,arvore.search(12).getLeft().getValue());
    }
}