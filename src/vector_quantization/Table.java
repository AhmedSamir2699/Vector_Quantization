package vector_quantization;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import java.util.Vector;
import vector_quantization.Vec;
import vector_quantization.qua;

public class Table {

    private static Formatter y;
    private static Scanner x;

    public static void open_r() {
        try {
            x = new Scanner(new File("C:\\Users\\dante\\Documents\\NetBeansProjects\\Vector_Quantization\\Table.txt"));
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void read(Vector<qua> tab) {
        Vector<Double> v = new Vector<Double>();
        Vector<qua> ve = new Vector<qua>();
        Vec vec = new Vec();
        qua q = new qua();
        int size = Integer.parseInt(x.next());
        int r = Integer.parseInt(x.next());
        int c = Integer.parseInt(x.next());
        while (x.hasNext()) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        if (x.hasNext()) {
                            v.add(Double.parseDouble(x.next()));

                        }
                    }
                    vec.s.add(v);
                    v = new Vector<Double>();
                }
                if (x.hasNext()) {
                    q.q = Integer.parseInt(x.next());
                }
                //          q.q = Integer.parseInt(x.next());
                q.head = vec;
                // = qq;
                tab.add(q);
                q = new qua();
                vec = new Vec();
            }
        }

    }

    public static void close_r() {
        x.close();
    }

    public static void readx(Vector<qua> tab) {
        open_r();
        read(tab);
        close_r();
    }

    public static void open_w() {
        try {
            y = new Formatter("C:\\Users\\dante\\Documents\\NetBeansProjects\\Vector_Quantization\\Table.txt");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void write(Vector<qua> tab) {
        y.format("%s%s", Integer.toString(tab.size()), " ");
        y.format("%s%s", Integer.toString(tab.get(0).head.s.size()), " ");
        y.format("%s%s", Integer.toString(tab.get(0).head.s.get(0).size()), " ");
        for (int i = 0; i < tab.size(); i++) {
            for (int j = 0; j < tab.get(i).head.s.size(); j++) {
                for (int k = 0; k < tab.get(i).head.s.get(j).size(); k++) {
                    y.format("%s%s", Double.toString(tab.get(i).head.s.get(j).get(k)), " ");
                }
            }
            y.format("%s%s", Integer.toString(tab.get(i).q), " ");
            // y.format("%s%s",999999, " ");

        }
    }

    public static void close_w() {
        y.close();
    }

    public static void writex(Vector<qua> tab) {
        open_w();
        write(tab);
        close_w();
    }

}
