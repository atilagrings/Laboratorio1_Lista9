public class Vendedor{
    private String nome;
    private static String meses[]={null,"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
    private double mes[] = new double[13];
    
    public Vendedor(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
   
    public void vende (int mes,double valor){
        if (mes>0 && mes<=12) this.mes[mes] += valor;
    }
    
    public double totalizaVendasAno(){
        double total=0;
        for (int i=1;i<=12;i++){
            total+=mes[i];}
        return total;
    }
    
    public String resumeVendasAno(){
        String resultado="\fVendas do ano do Vendedor "+getNome()+String.format("%1$-13s %2$-15s","\n\nMês","Total vendido R$\n");
        for (int i=1;i<=12;i++){
          resultado += String.format("%1$-13s %2$15s","\n"+meses[i],mes[i]);}
        resultado+= String.format("%1$-10s %2$15s","\n\nTotal do ano","R$ "+totalizaVendasAno());
        return resultado;
    }
    
    public void teste(){
       System.out.println(resumeVendasAno());
    }
}
   