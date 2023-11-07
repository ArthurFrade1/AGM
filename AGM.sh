#!/bin/bash

# Nome do arquivo fonte Java
ARQUIVO_JAVA="Main.java"
# Nome da classe principal (sem a extensão .java)
CLASSE_PRINCIPAL="Main"

# Compilar o código Java
if javac "$ARQUIVO_JAVA"; then
    # A compilação foi bem-sucedida
    echo "Compilação bem-sucedida. Executando o programa..."
    # Verificar se o arquivo de classe foi gerado antes de executá-lo
    if [ -f "${CLASSE_PRINCIPAL}.class" ]; then
        # Executar o programa
        java "$CLASSE_PRINCIPAL"
    else
        echo "Erro: O arquivo de classe não foi encontrado."
    fi
else
    echo "Erro: Falha na compilação."
fi