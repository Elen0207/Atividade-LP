package src;

class AbstrataAlunos {
    String Nome; // nome do aluno
    int RA; // número do registro do aluno
    
    // Método Construtor
    AbstrataAlunos() {
        this("", 0);
    }

    // Método Procedimento
    AbstrataAlunos(String INome, int IRA) {
        
        // criação dos intermediários adicionando a letra I no começo
        Nome = INome;
        RA = IRA;
    }  
}