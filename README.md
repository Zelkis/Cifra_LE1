1 - Criptografia por Deslocamento: consiste em fazer uma lista e adicionar a as letras a essa lista de maneira que cada letra ocupe uma posição da lista. As letras estão associadas a
cada posição da lista de forma que o a corresponde a posição 0, o b a posição 1 até o z que corresponde a posição 25. Para cifrar a mensagem, analisaremos cada letra da mensagem. As letras da
mensagem serão substituídas por outras letras adicionando a chave passada no metódo que pode ser um número de 0 até 25 e pegando o resto da divisão dessa operação por 26.

2 - Criptografia por Transposição: Para realizar essa criptografia utilizei dois metódos o primeiro consiste em realizar a transposição por colunas. Para realizar precisa-se primeiramente de
um array em que os elementos serão outros arrays de Strings de caracteres. A chave utilizada para esse metódo será uma palavra que não contém caracteres repetidos. Portanto, serão necessários 
dois argumentos para o metódo de criptografia, a chave e a mensagem que será cifrada. Para cifrar a mensagem itera-se sobre os caracteres da mesma de forma que esses caracteres serão adicionados
a um array do tamanho da mensagem e colocados no outro array criado, tendo assim uma matriz de matrizes. O próximo passo desse metódo consiste em ordenar os caracteres da chave para isso, utiliza-
se a função sort(), após transformar a chave em um array. Com a chave ordenada, itera-se sobre a mesma e para cada caracter pega-se a posição do mesmo e assim na matriz de matrizes, pega-se todos
os caracteres desta mesma posição. Assim, estaremos pegando as colunas ordenas de acordo com a chave. O outro metódo de criptografia por transposição consiste em usar um metódo que gera todas as
permutações de uma palavra e a função random() em java. O metódo gera todas as permutações de uma palavra e as armazena em uma lista, porém seu custo é muito alto de acordo com o tamanho da mensagem.
De posse das permutações, a função random escolhe um número dentro da range da lista gerada e a partir desse número pega a posição do elemento escolhido.

3 - Quebra Cifra por Deslocamento: Para quebrar a cifra de deslocamento usa-se dois metódos. O primeiro consiste em fazer um map com as frequencias dos caracteres mais comuns na língua portuguesa
Itera-se sobre a mensagem. Para cada letra da mensagem subtrai-se 26, adiciona o valor da chave que pode ser de 0 até 25 e obtém-se o resto da divisão dessa operação por 26. Deste modo, obteremos
todas as palavras para cada chave. Para cada palavra testa-se a pontuação de acordo com a frequencia dos caracteres da língua portuguesa. Por fim, retorna a palavra com maior pontuação. O outro 
metódo consiste em apenas analisar cada palavra obtida pela variação dos valores da chave.

4 - Quebra Cifra por Transposição: Para quebrar a cifra por transposição, o primeiro passo consiste em fazer o map com os digrafos e trigrafos mais comuns da língua portuguesa. Depois, de posse
da mensagem tentaremos quebrar da mesma forma que na cifra por deslocamento. Itera-se sobre a mensagem e para cada trio e dupla de caracteres analisa-se a pontuação correspondente. Porém aqui
nesse caso, como não se sabe qual é a chave usada, tentei usar o metódo das permutações. Para a transposição por colunas esse metódo não funciona, pois quando chega na última linha e os caracteres
não complentam o array, as letras do alfabeto são adicionadas para completa-lo. Deste modo, para o segundo metódo funciona, porém a medida em que se aumenta o número de letras da palavra fica-se
o algoritmo não aguenta e para.
