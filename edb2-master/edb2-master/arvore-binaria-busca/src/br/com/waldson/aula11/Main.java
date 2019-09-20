package br.com.waldson.aula11;

import javax.swing.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        arvore.insert(10);
        arvore.insert(30);
        arvore.insert(40);
        arvore.insert(15);
        arvore.insert(35);
        arvore.insert(50);
    }
}
