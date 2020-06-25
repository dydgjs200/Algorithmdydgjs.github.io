import java.util.Random;

public class Main {
    public static int[] Random_temperature() {
        Random r = new Random();
        int[] arr = new int[10];
        for(int i=0; i<10; i++) {
            arr[i] = r.nextInt(13)+12;
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();

        return arr;
    }

    public static double Output_Rice_function(int x) {
        double Total_Rice_Output = 50*x*x + 0.3*x + 100;
        return Total_Rice_Output;
    }

    public static int[] Genetic_selections(int[] index) {
        int sum = 0;
        int[] Random_Rice = new int[index.length];
        for(int i=0; i<index.length; i++) {
            Random_Rice[i] = (int) (index[i]);
            sum += Random_Rice[i];
        }

        double[] ratio = new double[index.length];
        for(int i=0; i<index.length; i++) {
            if(i==0) ratio[i] = (double)Random_Rice[i] / (double)sum;
            else ratio[i] = ratio[i-1] + (double)Random_Rice[i] / (double)sum;
        }

        int[] transform = new int[index.length];
        Random r = new Random();
        for(int i=0; i<index.length; i++) {
            double p = r.nextDouble();
            if(p < ratio[0]) transform[i] = index[0];
            else if(p < ratio[1]) transform[i] = index[1];
            else if(p < ratio[2]) transform[i] = index[2];
            else transform[i] = index[3];
        }

        return transform;
    }

    public static String int2String(String x) {
        return String.format("%8s", x).replace(' ', '0');
    }

    public static String[] Genetics_cro(int[] x) {
        String[] arr = new String[x.length];
        for(int i=0; i<x.length; i+=2) {
            String bit1 = int2String(Integer.toBinaryString(x[i]));
            String bit2 = int2String(Integer.toBinaryString(x[i+1]));

            arr[i] = bit1.substring(0, 2) + bit2.substring(2, 5);
            arr[i+1] = bit2.substring(0, 2) + bit1.substring(2, 5);
        }

        return arr;
    }

    public static int Reverse_Genetics(String x) {
        Random r = new Random();
        int gene = Integer.parseInt(x, 2);
        for(int i=0; i<x.length(); i++) {
            double p = (double)1/ (double)32;
            if(r.nextDouble() < p) {
                gene = 1 << i ^ gene;
            }
        }
        return gene;
    }

    public static int[] Genetics_mutation(String[] x) {
        int[] arr = new int[x.length];
        for (int i=0; i<x.length; i++)
            arr[i] = Reverse_Genetics(x[i]);
        return arr;
    }



    public static void main(String[] args) {
        int[] arr_tem = Random_temperature();
        for(int i=0; i<1000; i++) {        //진화횟수 설정
            int[] gene_select = Genetic_selections(arr_tem);
            String[] cross = Genetics_cro(gene_select);
            int[] gene_mut = Genetics_mutation(cross);

            double[] f = new double[gene_mut.length];
            double Genetics_MAX_VALUE = 0;
            for(int j = 0; j <gene_mut.length; j++) {
                Genetics_MAX_VALUE = Math.max(Genetics_MAX_VALUE, Output_Rice_function(gene_mut[j]));
                System.out.printf("%f ", Output_Rice_function(gene_mut[j]));
            }
            System.out.println();

            System.out.println(Genetics_MAX_VALUE);
        }
    }
}