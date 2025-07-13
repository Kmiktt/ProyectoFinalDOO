package org.example.Logica;
import org.example.Logica.Mascotas.Gato;
import org.example.Logica.Mascotas.Mascota;
import org.example.Logica.Mascotas.Perro;
import org.example.Logica.Mascotas.Pez;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var con = System.console();
        System.out.print("seleccione mascota:\n" +
                "1 = gato\n" +
                "2 = perro\n" +
                "3 = pez\n");
        Mascota m = null;
        Scanner preg = new Scanner(con.reader());
        int a = preg.nextInt();
        switch(a){
            case 1: m = new Gato("A",3);
            case 2: m = new Perro("C", 4);
            case 3: m = new Pez("E", 5);
            default:
        }
        while(con!=null){
            System.out.print("elija acción: \n" +
                    "1 = alimentar\n" +
                    "2 = bañar\n" +
                    "3 = jugar\n" +
                    "4 = sanar\n" +
                    "5 = salir\n");
            preg = new Scanner(System.in);
            int b = preg.nextInt();
            switch(b){
                case 1:
                    System.out.print("ingrese alimento: \n");
                    preg = new Scanner(System.in);
                    m.alimentar(preg.nextLine());
                    break;
                case 2:
                    m.limpiar();
                    break;
                case 3:
                    System.out.print("ingrese juego: \n");
                    preg = new Scanner(System.in);
                    m.jugar();
                    break;
                case 4: m.sanar();
                default:
            }
            System.out.println(m.toString() + "\n");
            m.update();
        }
    }
}