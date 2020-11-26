package src;

class AbstrataLivros {
    
    int IdLivro;
    String Titulo;
    int ISBN;   
        
    AbstrataLivros() {
        this ( 0, "", 0 );
    }

    AbstrataLivros(int CIdLivro, String CTitulo, int CISBN) {
        
        IdLivro = CIdLivro;
        Titulo = CTitulo;
        ISBN = CISBN;
    }
}
