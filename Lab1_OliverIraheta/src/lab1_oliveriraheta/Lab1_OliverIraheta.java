package lab1_oliveriraheta;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class Lab1_OliverIraheta {

    public static Scanner rm = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean x = true;
        //try {
        while (x) {
            System.out.println("""
                                   ===============================
                                   1.- Torres de Han\u00f3i
                                   2.- Buscar Fecha
                                   3.- \u03c0 (pi)
                                   4.- Salir
                                   """);
            int opc = rm.nextInt();

            x = Switch(opc, x);
        }
        //} catch (Exception e) {
        //    System.out.println(">>> ERROR <<<<");
        //}
    }

    public static boolean Switch(int opc, boolean x) {
        switch (opc) {
            case 1 -> {
                System.out.print("Ingrese cantidad de discos: ");
                rm = new Scanner(System.in);
                int n = rm.nextInt();
                hanoi(n, 1, 2, 3);
            }
            case 2 -> {
                fecha();
            }

            case 3 -> {
                pi();
            }
            case 4 -> {
                x = false;
            }

            default ->
                System.out.println("Opcion no Valida");

        }
        return x;
    }

    public static void hanoi(int n, int ori, int aux, int dest) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + ori + " a " + dest);
        } else {
            hanoi(n - 1, ori, dest, aux);
            System.out.println("Mover disco " + n + " de " + ori + " a " + dest);
            hanoi(n - 1, aux, ori, dest);
        }
    }

    public static void fecha() {

        System.out.print("Ingrese cadena: ");
        rm = new Scanner(System.in);
        String cadena = rm.nextLine();
        String datos[] = cadena.split(",");

        for (int i = 0; i < datos.length; i++) {
            Date Fecha = new Date();

            if (ValidarLetras(datos[i])) {
                
                if (datos[i].length() == 10 && datos[i].contains("/")) {
                    
                    String fecha[] = datos[i].split("/");
                    
                    if (fecha[0].length() == 2 && fecha[1].length()==2 && fecha[2].length()==4) {
                        
                        int dia = Integer.parseInt(fecha[0]);
                        int mes = Integer.parseInt(fecha[1])-1;
                        int anio = Integer.parseInt(fecha[2]);

                        
                        if (validadFecha(dia, mes, anio)==false) {
                            
                            Calendar c =new GregorianCalendar(anio, mes, dia);
                            Fecha = c.getTime();
                            System.out.println(Fecha);
                        }
                    }
                }

            }
        }
    }

    public static boolean validadFecha(int dia, int mes, int anio) {
        boolean validoFecha = false;

        if (dia < 1 || dia > 31) {
            validoFecha = true;
        }

        if (mes < 1 || mes > 12) {
            validoFecha = true;
        }
        if(anio<0){
            validoFecha = true;
        }
        return validoFecha;
    }

    public static boolean ValidarLetras(String str) {
        boolean x = true;

        for (int j = 0; j < str.length(); j++) {
            char c = str.charAt(j);
            if (c > 'A' && c < 'Z' || c > 'a' && c < 'z') {
                x = false;
            }
        }
        return x;
    }

    public static void pi() {
        System.out.print("Ingrese limite: ");
        rm = new Scanner(System.in);
        int lim = rm.nextInt();
        System.out.println("Total: "+ecua(lim,0,0));
    }
    public static double ecua(int lim,int n,double suma){
        
        if(n==lim){
            return 4*suma;
        }else{
            double tot= (Math.pow(-1, n))/((2*n)+1);
            suma+=tot;
            return ecua(lim,n+1,suma);
        }
    }

}
