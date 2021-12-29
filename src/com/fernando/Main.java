package com.fernando;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        List<Integer> resultado = new ArrayList<Integer>();
        int quadra = 0, quina = 0, sena = 0;

        resultado.add(06);
        resultado.add(36);
        resultado.add(31);
        resultado.add(44);
        resultado.add(37);
        resultado.add(50);

        try{
            File jogos = new File ("/Users/fernandogontijo/Documents/Projetos/Gerador-de-Numeros-Loteria-/MegaDaVirada/JogosLoteria.txt");
            FileReader leitor = new FileReader(jogos);
            BufferedReader lerArquivo = new BufferedReader(leitor);

            while (lerArquivo.ready()) {
                String numero = lerArquivo.readLine();
                String numerosJogados [] = numero.replace("[", "").replace("]", "").split(", ");
                int acertos = 0;
                for (int i= 0; i< 6; i++){
                    int numeroAux = Integer.parseInt(numerosJogados[i]);
                    for (int dezena : resultado)
                        if(numeroAux == dezena){
                        acertos ++;
                        break;
                    }
                }

                switch (acertos){
                    case 4:
                        quadra ++;
                        break;
                    case 5:
                        quina ++;
                        break;
                    case 6:
                        sena ++;
                        break;
                }
            }

            lerArquivo.close();

            System.out.println("Resultado: ");
            System.out.println("");

            if(quadra > 0){
                System.out.println("Quadra: " + quadra);
                System.out.println("");
            }

            if(quina > 0){
                System.out.println("Quina: " + quina);
                System.out.println("");
            }

            if(sena > 0){
                System.out.println("Sena: " + sena);
                System.out.println("");
            }

            if(quadra == 0 && quina == 0 && sena==0){
                System.out.println("Tente novamente no próximo ano! ");
                System.out.println("");
            }

        } catch (IOException e) {
            System.out.println("Arquivo não encontrado");

        }

    }
}
