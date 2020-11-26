package src;
 
import java.io.*;
import javax.swing.JOptionPane;
 
public class Main {
  public static void main (String arg []) throws IOException {
      int opc = 0;
      int b;
     // INSTANCIA DA CLASSE ABSTRATA ALUNO
      AbstrataAlunos[] aluno = new AbstrataAlunos[3];
        for (b = 0 ; b < 3 ; b++) {
          aluno [b] = new AbstrataAlunos();
        } 
      
      // INSTANCIA DA CLASSE ABSTRATA LIVRO
      AbstrataLivros [] livro = new AbstrataLivros[3];
        for (b = 0 ; b < 3 ; b++) {
          livro [b] = new AbstrataLivros();
        } 

      // INSTANCIA DA CLASSE ABSTRATA REGISTRO
      AbstrataRegistro [] registro = new AbstrataRegistro[3];
        for (b = 0 ; b < 3 ; b++) {
          registro [b] = new AbstrataRegistro();
        }
 
 
    do {
      opc = Integer.parseInt(JOptionPane.showInputDialog
                ("\n ** Controle de Livros **  \n1 - Fazer Cadastro ou Registro  \n2 - Fazer Consultas \n9 - Finaliza"));
      switch (opc) {
        case 1: CADASTRAR(aluno, registro, livro);  // Buscando o menu Cadastrar 
              break;
        case 2: CONSULTAR(aluno, registro, livro);  // Buscando o menu Consultar
             break;
        case 9: JOptionPane.showMessageDialog(null,"Programa finalizado");
          //Finaliza o Programa
        break;
 
        default: JOptionPane.showMessageDialog(null,"Opção inválida");
      } 
    } while (opc!=9);
  }
 
  // MENU CADASTRAR
  static void CADASTRAR (AbstrataAlunos [] aluno, AbstrataRegistro [] registro, AbstrataLivros [] livro) throws IOException {
    ClasseCadastrar Cadastra = new ClasseCadastrar();
    
    
    
    int menuCadastrar = 0;
 
    do {
      menuCadastrar = Integer.parseInt(JOptionPane.showInputDialog
                ("\n ** Cadastrar ou Registrar **  \n1 - Cadastrar Livros  \n2 - Cadastrar Alunos \n3 - Registrar Empréstimos \n9 - Voltar"));
 
      switch (menuCadastrar) {
        case 1: livro = Cadastra.CadastrarLivro(livro);  // Chamando a função cadastrar Livro 
              break;
        case 2: aluno = Cadastra.CadastrarAluno(aluno);  // Chamando a função cadastrar Aluno
             break;
        case 3: registro = Cadastra.RegistrarEmprestimo(registro, aluno,livro);  // Chamando a função Registrar Empréstimo
             break;
        case 9: JOptionPane.showMessageDialog(null,"Voltando ao menu anterior");
          //Finaliza o Programa
        break;
 
        default: JOptionPane.showMessageDialog(null,"Opção inválida");
      } 
    } while (menuCadastrar!=9);
  }
 
 
  // MENU CONSULTAR
  static void CONSULTAR ( AbstrataAlunos [] aluno, AbstrataRegistro [] registro, AbstrataLivros [] livro ) throws IOException {
    ClasseConsultar Consulta = new ClasseConsultar();   
    
    int menuConsultar = 0;
 
    do {
      menuConsultar = Integer.parseInt(JOptionPane.showInputDialog
                ("\n ** Consultar **  \n1 - Consulta de Livros  \n2 - Consulta de Empréstimo  \n3 - Relatório de tempo de atraso \n4 - Relatório de valor de multa   \n9 - Voltar"));
 
      switch (menuConsultar) {
        case 1: Consulta.ConsultarLivro(livro);  // Chamando a consulta de livro 
              break;
        case 2: Consulta.ConsultarEmprestimo(aluno, registro, livro);  // Chamando a consulta de empréstimo
             break;
        case 3: Consulta.RelatorioAtraso(registro);  // Chamando o relatório de atraso
             break;
        case 4: Consulta.RelatorioMulta(registro);  // Chamando o relatório de multa
             break;
        case 9: JOptionPane.showMessageDialog(null,"Voltando ao menu anterior");
          //Finaliza o Programa
        break;
 
        default: JOptionPane.showMessageDialog(null,"Opção inválida");
      } 
    } while (menuConsultar!=9);
  }
}