    public class Main {
    public static void main(String[] args) {
        //EXEMPLOS

        //Exemplo material
        // int TAM=6;
        // XGrafo graf=new XGrafo(TAM);
        // graf.insereAresta(0, 1, 6);
        // graf.insereAresta(0, 2, 1);
        // graf.insereAresta(0, 3, 5);
        // graf.insereAresta(1, 2, 2);
        // graf.insereAresta(1, 4, 5);
        // graf.insereAresta(2, 3, 2);
        // graf.insereAresta(2, 4, 6);
        // graf.insereAresta(2, 5, 4);
        // graf.insereAresta(3, 5, 4);
        // graf.insereAresta(4, 5, 3);

        //Exemplo 2 prof
        // int TAM=9;
        // XGrafo graf=new XGrafo(TAM);
        // graf.insereAresta(2, 1, 8);
        // graf.insereAresta(2, 3, 3);
        // graf.insereAresta(2, 4, 2);
        // graf.insereAresta(2, 5, 7);
        // graf.insereAresta(2, 6, 5);
        // graf.insereAresta(2, 8, 6);

        // graf.insereAresta(7, 1, 9);
        // graf.insereAresta(7, 3, 6);
        // graf.insereAresta(7, 4, 2);
        // graf.insereAresta(7, 5, 4);
        // graf.insereAresta(7, 6, 6);
        // graf.insereAresta(7, 8, 3);

        // graf.insereAresta(1, 3, 2);
        // graf.insereAresta(3, 4, 9);
        // graf.insereAresta(3, 5, 6);
        // graf.insereAresta(5, 6, 5);
        // graf.insereAresta(6, 8, 4);

        //Exemplo 1 prof
        int TAM=11;//Nunero do K no meu hashmap na classe XGrafo
        XGrafo graf=new XGrafo(TAM);
        graf.insereAresta("F", "G", 15);
        graf.insereAresta("F", "B", 5);
        graf.insereAresta("G", "A", 10);
        graf.insereAresta("G", "C", 5);
        graf.insereAresta("G", "D", 10);

        graf.insereAresta("C", "D", 5);
        graf.insereAresta("C", "E", 10);
        graf.insereAresta("D", "A", 10);
        graf.insereAresta("D", "E", 5);
        graf.insereAresta("E", "A", 5);

        graf.insereAresta("E", "K", 10);
        graf.insereAresta("K", "H", 20);
        graf.insereAresta("K", "B", 10);
        graf.insereAresta("H", "A", 10);
        graf.insereAresta("H", "B", 5);

        graf.insereAresta("B", "A", 5);

        graf.imprime();


        new XAGM(graf, TAM);




    }
    
}