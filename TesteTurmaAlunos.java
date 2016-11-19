public class TesteTurmaAlunos{
    static Teclado t = new Teclado();
    
    private static char resposta(String msg){
        char resp;
        do
            resp= Character.toUpperCase(t.leChar(msg+"[S-sim N-não] ? "));
        while (resp != 'S'&& resp != 'N');
        return resp;
    }//fim do método resposta
    
    public static void main(String args[]){
        Turma T1 = new Turma(t.leInt("\fDigite o número máximo de alunos para esta turma"));
        
        while (resposta("Quer cadastrar aluno")== 'S') {
            String nome = t.leString("Nome do Aluno:");
            double notaA = t.leDouble("Nota do GrauA:");
            double notaB = t.leDouble("Nota do GrauB:");
            
            T1.cadastraUmAluno(new Aluno(nome,notaA,notaB));
            int posicao = T1.getQuantosAlunos()-1;
            if (resposta("substituiu grau A")=='S')
                T1.getTodosAlunos()[posicao].substituiGrau('a',t.leDouble("Digite a nota do GrauC:"));
            else if (resposta("substituiu grau B")=='S')
                T1.getTodosAlunos()[posicao].substituiGrau('b',t.leDouble("Digite a nota do GrauC:"));
                double media = T1.getTodosAlunos()[posicao].getMediaFinal();
                System.out.println("A média do aluno ficou: "+media);
                if (media>=6) System.out.println("Aluno Aprovado! Parabéns!");
                else System.out.println("Aluno reprovado.");
        }//fim do while
        
        T1.exibeAlunos();
        System.out.println("\nO percentual de aprovação da turma é de: "+T1.calculaPercentualAprovados());
        T1.classificaOrdemMediaFinal();
        System.out.println("\n");
        T1.exibeAlunos();
    }//fim do método main
}//fim da classe