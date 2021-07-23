package com.yk.steeringwheel;

import java.util.ArrayList;

/**
 * @Description:
 * @author: liuzhixiang
 * @date: 2021/3/25
 * @mail: liuzhixiang@em-data.com.cn
 */
public class ReloadPerform {
    public static int i_s_on=1;
    private static int i_s_off=2;

    public static String s_s_on="aaaaa";
    private static String s_s_off="bbbbbb";

    public int i_on=3;
    private int i_off=4;

    public  String s_on="sfsdf";
    private  String s_off="erterte";

    public int getI_off() {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).run();
        return i_off;
    }

    public static int _getI_off() {

        return i_s_off;

    }

    public class Me{

        private  int ME_i_on=3;
        private int ME_i_off=4;

        public  String ME_s_on="sfsdf";
        private  String ME_s_off="erterte";

        public int pva(){
            return 2+ME_i_off;
        }
        private int _pva(){
            return 1+i_on;
        }

    }

    public static class Te{

        private int me_id_off_te=546456;

        public String me_id_on_asda="liuzhix";

        public static int TE_I_S_ON=1;
        private static int TE_I_S_OFF=2;

        public static String TE_S_S_ON="aaaaa";
        private static String TE_S_S_OFF="bbbbbb";

        public static int psi(){

            return TE_I_S_OFF+1000;
        }
        private static int _psi(){

            return TE_I_S_OFF+1000;
        }
    }

    public static class Ti{
        private int[] sa={1,2,3,4,56,7};
        private ArrayList<String> namelsit;

        public static int TI_I_S_ON=1;

        private static String TOI_S_S_OFF="bbbbbb";

        public static int psiTi(){

            return TI_I_S_ON+1000;
        }
        private static int _psi(){

            return TI_I_S_ON+1000;
        }
    }

    interface OnMyinterface{
        int maxdaxiao();
    }

    abstract class Oeaclass{
        public int c=1000;
        abstract void osfsdf();
    }

}
