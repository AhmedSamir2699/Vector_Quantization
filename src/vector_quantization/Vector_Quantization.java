package vector_quantization;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import javax.imageio.ImageIO;

public class Vector_Quantization {
public static void getAvg(int data[][], Vector<Integer> firstAvg)
{  int total=0,avg=0,counter=0,sum=0,c=0,v=0,w=0;
    for(int k=0;k<4;k++)
          {
          for(int i=v;i<data.length;i+=2)
          {
              
              for(int j=w;j<data.length;j+=2)
              {
                  total=total+data[i][j];
                  counter++;
              }
             
          }
              sum=sum+total;
              avg=sum/counter;
              firstAvg.add(avg);
              avg=0;
              total=0;
              counter=0;
              sum=0;
              w++;
              c++;
              if(c>1)
              {
                  v=1;
                  w=0;
                  c=0;
              }
          }
}
    public static void main(String[] args) {
        
         Scanner scan=new Scanner (System.in);        
        System.out.print("Enter the size of vector : " );        
        int sizeofvector=scan.nextInt();
        System.out.println();
                
        System.out.print("Enter the number of coodbook : " );        
        int num_coodBook=scan.nextInt();
        System.out.println();
        check_no_files(sizeofvector,num_coodBook);
 int[][] data=new int[][]{{1, 2, 7, 9,4, 11}
                                ,{ 3, 4, 6, 6, 12, 12}
                                ,{ 4, 9, 15, 14, 9, 9}
                                ,{10, 10, 20, 18, 8, 8}
                                ,{4, 3, 17, 16, 1, 4}
                                ,{4, 5, 18, 18, 5, 6 }};
 
          Vector<Integer> firstAvg=new Vector<Integer>();
          int total=0,avg=0,counter=0,sum=0,c=0,v=0,w=0;
          for(int k=0;k<4;k++)
          {
          for(int i=v;i<data.length;i+=2)
          {
              
              for(int j=w;j<data.length;j+=2)
              {
                  total=total+data[i][j];
                  counter++;
              }
             
          }
              sum=sum+total;
              avg=sum/counter;
              firstAvg.add(avg);
              avg=0;
              total=0;
              counter=0;
              sum=0;
              w++;
              c++;
              if(c>1)
              {
                  v=1;
                  w=0;
                  c=0;
              }
          }
          int sum3=0;
          for(int t=0;t<4;t++)
          {
              sum3=sum3+firstAvg.get(t);
           //   System.out.println(firstAvg.get(t));
          }
       
          Vector<Integer> big=new Vector<Integer>();
          Vector<Integer> small=new Vector<Integer>();
          int b=0,s=0,x=0,y=0;
          int total1=0,total2=0;
          int sum1=0,sum2=0;
          int counter1=1,counter2=1;
          int avg1=0,avg2=0;
          int sum4=0;
         
          int cc=0;
          sum=0;
          int count=0;
          avg=0;
          int ccc=0;
          int cccc=0;

    
         int i=0;
         int j=0;
          int num=data.length*6;
        
          int z=2;
          int p=0;
          // System.out.println(num);
          int h=firstAvg.get(0);
          Vector<Integer> subvector=new Vector<Integer>();
      
       int[][] t2=new int[][]{{6,8},{9,9}};
        Vector<int[][]> arr_res = new Vector<int[][]>() ;
      
     int mm=0;
     int kk=2;
     v=0;
       Vector<Integer> temp=new Vector<Integer>();
      
     //  do
     //  {
      temp.add(firstAvg.get(0));
      temp.add(firstAvg.get(1));
    // for(int r=0;r<6;r++)
     //{
       
     for(int f=0;f<3;f++)
     {
           for(int k=0;k<6;k+=2)
           {
             for( i=k;i<k+2;i++)
             {
                 for( j=v;j<kk;j++)
                 {
                  
                  sum1+=Math.pow(Math.abs(data[i][j]-(temp.get(mm)+1)),2);
                  
                  sum2+=Math.pow(Math.abs(data[i][j]-(temp.get(mm)-1)),2);
                     ccc++;
                     subvector.add(data[i][j]);
            mm++;
                   
                 }
                 mm=0;
                 temp.clear();
                 temp.add(firstAvg.get(mm+2));
                 temp.add(firstAvg.get(mm+3));
             }
             
                  if(sum1<sum2)
             {
                 
                 for(int t=0;t<subvector.size();t++)
                 {
                    big.add(subvector.get(t));
      
                 sum1=0;
                 sum2=0;
                 }
                
             }
             else
             {
                  for(int t=0;t<subvector.size();t++)
                 {
                    small.add(subvector.get(t));
               
                   sum1=0;
                   sum2=0;
                 }
             }
        
         
             if(ccc>=11)
             {
           
                 ccc=0;
             }
           
             cccc++;
   
             subvector.clear();
             
           
           }
           v+=2;
           kk+=2;
          // temp.clear();
     }
     temp.clear();
  //   firstAvg.clear();
      // }while(cccc<=18);
      int arr1[]=new int[big.size()];
      int arr2[]=new int[small.size()];
      int output[][]=new int [6][6];
           for(int t=0;t<big.size();t++)
          {
              arr1[t]=big.get(t);
              //System.out.println(big.get(t));
          }
           Integer[] scores = big.toArray(new Integer[big.size()]);
   
    int couunt=0;

        for(int t=0;t<6;t++)
        {
            for(int q=0;q<6;q++)
            {
                if(couunt==arr1.length) break;
            output[t][q]=arr1[couunt];
        // System.out.printf("a[%d][%d]= %d\n",t,q,output[t][q]);
            couunt++;
            }
        }
   
    
          // getAvg(output,firstAvg);
            for(int t=0;t<small.size();t++)
          {
               arr2[t]=small.get(t);
             // System.out.println(small.get(t));
          }
          //  print(output);
            int output1[][]=new int [][]{{1,2,7,9,4,3},
                                         {3,4,6,6,4,5},
                                         {9,9,1,4,9,10},
                                         {8,8,5,6,10,10}            };
            couunt=0;

        /*for(int t=0;t<6;t++)
        {
            for(int q=0;q<6;q++)
            {
                if(couunt==arr2.length) break;
            output1[t][q]=arr2[couunt];
            System.out.printf("a[%d][%d]= %d\n",t,q,output1[t][q]);
            couunt++;
            }
        }*/
        //output
       // print(output1);
        getAvg(output1,firstAvg);
        mm=0;
        mm=+4;
      //  temp.add(firstAvg.get(mm));
      // temp.add(firstAvg.get(mm+1));
     //}
        for(int t=0;t<firstAvg.size();t++)
          {
           //   sum3=sum3+firstAvg.get(t);
     //         System.out.println(firstAvg.get(t));
          }
    }

    public static int[][] modi_arr(int size, int[][] pixels) {
        int new_length = pixels.length;
                          //              System.out.println("qqqq "+size %(pixels.length));

        if ((pixels.length)%size == 0) {
                                               //     System.out.println("xxxxxxx");

            new_length = pixels.length;
        } else {
            while (new_length % size != 0) {
                new_length++;
                           //    System.out.println("qqqq "+new_length+"xxxx "+ new_length % size );

            }
        }
        int[][] arr = new int[new_length][new_length];
        for (int i = 0; i < new_length; i++) {
            for (int j = 0; j < new_length; j++) {
                if (j < pixels[0].length && i < pixels.length) {
                    arr[i][j] = pixels[i][j];
                } else {
                    arr[i][j] = 0;
                }
            }
        }
        return arr;
    }

    public static void check_no_files(int size,int num) {
        Vector<qua> tab = new Vector<qua>();
        Vector<qua> tab1 = new Vector<qua>();
        Vector<Integer> st = new Vector<Integer>();
        //Vector<Integer> st1 = new Vector<Integer>();
        int[][] pixels1 = readImage("C:\\Users\\Ascd\\Desktop\\Vector_Quantization\\Vector_Quantization\\cameraMan.jpg");
        int[][] pixels=modi_arr(2,pixels1);
                System.out.println(pixels.length);

        Double[][] arr1 = new Double[pixels.length][pixels[0].length];
        int f = size; //size
        qua a = new qua();
        qua a1 = new qua();
        a1.fill_groubs(pixels, f, f);
        table3(pixels, tab, f, f, num, a1);//
        improve(pixels, tab, f, f);
        insert_q(tab);
        System.out.println();

        compress(st, a1, tab);
        // System.out.print(st.size());
        int ar[] = {pixels.length, pixels[0].length};
        decompress(st, a, tab);
        System.out.println(st.size());

        Double[][] arr6 = new Double[ar[0]][ar[1]];
        arr6 = a.return_to_arr(pixels.length, pixels[0].length, f, f);
        int[][] arr2 = D_to_I(arr6);
        writeImage(arr2, "C:\\Users\\Ascd\\Desktop\\Vector_Quantization\\aaa.jpg");
    }
    
    public static void writeImage(int[][] imagePixels, String outPath) {

        BufferedImage image = new BufferedImage(imagePixels.length, imagePixels[0].length, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < imagePixels.length; y++) {
            for (int x = 0; x < imagePixels[y].length; x++) {
                int value = -1 << 24;
                value = 0xff000000 | (imagePixels[y][x] << 16) | (imagePixels[y][x] << 8) | (imagePixels[y][x]);
                image.setRGB(x, y, value);
            }
        }
        File ImageFile = new File(outPath);
        try {
            ImageIO.write(image, "jpg", ImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int[][] readImage(String path) {

        BufferedImage img;
        try {
            img = ImageIO.read(new File(path));

            int hieght = img.getHeight();
            int width = img.getWidth();

            int[][] imagePixels = new int[hieght][width];
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < hieght; y++) {
                    int pixel = img.getRGB(x, y);
                    int red = (pixel & 0x00ff0000) >> 16;
                    int grean = (pixel & 0x0000ff00) >> 8;
                    int blue = pixel & 0x000000ff;
                    int alpha = (pixel & 0xff000000) >> 24;
                    imagePixels[y][x] = red;
                }
            }

            return imagePixels;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            return null;
        }

    }
    
    public static void table3(int arr[][], Vector<qua> tab, int c, int r, int Codebook, qua a5) {
        qua a = new qua();
        Vector<qua> tab1 = new Vector<qua>();
        a.fill_groubs(arr, c, r);
        a.get_av();
        qua a1 = new qua();
        qua a0 = new qua();

        tab.add(a);
        //a = new qua();
        while (tab.size() < Codebook) {
            for (int j = 0; j < tab.size(); j++) {

                tab.get(j).split(a0, a1);
                tab1.add(a0);
                tab1.add(a1);
                a0 = new qua();
                a1 = new qua();
            }
          

            a.nearest2(tab1);
            tab.removeAllElements();
            // tab= new Vector<qua>();

            tab.addAll(tab1);
            tab1.removeAllElements();
            //     tab1 = new Vector<qua>();

        }
    }

    public static void improve(int arr[][], Vector<qua> tab, int c, int r) {
        qua a = new qua();
        a.fill_groubs(arr, c, r);
        a.get_av();
        for (int i = 0; i < 5; i++) {
            remove_groubs(tab);
            a.nearest2(tab);
        }
    }

    public static void compress(Vector<Integer> in, qua a, Vector<qua> tab) {
        System.out.println("aaaaaaaaa" + tab.size());

        for (int i = 0; i < a.groubs.size(); i++) {
            for (int j = 0; j < tab.size(); j++) {

                int d = tab.get(j).check_gr(a.groubs.get(i));
                if (d == 1) {

                    in.add(tab.get(j).q);
                }
            }
        }
    }

    public static void decompress(Vector<Integer> in, qua a, Vector<qua> tab) {

        for (int i = 0; i < in.size(); i++) {
            for (int j = 0; j < tab.size(); j++) {
                int d = tab.get(j).q;
                if (d == in.get(i)) {
                    a.groubs.add(tab.get(j).head);
                }
            }
        }
    }

    public static void insert_q(Vector<qua> tab) {
        for (int i = 0; i < tab.size(); i++) {
            tab.get(i).q = i;
        }
    }

    public static void remove_groubs(Vector<qua> tab) {
        for (int i = 0; i < tab.size(); i++) {
            tab.get(i).groubs.removeAllElements();
        }
    }

    public static int[][] D_to_I(Double[][] arr1) {
        int[][] arr = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                double x;
                if (arr1[i][j] != null) {
                    x = (arr1[i][j]);
                    arr[i][j] = (int) x;
                }

            }
        }
        return arr;
    }

    
}
