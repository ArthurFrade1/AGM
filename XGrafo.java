import java.util.HashMap;
import java.util.Map;

public class XGrafo{
    
    public Boolean isLetters=false;//usado pra saber se os vértices são strings
    //Se sim,faço uso dos HashmMaps:
    Map<Integer, String> map = new HashMap<>();//Mapeia de numero pra letra
    Map<String, Integer> mapeamento = new HashMap<>();//Mapeia de letra pra numero


    public int mat[][];
    public int numVertices;
    public int pos[];
    public XGrafo (int numVertices){
         mat=new int[numVertices][numVertices];
         pos=new int[numVertices]; this.numVertices=numVertices;
        for(int i=0; i<this.numVertices; i++){
            for(int j=0; j<this.numVertices; j++){
                mat[i][j]=0;
            }
            pos[i]=-1;


        }

        mapeamento.put("A", 0);
        mapeamento.put("B", 1);
        mapeamento.put("C", 2);
        mapeamento.put("D", 3);
        mapeamento.put("E", 4);
        mapeamento.put("F", 5);
        mapeamento.put("G", 6);
        mapeamento.put("H", 7);
        mapeamento.put("I", 8);
        mapeamento.put("J", 9);
        mapeamento.put("K", 10);

        map.put(0, "A");
        map.put(1, "B");
        map.put(2, "C");
        map.put(3, "D");
        map.put(4, "E");
        map.put(5, "F");
        map.put(6, "G");
        map.put(7, "H");
        map.put(8, "I");
        map.put(9, "J");
        map.put(10, "K");

    }

    public void insereAresta(int v1, int v2, int peso){
        mat[v1][v2]=peso;
    }

    public void insereAresta(String v1, String v2, int peso){
        mat[mapeamento.get(v1)][mapeamento.get(v2)]=peso;
        isLetters=true;
    }

    public Aresta proxAdj(int v){
        pos[v]++;
        
        while((pos[v]<numVertices&& mat[v][pos[v]]==0)){
            pos[v]++;
        }
        if(pos[v]==numVertices)return null;
        else return new Aresta(v, pos[v],mat[v][pos[v]]);
    }
    public Aresta retiraAresta(int v1,int v2){
        if(mat[v1][v2]==0) return null;
        else{
            Aresta aresta=new Aresta(v1, v2, mat[v1][v2]);
            mat[v1][v2]=0; return aresta;
        }
    }
    public void imprime(){
        System.out.println("Matriz de adjacência:");
        if (!isLetters) {
            System.out.print("   ");
            for(int i=0; i<numVertices; i++)
                System.out.print(i + "  ");
            System.out.println();
            for(int i=0; i<numVertices; i++){
                System.out.print(i + "  ");
                for(int j=0; j<numVertices; j++)
                    System.out.print(mat[i][j]+"  ");
                System.out.println();
                
            }
        }else{
            System.out.print("   ");
            for(int i=0; i<numVertices; i++)
                System.out.print(map.get(i) + "  ");
            System.out.println();
            for(int i=0; i<numVertices; i++){
                System.out.print(map.get(i)+ "  ");
                for(int j=0; j<numVertices; j++)
                    System.out.print(mat[i][j]+"  ");
                System.out.println();
            }
        }

    }      
}