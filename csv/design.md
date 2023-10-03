# Proposta do Software
- Tendo um arquivo csv e a necessidade de mostrar a soma de cada linha do documento, o programa recebe um arquivo .csv como entrada e retorna outro arquivo .csv como saída contendo as linhas originais com o adicional de uma nova coluna em cada linha contendo a respectiva soma dos números contidos na linha, respeitando o limite de 2 números por linha.

# Solução de Software

#### O software faz a verificação do arquivo de entrada para garantir que ele é do tipo .csv, se a verificação for feita com êxito o software parte para verificar se o arquivo possui o padrão estabelecido (2 números por linha, sem outros caracteres adicionais).
- Caso haja falha em qualquer uma das verificações o programa retorna uma mensagem de erro contendo o erro encontrado durante a verficação


#### O programa então realiza a leitura do arquivo e faz a soma de cada linha e armazena os resultados, após o término da leitura o programa vai escrever em um novo arquivo .csv as mesmas linhas e adicionando o resultado da soma como uma coluna adicional posterior às já existentes.
- Novamente, qualquer erro durante a leitura e escrita do novo arquivo é retornada para o usuário em forma de erro com a causa.


#### Um novo arquivo .csv é retornado para o usuário no diretório selecionado
