package vector_quantization;

import java.util.Vector;

public class Vec {

    public Vector<Vector<Double>> s = new Vector<Vector<Double>>();

    public int compare(Vec v0, Vec v1) {
        double sum0 = 0;
        double sum1 = 0;
        double total0 = 0;
        double total1 = 0;
        for (int i = 0; i < this.s.size(); i++) {
            for (int j = 0; j < this.s.get(i).size(); j++) {
                sum0 = this.s.get(i).get(j) - v0.s.get(i).get(j);
                sum0 = sum0 * sum0;
                sum1 = this.s.get(i).get(j) - v1.s.get(i).get(j);
                sum1 = sum1 * sum1;
            }
            total0 = total0 + sum0;
            total1 = total1 + sum1;
        }
        if (total0 < total1) {
            return 0;
        } else {
            return 1;
        }
    }

    public int compare2(Vector<qua> a) {
        double sum0 = 0;
        double sumc = 0;
        int curr = 0;
        double total0 = 0;
        double totalc = 0;
        int kkk = 1;
        int k;
        int start = a.size();
        for (int q = 0; q < a.size(); q++) {
            if (a.get(q).head.s.size() > 0) {
                start = q;
            }
        }
        curr = start;
        k = start;
        // System.out.print(a.size()+"sssssss");
        for (k = 0; k < a.size(); k++) {
                for (int i = 0; i < a.get(k).head.s.size(); i++) {
                    for (int j = 0; j < a.get(k).head.s.size(); j++) {
                        sumc = this.s.get(i).get(j) - a.get(curr).head.s.get(i).get(j);
                        sumc = sumc * sumc;
                        totalc = totalc + sumc;
                        sum0 = this.s.get(i).get(j) - a.get(k).head.s.get(i).get(j);
                        sum0 = sum0 * sum0;
                        total0 = total0 + sum0;
                    }
//                    total0 = total0 + sum0;
  //                  totalc = totalc + sumc;

                }
            
            if (total0 < totalc) {
                curr = k;
                
            }
            total0=0;
                totalc=0;
        }
    //}
        return curr;
    }
    
//    public int asss(Vec v1,Vec v2){
//    if(v1.s.size()>0){
//    for(int i;i<v2)
//    
//    
//    }
//    
//    }

    public int com(Vec v) {
        //   System.out.println("dsaadsdsa= "+this.s.size());

        for (int i = 0; i < this.s.size(); i++) {
            for (int j = 0; j < this.s.get(i).size(); j++) {
                double x = v.s.get(i).get(j);
                double y = this.s.get(i).get(j);
                //         System.out.println("x " + v.s.get(i).get(j) + "z " + this.s.get(i).get(j));

                if (x != y) {
                    return 0;
                }
            }
        }
        return 1;
    }

}
