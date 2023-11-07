
public class XAGM {
    public void BubbleSort(Aresta[] Arestas){
        for (int i = 0; i < Size-1; i++) {
            for (int j = 0; j < Size-1; j++) {    
                if(Arestas[j].peso>Arestas[j+1].peso){
                    Aresta temp; temp=Arestas[j+1];
                    Arestas[j+1]=Arestas[j];
                    Arestas[j]=temp;
                }
            }
        }
    }

    public void calculaMenor(Aresta[] Arestas){
        for (int i = 0; i < TAM; i++) {
                for (int j = 0; j < TAM; j++) {
                    if (graf.mat[i][j]>0) {
                        Aresta menor=new Aresta();
                        menor.v1=i;
                        menor.v2=j;
                        menor.peso=graf.mat[i][j];
                        Arestas[Size]=menor;
                        Size++;
                    }
                }
        }
        BubbleSort(Arestas);

    } 
    
    public static class Conjunto{

    }
    public static class Node{
        public Boolean hasConjunto=false;
        public int valor;
        public Conjunto conjunto;
        public Node(int valor, Conjunto conjunto){
            this.valor=valor;
            this.conjunto=conjunto;
        }

    }
    XGrafo graf;
    int TAM;
    int Size;    
    Node[] nodes;
    int cont=0;

    public XAGM(XGrafo graf,int TAM){
        Aresta[] Arestas=new Aresta[100];
        Aresta[] tree=new Aresta[100];
        nodes=new Node[TAM];
        this.TAM=TAM;
        this.graf=graf;
        calculaMenor(Arestas);//Volta vetor de arestas já ordenado por peso

        System.out.println("\nArestas ordenados:");
        for (int i = 0; i < Size; i++) {
            Aresta davez=Arestas[i];
            if(!graf.isLetters)
                System.out.println("linha - "+davez.v1+" coluna - "+davez.v2+" peso - "+davez.peso);
            else{
                System.out.println("linha - "+graf.map.get(davez.v1)+" coluna - "+graf.map.get(davez.v2)+" peso - "+davez.peso);
            }
        }
        for (int i = 0; i < TAM; i++) {//Adiciono ao array de nós, um novo nó de indice i com uma nova indicação de conjunto
            nodes[i]=new Node(i, new Conjunto());
        }

        for (int i = 0; i < Size; i++) {
            Node v1, v2;//Insiro nos nós os nós referenciados pela aresta em questão

            v1=nodes[Arestas[i].v1];
            v2=nodes[Arestas[i].v2];

            if(v1.conjunto!=v2.conjunto){
                tree[cont]=Arestas[i];//Inserindo na árevore a aresta
                cont++;
                if (v1.hasConjunto) {//Se o primeiro já faz parte de um conujunto(Também no caso do primeiro e segundo terem conjunto)
                    for (int j = 0; j < TAM; j++) {
                        if (nodes[j].conjunto==v2.conjunto) {//Rodo todos os nós que tem um conjunto igual ao do conjunto do segundo e coloco  o conjunto do primeiro
                            nodes[j].conjunto=v1.conjunto;
                            nodes[j].hasConjunto=true;
                        }
                    }
                }else if(v2.hasConjunto){//Se o segundo já faz parte de um conujunto
                    for (int j = 0; j < TAM; j++) {
                        if (nodes[j].conjunto==v1.conjunto) {//Rodo todos os nós que tem um conjunto igual ao do conjunto do segundo e coloco  o conjunto do primeiro
                            nodes[j].conjunto=v2.conjunto;
                            nodes[j].hasConjunto=true;
                        }
                    }
                }else{
                    v1.conjunto=v2.conjunto;
                    v1.hasConjunto=true;
                    v2.hasConjunto=true;
                }
            }
        }
        System.out.println("\nArestas da AGM:");
        int peso=0;
        for (int i = 0; i < cont; i++) {
            Aresta davez=tree[i];
            if(!graf.isLetters)
                System.out.println("linha - "+davez.v1+" coluna - "+davez.v2+" peso - "+davez.peso);
            else{
                System.out.println("linha - "+graf.map.get(davez.v1)+" coluna - "+graf.map.get(davez.v2)+" peso - "+davez.peso);
            }            
            peso+=davez.peso;
        }
        System.out.println("\nPeso da AGM: "+peso);
    }
    

}
