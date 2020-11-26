package src;

import java.io.*;
import javax.swing.*;

public class ClasseCadastrar {
        // Função cadastrar Livro
    public AbstrataLivros[] CadastrarLivro( AbstrataLivros[] livro ) throws IOException {
        int i = 0;
        int id = 1;
        
        String fileName = "ArquivoLivros.txt";	
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));

        for (i = 0 ; i < livro.length ; i++) { 
            livro[i] = new AbstrataLivros();  
        }
    
        System.out.println("\n *** LISTA DE LIVROS *** ");

        for (i = 0 ; i < livro.length; i++) {
                // Criando o Id
            livro[i].IdLivro = id++; 
               gravar.write(Integer.toString( livro[i].IdLivro )); 
                    gravar.newLine();
                // Recebendp o nome do livro
            livro[i].Titulo = JOptionPane.showInputDialog("Digite o nome do livro:");
              gravar.write( livro[i].Titulo ); 
                gravar.newLine();
                //Recebendo o codigo internacional do livro
            
            livro[i].ISBN = Integer.parseInt(JOptionPane.showInputDialog("Digite o ISBN do livro:")); // 
            // Colocar aqui
                gravar.write(Integer.toString( livro[i].ISBN )); 
                 gravar.newLine();
                // Mensagem de Sucesso
            JOptionPane.showMessageDialog(null,"Livro cadastrado com sucesso"); 
                //Lista de livros cadastrados
            System.out.println(" Id: " + livro[i].IdLivro + "\n Título: " + livro[i].Titulo + "\n ISBN: " + livro[i].ISBN);
        }       
        gravar.close();
        return livro;
    }

        // Função cadastrar Aluno
    public AbstrataAlunos[] CadastrarAluno( AbstrataAlunos[] aluno ) throws IOException {
        int i;  

        String fileName = "ArquivoAlunos.txt";	
        BufferedWriter gravar = new BufferedWriter(new FileWriter( fileName ));	
           
        for (i = 0 ; i < aluno.length ; i++) { 
            aluno[i] = new AbstrataAlunos();  
        }

        System.out.println("\n *** LISTA DE ALUNOS *** ");
        
        for (i = 0 ; i < aluno.length ; i++)  {	
                // Recebendo o nome do aluno
            aluno[i].Nome = JOptionPane.showInputDialog("Digite o nome do Aluno: "); 
                gravar.write( aluno[i].Nome ); 
                    gravar.newLine();	
                // Recebendo o RA do aluno
            aluno[i].RA = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA do Aluno :")); 
                gravar.write(Integer.toString( aluno[i].RA )); 
                    gravar.newLine();
            JOptionPane.showMessageDialog(null,"Aluno cadastrado com sucesso");// Mensagem de Sucesso
                //Lista de alunos cadastrados
            System.out.println(" Nome: " + aluno[i].Nome + "\n RA: " + aluno[i].RA);
        }
        gravar.close();
        return aluno;
    }

        // Função registrar empréstimo
    public AbstrataRegistro[] RegistrarEmprestimo( AbstrataRegistro[] registro, AbstrataAlunos[] aluno, AbstrataLivros [] livro ) throws IOException {      
        ClasseRegistra Registra = new ClasseRegistra();
        int i, opc = 0;  

        for (i = 0 ; i < registro.length ; i ++) { 
            registro[i] = new AbstrataRegistro();  
        }

        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog
                      ("\n ** Controle de Livros **  \n1 - Registrar Retirada  \n2 - Registrar Entrega \n9 - Voltar ao menu anterior"));
            switch (opc) {
              case 1: registro = Registra.Retirar(registro, aluno, livro); // Buscando o menu Cadastrar
                    break;
              case 2: registro = Registra.Entregar(registro, aluno, livro); // Buscando o menu Consultar
                   break;
              case 9: JOptionPane.showMessageDialog(null,"Voltando ao menu anterior");
                //Finaliza o Programa
              break;
       
              default: JOptionPane.showMessageDialog(null,"Opção inválida");
            } 
          } while (opc!=9);

        return registro;
    }
}