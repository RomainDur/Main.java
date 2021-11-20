import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class ArbrePrefixe extends Dictionary {


    public static class Noeud {
        Boolean EndWord;
        ArbrePrefixe Fils;

        public Noeud() {
            EndWord = false;
            Fils = new ArbrePrefixe();
        }

        public boolean getEndWord() {
            return EndWord;
        }

        public void AddFils(String mot, ArbrePrefixe arbre) {
            String FirstChar = mot.substring(0, 1);
            boolean End = false;
            if (mot.length() == 1) {
                End = true;
                arbre.add(FirstChar);
            }
            if (End = false) {
                arbre.add(FirstChar);
                AddFils(mot.substring(1, mot.length()), Fils.get(FirstChar));
            }

        }


        public ArbrePrefixe getFils() {
            return Fils;
        }

    }

    HashMap<String, ArbrePrefixe> Arbre;

    public ArbrePrefixe() {
        super();
        Arbre = new HashMap<String, ArbrePrefixe>();

    }

    public ArbrePrefixe get(String Char) {
        for (Map.Entry<String, ArbrePrefixe> entry : Arbre.entrySet()) {
            if (entry.getKey().equals(Char)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public boolean Contains(Object Char) {
        for (Map.Entry<String, ArbrePrefixe> entry : Arbre.entrySet()) {
            if (entry.getKey().equals(Char)) {
                return true;
            }
        }
        return false;
    }

    public void add(Object Chara) {
        String Char = (String) Chara;
        Arbre.put(Char, new ArbrePrefixe());
    }

    public void Addmot(String mot, ArbrePrefixe dico) {
        String FirstChar = mot.substring(0, 1);
        ArbrePrefixe.Noeud noeud = new ArbrePrefixe.Noeud();
        noeud.AddFils(mot, noeud.getFils());

        if (mot.length() == 1) {
            noeud.EndWord = true;
        }
        if (dico.Contains(FirstChar)) {
            if (noeud.EndWord = true) {
                dico.add(FirstChar);
            }
            Addmot(mot.substring(1, mot.length()), noeud.getFils().get(FirstChar));
        } else {
            dico.add(FirstChar);
            if (noeud.EndWord = false) {
                Addmot(mot.substring(1, mot.length()), noeud.getFils().get(FirstChar));
            }
        }
    }
}





