public class Urna{
    private int nUrna;
    private int[] contagemVotos;
    
    public Urna(int nUrna, int qtdCandidatos){
        this.nUrna = nUrna;
        contagemVotos = new int[qtdCandidatos+1];
    }
    
    public void recebeVoto(int candidato){
        if(candidato>=contagemVotos.length){contagemVotos[0]++;}
            else {contagemVotos[candidato]++;}
    }
    
    public void exibeResultado(){
        int totalVotos=0;
        for (int i=0;i<contagemVotos.length;i++){
            totalVotos+= contagemVotos[i];}
        System.out.println("\fResultado da eleição\n");
        System.out.printf("%-11s%7s","Candidato","Votos");
        for (int i=1; i<contagemVotos.length;i++){
            System.out.printf("\n%11s%7s",i,contagemVotos[i]);}
        System.out.printf("\n%11s%7s","Nulos:",contagemVotos[0]);
        System.out.printf("\n%11s%7s","TotalVotos:",totalVotos);
    }
}