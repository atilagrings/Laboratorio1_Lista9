public class Turma{
    private Aluno[] alu;
    private int qtdAlunos;
    
    public Turma(int nMaximoAlunos){ 
            alu = new Aluno[nMaximoAlunos];
    }
    
    public void cadastraUmAluno(Aluno aluno){//recebe todos os dados de apenas um aluno e instancia e cadastra este aluno
        int posicao = 0;
        boolean liberada = true;
        for (int i = 0;i<alu.length && (liberada == true);i++){
            if (!(alu[i] != null)) {
                liberada = false;
                posicao = i;}}
        alu[posicao] = aluno;
        qtdAlunos++;
    }
    
    public void exibeAlunos(){//exibe, na tela , os dados de todos os alunos cadastrados
        System.out.printf("%-20s%-10s%-13s%-10s","Nome do Aluno","NotaGrauA","NotaGrauB","MediaFinal");
        int tamanho = 0;
        for (int i=0;i<alu.length;i++){
            if (alu[i]!=null){ 
               System.out.printf("\n%-20s%-10s%-13s%-10s",alu[i].getNome(),alu[i].getNotaGa(),alu[i].getNotaGb(),alu[i].getMediaFinal());
            }}
    }
    
    public double calculaMediaTurma(){//retorna a média aritmética da turma
        int contador = 0;
        int soma = 0;
        for (int i=0;i<alu.length;i++){
            if(alu[i]!=null){
                contador++;
                soma+=alu[i].getMediaFinal();}}
        return (double)soma/contador;
    }
    
    public double calculaPercentualAprovados(){//retorna o percentual de alunos aprovados
        int contador = 0;
        int aprovados = 0;
        for (int i=0;i<alu.length;i++){
            if(alu[i]!=null){
                contador++;
                if(alu[i].getMediaFinal()>=6) aprovados++;}}
        return ((double)aprovados/contador)*100;
    }
    
    public void classificaOrdemAlfabetica(){//classifica os alunos cadastrados em ordem alfabética
        int limite = alu.length;
        Aluno temporario = null;
        for(int i=0;i<limite-1;i++){
            if (alu[i]==null && alu[i+1]!=null){
                temporario = alu[i+1];
                alu[i]=temporario;
                alu[i+1]=null;}}
        temporario = null;
        for(int x=0;x<limite;x++){
         for (int i=0; i<limite-1; i++){
              if (alu[i]!= null && alu[i+1]!=null){
                  if (alu[i].getNome().compareToIgnoreCase(alu[i+1].getNome())>0){
                      temporario = alu[i];
                      alu[i]=alu[i+1];
                      alu[i+1]=temporario;
                  }}}}
    }
    
    public void classificaOrdemMediaFinal(){//classifica os alunos cadastrados em decrescente de média final
        int limite = alu.length;
        Aluno temporario = null;
        for(int i=0;i<limite-1;i++){
            if (alu[i]==null && alu[i+1]!=null){
                temporario = alu[i+1];
                alu[i]=temporario;
                alu[i+1]=null;}}
        temporario = null;
        for(int x=0;x<limite;x++){
         for (int i=0; i<limite-1; i++){
              if (alu[i]!= null && alu[i+1]!=null){
                  if (alu[i].getMediaFinal()<alu[i+1].getMediaFinal()){
                      temporario = alu[i];
                      alu[i]=alu[i+1];
                      alu[i+1]=temporario;
                  }}}}
    }
    
    public Aluno[] getTodosAlunos(){//retorna o array de alunos
        return alu;
    }

    public int getQuantosAlunos(){//retorna o tamanho lógico do array de alunos
        return qtdAlunos;
    }

    public Aluno getUmAluno(int indice){//retorna o aluno armazenado no índice especificado. Se índice inválido,retorna o último aluno cadastrado
        if(indice<qtdAlunos && indice >=0 ) 
        return alu[indice];
        else return   getUmAluno();
    }

    public Aluno getUmAluno(){//retorna o último aluno cadastrado. Se não há alunos cadastrados, retorna null
        if(qtdAlunos>= 1) 
        return alu[qtdAlunos-1];
        else return   null;
    }
}
