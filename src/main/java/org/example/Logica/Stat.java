package org.example.Logica;

public class Stat {
    public int valor;
    public int modplus;
    public int modminus;
    public int maxi;
    public Stat (int val, int mplus, int max, int mminus){
        valor = val;
        modplus = mplus;
        maxi = max;
        modminus = mminus;
    }
    public int p(){
        return modplus;
    }
    public int m(){
        return maxi;
    }
    public void aumentarStat(){
        valor = Math.min(maxi,valor+modplus);
    }
    public void decrecer(){
        valor = Math.max(0,valor-modminus);
    }
    public int get(){
        return valor;
    }
    @Override
    public String toString(){
        return ("" + valor);
    }
}
