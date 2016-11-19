public class Aluno{
    private String nome;
    private double notaGa;
    private double notaGb;
    private double mediaFinal;
    
    public Aluno(String nome){
        this.nome= nome;
    }
    
    public Aluno(String nome, double notaGa, double notaGb){
        this.nome=nome;
        setNotaGa(notaGa);
        setNotaGb(notaGb);
        calculaMediaFinal();
    }
    
    public void calculaMediaFinal(){
        mediaFinal = (notaGa+2*notaGb)/3;
    }
    
    public void setNotaGa(double notaGa){
        if(notaGa>=0 && notaGa <= 10.0) this.notaGa = notaGa; else notaGa = 0;
    }
    
    public void setNotaGb(double notaGb){
        if(notaGb>=0 && notaGb <= 10.0) this.notaGb = notaGb; else notaGb = 0;
    }
    
    public void substituiGrau(char grau,double nota){
        if (grau == 'A' || grau =='a') this.notaGa = nota;
        if (grau == 'B' || grau =='b') this.notaGb = nota;
        calculaMediaFinal();
    }
    
    public String getNome(){
        return nome;
    }
    
    public double getNotaGa(){
        return notaGa;
    }
    
    public double getNotaGb(){
        return notaGb;
    }
    
    public double getMediaFinal(){
        calculaMediaFinal();
        return mediaFinal;
    }
    
    }
    
    
