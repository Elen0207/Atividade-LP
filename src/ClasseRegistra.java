package src;

import java.io.*;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class ClasseRegistra {
  
    public AbstrataRegistro[] Retirar ( AbstrataRegistro[] registro, AbstrataAlunos[] aluno, AbstrataLivros [] livro ) throws IOException {
        int i;
        
        String fileName = "ArquivoRegistroRetirada.txt";    
        BufferedWriter gravar = new BufferedWriter(new FileWriter( fileName ));   
 
        for (i = 0 ; i < registro.length ; i ++) { 
            registro[i] = new AbstrataRegistro();  
        }
 
        System.out.println("\n *** LISTA DE REGISTRO DE RETIRADA *** ");
 
        Calendar data = Calendar.getInstance();       
 
            for (i = 0 ; i < registro.length ; i ++)  { 
                    // Gerando o dia da retirada
                registro[i].RetiradaDia = data.get(Calendar.DAY_OF_MONTH); 
                    gravar.write(Integer.toString( registro[i].RetiradaDia )); 
                        gravar.newLine(); 
                    // Gerando o mes da retirada
                registro[i].RetiradaMes = data.get(Calendar.MONTH) + 1; 
                    gravar.write(Integer.toString( registro[i].RetiradaMes )); 
                        gravar.newLine(); 
                    // Gerando o ano da retirada
                registro[i].RetiradaAno = data.get(Calendar.YEAR);
                    gravar.write(Integer.toString( registro[i].RetiradaAno )); 
                        gravar.newLine(); 
                                       
    
                // >>> VALIDAÇÕES PARA CALCULAR A DATA DE DEVOLUÇÃO <<<
 
                // Validando Fevereiro se não é fevereiro, mas não precisa mudar de mês e ano
                if (registro[i].RetiradaDia <= 15 && registro[i].RetiradaMes != 2) {
                        // Calculando o dia de devolução
                    registro[i].DevolucaoDia = (registro[i].RetiradaDia + 15); 
                        gravar.write(Integer.toString( registro[i].DevolucaoDia )); 
                            gravar.newLine(); 
                        // Calculando o mês de devolução
                    registro[i].DevolucaoMes = registro[i].RetiradaMes; 
                        gravar.write(Integer.toString( registro[i].DevolucaoMes )); 
                            gravar.newLine(); 
                        // Calculando o ano de devolução
                    registro[i].DevolucaoAno = registro[i].RetiradaAno; 
                        gravar.write(Integer.toString( registro[i].DevolucaoAno )); 
                            gravar.newLine(); 
                        
                } else // Validando Fevereiro se é fevereiro, mas não precisa mudar de mês 
                if (registro[i].RetiradaDia <= 13 && registro[i].RetiradaMes == 2) {
                        // Calculando o dia de devolução
                    registro[i].DevolucaoDia = (registro[i].RetiradaDia + 15); 
                        gravar.write(Integer.toString( registro[i].DevolucaoDia )); 
                            gravar.newLine(); 
                        // Calculando o mês de devolução
                    registro[i].DevolucaoMes = registro[i].RetiradaMes; 
                        gravar.write(Integer.toString( registro[i].DevolucaoMes )); 
                                gravar.newLine(); 
                        // Calculando o ano de devolução
                    registro[i].DevolucaoAno = registro[i].RetiradaAno; 
                        gravar.write(Integer.toString( registro[i].DevolucaoAno )); 
                            gravar.newLine(); 
                            
                } else // Validando Fevereiro se é fevereiro, mas precisa mudar de mês
                if (registro[i].RetiradaDia > 13 && registro[i].RetiradaMes == 2) {
                        // Calculando o dia de devolução
                    registro[i].DevolucaoDia = ((registro[i].RetiradaDia + 15) - 28); 
                        gravar.write(Integer.toString( registro[i].DevolucaoDia )); 
                            gravar.newLine(); 
                        // Calculando o mês de devolução
                    registro[i].DevolucaoMes = registro[i].RetiradaMes + 1; 
                        gravar.write(Integer.toString( registro[i].DevolucaoMes )); 
                            gravar.newLine(); 
                        // Calculando o ano de devolução
                    registro[i].DevolucaoAno = registro[i].RetiradaAno; 
                        gravar.write(Integer.toString( registro[i].DevolucaoAno )); 
                            gravar.newLine(); 
 
                } else // Validando meses que tem 30 dias e precisa mudar de mês
                if (registro[i].RetiradaDia > 15 && registro[i].RetiradaMes == 4 || registro[i].RetiradaMes == 6
                        || registro[i].RetiradaMes == 9 || registro[i].RetiradaMes == 11) {
                        // Calculando o dia de devolução
                    registro[i].DevolucaoDia = ((registro[i].RetiradaDia + 15) - 30);
                        gravar.write(Integer.toString( registro[i].DevolucaoDia )); 
                            gravar.newLine(); 
                        // Calculando o mês de devolução
                    registro[i].DevolucaoMes = registro[i].RetiradaMes + 1; 
                        gravar.write(Integer.toString( registro[i].DevolucaoMes )); 
                            gravar.newLine(); 
                        // Calculando o ano de devolução
                    registro[i].DevolucaoAno = registro[i].RetiradaAno; 
                        gravar.write(Integer.toString( registro[i].DevolucaoAno )); 
                            gravar.newLine(); 
 
                } else // Validando se é dezembro para mudar o ano
                if (registro[i].RetiradaDia > 16 && registro[i].RetiradaMes == 12) {
                        // Calculando o dia de devolução
                    registro[i].DevolucaoDia = ((registro[i].RetiradaDia + 15) - 31); 
                        gravar.write(Integer.toString( registro[i].DevolucaoDia )); 
                            gravar.newLine(); 
                        // Calculando o mês de devolução
                    registro[i].DevolucaoMes = registro[i].RetiradaMes + 1; 
                        gravar.write(Integer.toString( registro[i].DevolucaoMes )); 
                            gravar.newLine(); 
                        // Calculando o ano de devolução
                    registro[i].DevolucaoAno = registro[i].RetiradaAno + 1; 
                        gravar.write(Integer.toString( registro[i].DevolucaoAno )); 
                            gravar.newLine(); 
                } else // Validando os demais meses para mudar de mes
                if (registro[i].RetiradaDia > 16) {
                        // Calculando o dia de devolução
                    registro[i].DevolucaoDia = ((registro[i].RetiradaDia + 15) - 31); 
                        gravar.write(Integer.toString( registro[i].DevolucaoDia )); 
                            gravar.newLine(); 
                        // Calculando o mês de devolução
                    registro[i].DevolucaoMes = registro[i].RetiradaMes + 1; 
                        gravar.write(Integer.toString( registro[i].DevolucaoMes )); 
                            gravar.newLine(); 
                        // Calculando o ano de devolução
                    registro[i].DevolucaoAno = registro[i].RetiradaAno; 
                        gravar.write(Integer.toString( registro[i].DevolucaoAno )); 
                            gravar.newLine(); 
                }
                    // Recebendo o Id do livro
                registro[i].IdLivroRegistroRetirada = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do livro: ")); 
                    gravar.write(Integer.toString( registro[i].IdLivroRegistroRetirada )); 
                            gravar.newLine(); 
                    // Recebendo o RA do aluno
                registro[i].RAregistroRetirada = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA do Aluno :"));
                    gravar.write(Integer.toString( registro[i].RAregistroRetirada )); 
                            gravar.newLine(); 
                    //Setando o status        
                registro[i].statusRetirada = "Emprestado";
                    gravar.write( registro[i].statusRetirada); 
                        gravar.newLine(); 
                    // Mensagem de Sucesso
                JOptionPane.showMessageDialog(null, "Registro feito com sucesso");
                
                    // Lista de registros
                System.out.println(" Número do Livro: " + registro[i].IdLivroRegistroRetirada + "\n RA: " + registro[i].RAregistroRetirada
                        + "\n Data da Retirada: " + registro[i].RetiradaDia + "/" + registro[i].RetiradaMes + "/"
                        + registro[i].RetiradaAno + "\n Data da Devolução: " + registro[i].DevolucaoDia + "/"
                        + registro[i].DevolucaoMes + "/" + registro[i].DevolucaoAno);
            }
 
        gravar.close();
        return registro;
    }
    
    public AbstrataRegistro[] Entregar ( AbstrataRegistro[] registro, AbstrataAlunos[] aluno, AbstrataLivros [] livro ) throws IOException {
        int i;
 
        String fileNameRead = "ArquivoRegistroRetirada.txt";    
        BufferedReader ler = new BufferedReader(new FileReader( fileNameRead ));
 
        String fileName = "ArquivoRegistroEntrega.txt";   
        BufferedWriter gravar = new BufferedWriter(new FileWriter( fileName ));   

        System.out.println("\n *** LISTA DE REGISTRO DE ENTREGA *** ");
 
        for (i = 0 ; i < registro.length ; i++) {
            livro[i] = new AbstrataLivros(); 
        }
 
        Calendar data = Calendar.getInstance();       
            // Pegando as datas
        for (i = 0 ; i < registro.length ; i++) {   
            
                // Lendo do arquivo: ArquivoRegistroRetirada.txt 
            registro[i].RetiradaDia = Integer.parseInt(ler.readLine()); 
                gravar.write(Integer.toString( registro[i].RetiradaDia )); 
                        gravar.newLine();
            registro[i].RetiradaMes = Integer.parseInt(ler.readLine()); 
                gravar.write(Integer.toString( registro[i].RetiradaMes )); 
                    gravar.newLine(); 
            registro[i].RetiradaAno = Integer.parseInt(ler.readLine());
                gravar.write(Integer.toString( registro[i].RetiradaAno )); 
                    gravar.newLine(); 
            
                // Lendo do arquivo: ArquivoRegistroRetirada.txt e gravando no ArquivoRegistroDevolucao.txt
            registro[i].DevolucaoDia = Integer.parseInt(ler.readLine());  
                gravar.write(Integer.toString( registro[i].DevolucaoDia )); 
                        gravar.newLine();   
                // Lendo do arquivo: ArquivoRegistroRetirada.txt e gravando no ArquivoRegistroDevolucao.txt
            registro[i].DevolucaoMes = Integer.parseInt(ler.readLine()); 
                gravar.write(Integer.toString( registro[i].DevolucaoMes )); 
                    gravar.newLine();     
                // Lendo do arquivo: ArquivoRegistroRetirada.txt e gravando no ArquivoRegistroDevolucao.txt
            registro[i].DevolucaoAno = Integer.parseInt(ler.readLine());  
                gravar.write(Integer.toString( registro[i].DevolucaoAno )); 
                    gravar.newLine(); 

                // Lendo do arquivo: ArquivoRegistroRetirada.txt 
            registro[i].IdLivroRegistroRetirada = Integer.parseInt(ler.readLine());   
            registro[i].RAregistroRetirada = Integer.parseInt(ler.readLine());  
            registro[i].statusRetirada = (ler.readLine()); 
        
                // Gerando o dia da entrega automatica
            registro[i].EntregaDia = data.get(Calendar.DAY_OF_MONTH); 
                gravar.write(Integer.toString( registro[i].EntregaDia )); 
                    gravar.newLine();
                // Gerando o mes da entrega automatica
            registro[i].EntregaMes = data.get(Calendar.MONTH) + 1; 
                gravar.write(Integer.toString( registro[i].EntregaMes )); 
                    gravar.newLine();
                // Gerando o ano da entrega automatica
            registro[i].EntregaAno = data.get(Calendar.YEAR);
                gravar.write(Integer.toString( registro[i].EntregaAno )); 
                    gravar.newLine();

                //Gravar no arquivo ArquivoRegistroDevolucao.txt
            registro[i].IdLivroRegistroEntrega = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do livro: ")); 
                gravar.write(Integer.toString( registro[i].IdLivroRegistroEntrega )); 
                        gravar.newLine(); 
                // Recebendo o RA do aluno
            registro[i].RAregistroEntrega = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA do Aluno :"));
                gravar.write(Integer.toString( registro[i].RAregistroEntrega )); 
                        gravar.newLine(); 
               //Setando o status         
            registro[i].statusEntrega = "Disponível";
                gravar.write( registro[i].statusEntrega); 
                    gravar.newLine(); 
                // Mensagem de Sucesso
            JOptionPane.showMessageDialog(null, "Registro feito com sucesso");
            
                // Mensagem dos Registros de Devolução
            System.out.println(" Número do Livro: " + registro[i].IdLivroRegistroEntrega + "\n RA: " + registro[i].RAregistroEntrega
                    + "\n Data da Retirada: " + registro[i].RetiradaDia + "/" + registro[i].RetiradaMes + "/"
                    + registro[i].RetiradaAno + "\n Data da Entrega: " + registro[i].EntregaDia + "/"
                    + registro[i].EntregaMes + "/" + registro[i].EntregaAno);
        }
        ler.close();
        gravar.close();
        return registro;
    }
}