package vector_quantization;

import java.util.Vector;

public class qua {
    public Vec head = new Vec();
    public Vector<Vec> groubs = new Vector<Vec>();
    public int q = -1;

    public Vector<Vector<Integer>> fill(int arr[][], int c, int r, int start_c, int start_r) {
        int c_lim = c;
        int r_lim = r;
        Vector<Vector<Integer>> s = new Vector<Vector<Integer>>();
        Vector<Integer> vec = new Vector<Integer>();

        for (int i = start_r; i < r_lim + start_r; i++) {
            for (int j = start_c; j < c_lim; j++) {
                vec.add(arr[i][j]);
            }
            s.add(vec);
            vec = new Vector<Integer>();
        }

        return s;
    }

    public Vec fill2(int arr[][], int c, int r, int start_c, int start_r) {
        int c_lim = c;
        int r_lim = r;
        Vec v = new Vec();
        Vector<Double> vec = new Vector<Double>();
        for (int i = start_r; i < r_lim + start_r; i++) {
            for (int j = start_c; j < c_lim + start_c; j++) {
                vec.add((double) arr[i][j]);
            }
            v.s.add(vec);
            vec = new Vector<Double>();
        }
        return v;
    }
    
    public void fill_groubs(int arr[][], int c, int r) {
        int start_c = 0;
        int start_r = 0;
        while (start_r < arr.length) {
            this.groubs.add(fill2(arr, c, r, start_c, start_r));
            start_c = start_c + c;
            if (start_c >= arr[0].length) {
                start_c = 0;
                start_r = start_r + r;
            }
        }
    }

    public void fill_arr(Double arr[][], int c, int r, int num) {
        for (int i = 0; i < this.groubs.get(num).s.size(); i++) {
            for (int j = 0; j < this.groubs.get(num).s.get(i).size(); j++) {
                arr[r + i][j + c] = this.groubs.get(num).s.get(i).get(j);
            }
        }
    }

    public Double[][] return_to_arr(int c_arr, int r_arr, int r, int c) {
        Double[][] arr = new Double[r_arr][c_arr];
        int num = 0;
        for (int i = 0; i < r_arr; i = i + r) {
            for (int j = 0; j < c_arr; j = j + c) {
                fill_arr(arr, j, i, num);
                num++;
            }
        }
        return arr;
    }

    public void get_av() {
        this.head = new Vec();
        if (this.groubs.size() > 0) {
            for (int i = 0; i < this.groubs.get(0).s.size(); i++) {
                Vector<Double> v = new Vector<Double>();
                for (int j = 0; j < this.groubs.get(0).s.get(i).size(); j++) {
                    double total = 0;
                    for (int k = 0; k < this.groubs.size(); k++) {
                        total = total + this.groubs.get(k).s.get(i).get(j);
                    }
                    v.add(total / (this.groubs.size()));
                }
                this.head.s.add(v);
            }
        }
    }

    public void split(qua v0, qua v1) {
        for (int i = 0; i < this.head.s.size(); i++) {
            Vector<Double> ve0 = new Vector<Double>();
            Vector<Double> ve1 = new Vector<Double>();
            for (int j = 0; j < this.head.s.get(i).size(); j++) {
                int i0 = (int) Math.ceil(this.head.s.get(i).get(j));
                int i1 = (int) Math.ceil(this.head.s.get(i).get(j));
                ve0.add((double) i0 - 1);
                ve1.add((double) i1 + 1);
            }
            v0.head.s.add(ve0);
            v1.head.s.add(ve1);
        }
    }

    public int nearest(qua v0, qua v1) {
        split(v0, v1);
        int d;
        for (int i = 0; i < this.groubs.size(); i++) {
            d = this.groubs.get(i).compare(v0.head, v1.head);
            if (d == 0) {
                v0.groubs.add(this.groubs.get(i));
            } else {
                v1.groubs.add(this.groubs.get(i));
            }
        }
        v1.get_av();
        v0.get_av();
        return 1;
    }

//    public int nearest2(qua v0, qua v1, qua a) {
//        split(v0, v1);
//        int d;
//        for (int i = 0; i < a.groubs.size(); i++) {
//            d = a.groubs.get(i).compare(v0.head, v1.head);
//            if (d == 0) {
//                v0.groubs.add(a.groubs.get(i));
//            } else {
//                v1.groubs.add(a.groubs.get(i));
//            }
//        }
//        v1.get_av();
//        v0.get_av();
//        return 1;
//    }
        public int nearest2(Vector<qua> a) {
        int d;
        for (int i = 0; i < this.groubs.size(); i++) {
            d = this.groubs.get(i).compare2(a);
            a.get(d).groubs.add(this.groubs.get(i));
        }
        for (int j = 0; j < a.size(); j++) {
            a.get(j).get_av();
        }
        return 1;
    }

    public int check_gr(Vec v) {
        for (int i = 0; i < this.groubs.size(); i++) {
            int d = this.groubs.get(i).com(v);
            if (d == 1) {
                return 1;
            }
        }
        return 0;
    }

}
