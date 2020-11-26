package src;

class AbstrataRegistro {  

    int IdLivroRegistroRetirada;
    int IdLivroRegistroEntrega;

    int RAregistroRetirada;
    int RAregistroEntrega;
           
    int RetiradaDia; // Dia da retirada
    int RetiradaMes; // Mes da retirada
    int RetiradaAno; // Ano da retirada

    int EntregaDia; // Dia que devolveu  
    int EntregaMes; // Mes que devolveu 
    int EntregaAno; // Ano que devolveu

    int DevolucaoDia;  // Dia que deverá devolver
    int DevolucaoMes;  // Mes que deverá devolver
    int DevolucaoAno;   // Ano que deverá devolver

    int multa;
    String statusRetirada;
    String statusEntrega;
    
    // Método Construtor
    AbstrataRegistro() {
        this( 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", "" );
    }

    // Método Procedimento
    AbstrataRegistro (int RIdLivroRegistro, int EIdLivroRegistro, int RRAregistro, int ERAregistro, int IRetiradaDia, int IRetiradaMes, int IRetiradaAno, int IEntregaDia,int IEntregaMes, int IEntregaAno, int IDevolucaoDia, int IDevolucaoMes, int IDevolucaoAno, int Cmulta, String Rstatus, String Estatus) {
        
        // criação dos intermediários adicionando a letra I no começo
        IdLivroRegistroRetirada = RIdLivroRegistro;
        IdLivroRegistroEntrega = EIdLivroRegistro;

        RAregistroRetirada = RRAregistro;
        RAregistroEntrega = ERAregistro;

        RetiradaDia = IRetiradaDia;
        RetiradaMes = IRetiradaMes;
        RetiradaAno = IRetiradaAno;

        EntregaDia = IEntregaDia;
        EntregaMes = IEntregaMes;
        EntregaAno = IEntregaAno;

        DevolucaoDia = IDevolucaoDia;
        DevolucaoMes = IDevolucaoMes;
        DevolucaoAno = IDevolucaoAno;

        multa = Cmulta;

        statusRetirada = Rstatus;
        statusEntrega = Estatus;
    }  
}