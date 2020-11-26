package src;

import java.io.*;
import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

 
public class ClasseConsultar {
    
      //  1 - Quantidade de livros na biblioteca
    public void ConsultarLivro ( AbstrataLivros [] livro ) throws IOException {
        int i, ConsultaIsbn, QtdeLivro = 0;    
 
        String fileName = "ArquivoLivros.txt";  
        BufferedReader ler = new BufferedReader(new FileReader( fileName ));    
        
        for (i = 0 ; i < livro.length ; i++) {
            livro[i] = new AbstrataLivros(); 
        }
 
        for (i = 0 ; i < livro.length ; i++) {      
            livro[i].IdLivro = Integer.parseInt(ler.readLine());    
            livro[i].Titulo = ler.readLine();   
            livro[i].ISBN = Integer.parseInt(ler.readLine());  
        }
        
        ConsultaIsbn = Integer.parseInt(JOptionPane.showInputDialog("Digite o ISBN do livro:"));
        
        System.out.println("\n *** Lista de quantidade de livros na biblioteca *** ");
 
        for ( i = 0 ; i < livro.length ; i++ ) { 
            if (ConsultaIsbn == livro[i].ISBN) {
                System.out.println("Número do Livro: " + livro[i].IdLivro + " | Nome do Livro: " + livro[i].Titulo);
                QtdeLivro ++;
            }
        }
            // Validacao para confirmar se o livro existe
        if (QtdeLivro == 0){
            JOptionPane.showMessageDialog(null, "Livro não localizado");
        }
        
        System.out.println("Total: " + QtdeLivro);     
    }
 
   		// 2 - Quantidade de livros na emprestados
	public void ConsultarEmprestimo ( AbstrataAlunos [] aluno, AbstrataRegistro [] registro, AbstrataLivros [] livro ) throws IOException {

		int i, cont = 0;  
		
			// Recuperar o arquivo livros
		String fileName = "ArquivoLivros.txt";  
		BufferedReader ler = new BufferedReader(new FileReader( fileName ));    
			
		for (i = 0 ; i < livro.length ; i++) {
			livro[i] = new AbstrataLivros(); 
		}
		
		for (i = 0 ; i < livro.length ; i++) {      
			livro[i].IdLivro = Integer.parseInt(ler.readLine());    
			livro[i].Titulo = ler.readLine();   
			livro[i].ISBN = Integer.parseInt(ler.readLine());  
		}
		   

			 // Recuperar o arquivo alunos
		String fileNameA = "ArquivoAlunos.txt";  
		BufferedReader lerA = new BufferedReader(new FileReader( fileNameA ));    
		
		for (i = 0 ; i < aluno.length ; i++) {
			aluno[i] = new AbstrataAlunos(); 
		}
		
		for (i = 0 ; i < aluno.length ; i++) {      
			aluno[i].Nome = lerA.readLine();    
			aluno[i].RA = Integer.parseInt(lerA.readLine());  
		}

			// Recuperacao da Entrega
		String fileNameD = "ArquivoRegistroEntrega.txt";
		BufferedReader lerD = new BufferedReader(new FileReader( fileNameD ));
		
			// Recuperacao da Retirada
		String fileNameR = "ArquivoRegistroRetirada.txt";
		BufferedReader lerR = new BufferedReader(new FileReader( fileNameR ));   
			
		for (i = 0 ; i < registro.length ; i++) {
			registro[i] = new AbstrataRegistro(); 
		}
		

		for (i = 0 ; i < registro.length ; i++) {   

			registro[i].RetiradaDia = Integer.parseInt(lerD.readLine());
			registro[i].RetiradaMes = Integer.parseInt(lerD.readLine());  
			registro[i].RetiradaAno = Integer.parseInt(lerD.readLine());  

			registro[i].DevolucaoDia = Integer.parseInt(lerD.readLine()); 
			registro[i].DevolucaoMes = Integer.parseInt(lerD.readLine()); 
			registro[i].DevolucaoAno = Integer.parseInt(lerD.readLine()); 

			registro[i].EntregaDia = Integer.parseInt(lerD.readLine());
			registro[i].EntregaMes = Integer.parseInt(lerD.readLine());  
			registro[i].EntregaAno = Integer.parseInt(lerD.readLine());  
			
			registro[i].IdLivroRegistroEntrega = Integer.parseInt(lerD.readLine());   
			registro[i].RAregistroEntrega = Integer.parseInt(lerD.readLine());  
			registro[i].statusEntrega = (lerD.readLine()); 


			registro[i].RetiradaDia = Integer.parseInt(lerR.readLine());
			registro[i].RetiradaMes = Integer.parseInt(lerR.readLine());  
			registro[i].RetiradaAno = Integer.parseInt(lerR.readLine());  
			
			registro[i].DevolucaoDia = Integer.parseInt(lerR.readLine()); 
			registro[i].DevolucaoMes = Integer.parseInt(lerR.readLine()); 
			registro[i].DevolucaoAno = Integer.parseInt(lerR.readLine()); 

			registro[i].IdLivroRegistroRetirada = Integer.parseInt(lerR.readLine());   
			registro[i].RAregistroRetirada = Integer.parseInt(lerR.readLine());  
			registro[i].statusRetirada = (lerR.readLine()); 
		}

		System.out.println("\n *** Lista de quantidade de livros emprestados *** ");
						
		for ( int a = 0 ; a < registro.length ; a ++ ) {           
				// Validacao para confirmar se o livro está na lista de Retirada
			for (int l = 0 ; l < registro.length ; l ++ ) {					
				if ( registro[a].IdLivroRegistroRetirada != registro[l].IdLivroRegistroEntrega ) {			
					cont ++ ;	
				} 
			}

			if (cont < 3 ) {
				// Validacao para confirmar se o aluno existe
					for ( int j = 0 ; j < aluno.length ; j ++ ) {
						if ( aluno[j].RA == registro[a].RAregistroRetirada ) {
							System.out.println( "Número do Livro: " + livro[a].IdLivro + " | Status: " + registro[a].statusRetirada +" | Aluno: " + aluno[j].Nome ); 
						} 
					}	

					cont = 0;
			} 
			else {
					// Mensagem de resposta
				System.out.println( "Número do Livro: " + livro[a].IdLivro + " | Status: " + registro[a].statusEntrega ); 	

				cont = 0;
			}		
		}
	}
	
		//  3 - Quantidade de livros em atraso de devolucao 
	public void RelatorioAtraso ( AbstrataRegistro [] registro ) throws IOException {
		int i;
			// Recuperacao da Entrega
		String fileNameD = "ArquivoRegistroEntrega.txt";
		BufferedReader lerD = new BufferedReader(new FileReader( fileNameD ));
		
			// Recuperacao da Retirada
		String fileNameR = "ArquivoRegistroRetirada.txt";
		BufferedReader lerR = new BufferedReader(new FileReader( fileNameR ));   
			
		for (i = 0 ; i < registro.length ; i++) {
			registro[i] = new AbstrataRegistro(); 
		}
		
		for (i = 0 ; i < registro.length ; i++) {   

			registro[i].RetiradaDia = Integer.parseInt(lerD.readLine());
			registro[i].RetiradaMes = Integer.parseInt(lerD.readLine());  
			registro[i].RetiradaAno = Integer.parseInt(lerD.readLine());  

			registro[i].DevolucaoDia = Integer.parseInt(lerD.readLine()); 
			registro[i].DevolucaoMes = Integer.parseInt(lerD.readLine()); 
			registro[i].DevolucaoAno = Integer.parseInt(lerD.readLine()); 

			registro[i].EntregaDia = Integer.parseInt(lerD.readLine());
			registro[i].EntregaMes = Integer.parseInt(lerD.readLine());  
			registro[i].EntregaAno = Integer.parseInt(lerD.readLine());  
			
			registro[i].IdLivroRegistroEntrega = Integer.parseInt(lerD.readLine());   
			registro[i].RAregistroEntrega = Integer.parseInt(lerD.readLine());  
			registro[i].statusEntrega = (lerD.readLine()); 


			registro[i].RetiradaDia = Integer.parseInt(lerR.readLine());
			registro[i].RetiradaMes = Integer.parseInt(lerR.readLine());  
			registro[i].RetiradaAno = Integer.parseInt(lerR.readLine());  
			
			registro[i].DevolucaoDia = Integer.parseInt(lerR.readLine()); 
			registro[i].DevolucaoMes = Integer.parseInt(lerR.readLine()); 
			registro[i].DevolucaoAno = Integer.parseInt(lerR.readLine()); 

			registro[i].IdLivroRegistroRetirada = Integer.parseInt(lerR.readLine());   
			registro[i].RAregistroRetirada = Integer.parseInt(lerR.readLine());  
			registro[i].statusRetirada = (lerR.readLine()); 
		}
		

		String diaR[] = new String[3];
		String diaE[] = new String[3];
		
		String mesR[] = new String[3];
		String mesE[] = new String[3];
		
		String anoR[] = new String[3];
		String anoE[] = new String[3];
		
		String dataDevolucao[] = new String[3];
		String dataEmprestimo [] = new String[3];            
        
		System.out.println("\n *** Lista de quem entregou atrasado *** ");
		
	  	for (i = 0 ; i < registro.length ; i++) {    	
			diaR[i]= (Integer.toString(registro[i].RetiradaDia));
			mesR[i]= (Integer.toString(registro[i].RetiradaMes));      	
			anoR[i]= (Integer.toString(registro[i].RetiradaAno));
				
			diaE[i]= (Integer.toString(registro[i].EntregaDia));
			mesE[i]= (Integer.toString(registro[i].EntregaMes));       	
			anoE[i]= (Integer.toString(registro[i].EntregaAno));       	

			dataEmprestimo[i] = anoR[i]+"-"+mesR[i]+"-"+diaR[i];
			dataDevolucao[i] = anoE[i]+"-"+mesE[i]+"-"+diaE[i];

				//Convertendo para data
			LocalDate dataE = LocalDate.parse(dataEmprestimo[i]);
			LocalDate dataD = LocalDate.parse(dataDevolucao[i]);
			
				//Calculando o número de dias
			long numDias= ChronoUnit.DAYS.between(dataE , dataD);
									
			if (numDias <= 15) {
				System.out.println("O Livro: " + registro[i].IdLivroRegistroRetirada + " não está em atraso.  Hoje completa "+ numDias +" dias de empréstimo");
			}
			else {
				System.out.println("O Livro: " + registro[i].IdLivroRegistroRetirada + " está atrasado em: " + (numDias - 15) + " dias");
			}
		}
	}

		//  4 - Quantidade e valor das multas por atraso
	public void RelatorioMulta ( AbstrataRegistro [] registro ) throws IOException {
		int i;
					// Recuperacao da Entrega
		String fileNameD = "ArquivoRegistroEntrega.txt";
		BufferedReader lerD = new BufferedReader(new FileReader( fileNameD ));
		
			// Recuperacao da Retirada
		String fileNameR = "ArquivoRegistroRetirada.txt";
		BufferedReader lerR = new BufferedReader(new FileReader( fileNameR ));   
			
		for (i = 0 ; i < registro.length ; i++) {
			registro[i] = new AbstrataRegistro(); 
		}
		
		for (i = 0 ; i < registro.length ; i++) {   

			registro[i].RetiradaDia = Integer.parseInt(lerD.readLine());
			registro[i].RetiradaMes = Integer.parseInt(lerD.readLine());  
			registro[i].RetiradaAno = Integer.parseInt(lerD.readLine());  

			registro[i].DevolucaoDia = Integer.parseInt(lerD.readLine()); 
			registro[i].DevolucaoMes = Integer.parseInt(lerD.readLine()); 
			registro[i].DevolucaoAno = Integer.parseInt(lerD.readLine()); 

			registro[i].EntregaDia = Integer.parseInt(lerD.readLine());
			registro[i].EntregaMes = Integer.parseInt(lerD.readLine());  
			registro[i].EntregaAno = Integer.parseInt(lerD.readLine());  
			
			registro[i].IdLivroRegistroEntrega = Integer.parseInt(lerD.readLine());   
			registro[i].RAregistroEntrega = Integer.parseInt(lerD.readLine());  
			registro[i].statusEntrega = (lerD.readLine()); 


			registro[i].RetiradaDia = Integer.parseInt(lerR.readLine());
			registro[i].RetiradaMes = Integer.parseInt(lerR.readLine());  
			registro[i].RetiradaAno = Integer.parseInt(lerR.readLine());  
			
			registro[i].DevolucaoDia = Integer.parseInt(lerR.readLine()); 
			registro[i].DevolucaoMes = Integer.parseInt(lerR.readLine()); 
			registro[i].DevolucaoAno = Integer.parseInt(lerR.readLine()); 

			registro[i].IdLivroRegistroRetirada = Integer.parseInt(lerR.readLine());   
			registro[i].RAregistroRetirada = Integer.parseInt(lerR.readLine());  
			registro[i].statusRetirada = (lerR.readLine()); 
		}
		

		String diaR[] = new String[3];
		String diaE[] = new String[3];
		
		String mesR[] = new String[3];
		String mesE[] = new String[3];
		
		String anoR[] = new String[3];
		String anoE[] = new String[3];
		
		String dataDevolucao[] = new String[3];
		String dataEmprestimo [] = new String[3];            
		
		System.out.println("\n *** Lista de multas *** ");

		for (i = 0 ; i < registro.length ; i++) {    	
			diaR[i]= (Integer.toString(registro[i].RetiradaDia));
			mesR[i]= (Integer.toString(registro[i].RetiradaMes));      	
			anoR[i]= (Integer.toString(registro[i].RetiradaAno));
				
			diaE[i]= (Integer.toString(registro[i].EntregaDia));
			mesE[i]= (Integer.toString(registro[i].EntregaMes));       	
			anoE[i]= (Integer.toString(registro[i].EntregaAno));       	

			dataEmprestimo[i] = anoR[i]+"-"+mesR[i]+"-"+diaR[i];
			dataDevolucao[i] = anoE[i]+"-"+mesE[i]+"-"+diaE[i];

				//Convertendo para data
			LocalDate dataE = LocalDate.parse(dataEmprestimo[i]);
			LocalDate dataD = LocalDate.parse(dataDevolucao[i]);
			
				//Calculando o número de dias
			long numDias= ChronoUnit.DAYS.between(dataE , dataD);
									
			if (numDias > 15) {
			
				System.out.println("O Livro: " + registro[i].IdLivroRegistroRetirada + " está atrasado em: " + (numDias - 15) + " dias. Devendo a multa de: R$ "+ ((numDias - 15) * 0.5 ));
			}
		}
	}      
}