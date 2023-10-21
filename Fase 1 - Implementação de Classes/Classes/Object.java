package Classes;

//import java.util;

public class Object {
    private int codigoObjeto; // Autoincrement do banco de dados
    private float valorAluguel; 
    private int quantidadeExemplares = 0;
    private static int numeroCodigos = 0; //Valor futuramente extraido do banco para autoincrement

    public Object(String titulo, String nomeBanda, String estilo, float valorAluguel){
        setCodigoObjeto();// AutoIncrement do banco para codigoObjeto
        setValorAluguel(valorAluguel);
        adicionarExemplar();
    }
    
    public Object(){}


    public int getCodigoObjeto() { return this.codigoObjeto; }

    public void setCodigoObjeto(){
       this.codigoObjeto = numeroCodigos++;
    }


    public float getValorAluguel() { return valorAluguel; }

    public void setValorAluguel(float valorAluguel){
        this.valorAluguel = valorAluguel;
    }


    public int getQuantidadeExemplares() { return quantidadeExemplares; }

    public void adicionarExemplar(){
        this.quantidadeExemplares++;
    }
    public void adicionarExemplar(int quantidadeExemplares){
        this.quantidadeExemplares = quantidadeExemplares; // Podem haver 0 exemplares
    }

}
