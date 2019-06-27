/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector_quantization;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author dante
 */
public class Index {

    private static Formatter y;
    private static Scanner x;

    public static void open_r() {
        try {
            x = new Scanner(new File("C:\\Users\\dante\\Documents\\NetBeansProjects\\Vector_Quantization\\Index.txt"));
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void read(Vector<Integer> in, int arr[]) {
        arr[0] = (Integer.parseInt(x.next()));
        arr[1] = (Integer.parseInt(x.next()));

        while (x.hasNext()) {
            in.add(Integer.parseInt(x.next()));
        }
    }

    public static void close_r() {
        x.close();
    }

    public static void readx(Vector<Integer> in, int arr[]) {
        open_r();
        read(in, arr);
        close_r();
    }

    public static void open_w() {
        try {
            y = new Formatter("C:\\Users\\dante\\Documents\\NetBeansProjects\\Vector_Quantization\\Index.txt");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void write(Vector<Integer> in, int arr[]) {
        y.format("%s%s", Integer.toString(arr[0]), " ");
        y.format("%s%s", Integer.toString(arr[1]), " ");
        for (int i = 0; i < in.size(); i++) {
            y.format("%s%s", Integer.toString(in.get(i)), " ");
        }
    }

    public static void close_w() {
        y.close();
    }

    public static void writex(Vector<Integer> in, int arr[]) {
        open_w();
        write(in, arr);
        close_w();
    }

}
